package edu.test.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.test.demo.dao.CommentDAO;
import edu.test.demo.vo.CommentVO;
import edu.test.demo.vo.NicknamedCommentVO;

@Service
public class CommentService {
	@Autowired
	CommentDAO commentDAO;
// select comment.  by PK(commentId)
	public CommentVO selectCommentByCommentId(int comment_id) {
		return commentDAO.selectCommentByCommentId(comment_id);
	}
// select comment.  by PK(commentId) nickname version
	public NicknamedCommentVO selectNicknamedCommentByCommentId(int comment_id) {
		return commentDAO.selectNicknamedCommentByCommentId(comment_id);
	}
//	select comments(List). by userID(to)
	public List<CommentVO> selectCommentByCommentIdTo(int comment_id_to){
		return commentDAO.selectCommentByCommentIdTo(comment_id_to);
	}
//	select comments(List). by userID(to) nickname version
	public List<NicknamedCommentVO> selectNicknamedCommentByCommentIdTo(int comment_id_to){
		return commentDAO.selectNicknamedCommentByCommentIdTo(comment_id_to);
	}
// insert comment
	public int insertComment(CommentVO vo) {
		//vo.setComment_time(Timestamp.valueOf(LocalDateTime.now()));
		return commentDAO.insertComment(vo);
	}

//댓글 삭제하기(status를 2으로 바꿈)	delete comment(change status 2)
	public int deleteComment(int comment_id) {
		return commentDAO.deleteComment(comment_id);
	}
	
//댓글 수정하기 change comment
	public int modifyComment(int comment_id, String comment_contents) {
		CommentVO originComment = commentDAO.selectCommentByCommentId(comment_id);	//	기존 댓글		origin
		CommentVO newComment = new CommentVO();	//	수정 댓글		modified
		newComment.setComment_id_to(originComment.getComment_id_to());
		newComment.setComment_id_from(originComment.getComment_id_from());
		newComment.setComment_contents("comment_id="+comment_id+" "+originComment.getComment_contents());
		newComment.setComment_time(originComment.getComment_time());
		newComment.setComment_access(originComment.getComment_access());
		newComment.setComment_status(1);
		
		comment_contents += "("+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH시 mm분"))+"에 수정됨)";	//	기존대댓글에 시간 추가 origin contents + modifying time
		Map<String,Object> idAndContents = new HashMap<>();
		idAndContents.put("comment_id", comment_id);
		idAndContents.put("comment_contents", comment_contents);
		idAndContents.put("comment_time", originComment.getComment_time());
		//수정 댓글 추가 + 기존 댓글 수정		new insert, origin modify 
		int rst = commentDAO.insertComment(newComment) + commentDAO.modifyComment(idAndContents);
		return rst;
	}
	
}
