package com.ybm.hotdog.board.info;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.info.dao.BoardInfoDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardInfoDaoTest {
	
	@Inject
	private BoardInfoDAO dao;
	
	Logger logger = Logger.getLogger(BoardInfoDaoTest.class);
	
	/** 게시글 전체 조회 테스트 */
	@Test
	public void testListAll()  throws Exception {
		List<ArticleDTO> list = dao.listAll();
		
		for (ArticleDTO article : list) {
			logger.info(list);
		}
	}

}
