package com.ybm.hotdog.category.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ybm.hotdog.category.dao.CategoryDAO;
import com.ybm.hotdog.category.domain.CategoryDTO;

/**
 * CategoryService 인터페이스 구현 클래스
 * 
 * @Package : com.ybm.hotdog.category.service
 * @FileName : CategoryServiceImpl.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 30. 
 *
 */

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Inject
	private CategoryDAO dao;

	/** 카테고리 번호로 카테고리 조회 */
	@Override
	public CategoryDTO getCategory(int categoryNo) {
		return dao.getCategory(categoryNo);
	}

}
