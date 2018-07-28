package com.ybm.hotdog.user.dao;

import java.util.List;

import com.ybm.hotdog.user.domain.UserDTO;

/**
 * 회원 관련 DB에서 데이터를 가져와 모델 생성
 * 
 * @Package : com.ybm.hotdog.user.dao
 * @FileName : UserDAO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
public interface UserDAO {

	/** 회원 목록 조회 */
	public List<UserDTO> UserListAll ();
	
	/** 회원 번호로 회원 정보 조회 */
	public UserDTO getUser (int userNo);
	
}
