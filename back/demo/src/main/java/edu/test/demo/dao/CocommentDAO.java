package edu.test.demo.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.test.demo.vo.CocommentVO;
import edu.test.demo.vo.NicknamedCocommentVO;

@Repository
@Mapper
public interface CocommentDAO {
	public CocommentVO selectCocommentByCocommentId(int cocomment_id);//���� ���̵�� Ư�� ������ 1�� �޾ƿ�
	public NicknamedCocommentVO selectNicknamedCocommentByCocommentId(int cocomment_id);//ver nickname
	public List<CocommentVO> selectCocommentByCommentId(int comment_id);//��� ���̵�� ���� ����� �޾ƿ�
	public List<NicknamedCocommentVO> selectNicknamedCocommentByCommentId(int comment_id);// ver nickname
	public int insertCocomment(CocommentVO vo);		//대댓글 입력
	public int deleteCocomment(int cocomment_id);	//대댓글 삭제
	public int modifyCocomment(Map<String, Object> idAndContents);	//대댓글 수정
}
