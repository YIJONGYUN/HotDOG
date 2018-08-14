/**
 * @Summary   : 
 * @Package : com.ybm.hotdog.util
 * @FileName : infoPaging.java
 * @Author : KWON HANBYEOL
 * @date : 2018. 8. 14.  
 * 
 */
package com.ybm.hotdog.util;

/**
 * 
 * @Package : com.ybm.hotdog.util
 * @FileName : infoPaging.java
 * @Author : KWON HANBYEOL
 * @date : 2018. 8. 14.
 * 
 */
public class infoPaging {
	private int pageSize;  //한 페이지에 보여줄 게시글 수
	private int pageBlock; //페이징 블록 사이즈
	private int pageNo;    //페이지 번호
	private int startRowNo;//조회 시작 row 번호
	private int endRowNo;  //조회 마지막 row 번호
	private int firstPageNo; //첫 번째 페이지 번호
	private int finalPageNo;//마지막 페이지 번호
	private int prevPageNo;//이전 페이지 번호
	private int nextPageNo;//다음 페이지 번호
	private int startPageNo;//시작 페이지
	private int endPageNo;//끝 페이지
	private int totalCount;//전체 게시글 수

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageBlock
	 */
	public int getPageBlock() {
		return pageBlock;
	}

	/**
	 * @param pageBlock
	 *            the pageBlock to set
	 */
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the startRowNo
	 */
	public int getStartRowNo() {
		return startRowNo;
	}

	/**
	 * @param startRowNo
	 *            the startRowNo to set
	 */
	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}

	/**
	 * @return the endRowNo
	 */
	public int getEndRowNo() {
		return endRowNo;
	}

	/**
	 * @param endRowNo
	 *            the endRowNo to set
	 */
	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}

	/**
	 * @return the firstPageNo
	 */
	public int getFirstPageNo() {
		return firstPageNo;
	}

	/**
	 * @param firstPageNo
	 *            the firstPageNo to set
	 */
	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	/**
	 * @return the finalPageNo
	 */
	public int getFinalPageNo() {
		return finalPageNo;
	}

	/**
	 * @param finalPageNo
	 *            the finalPageNo to set
	 */
	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	/**
	 * @return the prevPageNo
	 */
	public int getPrevPageNo() {
		return prevPageNo;
	}

	/**
	 * @param prevPageNo
	 *            the prevPageNo to set
	 */
	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	/**
	 * @return the nextPageNo
	 */
	public int getNextPageNo() {
		return nextPageNo;
	}

	/**
	 * @param nextPageNo
	 *            the nextPageNo to set
	 */
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	/**
	 * @return the startPageNo
	 */
	public int getStartPageNo() {
		return startPageNo;
	}

	/**
	 * @param startPageNo
	 *            the startPageNo to set
	 */
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	/**
	 * @return the endPageNo
	 */
	public int getEndPageNo() {
		return endPageNo;
	}

	/**
	 * @param endPageNo
	 *            the endPageNo to set
	 */
	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void makePaging(int totalCount) {
		// 기본 값 설정
		if (this.totalCount == 0)
			return;
		if (this.pageNo == 0)
			this.setPageNo(1); // 기본 페이지 번호
		if (this.pageSize == 0)
			this.setPageSize(5); // 기본 페이지 리스트 사이즈
		if (this.pageBlock == 0)
			this.setPageBlock(5); // 기본 페이지 네비[블록] 사이즈

		// 첫 페이지, 마지막 페이지 계산
		int finalPage = (totalCount + (pageSize - 1)) / pageSize; // 마지막 페이지
		this.setFinalPageNo(1);
		this.setFinalPageNo(finalPage);

		// 이전, 다음 페이지 계산
		boolean isNowFirst = pageNo == 1 ? true : false;
		boolean isNowFinal = pageNo == finalPage ? true : false;
		if(isNowFirst) {
			this.setPrevPageNo(1); //이전 페이지 번호
		}else {
			this.setPrevPageNo(((pageNo - 1)<1?1:(pageNo-1)));  //이전 페이지 번호
		}
		if(isNowFinal) {
			this.setNextPageNo(finalPage); //다음 페이지 번호
		}else {
			this.setNextPageNo(((pageNo +1)>finalPage?finalPage:(pageNo+1))); //다음 페이지 번호
		}
		
		//페이징 블록을 계산
		int startPage = ((pageNo-1)/pageBlock)*pageBlock+1; //시작 페이지
		int endPage = startPage + pageBlock -1; //끝 페이지
		
		if(endPage>finalPage) { // 전체 페이지 수가 28인데 페이징이 30까지일경우 28까지만 노출
			endPage=finalPage;
		}
		this.setStartPageNo(startPage);
		this.setEndPageNo(endPage);
		
		//조회 시작 row 조회 마지막 row 계산
		int startRowNo = ((pageNo-1)*pageSize)+1;
		int endRowNo = pageNo*pageSize;
		setStartRowNo(startRowNo);
		setEndRowNo(endRowNo);
		
	}
}
