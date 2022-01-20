package edu.test.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.test.demo.vo.UserVO;

@Repository
@Mapper
public interface UserDAO {
	public List<UserVO> selectUser();					//for a test
	
	public UserVO selectUserByUserId(int user_id);		//userVO by user id
	public UserVO selectUserByUserEmail(String user_email);		//userVO by user id
	public int insertUser(UserVO vo);					//insert
	
	//new join logic(insert tmp user)
	public int insertTmpUser(UserVO vo);
	
	public UserVO selectUserLogin(Map<String, String> id_pass);//login check
	public int modifyUser(UserVO vo);		//modify user
	public UserVO emailCheck(String email);			//	email check
	public UserVO nicknameCheck(String nickname);	//	nickname check
	public List<UserVO> selectUsersByLocation(String location);	//recommend user mulgae version. userVO by location
	public int modifyPw(Map<String,Object> emailPass);					//	modify password
	public UserVO selectUserByUserPw(String user_pw);					//	userVO by pw
}
