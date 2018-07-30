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

}
