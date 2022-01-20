package edu.test.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.test.demo.dao.UserCharacterDAO;
import edu.test.demo.dao.UserDAO;
import edu.test.demo.vo.UserCharacterVO;
import edu.test.demo.vo.UserVO;

@Service
public class UserCharacterService {
	@Autowired
	UserCharacterDAO userCharacterDAO;
	@Autowired
	UserDAO userDAO;

	public UserCharacterVO selectUserCharacterByUserId(int user_id) {
		return userCharacterDAO.selectUserCharacterByUserId(user_id);
	}

//To recommend
	public List<UserVO> sameCharacter(UserCharacterVO userCharacterVO){
		List<UserVO> ul=new ArrayList<UserVO>();
		List<Integer> idList=userCharacterDAO.sameCharacter(userCharacterVO);
		for (Integer user_id : idList) {
			ul.add(userDAO.selectUserByUserId(user_id));
		}
		return ul;
	}

//insert user character when join
	public int insertUserCharacter(UserCharacterVO characterVO) {
		return userCharacterDAO.insertUserCharacter(characterVO);
	}
	
}
