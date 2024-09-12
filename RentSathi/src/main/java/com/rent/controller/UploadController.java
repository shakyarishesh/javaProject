package com.rent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mysql.cj.Session;
import com.rent.dao.RegisterDao;
import com.rent.dao.UploadDao;
import com.rent.dao.UserDao;
import com.rent.service.UploadService;
import com.rent.sprite.UploadTable;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	UploadService uploadService;
	
	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UploadDao uploadDao;
	
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String Upload(@RequestParam("img") CommonsMultipartFile image, HttpServletRequest request, @ModelAttribute("upload") UploadTable uploadTable)
	{
		System.out.println("---------------------------------");
		System.out.println(image.getOriginalFilename());
		
		byte[] img_byte = image.getBytes();
		System.out.println(img_byte);
		
		
		System.out.println(uploadTable.getBhk());
		
		String userEmail = (String) request.getSession().getAttribute("login");
		System.out.println("userEmail: "+userEmail);
		
		Integer userId = userDao.getExistingUser(userEmail).getId();
		System.out.println("user id:"+userId);
		
		System.out.println("---------------------------------");
		uploadService.setUpload(uploadTable, userId, image.getOriginalFilename(), img_byte);
		
		
		//gives path of the image folder after the project has been run, not the one on the project.
		//String path = request.getServletContext().getRealPath("/resources/Images/"+image.getOriginalFilename());
		//System.out.println(path);
//		FileOutputStream fos;
//		try {
//			fos = new FileOutputStream(path);
//			fos.write(img_byte);
//			fos.close();
//			System.out.println("Image uploaded");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		return "redirect:/intro";
	}
	
	/*@RequestMapping(path="/housedetail", method = RequestMethod.GET)
	public String UploadGet(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		model.addAttribute("rentDetails", uploadDao.getRentDetailByHouse());
		//System.out.println(uploadDao.getRentDetail());
			
		return "demo";
	}*/
	
	
	
}
