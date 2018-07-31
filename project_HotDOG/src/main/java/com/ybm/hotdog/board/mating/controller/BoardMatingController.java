package com.ybm.hotdog.board.mating.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.mating.service.BoardMatingService;
import com.ybm.hotdog.category.domain.CategoryDTO;
import com.ybm.hotdog.category.service.CategoryService;
import com.ybm.hotdog.user.domain.UserDTO;
import com.ybm.hotdog.user.service.UserService;

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
	
	@Inject
	private BoardMatingService matingService;
	
	@Inject
	private UserService userService;
	
	@Inject
	private CategoryService categoryService;
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String boardForm(Model model) {
		logger.info("도그시그널 글 작성 페이지");
		
		List<CategoryDTO> categoryList = categoryService.getCategoryList(3);
		
		model.addAttribute("categoryList", categoryList);
		
		return "board/mating/matingForm";
	}
	
	@RequestMapping(value = "/detail/{articleNo}", method = RequestMethod.GET)
	public String boardDetail(Model model, @PathVariable int articleNo) {
		logger.info("도그시그널 글 상세 페이지");
		
		ArticleDTO article = matingService.getArticle(articleNo);
		CategoryDTO category = categoryService.getCategory(article.getCategoryNo());
		UserDTO user = userService.getUser(article.getUserNo());
		
		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("user", user);
		
		return "board/mating/matingDetail";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String boardEdit(Locale locale) {
		logger.info("도그시그널 글 수정 페이지", locale);
		
		return "board/mating/matingEdit";
	}
	
	/**
	 * 게시글 등록
	 *
	 * @Method Name : regist
	 * @param article	등록할 게시글 객체
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(ArticleDTO article, RedirectAttributes rttr) throws Exception {
		
		logger.info(article.toString());
		matingService.regist(article);
		
		rttr.addFlashAttribute("message", "success");
		
		return "redirect:/board/mating";
	}
	
}
