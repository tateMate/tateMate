package edu.test.demo.controller;



import java.io.*;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import edu.test.demo.service.CocommentService;
import edu.test.demo.service.CommentService;
import edu.test.demo.service.UserCharacterService;
import edu.test.demo.service.UserService;
import edu.test.demo.vo.CocommentVO;
import edu.test.demo.vo.CommentVO;
import edu.test.demo.vo.UserCharacterVO;
import edu.test.demo.vo.UserVO;

@Controller
public class TestController2 {
	@Autowired
	UserService userService;
	@Autowired
	UserCharacterService userCharacterService;
	@Autowired
	CommentService commentService;
	@Autowired
	CocommentService cocommentService;
	
//test main page
	@GetMapping("/main")
	public String testpage(Model model, HttpSession session) {
		if(session.getAttribute("user")!=null) {
			model.addAttribute("rcmd",userCharacterService.sameCharacter((UserCharacterVO)(session.getAttribute("userCharacter"))) );
		}
		return "main/testmain";
	}
	
//user info
	@GetMapping("/userinfo")
	public String userInfoPage(Model model, @RequestParam(required = false) Integer user_id) {
		model.addAttribute("user",userService.selectUserByUserId(user_id));
		model.addAttribute("character",userCharacterService.selectUserCharacterByUserId(user_id));
		model.addAttribute("comment", commentService.selectCommentByCommentIdTo(user_id));
		model.addAttribute("cocomment", cocommentService.selectCocommentByUserId(user_id));
		return "main/userInfo";
	}

//modify user info
	@GetMapping("/userinfo/modify")
	public String modifyUserInfoPage(Model model,HttpSession session, @RequestParam Integer user_id) {
		//if (login user != targeted user)can't modify information
		try {
			int session_user_id = ((UserVO) session.getAttribute("user")).getUser_id();
			if (session_user_id == user_id)
				return "main/userModify";
			else {
				model.addAttribute("msg", "Unauthorized User!");
				return "main/fail";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e);
			System.out.println(e);
			return "main/fail";
		}
	}
	@PostMapping("/userinfo/modify")
	public String modifyUserInfo(Model model, UserVO userVO, UserCharacterVO userCharacterVO, HttpSession session, HttpServletRequest request, @RequestParam(value="file") MultipartFile file) {
		try {
			userService.modifyUser(userVO,userCharacterVO,session, request, file);
			return "redirect:/userinfo?user_id="+((UserVO)session.getAttribute("user")).getUser_id();
		}catch (Exception e) {
			model.addAttribute("msg",e);
			System.out.println(e);
			return "main/fail";
		}
	}
	
//????????????
	@PostMapping("/comment")
	public String PostComment(Model model, CommentVO commentVO){
		try {
			commentService.insertComment(commentVO);
			return "redirect:/userinfo?user_id="+commentVO.getComment_id_to();
		}catch (Exception e) {
			model.addAttribute("msg",e);
			System.out.println(e);
			return "main/fail";
		}
	}
	//?????? ??????(?????? ????????? status??? 2??? ??????)
	@PostMapping("/delco")
	public String deleteComment(Model model, HttpSession session, int comment_id) {
		try {
			//if (login user != commented user) can't delete.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();
			int user_id = commentService.selectCommentByCommentId(comment_id).getComment_id_from();
			if(session_user_id==user_id) {
				commentService.deleteComment(comment_id);
				return "main/success";
			}else {
				model.addAttribute("msg","Unauthorized User");
				return "main/fail";
			}
		} catch (Exception e) {
			model.addAttribute("msg",e);
			System.out.println(e);
			return "main/fail";
		}
	}
	//?????? ??????(?????? ????????? status??? 1??? ????????? log??? ?????? ??????)
	@PostMapping("/modico")
	public String modifyComment(Model model,HttpSession session, int comment_id, String comment_contents) {
		try {
			//if (login user != commented user) can't modify.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();					//?????? ?????? id
			int user_id = commentService.selectCommentByCommentId(comment_id).getComment_id_from();		//????????? ??? ?????? id
			if(session_user_id==user_id) {
				commentService.modifyComment(comment_id, comment_contents);
				return "main/success";
			}else {
				model.addAttribute("msg","Unauthorized User");
				return "main/fail";
			}
		} catch (Exception e) {
			model.addAttribute("msg",e);
			System.out.println(e);
			return "main/fail";
		}
	}
	
	
//???????????????
	@PostMapping("/cocomment")
	public String PostCocomment(CocommentVO cocommentVO){
		cocommentService.insertCocomment(cocommentVO);
		return "main/success";
	}
	//????????? ??????(?????? ???????????? status??? 2??? ??????)
	@PostMapping("/delcoco")
	public String deleteCocomment(Model model, HttpSession session, int cocomment_id) {
		try {
			//if (login user != cocommented user) can't delete.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();
			int user_id = cocommentService.selectCocommentByCocommentId(cocomment_id).getCocomment_id_from();
			if(session_user_id==user_id) {
				cocommentService.deleteCocomment(cocomment_id);
				return "main/success";
			}else {
				model.addAttribute("msg","Unauthorized User");
				return "main/fail";
			}
		} catch (Exception e) {
			model.addAttribute("msg",e);
			System.out.println(e);
			return "main/fail";
		}
	}
	//????????? ??????
	@PostMapping("/modicoco")
	public String modifyCocomment(Model model,HttpSession session, int cocomment_id, String cocomment_contents) {
		try {
			// if (login user != cocommented user) can't modify.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();					//?????? ?????? id
			int user_id = cocommentService.selectCocommentByCocommentId(cocomment_id).getCocomment_id_from();		//???????????? ??? ?????? id
			if(session_user_id==user_id) {
				cocommentService.modifyComment(cocomment_id, cocomment_contents);
				return "main/success";
			}else {
				model.addAttribute("msg","Unauthorized User");
				return "main/fail";
			}
		} catch (Exception e) {
			model.addAttribute("msg",e);
			System.out.println(e);
			return "main/fail";
		}
	}
	
//????????????
	@PostMapping("/testJoin")
	public String testJoin(String email, String verificationCode, HttpSession session, Model model) {
		if(userService.codeChk(verificationCode, session)) {
			model.addAttribute("email", email);
			session.removeAttribute("verificationCode");
			return "main/testJoin";
		}else return "main/fail";
	}
	@PostMapping("testJoinComplete")
	public String testJoinComplete(UserVO user, UserCharacterVO userCharacter, HttpServletRequest request, MultipartFile file) {
		try {
			userService.insertUser(user, request, file);
			userCharacterService.insertUserCharacter(userCharacter);
			return "main/success";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/fail";
		}
	}
	
