package com.ybm.hotdog.board.info.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
import com.ybm.hotdog.board.info.dao.BoardInfoDAO;
import com.ybm.hotdog.util.PagingHelper;

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

	private PagingHelper pagingHelper;
	
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
	public List<ArticleDTO> searchArticle(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return dao.articleSearch(searchOption, keyword, start, end);
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

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#reArticleRegister(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	@Override
	public void reArticleRegister(ArticleDTO article) {
		// TODO Auto-generated method stub
		dao.reArticleRegister(article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#reOrder(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	@Override
	public void reOrder(ArticleDTO article) {
		// TODO Auto-generated method stub
		dao.reOrder(article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#countReArticle()
	 */
	/** 답글갯수 */
	@Override
	public int countReArticle() {
		// TODO Auto-generated method stub
		return dao.countReArticle();
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#countPerReArticle(int)
	 */
	/** 게시판별 답글갯수 */
	@Override
	public int countPerReArticle(int articleNo) {
		// TODO Auto-generated method stub
		return dao.countPerReArticle(articleNo);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#countArticle()
	 */
	/** 게시판글 갯수 */
	@Override
	public int countArticle() {
		// TODO Auto-generated method stub
		return dao.countArticle();
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

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#articleSearchNum(java.lang.String, java.lang.String)
	 */
	@Override
	public int articleSearchNum(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return dao.articleSearchNum(searchOption, keyword);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.service.BoardInfoService#getPagingArticleList(int, int)
	 */
	/** 페이징 처리 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> getPagingArticleList(int start, int end) {
		// TODO Auto-generated method stub
		return dao.getPagingArticleList(start, end);
	}
}
