package com.ybm.hotdog.board.mating.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
import com.ybm.hotdog.board.mating.dao.BoardMatingDAO;
import com.ybm.hotdog.util.PagingHelper;

/**
 * BoardMatingService 인터페이스 구현 클래스
 * 
 * @Package : com.ybm.hotdog.board.mating.service
 * @FileName : BoardMatingServiceImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */

@Service
public class BoardMatingServiceImpl implements BoardMatingService {
	
	@Inject
	private BoardMatingDAO dao;
	
	private PagingHelper pagingHelper;

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll() {
		return dao.listAll();
	}

	/** 게시글 상세 조회 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		return dao.getArticle(articleNo);
	}

	/** 게시글 등록 */
	@Override
	public void regist(ArticleDTO article) {
		dao.regist(article);
	}

	/** 게시글 삭제 */
	@Override
	public void delete(int articleNo) {
		dao.delete(articleNo);
	}

	/** 게시글 수정 */
	@Override
	public void edit(ArticleDTO article) {
		dao.edit(article);
	}

	/** 조회수 증가 */
	@Override
	public void hitcountUpdate(int articleNo) {
		dao.hitcountUpdate(articleNo);
	}

	/** 전체 게시글 수 조회 */
	@Override
	public int getArticleNumber() {
		return dao.getArticleNumber();
	}

	/** 게시글 검색 */
	@Override
	public List<ArticleDTO> search(String searchType, String keyword) {
		return dao.search(searchType, keyword);
	}

	/** 검색 게시글 수 조회 */
	@Override
	public int getSearchNumber(String searchType, String keyword) {
		return dao.getSearchNumber(searchType, keyword);
	}

	/** 댓글 작성 */
	@Override
	public void registReply(ReplyDTO reply) {
		dao.registReply(reply);
	}

	/** 댓글 조회 */
	@Override
	public List<ReplyDTO> getReply(int articleNo) {
		return dao.getReply(articleNo);
	}

	/** 댓글 수 조회 */
	@Override
	public int getReplyNumber(int articleNo) {
		return dao.getReplyNumber(articleNo);
	}

	/** 답글 등록 */
	@Override
	public void registRearticle(ArticleDTO article) {
		dao.registRearticle(article);
	}

	/** 답글 계층 및 순서 수정 */
	@Override
	public void updateRearticle(int group, int order) {
		dao.updateRearticle(group, order);
	}

	/** 페이징 처리 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> getArticleList(int start, int end) {
		return dao.getArticleList(start, end);
	}

	@Override
	public int getFirstPage() {
		return pagingHelper.getFirstPage();
	}

	@Override
	public int getLastPage() {
		return pagingHelper.getLastPage();
	}

	@Override
	public int getPrevLink() {
		return pagingHelper.getPrevLink();
	}

	@Override
	public int getNextLink() {
		return pagingHelper.getNextLink();
	}

	@Override
	public int getListNo() {
		return pagingHelper.getListNo();
	}

	@Override
	public int[] getPages() {
		return pagingHelper.getPages();
	}
	
	public PagingHelper getPagingHelper() {
		return pagingHelper;
	}

	@Override
	public void setPagingHelper(PagingHelper pagingHelper) {
		this.pagingHelper = pagingHelper;
	}
	
}
