package com.ybm.hotdog.board.mating;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.mating.dao.BoardMatingDAO;
import com.ybm.hotdog.category.dao.CategoryDAO;
import com.ybm.hotdog.category.domain.CategoryDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardMatingDaoTest {
	
	@Inject
	private BoardMatingDAO dao;
	
	@Inject
	private CategoryDAO categoryDao;
	
	Logger logger = Logger.getLogger(BoardMatingDaoTest.class);
	
	/** 게시글 전체 조회 테스트 */
	@Test
	public void testListAll()  throws Exception {
		List<ArticleDTO> list = dao.listAll();
		
		for (ArticleDTO article : list) {
			logger.info(list);
		}
	}
	
	/** 카테고리 조회 테스트 */
	@Test
	public void testCategory()  throws Exception {
		CategoryDTO list = categoryDao.getCategory(8);
		
		logger.info(list.getContent());
	}
	
	/** 글 조회 테스트 */
	@Test
	public void testArticleDetail()  throws Exception {
		ArticleDTO article = dao.getArticle(1);
		
		logger.info(article);
	}

}
