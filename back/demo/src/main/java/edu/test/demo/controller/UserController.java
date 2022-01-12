package edu.test.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.test.demo.service.UserService;
import edu.test.demo.vo.UserVO;

@RestController
public class UserController {
	@Autowired
	UserService userService;

//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public List<UserVO> test() {
//		List<UserVO> userList = userService.selectUser();
//		return userList;
//	}
}
