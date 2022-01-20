package edu.test.demo.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.test.demo.service.CocommentService;
import edu.test.demo.service.CommentService;
import edu.test.demo.vo.CocommentVO;
import edu.test.demo.vo.CommentVO;
import edu.test.demo.vo.UserVO;

@RestController
@RequestMapping("/api/main/userInfo/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	@Autowired
	CocommentService cocommentService;

	//댓글창
	@GetMapping("/")
	public JSONArray commentList(Integer user_id) {
		return cocommentService.selectCocommentByCommentIdTo(user_id);
	}
	
	//댓글작성
	@PostMapping("/insert")
	public boolean insertComment(CommentVO commentVO) {
		try {
			commentService.insertComment(commentVO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//댓글수정
	@PostMapping("/modify")
	public boolean modifyComment(HttpSession session, Integer comment_id, String comment_contents) {
		try {
			//if (login user != commented user) can't modify.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();					//세션 유저 id
			int user_id = commentService.selectCommentByCommentId(comment_id).getComment_id_from();		//댓글을 쓴 유저 id
			if(session_user_id==user_id) {
				commentService.modifyComment(comment_id, comment_contents);
				return true;
			}else {
				return false;	//	작성자가 아님
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//댓글삭제
	@PostMapping("/delete")
	public boolean deleteComment(HttpSession session, Integer comment_id) {
		try {
			//if (login user != commented user) can't delete.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();
			int user_id = commentService.selectCommentByCommentId(comment_id).getComment_id_from();
			if(session_user_id==user_id) {
				commentService.deleteComment(comment_id);
				return true;
			}else {
				return false; // 작성자가 아님
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//대댓글작성
	@PostMapping("/cocomment/insert")
	public boolean insertCocomment(CocommentVO cocommentVO) {
		try {
			cocommentService.insertCocomment(cocommentVO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//대댓글수정
	@PostMapping("/cocomment/modify")
	public boolean modifyCocomment(HttpSession session, Integer cocomment_id, String cocomment_contents) {
		try {
			// if (login user != cocommented user) can't modify.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();					//세션 유저 id
			int user_id = cocommentService.selectCocommentByCocommentId(cocomment_id).getCocomment_id_from();		//대댓글을 쓴 유저 id
			if(session_user_id==user_id) {
				cocommentService.modifyComment(cocomment_id, cocomment_contents);
				return true;
			}else {
				return false;	//	작성자가 아님
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//대댓글삭제
	@PostMapping("/cocomment/delete")
	public boolean deleteCocomment(HttpSession session, Integer cocomment_id) {
		try {
			//if (login user != cocommented user) can't delete.
			int session_user_id = ((UserVO)session.getAttribute("user")).getUser_id();
			int user_id = cocommentService.selectCocommentByCocommentId(cocomment_id).getCocomment_id_from();
			if(session_user_id==user_id) {
				cocommentService.deleteCocomment(cocomment_id);
				return true;
			}else {
				return false;	//	작성자가 아님
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
