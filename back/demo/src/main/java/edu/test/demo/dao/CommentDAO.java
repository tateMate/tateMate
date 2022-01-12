package edu.test.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.test.demo.vo.CommentVO;
import edu.test.demo.vo.NicknamedCommentVO;

@Repository
@Mapper
public interface CommentDAO {
	public CommentVO selectCommentByCommentId(int comment_id);			//��� ���̵�� Ư�� ��� 1���� �޾ƿ�
	public NicknamedCommentVO selectNicknamedCommentByCommentId(int comment_id);	//ver nickname
	public List<CommentVO> selectCommentByCommentIdTo(int comment_id_to);//����� �޴� ��� ���̵�� ��� ����� ������
	public List<NicknamedCommentVO> selectNicknamedCommentByCommentIdTo(int comment_id_to);//ver nickname
	public int insertComment(CommentVO commentVO);	//댓글 입력
	public int deleteComment(int comment_id);	//댓글 삭제
	public int modifyComment(Map<String, Object> idAndContents);	//댓글 수정
}
