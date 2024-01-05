package com.yedam.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> relpyList(int boardNo);
	List<ReplyVO> replyListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	// int 같은 타입이기 때문에 구분하기 위해 @Param("boradNo")으로 이름을 지정해줌
	int deleteReply(int replyNo);
	int insertReply(ReplyVO vo);
	ReplyVO selectReply(int replyNo);
}
