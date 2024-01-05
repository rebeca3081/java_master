package com.yedam.reply.service;

import java.util.List;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyService {
	// 비지니스 로직
	List<ReplyVO> replyList(int boardNo); // 댓글목록
	List<ReplyVO> replyListPaging(int boardNo, int page); // 5개로 나뉜 댓글 목록
	boolean removeReply(int replyNo); // 댓글 삭제
	boolean addReply(ReplyVO vo); // 댓글 추가
	ReplyVO getReply(int replyNo); // 조회
}
