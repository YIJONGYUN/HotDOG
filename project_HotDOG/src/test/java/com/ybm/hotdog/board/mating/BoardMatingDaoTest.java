package com.ybm.hotdog.board.mating;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardMatingDaoTest {

	@Inject
	private BoardMatingDAO dao;

	@Inject
	private CategoryDAO categoryDao;

	Logger logger = Logger.getLogger(BoardMatingDaoTest.class);

	/** 게시글 전체 조회 테스트 */
	@Test
	public void testListAll() throws Exception {
		List<ArticleDTO> list = dao.listAll();

		for (ArticleDTO article : list) {
			logger.info(article.toString());
		}
	}

	/** 카테고리 조회 테스트 */
	@Test
	public void testCategory() throws Exception {
		CategoryDTO list = categoryDao.getCategory(8);

		logger.info(list.getContent());
	}

	/** 글 조회 테스트 */
	@Test
	public void testArticleDetail() throws Exception {
		ArticleDTO article = dao.getArticle(1);

		logger.info(article);
	}
	
	/** 카테고리 리스트 조회 테스트 */
	@Test
	public void testCategoryList() throws Exception {
		List<CategoryDTO> list = categoryDao.getCategoryList(3);
		
		for (CategoryDTO categoryDTO : list) {
			logger.info(categoryDTO.toString());
		}
	}
	
	/** 글 작성 테스트 */
	@Test
	public void testCreate() throws Exception {
		ArticleDTO article = new ArticleDTO();
		article.setCategoryNo(7);
		article.setTitle("테스트에서 작성");
		article.setContent("테스트 테스트");
		
		dao.regist(article);
		
		logger.info("글 작성 완료!");
	}

}
