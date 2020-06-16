package org.zcn.service;

import org.springframework.web.multipart.MultipartFile;
import org.zcn.utils.PictureResult;


public interface PictureService {
	PictureResult uploadPicture(MultipartFile uploadFile);
}
