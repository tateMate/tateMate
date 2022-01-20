package edu.test.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.test.demo.dao.CocommentDAO;
import edu.test.demo.dao.CommentDAO;
import edu.test.demo.vo.CocommentVO;
import edu.test.demo.vo.CommentVO;
import edu.test.demo.vo.NicknamedCocommentVO;
import edu.test.demo.vo.NicknamedCommentVO;

@Service
public class CocommentService {
	@Autowired
	CocommentDAO cocommentDAO;
	@Autowired
	CommentDAO commentDAO;
	
//select cocomment.  by PK(cocommentId)
	public CocommentVO selectCocommentByCocommentId(int cocomment_id) {
		return cocommentDAO.selectCocommentByCocommentId(cocomment_id);
	}
//select cocomment.  by PK(cocommentId) nickname version
	public NicknamedCocommentVO selectNicknamedCocommentByCocommentId(int cocomment_id) {
		return cocommentDAO.selectNicknamedCocommentByCocommentId(cocomment_id);
	}

//select cocomments(List). by commentID
	public List<CocommentVO> selectCocommentByCommentId(int comment_id) {
		return cocommentDAO.selectCocommentByCommentId(comment_id);
	}
//select cocomments(List). by commentID nickname version
	public List<NicknamedCocommentVO> selectNicknamedCocommentByCommentId(int comment_id) {
		return cocommentDAO.selectNicknamedCocommentByCommentId(comment_id);
	}

//insert cocomment
	public int insertCocomment(CocommentVO vo) {
		return cocommentDAO.insertCocomment(vo);
	}

//대댓글 삭제하기(status를 2으로 바꿈) delete cocomment(change status 2)
	public int deleteCocomment(int cocomment_id) {
		return cocommentDAO.deleteCocomment(cocomment_id);
	}
	
//해당 유저가 받은 comment의 id를 모두 읽어와서 cocomment를 선별
	public List<List<CocommentVO>> selectCocommentByUserId(int user_id){
		List<CommentVO> coLi=commentDAO.selectCommentByCommentIdTo(user_id);
		List<List<CocommentVO>> selected= new ArrayList<List<CocommentVO>>();
		for (CommentVO commentVO : coLi) {
			selected.add(cocommentDAO.selectCocommentByCommentId(commentVO.getComment_id()));
		}
		return selected;
	}
	
//JSONArray받기 ([{"comment":comment, "cocomment":[cocomment]}])
	public JSONArray selectCocommentByCommentIdTo(int user_id) {
		JSONArray ja = new JSONArray();
		List<NicknamedCommentVO> coList = commentDAO.selectNicknamedCommentByCommentIdTo(user_id);
		for(NicknamedCommentVO comment:coList) {
			List<NicknamedCocommentVO> cocoList = cocommentDAO.selectNicknamedCocommentByCommentId(comment.getComment_id());
			HashMap<String, Object> hm = new HashMap<>();
			hm.put("comment", comment);
			hm.put("cocomment", cocoList);
			JSONObject jo = new JSONObject(hm);
			ja.add(jo);
		}
		return ja;
	}
	
//대댓글 수정하기 change cocomment
	public int modifyComment(int cocomment_id, String cocomment_contents) {
		CocommentVO originCocomment = cocommentDAO.selectCocommentByCocommentId(cocomment_id);	//	기존 대댓글		origin
		CocommentVO newCocomment = new CocommentVO();	//	수정 대댓글		modified
		newCocomment.setComment_id(originCocomment.getComment_id());
		newCocomment.setCocomment_id_from(originCocomment.getCocomment_id_from());
		newCocomment.setCocomment_contents(originCocomment.getCocomment_contents());
		newCocomment.setCocomment_time(originCocomment.getCocomment_time());
		newCocomment.setCocomment_status(1);
		
		LocalDateTime now=LocalDateTime.now();
		
		cocomment_contents += "("+now.format(DateTimeFormatter.ofPattern("yy-MM-dd HH시 mm분"))+"에 수정됨)";	//	기존대댓글에 시간 추가 origin contents + modifying time
//		cocomment_contents += "("+Timestamp.valueOf(LocalDateTime.of(now.getYear(),now.getMonth(),now.getDayOfMonth(),now.getHour(),now.getMinute()))+"에 수정됨)";	//	기존대댓글에 시간 추가 origin contents + modifying time
		Map<String,Object> idAndContents = new HashMap<>();
		idAndContents.put("cocomment_id", cocomment_id);
		idAndContents.put("cocomment_contents", cocomment_contents);
		idAndContents.put("cocomment_time", originCocomment.getCocomment_time());
		//수정 대댓글 추가 + 기존 대댓글 수정		new insert, origin modify 
		int rst = cocommentDAO.insertCocomment(newCocomment) + cocommentDAO.modifyCocomment(idAndContents);
		return rst;
	}
	
	
	
}
