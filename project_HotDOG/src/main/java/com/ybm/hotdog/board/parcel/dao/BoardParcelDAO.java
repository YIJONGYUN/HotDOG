package com.ybm.hotdog.board.parcel.dao;

import java.util.List;

import com.ybm.hotdog.board.domain.ArticleDTO;

public interface BoardParcelDAO {

	/** 게시글의 목록 조회 */
	public List<ArticleDTO> listAll();// 모든 게시글을 가져옴으로 반환형이 리스트임을 알 수 있음.

	/** 게시글의 상세 내용 조회 */
	public ArticleDTO getArticle(int articleNo);// 많은 게시글 중 articleNo에 해당하는 글 하나만 가져옴.

	/** 게시글 저장 */
	public void articleInsert(ArticleDTO articleDTO);

	/** 게시글 수정 */
	public void articleUpdate(ArticleDTO articleDTO);

	/** 게시글 삭제 */
	public void articleDelete(int articleNo);

	/** 게시글 조회수 증가 */
	public void increaseHitCount(int articleNo);
	
	/** 게시글 검색 */
	public List<ArticleDTO> listSearch(String searchOption, String keyword);

}
