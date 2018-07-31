package com.ybm.hotdog.board.info.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.board.domain.ArticleDTO;

/**
 * BoardInfoDAO 인터페이스를 구현하는 클래스
 * 
 * @Package : com.ybm.hotdog.board.info.dao
 * @FileName : BoardInfoDAOImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */

@Repository
public class BoardInfoDAOImpl implements BoardInfoDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.ybm.hotdog.mappers.InfoBoardMapper";

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll() {
		return sqlSession.selectList(namespace + ".boardInfoListAll");
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#getArticle(int)
	 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".articleDetail", articleNo);
	}

}
