package com.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rent")
public class RentController {
	
	@RequestMapping(value="/upload")
	public String upload()
	{
		return "upload";
	}
	
	

}
