package com.ybm.hotdog.user.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ybm.hotdog.user.domain.UserDTO;
import com.ybm.hotdog.user.service.UserService;

/**
 * 회원 관련 프로젝트 Controller @RequestMapping("/user") URI 매칭
 * 
 * @Package : com.ybm.hotdog.user.controller
 * @FileName : UserController.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 23. 
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

	UserDTO user;
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}
	
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage() {
		return "user/register";
	}
	
	/**
	 * 회원가입
	 * 
	 *
	 * @Method Name : register
	 * @param user	등록할 회원 객체
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String register(UserDTO user) throws Exception {
		
		service.register(user);
		
		return "user/login";
	}

}
