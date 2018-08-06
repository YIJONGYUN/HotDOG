package com.ybm.hotdog.board.mating.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;

import oracle.net.aso.a;
/**
 * BoardMatingDAO 인터페이스를 구현하는 클래스
 * 
 * @Package : com.ybm.hotdog.board.mating.dao
 * @FileName : BoardMatingDAOImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
@Repository
public class BoardMatingDAOImpl implements BoardMatingDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.ybm.hotdog.mappers.MatingBoardMapper";

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll() {
		return sqlSession.selectList(namespace + ".boardMatingListAll");
	}

	/** 게시글 상세 조회 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		return sqlSession.selectOne(namespace + ".articleDetail", articleNo);
	}

	/** 게시글 등록 */
	@Override
	public void regist (ArticleDTO article) {
		sqlSession.insert(namespace + ".registMating", article);
	}

	/** 게시글 삭제 */
	@Override
	public void delete(int articleNo) {
		sqlSession.delete(namespace + ".deleteMating", articleNo);
	}

	/** 게시글 수정 */
	@Override
	public void edit (ArticleDTO article) {
		sqlSession.update(namespace + ".updateMating", article);
	}

	/** 조회수 증가 */
	@Override
	public void hitcountUpdate(int articleNo) {
		sqlSession.update(namespace + ".updateHitcount", articleNo);
	}

	/** 전체 게시글 수 조회 */
	@Override
	public int getArticleNumber() {
		return sqlSession.selectOne(namespace + ".getArticleNumber");
	}

	/** 게시글 검색 */
	@Override
	public List<ArticleDTO> search(String searchType, String keyword) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		
		return sqlSession.selectList(namespace + ".searchMating", map);
	}

	/** 검색 게시글 수 조회*/
	@Override
	public int getSearchNumber(String searchType, String keyword) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne(namespace + ".getSearchNumber", map);
	}

	/** 댓글 작성 */
	@Override
	public void registReply(ReplyDTO reply) {
		sqlSession.insert(namespace + ".registReply", reply);
	}

	/** 댓글 조회 */
	@Override
	public List<ReplyDTO> getReply(int articleNo) {
		return sqlSession.selectList(namespace + ".getReply" , articleNo);
	}

	/** 댓글 수 조회 */
	@Override
	public int getReplyNumber(int articleNo) {
		return sqlSession.selectOne(namespace + ".getReplyNumber", articleNo);
	}

	/** 답글 등록 */
	@Override
	public void registRearticle(ArticleDTO article) {
		sqlSession.insert(namespace + ".registMatingRearticle", article);
	}

	/** 답글 계층 및 순서 수정 */
	@Override
	public void updateRearticle(int group, int order) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("group", group);
		map.put("order", order);
		
		sqlSession.update(namespace + ".updateMatingRearticle", map);
	}

}
