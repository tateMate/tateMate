package edu.test.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.test.demo.dao.ImageDAO;
import edu.test.demo.vo.ImageVO;

@Service
public class ImageService {
	@Autowired
	ImageDAO imageDAO;
//이미지 아이디로 특정 이미지 1개를 받아옴	
	public ImageVO selectImageByImageId(int image_id) {
		return imageDAO.selectImageByImageId(image_id);
	}
	
//유저 아이디로 이미지 목록을 받아옴	
	public List<ImageVO> selectImageByUserId(int user_id){
		return imageDAO.selectImageByUserId(user_id);
	}
}
