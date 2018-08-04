package com.ybm.hotdog.board.parcel.controller;

import java.util.ArrayList;
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

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.parcel.service.BoardParcelService;
import com.ybm.hotdog.category.domain.CategoryDTO;
import com.ybm.hotdog.category.service.CategoryService;
import com.ybm.hotdog.user.domain.UserDTO;
import com.ybm.hotdog.user.service.UserService;

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

	@Inject
	private BoardParcelService service;

	@Inject
	private UserService userService;

	@Inject
	private CategoryService categoryService;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String boardForm(Locale locale) {
		logger.info("이리오시개 글 작성 페이지", locale);

		return "board/parcel/parcelForm";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String boardWrite(ArticleDTO articleDTO) {
		logger.info("이리오시개 글 작성 처리 페이지");

		service.articleInsert(articleDTO);

		return "redirect:/board/parcel";
	}

	@RequestMapping(value = "/detail/{articleNo}", method = RequestMethod.GET)
	public String boardDetail(Locale locale, Model model, @PathVariable int articleNo) {
		logger.info("이리오시개 글 상세 페이지", locale);

		service.increaseHitCount(articleNo);

		ArticleDTO article = service.getArticle(articleNo);
		UserDTO user = userService.getUser(article.getUserNo());
		CategoryDTO category = categoryService.getCategory(article.getCategoryNo());

		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("user", user);

		return "board/parcel/parcelDetail";
	}

	@RequestMapping(value = "/edit/{articleNo}", method = RequestMethod.GET)
	public String boardEdit(Locale locale, Model model, @PathVariable int articleNo) {
		logger.info("이리오시개 글 수정 페이지", locale);

		ArticleDTO article = service.getArticle(articleNo);
		UserDTO user = userService.getUser(article.getUserNo());
		CategoryDTO category = categoryService.getCategory(article.getCategoryNo());

		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("user", user);

		return "board/parcel/parcelEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String boardUpdate(ArticleDTO articleDTO) {
		logger.info("이리오시개 글 업데이트 페이지");

		service.articleUpdate(articleDTO);

		return "redirect:/board/parcel";
	}

	@RequestMapping(value = "/delete/{articleNo}", method = RequestMethod.GET)
	public String boardDelete(Locale locale, @PathVariable int articleNo) {
		logger.info("이리오시개 글 삭제 페이지", locale);

		service.articleDelete(articleNo);

		return "redirect:/board/parcel";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String boardSearchs(Model model, String searchOption, String keyword) {
		logger.info("이리오시개 글 검색 페이지");

		List<ArticleDTO> list = service.listSearch(searchOption, keyword);
		List<UserDTO> name = new ArrayList<UserDTO>();
		List<CategoryDTO> category = new ArrayList<CategoryDTO>();

		for (ArticleDTO articleList : list) {
			name.add(userService.getUser(articleList.getUserNo()));
			category.add(categoryService.getCategory(articleList.getCategoryNo()));
		}

		model.addAttribute("boardParcelList", list);
		model.addAttribute("name", name);
		model.addAttribute("category", category);

		return "board/parcel/parcel";
	}
}
