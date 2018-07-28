package com.ybm.hotdog;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.mating.service.BoardMatingService;
import com.ybm.hotdog.user.domain.UserDTO;
import com.ybm.hotdog.user.service.UserService;

/**
 * 메뉴 관련 컨트롤러
 * 
 * @Package : com.ybm.hotdog
 * @FileName : HomeController.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 24. 
 *
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardMatingService matingService;
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("인덱스 페이지", locale);
		
		return "index";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale) {
		logger.info("핫도그란? 페이지 들어옴~", locale);
		
		return "about/about";
	}
	
	@RequestMapping(value = "/board/mating", method = RequestMethod.GET)
	public String boardMating(Model model) {
		logger.info("도그시그널 페이지 들어옴~");
		
		List<ArticleDTO> list = matingService.listAll();
		
		model.addAttribute("boardMatingList", list);
		
		return "board/mating/mating";
	}
	
	@RequestMapping(value = "/board/info", method = RequestMethod.GET)
	public String boardInfo(Locale locale) {
		logger.info("독스타그램 페이지 들어옴~", locale);
		
		return "board/info/info";
	}
	
	@RequestMapping(value = "/board/parcel", method = RequestMethod.GET)
	public String boardParcel(Locale locale) {
		logger.info("이리오시개 페이지 들어옴~", locale);
		
		return "board/parcel/parcel";
	}
	
}
