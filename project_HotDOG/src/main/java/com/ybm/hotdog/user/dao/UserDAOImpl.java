package com.ybm.hotdog.user.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.user.domain.UserDTO;

/**
 * UserDAO 인터페이스를 구현하는 클래스
 * 
 * @Package : com.ybm.hotdog.user.dao
 * @FileName : UserDAOImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.ybm.hotdog.mappers.UserMapper";
	
	Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	/** 회원 목록 조회 */
	@Override
	public List<UserDTO> UserListAll() {
		return sqlSession.selectList(namespace + ".userListAll");
	}

	/** 회원 번호로 회원 정보 조회 */
	@Override
	public UserDTO getUser(int userNo) {
		return sqlSession.selectOne(namespace + ".getUser", userNo);
	}

}
