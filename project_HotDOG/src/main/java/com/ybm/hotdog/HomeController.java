package com.ybm.hotdog;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
import com.ybm.hotdog.board.info.service.BoardInfoService;
import com.ybm.hotdog.board.mating.service.BoardMatingService;
import com.ybm.hotdog.board.parcel.service.BoardPager;
import com.ybm.hotdog.board.parcel.service.BoardParcelService;
import com.ybm.hotdog.category.domain.CategoryDTO;
import com.ybm.hotdog.category.service.CategoryService;
import com.ybm.hotdog.user.domain.UserDTO;
import com.ybm.hotdog.user.service.UserService;
import com.ybm.hotdog.util.PagingHelper;

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
	private BoardInfoService InfoService;

	@Inject
	private BoardParcelService parcelService;

	@Inject
	private UserService userService;

	@Inject
	private CategoryService categoryService;

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
	public String boardMating(Model model, Integer curPage) {
		logger.info("도그시그널 페이지 들어옴~ 페이지: " + curPage);
		
		if (curPage == null) curPage = 1;
		
		int numPerPage = 10;	// 페이지 당 게시글 수
		int pagePerBlock = 5;	// 페이지 링크 그룹 (block) 크기
		int totalRecord = matingService.getArticleNumber();	// 전체 게시글 수
		
		PagingHelper pagingHelper = new PagingHelper(totalRecord, curPage, numPerPage, pagePerBlock);
		matingService.setPagingHelper(pagingHelper);
		
		int start = pagingHelper.getStartRecord();
		int end = pagingHelper.getEndRecord();
		
		List<ArticleDTO> list = matingService.getArticleList(start, end);
		List<UserDTO> name = new ArrayList<UserDTO>();
		List<CategoryDTO> category = new ArrayList<CategoryDTO>();
		List<Integer> replyNumber = new ArrayList<Integer>();

		for (ArticleDTO articleList : list) {
			name.add(userService.getUser(articleList.getUserNo()));
			category.add(categoryService.getCategory(articleList.getCategoryNo()));
			replyNumber.add(matingService.getReplyNumber(articleList.getArticleNo()));
		}
		
		int listNo = matingService.getListNo();
		int prevLink = matingService.getPrevLink();
		int nextLink = matingService.getNextLink();
		int firstPage = matingService.getFirstPage();
		int lastPage = matingService.getLastPage();
		int[] pages = matingService.getPages();
		
		logger.info(pagingHelper.toString());

		model.addAttribute("boardMatingList", list);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		model.addAttribute("articleNumber", totalRecord);
		model.addAttribute("replyNumber", replyNumber);
		model.addAttribute("prevLink", prevLink);
		model.addAttribute("nextLink", nextLink);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("pages", pages);
		model.addAttribute("curPage", curPage);
		model.addAttribute("listNo", listNo);

		return "board/mating/mating";
	}

	@RequestMapping(value = "/board/info", method = RequestMethod.GET)
	public String boardInfo(Locale locale, Model model) {
		logger.info("독스타그램 페이지 들어옴~", locale);

		List<ArticleDTO> list = InfoService.listAll();
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

	@RequestMapping(value = "/board/parcel", method = RequestMethod.GET)
	public String boardParcel(Locale locale, Model model, @RequestParam(defaultValue = "list") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage) {
		logger.info("이리오시개 페이지 들어옴~", locale);

		int count = parcelService.searchCount(searchOption, keyword);
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<ArticleDTO> list = parcelService.listAll(searchOption, keyword, start, end);
		List<UserDTO> name = new ArrayList<UserDTO>();
		List<CategoryDTO> category = new ArrayList<CategoryDTO>();
		List<Integer> replyCount = new ArrayList<Integer>();

		for (ArticleDTO articleList : list) {
			name.add(userService.getUser(articleList.getUserNo()));
			category.add(categoryService.getCategory(articleList.getCategoryNo()));
			replyCount.add(parcelService.listReply(articleList.getArticleNo()).size());
		}

		model.addAttribute("boardParcelList", list);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		model.addAttribute("replyCount", replyCount);
		model.addAttribute("boardPager", boardPager);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);

		return "board/parcel/parcel";
	}

}
