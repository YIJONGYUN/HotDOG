package com.ybm.hotdog.board.domain;

/**
 * 게시판 관련 객체 선언 및 getter(), setter() 메소드 정의
 * 
 * @Package : com.ybm.hotdog.board.domain
 * @FileName : BoardDTO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25.
 *
 */
public class BoardDTO {
	private int boardNo;
	private String boardName;

	public BoardDTO() {}

	public BoardDTO(int boardNo, String boardName) {
		this.boardNo = boardNo;
		this.boardName = boardName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardName=" + boardName + "]";
	}

}
