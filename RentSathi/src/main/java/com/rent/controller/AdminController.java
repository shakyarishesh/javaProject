package com.rent.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rent.dao.BookingDao;
import com.rent.dao.RegisterDao;
import com.rent.dao.RegisterDaoImpl;
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
	
	private static final Logger logger = Logger.getLogger(AdminController.class);

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

	@RequestMapping(path = "/bookinglistings", method = RequestMethod.GET)
	public String bookingListings(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("login") != null) {
			model.addAttribute("listings", bookingDao.getAllBookingsBooked());
			return "admin/bookinglistings";
		}
		return "redirect:/intro";

	}
	
	@RequestMapping(path = "/bookinglistings/{rent_id}/{status}", method = RequestMethod.POST)
	public String bookingListingsPost(@PathVariable("rent_id") UUID rentId, 
            @PathVariable("status") String status,HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("login") != null) {
			
			Status statuss =  Status.valueOf(status);
		
			rentDao.changestatus(rentId, statuss);
			
			return "redirect:/admin/bookinglistings";
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
	
	@RequestMapping(path = "/rentlistings", method = RequestMethod.GET)
	public String Rentlistings(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("login") != null) {
			model.addAttribute("listings", rentDao.getAllRent());
			return "admin/rentListings";
		}
		return "redirect:/intro";

	}
	
	@RequestMapping(path = "/deleterent/{rent_id}", method = RequestMethod.GET)
	public String deleteRent(@PathVariable("rent_id") UUID rent_id, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		String email = (String) request.getSession().getAttribute("login");

		rentDao.deleteRent(rent_id);
		//System.out.println("rent id:"+ rent_id);
		logger.info("deleted by"+email);
		
		redirectAttributes.addFlashAttribute("message", "User deleted successfully");
		return "redirect:/admin/rentlistings";
	}

}
