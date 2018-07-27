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

	@Override
	public List<UserDTO> UserListAll() {
		return dao.UserListAll();
	}

}
