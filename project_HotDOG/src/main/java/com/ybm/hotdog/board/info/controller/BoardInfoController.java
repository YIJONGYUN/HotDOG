package com.ybm.hotdog.board.info.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 정보 게시판 관련 프로젝트 Controller @RequestMapping("/board/info") URI 매칭
 * 
 * @Package : com.ybm.hotdog.board.info.controller
 * @FileName : BoardInfoController.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25. 
 *
 */

@Controller
@RequestMapping("/board/info")
public class BoardInfoController {
	private static final Logger logger = LoggerFactory.getLogger(BoardInfoController.class);
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String boardForm(Locale locale) {
		logger.info("독스타그램 글 작성 페이지", locale);
		
		return "board/info/infoForm";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boardDetail(Locale locale) {
		logger.info("독스타그램 글 상세 페이지", locale);
		
		return "board/info/infoDetail";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String boardEdit(Locale locale) {
		logger.info("독스타그램 글 수정 페이지", locale);
		
		return "board/info/infoEdit";
	}
}
