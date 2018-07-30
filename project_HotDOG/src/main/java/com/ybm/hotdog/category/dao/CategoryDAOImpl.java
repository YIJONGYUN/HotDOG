package com.ybm.hotdog.category.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ybm.hotdog.category.domain.CategoryDTO;

/**
 * CategoryDAO 인터페이스를 구현하는 클래스
 * 
 * @Package : com.ybm.hotdog.category.dao
 * @FileName : CategoryDAOImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 30. 
 *
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.ybm.hotdog.mappers.CategotyMapper";
	
	Logger logger = Logger.getLogger(CategoryDAOImpl.class);

	/** 카테고리 번호로 카테고리 조회 */
	@Override
	public CategoryDTO getCategory(int categoryNo) {
		return sqlSession.selectOne(namespace + ".getCategory", categoryNo);
	}

}
