package com.ybm.hotdog.board.parcel.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
import com.ybm.hotdog.board.parcel.dao.BoardParcelDAO;

@Service
public class BoardParcelServiceImpl implements BoardParcelService {

	@Inject
	private BoardParcelDAO dao;

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll() {
		return dao.listAll();
	}

	/** 댓글 전체 조회 */
	@Override
	public List<ReplyDTO> listReply(int articleNo) {
		return dao.listReply(articleNo);
	}

	/** 게시글 상세 조회 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		return dao.getArticle(articleNo);
	}

	/** 게시글 삭제 */
	@Override
	public void articleDelete(int articleNo) {
		dao.articleDelete(articleNo);
	}

	/** 게시글 작성 */
	@Override
	public void articleInsert(ArticleDTO articleDTO) {
		dao.articleInsert(articleDTO);
	}

	/** 댓글 작성 */
	@Override
	public void replyInsert(ReplyDTO replyDTO) {
		dao.replyInsert(replyDTO);

	}

	/** 게시글 수정 */
	@Override
	public void articleUpdate(ArticleDTO articleDTO) {
		dao.articleUpdate(articleDTO);
	}

	/** 게시글 수정 */
	@Override
	public void increaseHitCount(int articleNo) {
		dao.increaseHitCount(articleNo);

	}

	/** 게시글 검색 */
	@Override
	public List<ArticleDTO> listSearch(String searchOption, String keyword) {
		return dao.listSearch(searchOption, keyword);
	}

}
