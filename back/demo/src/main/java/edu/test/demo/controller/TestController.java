package edu.test.demo.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.test.demo.service.CocommentService;
import edu.test.demo.service.CommentService;
import edu.test.demo.service.UserService;
import edu.test.demo.vo.CocommentVO;
import edu.test.demo.vo.CommentVO;
import edu.test.demo.vo.NicknamedCocommentVO;
import edu.test.demo.vo.NicknamedCommentVO;
import edu.test.demo.vo.UserVO;

@RestController
public class TestController {
	@Autowired
	UserService userService;
	@Autowired
	CommentService commentService;
	@Autowired
	CocommentService cocommentService;
	
	
	@GetMapping("/rest/user")
	public List<UserVO> selectUser(@RequestParam(required = false) Integer id) {
		List<UserVO> li=new ArrayList<UserVO>();
		li.add(userService.selectUserByUserId(id));
		if(id==null) return userService.selectUser();
		return li;
	}
	@GetMapping("/rest/booleantest")
	public boolean booleanTest(@RequestParam(required = false) Integer id) {
		boolean chk = true;
		boolean chk2 = false;
		boolean rst;
		if(id!=null) {
			rst = (id==1)?chk:chk2;
		}else rst = false;
		return rst;
	}
	@GetMapping("/rest/test")
	public List test() {
		int user_id = 2;
		JSONArray ja = cocommentService.selectCocommentByCommentIdTo(user_id);
		return ja;
	}
	@GetMapping("/api/users")
	public List<UserVO> users() {
		List<UserVO> userList = userService.selectUser();
		return userList;
	}
}