	@GetMapping("/join")
	public String UserInsertGet() {
		return "main/join";
	}
	
	//new join logic
	@GetMapping("/newjoin")
	public String newjoin() {
		return "main/joinMailCHK";
	}
	
	//?????? ?????????
	@PostMapping("/loadingPage")
	public String joinLoading(Model model, String user_email) {
		try {
			model.addAttribute("email", user_email);
			return "main/loadingPage";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg",e);
			return "main/fail";
		}
	}
	
	@PostMapping("/joinmail")
	public String joinjoin(Model model, String user_email, HttpSession session) {
		try {
			model.addAttribute("email", user_email);
			model.addAttribute("title", "???????????? ???????????? ??????????????? ???????????????");
			//userVo??? ????????? ???????????????:pw=useremail,id=set.tmpPW
			userService.insertTmpUser(user_email, session);
			return "main/sendmail";
		} catch (Exception e) {
			model.addAttribute("msg",e);
			return "main/fail";
		}
	}
	
	//???????????? ?????????
	@GetMapping("/realjoin")
	public String realjoin(@RequestParam(required = true)String tatemate, Model model) {
		model.addAttribute("user",userService.selectUserByshalizedEmail(tatemate));
		return "main/join";
		/*
		try {
			UserVO user = userService.selectUserByUserPw(tmpPw);
			if(user == null) {
				model.addAttribute("msg","????????? ?????????????????????.");
				return "main/fail";
			}
			//?????????????????? ?????????
			model.addAttribute("user_email", user.getUser_email());
			return "main/join";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("msg",e);
			return "main/fail";
		}
		*/
	}
	
	@PostMapping("/realjoin")
	public String UserInsertPost(Model model, UserVO vo, UserCharacterVO characterVO, HttpServletRequest request, @RequestParam(value="file") MultipartFile file) throws IllegalStateException, IOException {
		try {
			//userCharacterService.insertUserCharacter(characterVO);// modify??? ??????
			userService.modifyUser(vo, characterVO, null, request, file);
			return "redirect:/login";
		}catch (Exception e) {
			model.addAttribute("msg",e);
			return "main/fail";
		}
	}
	
	
	
	
	
	
	
//???????????? ??? email ?????? ??????
	@PostMapping("/emailChk")
	@ResponseBody
	public boolean UserEmailCHK(String user_email) {
		return userService.emailCheck(user_email);
	}

//?????????
	@GetMapping("/login")
	public String loginGet() {
		return "main/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, String user_email, String user_pw, HttpSession session) {
		UserVO user = userService.loginCheck(user_email, user_pw); 
		if (user == null) {
			model.addAttribute("msg","ID??? ??????????????? ??????????????????");
			return "main/fail";
		}else {
			session.setAttribute("user", user);
			session.setAttribute("userCharacter", userCharacterService.selectUserCharacterByUserId(user.getUser_id()));
			return "redirect:/main";
		}
		
	}
//?????? ?????? log out	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}	
	
	
//???????????? ?????? ?????????
	@GetMapping("/forgotPw")
	public String forgotPwGet() {
		return "main/forgotPw";
	}
	
//???????????? ?????? ????????? post
	@PostMapping("/forgotPw")
	public String forgotPwPost(String user_email, Model model) {
		try {
			UserVO user = userService.selectUserByUserEmail(user_email);
			if(user==null) {
				model.addAttribute("msg","???????????? ?????? EMAIL?????????.");
				return "main/fail";
			}
			userService.forgotPw(user.getUser_id());
			model.addAttribute("email", user_email);	// ${email}??? ??????????????? ????????? ??? ?????? ????????? ?????????! ???????????? ??????!
			model.addAttribute("title","??????????????? ????????????????????? ????????? ????????? ???????????? ????????????.");
			return "main/sendmail";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("msg",e);
			return "main/fail";
		}
	}

//???????????? ?????? ????????? get
	@GetMapping("/modifyPw")
	public String modifyPwGet(String tmpPw, Model model) {
		try {
			UserVO user = userService.selectUserByUserPw(tmpPw);
			if(user == null) {
				model.addAttribute("msg","????????? ?????????????????????.");
				return "main/fail";
			}
			model.addAttribute("user", user);
			return "main/modifyPw";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("msg",e);
			return "main/fail";
		}
		
	}

//???????????? ?????? ????????? post
	@PostMapping("modifyPw")
	public String modifyPwPost(int user_id, String user_email, String user_pw, Model model) {
		try {
			userService.modifyPw(user_id, user_email, user_pw);
			return "redirect:/login";
		} catch (Exception e) {
			model.addAttribute("msg", e);
			System.out.println(e);
			return "main/fail";
		}
	}
	
	
}
