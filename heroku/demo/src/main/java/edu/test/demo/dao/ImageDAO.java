package edu.test.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.test.demo.vo.ImageVO;

@Repository
@Mapper
public interface ImageDAO {
	public ImageVO selectImageByImageId(int image_id);		
	public List<ImageVO> selectImageByUserId(int user_id);	
}
