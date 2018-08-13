package com.ybm.hotdog.board.info.dao;

import java.util.List;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;

/**
 * 정보게시판 DB에서 데이터를 가져와 모델 생성
 * 
 * @Package : com.ybm.hotdog.board.info.dao
 * @FileName : BoardInfoDAO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
public interface BoardInfoDAO {
	
	/** 게시글 목록 전체 조회 */
	public List<ArticleDTO> listAll();
	/** 게시글 번호로 검색 */
	public ArticleDTO getArticle(int articleNo);
	/** 게시글 등록 */
	public void articleRegister(ArticleDTO article);
	/** 게시글 삭제 */
	public void articleDelete(int articleNo);
	/** 게시글 수정 */
	public void articleEdit(ArticleDTO article);
	/** 게시글 검색 */
	public List<ArticleDTO> articleSearch(String searchOption, String keyword);
	/** 댓글 카운트 */
	public int countReply(int articleNo);
	/** 댓글등록  */
	public void replyRegister(ReplyDTO reply);
	/** 댓글 리스트 */
	public List<ReplyDTO> replyListAll(int articleNo);

}
