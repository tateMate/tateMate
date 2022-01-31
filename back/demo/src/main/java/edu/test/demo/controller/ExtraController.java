package edu.test.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.test.demo.service.UserService;
import edu.test.demo.vo.UserVO;

@RestController
public class ExtraController {
	@Autowired
	UserService userService;
	
	//email 중복체크
	@PostMapping("/api/check/email")
	public boolean checkEmail(String user_email) {
		return userService.emailCheck(user_email);
	}
	
	//nickname 중복체크
	@PostMapping("/check/nickname")
	public boolean checkNickname(String user_nickname) {
		return userService.nicknameCheck(user_nickname);
	}
	
	//pw 체크
	@PostMapping("/check/pw")
	public boolean checkPw(String user_pw, HttpSession session) {
		return userService.pwCheck(user_pw, session);
	}
	
//***************************비밀번호 찾기***************************
	//인증번호전송
	@PostMapping("/findPw/sendEmail")
	public String sendEmail(@RequestBody Map<String, Object> param, HttpSession session) {
		try {
			String user_email = (String)param.get("user_email");
			UserVO user = userService.selectUserByUserEmail(user_email);
			if(user==null) {
				return "false";	//	없는 email
			}
			userService.forgotPw(user.getUser_id(), session);	//	email로 인증번호 전송, 비밀번호 초기화되었으니 반드시 재설정 하시오.
			return user_email;
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	//패스워드 변경 완료
	@PostMapping("/findPw/modifyPw/complete")
	public boolean modifyPwPost(String user_email, String user_pw) {
		try {
			int user_id = userService.selectUserByUserEmail(user_email).getUser_id();
			userService.modifyPw(user_id, user_email, user_pw);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
