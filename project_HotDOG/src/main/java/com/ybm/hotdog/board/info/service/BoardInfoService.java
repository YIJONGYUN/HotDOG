package com.ybm.hotdog.board.info.service;

import java.util.List;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
import com.ybm.hotdog.util.PagingHelper;

/**
 * 정보게시판 관련 인터페이스 정의
 * 
 * @Package : com.ybm.hotdog.board.info.service
 * @FileName : BoardInfoService.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
public interface BoardInfoService {
	
	/** 게시글 목록 전체 조회 */
	public List<ArticleDTO> listAll();
	/** 게시글 번호로 조회 */
	public ArticleDTO getArticle(int articleNo);
	/** 게시글 등록 */
	public void articleRegister(ArticleDTO article);
	/** 게시글 삭제 */
	public void articleDelete(int articleNo);
	/** 게시글 수정 */
	public void articleEdit(ArticleDTO article);
	/** 게시글 검색 */
	public List<ArticleDTO> searchArticle(String searchOption, String keyword, int start, int end);
	/** 댓글 카운트*/
	public int countReply(int articleNo);
	/** 댓글 등록 */
	public void replyRegister(ReplyDTO reply);
    /** 댓글 리스트 */
	public List<ReplyDTO> replyListAll(int articleNo);
	/** 답글 등록 */
	public void reArticleRegister(ArticleDTO article);
	/** order 재정렬 */
	public void reOrder(ArticleDTO article);
	/** 답글갯수 */
	public int countReArticle();
	/** 게시판별 답글갯수 */
	public int countPerReArticle(int articleNo);
	/** 게시판글 갯수 */
	public int countArticle();
	/** 검색 게시판글 갯수 */
	public int articleSearchNum(String searchOption, String keyword);
	/** 페이징 처리 게시글 목록 전체 조회 */
	public List<ArticleDTO> getPagingArticleList (int start, int end);
	
	//페이징
	
	public int getFirstPage();

	public int getLastPage();

	public int getPrevLink();

	public int getNextLink();

	public int getListNo();

	public int[] getPages();
	
	public void setPagingHelper (PagingHelper pagingHelper);
	
}
