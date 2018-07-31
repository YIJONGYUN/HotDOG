package com.ybm.hotdog.board.parcel.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.board.domain.ArticleDTO;

@Repository
public class BoardParcelDAOImpl implements BoardParcelDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.ybm.hotdog.mappers.parcelBoardMapper";

	/** 게시글 목록 전체 조회 */
	@Override
	public List<ArticleDTO> listAll() {
		return sqlSession.selectList(namespace + ".boardParcelListAll"); // selectList : 쿼리 결과를 List<E>로 반환
	}

	/** 게시글 상세 내용 조회 */
	@Override
	public ArticleDTO getArticle(int articleNo) {
		return sqlSession.selectOne(namespace + ".articleDetail", articleNo);// selectOne : 쿼리 결과로 레코드 하나만 반환
	}

}
