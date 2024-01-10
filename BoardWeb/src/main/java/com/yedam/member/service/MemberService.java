package com.yedam.member.service;

import java.util.List;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String id, String pw); // 로그인 기능
	public List<MemberVO> memberList(); // 회원 목록 기능
	public MemberVO getMember(String id); // 회원 상세 기능
	
	// 등록, 삭제
	public boolean addMember(MemberVO vo);
	public boolean removeMember(String id);
}
