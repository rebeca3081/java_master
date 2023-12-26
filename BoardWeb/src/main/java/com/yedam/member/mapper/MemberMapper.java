package com.yedam.member.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	// @Param("id") : 쿼리문의 파라미터 값으로 쓰고싶은 값 이름지정
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
}
