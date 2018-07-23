package com.ybm.hotdog.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 게시판 관련 프로젝트 Controller @RequestMapping("/board") URI 매칭
 * 
 * @Package : com.ybm.hotdog.board.controller
 * @FileName : BoardController.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 23. 
 *
 */

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}
	
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage() {
		return "user/register";
	}

}
