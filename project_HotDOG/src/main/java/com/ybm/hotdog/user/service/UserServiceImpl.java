package com.ybm.hotdog.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.user.dao.UserDAO;
import com.ybm.hotdog.user.domain.UserDTO;

/**
 * UserService 인터페이스 구현 클래스
 * 
 * @Package : com.ybm.hotdog.user.service
 * @FileName : UserServiceImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;

	/** 회원 목록 조회 */
	@Override
	public List<UserDTO> UserListAll() {
		return dao.UserListAll();
	}

	/** 회원 번호로 회원 정보 조회 */
	@Override
	public UserDTO getUser(int userNo) {
		return dao.getUser(userNo);
	}

	/** 회원 가입 */
	@Override
	public void register(UserDTO user) {
		dao.register(user);
	}

	/** 로그인 */
	@Override
	public UserDTO login(UserDTO user) {
		return dao.login(user);
	}

}
