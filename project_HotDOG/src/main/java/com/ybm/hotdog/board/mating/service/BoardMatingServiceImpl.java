package com.ybm.hotdog.board.mating.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.mating.dao.BoardMatingDAO;

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

}
