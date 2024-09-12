package com.rent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rent.dao.SearchDao;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchDao searchDao;

	@RequestMapping(path = "/housedetail", method = RequestMethod.GET)
	public String UploadGet(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("rentDetails", searchDao.getRentDetailByHouse());
		// System.out.println(uploadDao.getRentDetail());

		return "demo";
	}

	@RequestMapping(path = "/flatdetail", method = RequestMethod.GET)
	public String UploadGetByFalt(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("rentDetails", searchDao.getRentDetailByFlat());
		// System.out.println(uploadDao.getRentDetail());

		return "demo";
	}

	@RequestMapping(path = "/roomdetail", method = RequestMethod.GET)
	public String UploadGetByRoom(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("rentDetails", searchDao.getRentDetailByRoom());
		// System.out.println(uploadDao.getRentDetail());

		return "demo";
	}

	@RequestMapping(path = "/searchByDistrict", method = RequestMethod.GET)
	public String SearchByDistrict(HttpServletRequest request, HttpServletResponse response, Model model) {
		String district = request.getParameter("district");
		System.out.println("Search by district: " + district);
		
		String rentType = request.getParameter("rentType");
		System.out.println("Search by rentType: " + rentType);

		System.out.println(searchDao.getRentDetailByDistrict(district, rentType));
		
		if(!searchDao.getRentDetailByDistrict(district, rentType).isEmpty())
		{
			model.addAttribute("rentDetails", searchDao.getRentDetailByDistrict(district, rentType));
		}else
		{
			model.addAttribute("error", "No Data available");
		}
		return "intro";
	}
}
