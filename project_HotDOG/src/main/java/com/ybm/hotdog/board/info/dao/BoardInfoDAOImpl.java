package com.ybm.hotdog.board.info.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;

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
		sqlSession.update(namespace + ".articleDelete",articleNo); 
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

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#countReply(int)
	 */
	@Override
	public int countReply(int articleNo) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace + ".countReply",articleNo);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#replyRegister(com.ybm.hotdog.board.domain.ReplyDTO)
	 */
	@Override
	public void replyRegister(ReplyDTO reply) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".replyRegister",reply);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#replyListAll(int)
	 */
	@Override
	public List<ReplyDTO> replyListAll(int articleNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".replyListAll", articleNo);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#reArticleRegister(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	@Override
	public void reArticleRegister(ArticleDTO article) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".reArticleRegister",article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#reOrder(com.ybm.hotdog.board.domain.ArticleDTO)
	 */
	/** order 재정렬 */
	@Override
	public void reOrder(ArticleDTO article) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".reOrder", article);
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#countReArticle()
	 */
	/** 답글갯수 */
	@Override
	public int countReArticle() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".countReArticle");
	}

	/* (non-Javadoc)
	 * @see com.ybm.hotdog.board.info.dao.BoardInfoDAO#countPerReArticle(int)
	 */
	/** 게시판별 답글갯수 */
	@Override
	public int countPerReArticle(int articleNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".countPerReArticle",articleNo);
	}

}
