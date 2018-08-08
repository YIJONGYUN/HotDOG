package com.ybm.hotdog.board.parcel;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.parcel.dao.BoardParcelDAO;
import com.ybm.hotdog.category.dao.CategoryDAO;
import com.ybm.hotdog.category.domain.CategoryDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
// root-context에 Test를 사용하기위해 dao context 추가했음.
public class BoardParcelDaoTest {

	@Inject
	private BoardParcelDAO dao;

	@Inject
	private CategoryDAO categoryDao;

	Logger logger = Logger.getLogger(BoardParcelDaoTest.class);

	/** 카테고리 조회 테스트 */
	@Test
	public void testCategory() throws Exception {
		CategoryDTO list1 = categoryDao.getCategory(5);
		logger.info(list1.getContent());

		CategoryDTO list2 = categoryDao.getCategory(6);
		logger.info(list2.getContent());
	}

	/** 글 조회 테스트 */
	@Test
	public void testArticleDetail() throws Exception {
		ArticleDTO article = dao.getArticle(150);

		logger.info(article.toString());
	}

	@Test
	public void testArticleWrite() throws Exception {
		ArticleDTO article = new ArticleDTO();
		article.setTitle("테스트에서 작성");
		article.setContent("테스트에서 작성");
		article.setCategoryNo(5);

		dao.articleInsert(article);

		logger.info("작성 완료");
	}

}
