package com.ybm.hotdog.board.mating.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		matingService.hitcountUpdate(articleNo);
		
		ArticleDTO article = matingService.getArticle(articleNo);
		CategoryDTO category = categoryService.getCategory(article.getCategoryNo());
		UserDTO user = userService.getUser(article.getUserNo());
		
		
		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("user", user);
		
		return "board/mating/matingDetail";
	}
	
	@RequestMapping(value = "/editForm/{articleNo}", method = RequestMethod.GET)
	public String boardEdit(Model model, @PathVariable int articleNo) {
		logger.info("도그시그널 글 수정 페이지");
		
		ArticleDTO article = matingService.getArticle(articleNo);
		CategoryDTO category = categoryService.getCategory(article.getCategoryNo());
		List<CategoryDTO> categoryList = categoryService.getCategoryList(3);
		
		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryList);
		
		return "board/mating/matingEdit";
	}
	
	/**
	 * 게시글 등록
	 *
	 * @Method Name : regist
	 * @param article	등록할 게시글 객체
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(ArticleDTO article) throws Exception {
		
		matingService.regist(article);
		
		return "redirect:/board/mating";
	}
	
	/**
	 * 게시글 삭제
	 *
	 * @Method Name : delete
	 * @param model
	 * @param articleNo	삭제할 게시글 번호
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{articleNo}", method = RequestMethod.GET)
	public String delete(@PathVariable int articleNo) throws Exception {
		
		matingService.delete(articleNo);
		
		return "redirect:/board/mating";
	}
	
	/**
	 * 게시글 수정
	 *
	 * @Method Name : edit
	 * @param article
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(ArticleDTO article) {
		
		matingService.edit(article);
		
		return "redirect:/board/mating";
	}
	
	/**
	 * 게시글 검색
	 *
	 * @Method Name : search
	 * @param model
	 * @param search
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model, String searchType, String keyword) throws Exception {
		
		List<ArticleDTO> list = matingService.search(searchType, keyword);
		List<UserDTO> name = new ArrayList<UserDTO>();
		List<CategoryDTO> category = new ArrayList<CategoryDTO>();
		int articleNumber = matingService.getSearchNumber(searchType, keyword);

		for (ArticleDTO articleList : list) {
			name.add(userService.getUser(articleList.getUserNo()));
			category.add(categoryService.getCategory(articleList.getCategoryNo()));
		}

		model.addAttribute("boardMatingList", list);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		model.addAttribute("articleNumber", articleNumber);

		return "board/mating/mating";
	}
}
