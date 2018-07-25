package com.ybm.hotdog.board.domain;

import java.util.Date;

/**
 * 댓글 관련 객체 선언 및 getter(), setter() 메소드 정의
 * 
 * @Package : com.ybm.hotdog.board.domain
 * @FileName : ReplyDTO.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 25.
 *
 */
public class ReplyDTO {
	private int replyNo;
	private int articleNo;
	private int userNo;
	private String content;
	private Date regDate;

	public ReplyDTO() {}

	public ReplyDTO(int replyNo, int articleNo, int userNo, String content, Date regDate) {
		this.replyNo = replyNo;
		this.articleNo = articleNo;
		this.userNo = userNo;
		this.content = content;
		this.regDate = regDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

	@Override
	public String toString() {
		return "ReplyDTO [replyNo=" + replyNo + ", articleNo=" + articleNo + ", userNo=" + userNo + ", content="
				+ content + ", regDate=" + regDate + "]";
	}

}
