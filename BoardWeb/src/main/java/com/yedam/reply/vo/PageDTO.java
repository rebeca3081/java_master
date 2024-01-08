package com.yedam.reply.vo;

import lombok.Data;

@Data
public class PageDTO {
	// 필드
	private int currPage;
	private int totalCnt;
	private boolean prev, next;
	private int startPage, lastPage;

	// 생성자: (현재페이지, 건수) <- 매개변수
	public PageDTO(int page, int totalCnt) {
		this.currPage = page;
		this.totalCnt = totalCnt;

		// 이전페이지 여부, 첫페이지, 마지막페이지, 이후페이지 여부
		// 전체건수:70건, 15페이지
		int realLast = (int) Math.ceil(totalCnt / 5.0); // 마지막페이지가 몇번인지 (14)
		this.lastPage = (int) Math.ceil(page / 5.0) * 5; // 5개씩 페이지번호를 보여주기위함 마지막페이지
		this.startPage = this.lastPage - 4; // 5개 번호를 보여주기로 했으니 -4하면 첫번호가 계산됨
		this.lastPage = this.lastPage > realLast ? realLast : this.lastPage;

		this.prev = this.startPage > 1;
		this.next = this.lastPage < realLast; // 유휴페이지가 있음
	}

	// 우클릭 -> source toString() 오버라이딩
	@Override
	public String toString() {
		return "PageDTO [currPage=" + currPage + ", totalCnt=" + totalCnt + ", prev=" + prev + ", next=" + next
				+ ", startPage=" + startPage + ", lastPage=" + lastPage + "]";
	}
}
