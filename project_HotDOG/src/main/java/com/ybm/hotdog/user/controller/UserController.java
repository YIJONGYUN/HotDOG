package com.ybm.hotdog.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ybm.hotdog.user.domain.UserDTO;
import com.ybm.hotdog.user.service.UserService;

import oracle.net.aso.o;

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
		logger.info("로그인 페이지");
		return "user/login";
	}
	
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage() {
		return "user/register";
	}
	
	/**
	 * 회원가입
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
	
	/**
	 * 로그인
	 * 
	 * @Method Name : login
	 * @param user
	 * @param session
	 * @param model
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login (UserDTO user, HttpSession session, Model model) throws Exception {
		
		UserDTO loginCheck = service.login(user);
		
		if(loginCheck == null) {
			return;
		}
		
		model.addAttribute("user", loginCheck);
	}
	
	/**
	 * 로그아웃
	 *
	 * @Method Name : logout
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("login");
		
		if (obj != null) {
			UserDTO user = (UserDTO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
		}
		
		return "user/logout";
	}

}
