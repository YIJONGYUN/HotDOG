package com.ybm.hotdog.category.service;

import com.ybm.hotdog.category.domain.CategoryDTO;

/**
 * 카테고리 관련 인터페이스 정의
 * 
 * @Package : com.ybm.hotdog.category.service
 * @FileName : CategoryService.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 30. 
 *
 */
public interface CategoryService {
	
	/** 카테고리 번호로 카테고리 조회 */
	public CategoryDTO getCategory (int categoryNo);
}
