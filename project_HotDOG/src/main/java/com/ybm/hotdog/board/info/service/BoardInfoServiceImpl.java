package com.ybm.hotdog.board.info.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
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

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#getArticle(int)
	 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		// TODO Auto-generated method stub
		return dao.getArticle(articleNo);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#articleRegister(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	@Override
	public void articleRegister(ArticleDTO article) {
		// TODO Auto-generated method stub
		dao.articleRegister(article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#articleDelete(int)
	 */
	@Override
	public void articleDelete(int articleNo) {
		// TODO Auto-generated method stub
		dao.articleDelete(articleNo);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#articleEdit(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	@Override
	public void articleEdit(ArticleDTO article) {
		// TODO Auto-generated method stub
		dao.articleEdit(article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#searchArticle(java.lang.String, java.lang.String)
	 */
	/** 키워드로 게시글 검색 */
	@Override
	public List<ArticleDTO> searchArticle(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return dao.articleSearch(searchOption, keyword);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#countReply(int)
	 */
	@Override
	public int countReply(int articleNo) {
		// TODO Auto-generated method stub
		return dao.countReply(articleNo);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#replyRegister(com.ybm.hotdog.board.domain.ReplyDTO)
	 */
	@Override
	public void replyRegister(ReplyDTO reply) {
		// TODO Auto-generated method stub
		dao.replyRegister(reply);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#replyListAll(int)
	 */
	@Override
	public List<ReplyDTO> replyListAll(int articleNo) {
		// TODO Auto-generated method stub
		return dao.replyListAll(articleNo);
	}

}
