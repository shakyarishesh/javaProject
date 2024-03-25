package com.rent.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rent.dao.BookingDao;
import com.rent.dao.RegisterDao;
import com.rent.dao.RentDao;
import com.rent.dao.UserDao;
import com.rent.model.Status;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserDao userDao;

	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	RentDao rentDao;

	@RequestMapping(value = "/index")
	public String index() {
		return "admin/index";
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public String users(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("login") != null) {
			model.addAttribute("users", userDao.getAllUser());
			return "admin/users";
		}
		return "redirect:/intro";
	}

	@RequestMapping(path = "/listings", method = RequestMethod.GET)
	public String listings(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("login") != null) {
			model.addAttribute("listings", bookingDao.getAllBookings());
			return "admin/listings";
		}
		return "redirect:/intro";

	}
	
	@RequestMapping(path = "/listings/{rent_id}/{status}", method = RequestMethod.POST)
	public String listingsPost(@PathVariable("rent_id") UUID rentId, 
            @PathVariable("status") String status,HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("login") != null) {
			
			Status statuss =  Status.valueOf(status);
		
			rentDao.changestatus(rentId, statuss);
			
			return "redirect:/admin/listings";
		}
		return "redirect:/intro";

	}

	@RequestMapping(path = "/deleteUser/{user_id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("user_id") Integer user_id, RedirectAttributes redirectAttributes) {
		// Assuming you have a service method to delete the user
		userDao.deleteUser(user_id);
		// UUID regId = userDao.getRegisterId(user_id);
		// registerDao.deteleUserReg(regId);
		redirectAttributes.addFlashAttribute("message", "User deleted successfully");
		return "redirect:/admin/users";
	}

}
