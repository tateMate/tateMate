package edu.test.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.test.demo.vo.ImageVO;

@Repository
@Mapper
public interface ImageDAO {
	public ImageVO selectImageByImageId(int image_id);		//이미지 아이디로 특정 이미지 1개를 받아옴	
	public List<ImageVO> selectImageByUserId(int user_id);	//유저 아이디로 이미지 목록을 받아옴	
}
