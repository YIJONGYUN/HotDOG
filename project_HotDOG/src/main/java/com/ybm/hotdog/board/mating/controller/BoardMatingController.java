package com.ybm.hotdog.board.mating.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 교배 게시판 관련 프로젝트 Controller @RequestMapping("/board/mating") URI 매칭
 * 
 * @Package : com.ybm.hotdog.board.mating.controller
 * @FileName : BoardMatingController.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 24. 
 *
 */

@Controller
@RequestMapping("/board/mating")
public class BoardMatingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardMatingController.class);
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String boardForm(Locale locale) {
		logger.info("도그시그널 글 작성 페이지", locale);
		
		return "board/mating/boardForm";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boardDetail(Locale locale) {
		logger.info("도그시그널 글 상세 페이지", locale);
		
		return "board/mating/boardDetail";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String boardEdit(Locale locale) {
		logger.info("도그시그널 글 수정 페이지", locale);
		
		return "board/mating/boardEdit";
	}
	
}
