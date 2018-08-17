package com.ybm.hotdog.user;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ybm.hotdog.user.dao.UserDAO;
import com.ybm.hotdog.user.domain.UserDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoTest {
	
	@Inject
	private UserDAO dao;
	
	Logger logger = Logger.getLogger(UserDaoTest.class);
	
	/** 회원 목록 조회 테스트 */
	@Test
	public void TestUserListAll() {
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		list = dao.UserListAll();
		
		for (UserDTO user : list) {
			logger.info("리스트 : "+list);
		}
		
	}
	
	/** 회원 가입 테스트 */
	@Test
	public void TestRegistAll() {
		
		UserDTO user = new UserDTO(1, "test", "1111", "이종윤", "01026479515", 1);
				
		dao.register(user);
		
		logger.info("회원가입 완료");
		
	}
	
	/** 로그인 테스트 */
	@Test
	public void TestLogin() {
		
		UserDTO user = new UserDTO(1, "jong", "1234", "이종윤", "01026479515", 1);
				
		UserDTO userDTO = dao.login(user);
		
		logger.info(userDTO.toString());
		
	}
}
