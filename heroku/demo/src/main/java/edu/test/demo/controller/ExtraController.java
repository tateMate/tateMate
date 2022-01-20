package edu.test.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	//url전송
	@PostMapping("/findPw/sendURL")
	public boolean sendEmail(String user_email) {
		try {
			UserVO user = userService.selectUserByUserEmail(user_email);
			if(user==null) {
				return false;	//	없는 email
			}
			//후에 서비스에서 링크 변경
			userService.forgotPw(user.getUser_id());	//	email로 링크 전송, 비밀번호 초기화되었으니 반드시 재설정 하시오.
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//패스워드 변경 폼 (파라미터 받아서 검사 후, email 리턴)
	@GetMapping("/findPw/modifyPw/form")
	public String modifyPwGet(String tmpPw) {
		try {
			UserVO user = userService.selectUserByUserPw(tmpPw);
			if(user == null) {
				return "";	//	링크가 만료됨.(이미 변경된 비밀번호)
			}
			return user.getUser_email();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	//패스워드 변경 완료
	@PostMapping("/findPw/modifyPw/complete")
	public boolean modifyPwPost(int user_id, String user_email, String user_pw) {
		try {
			userService.modifyPw(user_id, user_email, user_pw);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
