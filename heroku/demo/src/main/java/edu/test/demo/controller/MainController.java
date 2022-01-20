
package edu.test.demo.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.test.demo.service.CocommentService;
import edu.test.demo.service.CommentService;
import edu.test.demo.service.UserCharacterService;
import edu.test.demo.service.UserService;
import edu.test.demo.vo.UserCharacterVO;
import edu.test.demo.vo.UserVO;

@RestController
@RequestMapping("/api/main")
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
	UserCharacterService userCharacterService;
	@Autowired
	CommentService commentService;
	@Autowired
	CocommentService cocommentService;
	
	//가입 url 전송
	@PostMapping("/join/sendURL")
	public boolean sendURL(String user_email){
		try {
			userService.insertTmpUser(user_email);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	//회원가입 폼(파리미터로 확인 후, user_id,user_email 등 리턴)			/	나중에 링크에 따라 서비스에서 링크 수정
	@GetMapping("/join/form")
	public UserVO joinForm(String tatemate) {
		return userService.selectUserByshalizedEmail(tatemate);
	}
	
	//회원가입 완료
	@PostMapping("/join/complete")
	public boolean joinComplete(UserVO userVO, UserCharacterVO userCharacterVO, HttpServletRequest request, @RequestParam(value = "file") MultipartFile file){
		try {
			userService.modifyUser(userVO, userCharacterVO, null, request, file);
			return true;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//로그인
	@PostMapping("/login")
	public boolean login(String user_email, String user_pw, HttpSession session) {
		UserVO user = userService.loginCheck(user_email, user_pw);
		if(user == null)
			return false;
		else {
			user.setUser_pw("");
			session.setAttribute("user", user);
			session.setAttribute("userCharacter", userCharacterService.selectUserCharacterByUserId(user.getUser_id()));
			return true;
		}
	}
	
	//로그아웃
	@GetMapping("/logout")
	public boolean logout(HttpSession session) {
		session.invalidate();
		return true;
	}
	
	//추천 매칭 리스트
	@GetMapping("/rcmd")
	public List<UserVO> rcmdUserList(HttpServletRequest session){
		if(session.getAttribute("user")!=null) {
			return userCharacterService.sameCharacter((UserCharacterVO)(session.getAttribute("userCharacter")));
		}else return null;
	}
	
	//상세회원정보
	@GetMapping("/userInfo")
	public JSONObject userInfo(Integer user_id) {
		UserVO user = userService.selectUserByUserId(user_id);
		user.setUser_pw("");
		UserCharacterVO userCharacter = userCharacterService.selectUserCharacterByUserId(user_id);
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("user", user);
		hm.put("userCharacter", userCharacter);
		JSONObject jo = new JSONObject(hm);
		return jo;
	}
	
	//회원정보수정(form)
	@PostMapping("/userInfo/modify")
	public boolean userModify(UserVO userVO, UserCharacterVO userCharacterVO, HttpSession session, HttpServletRequest request, @RequestParam(value="file") MultipartFile file) {
		try {
			userService.modifyUser(userVO, userCharacterVO, session, request, file);
			return true;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
