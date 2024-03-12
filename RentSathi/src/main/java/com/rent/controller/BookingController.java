package com.rent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rent.model.Rent;
import com.rent.sprite.BookingTable;

@Controller
@RequestMapping("/book")
public class BookingController {

	@RequestMapping("/rentNow/{rent_id}")
	public String booking(@PathVariable("rent_id") String rentId, Model model) {
		System.out.println("rent id:" + rentId);
		model.addAttribute("rent_id", rentId);
		return "booking";
	}

	/*@RequestMapping(path = "/bookAd/{rent_id}", method = RequestMethod.POST)
	public String bookingPost(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute BookingTable bookingTable) {

		return "intro";
	}*/
}
