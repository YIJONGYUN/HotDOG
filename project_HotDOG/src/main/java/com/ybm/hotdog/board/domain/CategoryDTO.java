package com.ybm.hotdog.board.domain;

/**
 * 카테고리 관련 객체 선언 및 getter(), setter() 메소드 정의
 * 
 * @Package : com.ybm.hotdog.board.domain
 * @FileName : CategoryDTO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25.
 *
 */
public class CategoryDTO {
	private int categoryNo;
	private int boardNo;
	private String content;

	public CategoryDTO() {}

	public CategoryDTO(int categoryNo, int boardNo, String content) {
		this.categoryNo = categoryNo;
		this.boardNo = boardNo;
		this.content = content;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryNo=" + categoryNo + ", boardNo=" + boardNo + ", content=" + content + "]";
	}

}
