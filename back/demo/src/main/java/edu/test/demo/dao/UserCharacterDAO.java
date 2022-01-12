package edu.test.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.test.demo.vo.UserCharacterVO;


@Repository
@Mapper
public interface UserCharacterDAO {
	public UserCharacterVO selectUserCharacterByUserId(int user_id);	//���� ���̵�� Ư�� ���� 1���� �޾ƿ�
	public int modifyUserCharacter(UserCharacterVO vo);		//modify user character
	public List<Integer> sameCharacter(UserCharacterVO vo);			//to recommend
	public int insertUserCharacter(UserCharacterVO characterVO);	//join
}
