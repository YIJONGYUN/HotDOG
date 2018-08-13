package com.ybm.hotdog.board.info.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
import com.ybm.hotdog.board.info.service.BoardInfoService;
import com.ybm.hotdog.category.domain.CategoryDTO;
import com.ybm.hotdog.category.service.CategoryService;
import com.ybm.hotdog.user.domain.UserDTO;
import com.ybm.hotdog.user.service.UserService;

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

	@Inject
	private BoardInfoService service;

	@Inject
	private UserService userService;

	@Inject
	private CategoryService categoryService;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String boardForm(Locale locale, Model model) {
		logger.info("독스타그램 글 작성 페이지", locale);

		List<CategoryDTO> category = categoryService.getCategoryList(1);
		model.addAttribute("category", category);

		return "board/info/infoForm";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String boardFormSearch(@RequestParam("searchOption") String searchOption,@RequestParam("keyword") String keyword, Model model) {
		logger.info("독스타그램 게시글 검색");
		
		List<ArticleDTO> list = service.searchArticle(searchOption, keyword);
		List<UserDTO> name = new ArrayList<UserDTO>();
		List<CategoryDTO> category = new ArrayList<CategoryDTO>();
		int articleCount = 0;
		
		for (ArticleDTO articleList : list) {
			name.add(userService.getUser(articleList.getUserNo()));
			category.add(categoryService.getCategory(articleList.getCategoryNo()));
			articleCount++;
		}

		model.addAttribute("boardInfoList", list);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		model.addAttribute("articleCount", articleCount);
		
		return "board/info/info";
	}

	@RequestMapping(value = "/detail/{articleNo}", method = RequestMethod.GET)
	public String boardDetail(Locale locale, Model model, @PathVariable int articleNo) {
		logger.info("독스타그램 글 상세 페이지", locale);

		ArticleDTO article = service.getArticle(articleNo);
		CategoryDTO category = categoryService.getCategory(article.getCategoryNo());
		UserDTO user = userService.getUser(article.getUserNo());
		List<ReplyDTO> reply = service.replyListAll(articleNo);
		int replyCount = service.countReply(articleNo);

		/** 조회수 올리기 */
		int hitCount = article.getHitCount();
		hitCount++;
		article.setHitCount(hitCount);
		service.articleEdit(article);

		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("user", user);
		model.addAttribute("reply", reply);
		model.addAttribute("replyCount", replyCount);


		return "board/info/infoDetail";
	}

	@RequestMapping(value = "/viewedit/{articleNo}", method = RequestMethod.GET)
	public String boardViewEdit(@PathVariable int articleNo,Model model) {
	logger.info("독스타그램 글 수정 페이지");
		
	ArticleDTO article = service.getArticle(articleNo);
	CategoryDTO category = categoryService.getCategory(article.getCategoryNo());
	List<CategoryDTO> categoryList = categoryService.getCategoryList(1);
	
	model.addAttribute("article",article);
	model.addAttribute("category",category);
	model.addAttribute("categoryList",categoryList);

		return "board/info/infoEdit";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String boardRegister(ArticleDTO article) {

		article.setStep(1);
		article.setOrder(1);

		service.articleRegister(article);

		return "redirect:/board/info";
	}

	@RequestMapping(value = "/rearticleRegister", method = RequestMethod.POST)
	public String rearticleRegister(ArticleDTO article) {

		article.setCategoryNo(1);
		service.articleRegister(article);

		return "redirect:/board/info";
	}

	@RequestMapping(value = "/delete/{articleNo}", method = RequestMethod.GET)
	public String boardDelete(@PathVariable int articleNo) throws Exception{

		service.articleDelete(articleNo);

		return "redirect:/board/info";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String boardEdit(ArticleDTO article) throws Exception{

		service.articleEdit(article);

		return "redirect:/board/info";
	}
	
	@RequestMapping(value = "/reply/{articleNo}", method = RequestMethod.POST)
	public String addReply(@RequestParam("replyContent") String replyContent, @PathVariable int articleNo, Model model)
			throws Exception {
		logger.info(" 댓글 다는중 ");
		ReplyDTO reply = new ReplyDTO();
		reply.setArticleNo(articleNo);
		reply.setContent(replyContent);
		reply.setUserNo(2);

		service.replyRegister(reply);

		ArticleDTO article = service.getArticle(articleNo);
		CategoryDTO category = categoryService.getCategory(article.getCategoryNo());
		UserDTO user = userService.getUser(article.getUserNo());
		List<ReplyDTO> reply1 = service.replyListAll(articleNo);
		List<UserDTO> userName = new ArrayList<UserDTO>();
		int replyCount = service.countReply(articleNo);

		for (ReplyDTO replyList : reply1) {
			userName.add(userService.getUser(replyList.getUserNo()));
		}

		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("user", user);
		model.addAttribute("reply", reply1);
		model.addAttribute("replyCount", replyCount);
		model.addAttribute("userName", userName);
		model.addAttribute("articleNo", articleNo);

		return "board/info/infoDetail";
	}

	@RequestMapping(value = "/rearticleForm/{articleNo}", method = RequestMethod.GET)
	public String rearticle(@PathVariable int articleNo, Model model) throws Exception {

		ArticleDTO articleDTO = service.getArticle(articleNo);
		
		if (articleDTO.getGroup() == 1) {
			articleDTO.setGroup(articleDTO.getArticleNo());
			service.articleEdit(articleDTO);
			articleDTO.setOrder(articleDTO.getOrder() + 1);
			articleDTO.setStep(articleDTO.getStep() + 1);
			articleDTO.setGroup(articleDTO.getArticleNo());
		} else {
			articleDTO.setOrder(articleDTO.getOrder() + 1);
			articleDTO.setStep(articleDTO.getStep() + 1);
			articleDTO.setGroup(articleDTO.getGroup());
		}

		model.addAttribute("articleDTO", articleDTO);

		return "board/info/rearticleForm";

	}

}


