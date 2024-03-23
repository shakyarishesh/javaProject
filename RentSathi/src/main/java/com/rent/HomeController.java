package com.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rent.dao.SearchDao;

@Controller
public class HomeController {

	@Autowired
	SearchDao searchDao;

	@RequestMapping(value="/intro") 
	public String home(Model model) {
	  model.addAttribute("rentDetails", searchDao.getRentDetail());
	  //System.out.println(uploadDao.getRentDetail()); 
	  return "intro";
	  }

	@RequestMapping(value = "/login")
	public String Login() {
		return "login";
	}
}
