package com.ybm.hotdog.board.info.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.info.dao.BoardInfoDAO;

/**
 * BoardInfoService 인터페이스 구현 클래스
 * 
 * @Package : com.ybm.hotdog.board.info.service
 * @FileName : BoardInfoServiceImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
@Service
public class BoardInfoServiceImpl implements BoardInfoService {
	
	@Inject
	private BoardInfoDAO dao;

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll() {
		return dao.listAll();
	}

}
