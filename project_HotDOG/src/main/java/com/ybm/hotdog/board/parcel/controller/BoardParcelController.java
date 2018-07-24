package com.ybm.hotdog.board.parcel.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 분양 게시판 관련 프로젝트 Controller @RequestMapping("/board/parcel") URI 매칭
 * 
 * @Package : com.ybm.hotdog.board.parcel.controller
 * @FileName : BoardParcelController.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25. 
 *
 */

@Controller
@RequestMapping("/board/parcel")
public class BoardParcelController {
private static final Logger logger = LoggerFactory.getLogger(BoardParcelController.class);
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String boardForm(Locale locale) {
		logger.info("이리오시개 글 작성 페이지", locale);
		
		return "board/parcel/parcelForm";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boardDetail(Locale locale) {
		logger.info("이리오시개 글 상세 페이지", locale);
		
		return "board/parcel/parcelDetail";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String boardEdit(Locale locale) {
		logger.info("이리오시개 글 수정 페이지", locale);
		
		return "board/parcel/parcelEdit";
	}
}
