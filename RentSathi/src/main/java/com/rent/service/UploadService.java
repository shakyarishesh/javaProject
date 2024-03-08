package com.rent.service;

import com.rent.sprite.UploadTable;

public interface UploadService {
	
	Boolean setUpload(UploadTable uploadTable, Integer userId, String img_name, byte[] img_path);

}
