package com.ybm.hotdog.util;

import java.util.Arrays;

/**
 * 페이징 처리를 위한 유틸 클래스
 * 
 * @Package : com.ybm.hotdog.util
 * @FileName : PagingHelper.java
 * @Author : YI JONGYUN
 * @date : 2018. 8. 8. 
 *
 */
public class PagingHelper {

	private int firstPage; // 첫번째 페이지 번호
	private int lastPage; // 마지막 페이지 번호
	private int prevLink; // [이전] 링크
	private int nextLink; // [다음] 링크
	private int startRecord; // 목록 ROWNUM 시작
	private int endRecord; // 목록 ROWNUM 끝
	private int listNo;		// 목록에서 위에서부터 순서대로 붙여지는 번호
	private int[] pages; // 첫번째 페이지 번호부터 1씩 증가하여 마지막 페이지 번호까지 저장할 배열

	public PagingHelper(int totalRecord, int curPage, int numPerPage, int pagePerBlock) {
		
		/* 총 페이지 수 = 전체 게시물 / 페이지 당 게시물 수
		 * 				OR (전체 게시물 / 페이지 당 게시물 수) + 1 */
		int totalPage = ((totalRecord % numPerPage) == 0) ? totalRecord / numPerPage : totalRecord / numPerPage + 1;
		
		/* 한 블럭 <-- 1 2 3 4 5 --> */
		int totalBlock = ((totalPage % pagePerBlock) == 0) ? totalPage / pagePerBlock : totalPage / pagePerBlock + 1;
		
		/* 현재 블럭 */
		int block = ((curPage % pagePerBlock) == 0) ? curPage / pagePerBlock : curPage / pagePerBlock + 1;
		
		this.firstPage = (block - 1) * pagePerBlock + 1;
		this.lastPage = block * pagePerBlock;
		
		if (block >= totalBlock) {
			this.lastPage = totalPage;
		}
		
		pages = makeArray(firstPage, lastPage);
		
		if (block > 1) {
			this.prevLink = firstPage - 1;
		}
		
		if (block < totalBlock) {
			this.nextLink = lastPage + 1;
		}
		
		this.listNo = totalRecord - (curPage - 1) * numPerPage;
		this.startRecord = (curPage - 1) * numPerPage + 1;
		this.endRecord = startRecord + numPerPage - 1;
	}
	
	private int[] makeArray (int first, int last) {
		int size = last - first + 1;
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = first++;
		}
		return array;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getPrevLink() {
		return prevLink;
	}

	public int getNextLink() {
		return nextLink;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public int getEndRecord() {
		return endRecord;
	}

	public int getListNo() {
		return listNo;
	}

	public int[] getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return "PagingHelper [firstPage=" + firstPage + ", lastPage=" + lastPage + ", prevLink=" + prevLink
				+ ", nextLink=" + nextLink + ", startRecord=" + startRecord + ", endRecord=" + endRecord + ", listNo="
				+ listNo + ", pages=" + Arrays.toString(pages) + "]";
	}
}
