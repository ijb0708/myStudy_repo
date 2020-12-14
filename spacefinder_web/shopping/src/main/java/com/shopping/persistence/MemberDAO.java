package com.shopping.persistence;

import com.shopping.domain.MemberVO;

public interface MemberDAO {
	
	// 회원 가입
	public void signup (MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO signin(MemberVO vo) throws Exception;
	
	// 아이디 중복체크
	public MemberVO idChk(String userId) throws Exception;
}
