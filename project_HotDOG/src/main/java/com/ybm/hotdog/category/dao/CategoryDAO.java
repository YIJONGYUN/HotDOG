package com.ybm.hotdog.category.dao;

import java.util.List;

import com.ybm.hotdog.category.domain.CategoryDTO;

/**
 * 카테고리 DB에서 데이터를 가져와 모델 생성
 * 
 * @Package : com.ybm.hotdog.category.dao
 * @FileName : CategoryDAO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 30. 
 *
 */
public interface CategoryDAO {

	/** 카테고리 번호로 카테고리 조회 */
	public CategoryDTO getCategory (int categoryNo);
	
	/** 게시판 번호로 카테고리 리스트 조회 */
	public List<CategoryDTO> getCategoryList (int boardNo);
}
