package com.ybm.hotdog.board.mating;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;
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
	public void testInsert() throws Exception {
		ArticleDTO article = new ArticleDTO();
		article.setCategoryNo(7);
		article.setTitle("테스트에서 작성");
		article.setContent("테스트 테스트");
		
		dao.regist(article);
		
		logger.info("글 작성 완료!");
	}
	
	/** 글 삭제 테스트 */
	@Test
	public void testDelete() throws Exception {
		dao.delete(23);
		
		logger.info("글 삭제 완료!");
	}
	
	/** 글 수정 테스트 */
	@Test
	public void testUpdate() throws Exception {
		ArticleDTO article = new ArticleDTO();
		article.setArticleNo(21);
		article.setCategoryNo(7);
		article.setTitle("테스트에서 수정");
		article.setContent("테스트 테스트");
		
		dao.edit(article);
		
		logger.info("글 수정 완료!");
	}
	
	/** 게시글 수 조회 테스트 */
	@Test
	public void testGetArticlenumber() throws Exception {
		
		logger.info(dao.getArticleNumber());
		logger.info(dao.getSearchNumber("title", "수정"));
	}
	
	/** 게시글 검색 테스트 */
	@Test
	public void testSearch() throws Exception {
		List<ArticleDTO> list = dao.search("title", "답", 0, 10);

		for (ArticleDTO article : list) {
			logger.info(article.toString());
		}
	}
	
	/** 댓글 작성 테스트 */
	@Test
	public void testRegistReply() throws Exception {
		
		ReplyDTO reply = new ReplyDTO();
		reply.setArticleNo(1);
		reply.setContent("테스트에서 댓글 작성");
		
		dao.registReply(reply);

		logger.info("댓글 작성 완료!");
	}
	
	/** 답글 작성 테스트 */
	@Test
	public void testInsertReply() throws Exception {
		ArticleDTO article = new ArticleDTO();
		article.setCategoryNo(7);
		article.setArticleNo(65);
		article.setTitle("테스트에서 답글 작성");
		article.setContent("답글 1 내용");
		
		dao.registRearticle(article);
		
		logger.info("답글 작성 완료!");
	}

}
