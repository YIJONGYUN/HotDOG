package com.ybm.hotdog.user.service;

import java.util.List;

import com.ybm.hotdog.user.domain.UserDTO;

/**
 * 회원 관련 인터페이스 정의
 * 
 * @Package : com.ybm.hotdog.user.service
 * @FileName : UserService.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
public interface UserService {
	
	/** 회원 목록 조회 */
	public List<UserDTO> UserListAll ();

}
