package com.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.controller.CommonController;
import com.rent.dao.UploadDao;
import com.rent.dao.UserDao;
import com.rent.model.Rent;
import com.rent.sprite.UploadTable;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	UploadDao uploadDao;

	@Autowired
	UserDao userDao;

	@Override
	public Boolean setUpload(UploadTable uploadTable, Integer userId, String img_name, byte[] img_path) {
		Rent rent = new Rent();

		rent.setBhk(uploadTable.getBhk());
		rent.setDescription(uploadTable.getDescription());
		rent.setPrice(uploadTable.getPrice());
		rent.setRentType(uploadTable.getRentType());
		rent.setTitle(uploadTable.getTitle());
		rent.setCreatedAt(CommonController.getCurrentDateTime());
		rent.setUpdatedAt(CommonController.getCurrentDateTime());
		rent.setDeletedAt(null);
		rent.setCreatedBy(userDao.getUser(userId));
		rent.setUpdatedBy(userDao.getUser(userId));
		rent.setImageName(img_name);
		rent.setImagePath(img_path);
		rent.setLocation(uploadTable.getLocation());

		return uploadDao.addUpload(rent);

	}

}
