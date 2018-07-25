package com.ybm.hotdog.board.domain;

import java.util.Date;

/**
 * 게시글 관련 객체 선언 및 getter(), setter() 메소드 정의
 * 
 * @Package : com.ybm.hotdog.board.domain
 * @FileName : ArticleDTO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25.
 *
 */
public class ArticleDTO {
	private int articleNo;
	private int boardNo;
	private int userNo;
	private int categoryNo;
	private String title;
	private String content;
	private Date regDate;
	private int hitCount;
	private int group;
	private int step;
	private int order;

	public ArticleDTO() {}

	public ArticleDTO(int articleNo, int boardNo, int userNo, int categoryNo, String title, String content, Date regDate, int hitCount, int group, int step, int order) {
		this.articleNo = articleNo;
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.categoryNo = categoryNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hitCount = hitCount;
		this.group = group;
		this.step = step;
		this.order = order;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "ArticleDTO [articleNo=" + articleNo + ", boardNo=" + boardNo + ", userNo=" + userNo + ", categoryNo="
				+ categoryNo + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", hitCount="
				+ hitCount + ", group=" + group + ", step=" + step + ", order=" + order + "]";
	}

}
