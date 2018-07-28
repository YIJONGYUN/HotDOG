package com.ybm.hotdog.board.mating.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.board.domain.ArticleDTO;
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

}
