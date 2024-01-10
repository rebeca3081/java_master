package com.yedam.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	// @Param("id") : 쿼리문의 파라미터 값으로 쓰고싶은 값 이름지정
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	public List<MemberVO> selectList();
	public MemberVO selectOne(String id);
	
	// 입력, 삭제 (insert, delete, update -> int로 넘어옴)
	public int insertMember(MemberVO vo);
	public int deleteMember(String id);
}
