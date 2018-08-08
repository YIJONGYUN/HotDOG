package com.ybm.hotdog.board.parcel.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;

@Repository
public class BoardParcelDAOImpl implements BoardParcelDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.ybm.hotdog.mappers.parcelBoardMapper";

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll(String searchOption, String keyword, int start, int end) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);

		return sqlSession.selectList(namespace + ".boardParcelListAll", map); // selectList : 쿼리 결과를 List<E>로 반환
	}

	/** 검색 게시글 전체 수 */
	@Override
	public int searchCount(String searchOption, String keyword) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne(namespace + ".searchCount", map);
	}

	/** 댓글 전체 조회 */
	@Override
	public List<ReplyDTO> listReply(int articleNo) {
		return sqlSession.selectList(namespace + ".listReply", articleNo);
	}

	/** 게시글 상세 내용 조회 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		return sqlSession.selectOne(namespace + ".articleDetail", articleNo);// selectOne : 쿼리 결과로 레코드 하나만 반환
	}

	/** 게시글 삭제 */
	@Override
	public void articleDelete(int articleNo) {
		sqlSession.delete(namespace + ".articleDelete", articleNo);
	}

	/** 게시글 작성 */
	@Override
	public void articleInsert(ArticleDTO articleDTO) {
		sqlSession.insert(namespace + ".articleInsert", articleDTO);

	}

	/** 답글 구조 */
	@Override
	public void replyView(int group, int order) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("group", group);
		map.put("order", order);

		sqlSession.insert(namespace + ".replyView", map);
	}

	/** 답글 작성 */
	@Override
	public void articleReplyInsert(ArticleDTO articleDTO) {
		sqlSession.insert(namespace + ".articleReplyInsert", articleDTO);
	}

	/** 댓글 작성 */
	@Override
	public void replyInsert(ReplyDTO replyDTO) {
		sqlSession.insert(namespace + ".replyInsert", replyDTO);

	}

	/** 게시글 수정 */
	@Override
	public void articleUpdate(ArticleDTO articleDTO) {
		sqlSession.update(namespace + ".articleUpdate", articleDTO);

	}

	/** 게시글 조회수 증가 */
	@Override
	public void increaseHitCount(int articleNo) {
		sqlSession.update(namespace + ".increaseHitCount", articleNo);

	}
}
