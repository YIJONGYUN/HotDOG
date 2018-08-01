package com.ybm.hotdog.board.mating.dao;

import java.util.List;

import com.ybm.hotdog.board.domain.ArticleDTO;

/**
 * 교배게시판 DB에서 데이터를 가져와 모델 생성
 * 
 * @Package : com.ybm.hotdog.board.mating.dao
 * @FileName : BoardMatingDAO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
public interface BoardMatingDAO {
	
	/** 게시글 목록 전체 조회 */
	public List<ArticleDTO> listAll();
	
	/** 게시글 상세 조회 */
	public ArticleDTO getArticle(int articleNo);
	
	/** 게시글 등록 */
	public void regist (ArticleDTO article);

	/** 게시글 삭제 */
	public void delete (int articleNo);
	
	/** 게시글 수정 */
	public void edit (ArticleDTO article);
	
	/** 조회수 증가 */
	public void hitcountUpdate(int articleNo);
	
	/** 전체 게시글 수 조회 */
	public int getArticleNumber();
}
