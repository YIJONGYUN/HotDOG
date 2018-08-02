package com.ybm.hotdog.board.info.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSession;
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

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#articleRegister(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	@Override
	public void articleRegister(ArticleDTO article) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".articleRegister",article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#articleDelete(int)
	 */
	@Override
	public void articleDelete(int articleNo) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".articleDelete",articleNo); 
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#articleEdit(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	@Override
	public void articleEdit(ArticleDTO article) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".articleEdit",article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#articleSearch(java.lang.String, java.lang.String)
	 */
	/** 키워드로 게시글 검색 */
	@Override
	public List<ArticleDTO> articleSearch(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectList(namespace + ".articleSearch",map);
	}

}
