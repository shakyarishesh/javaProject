package com.rent.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rent.dao.RentDao;
import com.rent.service.BookingService;
import com.rent.sprite.BookingTable;

@Controller
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	RentDao rentDao;

	@RequestMapping("/rentNow/{rent_id}")
	public String booking(@PathVariable("rent_id") UUID rentId, RedirectAttributes redirectAttributes, Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("login")!=null)
		{
			model.addAttribute("rentid", rentId);
			//System.out.println("rent id:" + rentId);
			return "booking";
		}else
		{
			return "redirect:/login";
		}
		
	}

	@RequestMapping(path = "/bookAdd", method = RequestMethod.POST)
	public String bookingPost(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute BookingTable bookingTable) {
		// Get the rent_id parameter from the request
		String rentIdParameter = request.getParameter("rent_id");

		// Convert the rent_id parameter string to a UUID
		UUID rent_id = UUID.fromString(rentIdParameter);
		String user_email = (String) request.getSession().getAttribute("login");
		//System.out.println("logged in as:"+user);
	
		
		bookingService.addBookingDetails(bookingTable, rent_id, user_email);
		
		return "redirect:/intro";
	}
	
	@RequestMapping("/bookingDetails")
	public String bookingDetails( Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("login")!=null)
		{
			
			return "bookingdetails";
		}else
		{
			return "redirect:/login";
		}
		
	}
	
}
