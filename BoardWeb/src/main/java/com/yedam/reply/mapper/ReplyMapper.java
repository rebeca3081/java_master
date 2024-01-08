package com.yedam.reply.mapper;

import java.util.HashMap;
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
	
	// 페이지 계산하기 위한 전체 건수 반환.
	int selectCount(int boardNo);
	
	// 차트데이터(댓글, 작성건수)<String, Object> => <key, value>
	// 컬럼이 2개이기 때문에 VO를 따로 만들지 않고 키:value로 사용하도록 함
	List<HashMap<String, Object>> selectReplyCnt();
}
