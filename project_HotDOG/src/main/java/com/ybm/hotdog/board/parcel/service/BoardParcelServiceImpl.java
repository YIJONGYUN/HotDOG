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

	/** 게시글 검색 */
	@Override
	public List<ArticleDTO> listAll(String searchOption, String keyword, int start, int end) {
		return dao.listAll(searchOption, keyword, start, end);
	}

	/** 검색 게시글 전체 수 */
	@Override
	public int searchCount(String searchOption, String keyword) {
		return dao.searchCount(searchOption, keyword);
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

	/** 답글 구조 */
	@Override
	public void replyView(int group, int order) {
		dao.replyView(group, order);

	}

	/** 답글 저장 */
	@Override
	public void articleReplyInsert(ArticleDTO articleDTO) {
		dao.articleReplyInsert(articleDTO);
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

}
