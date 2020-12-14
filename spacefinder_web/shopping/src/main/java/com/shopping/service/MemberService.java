package com.shopping.service;

import javax.servlet.http.HttpSession;

import com.shopping.domain.MemberVO;

public interface MemberService {
	
	//회원 가입
	public void signup(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO signin(MemberVO vo) throws Exception;
	
	//로그아웃
	public void signout(HttpSession session) throws Exception;
	
	//id중복체크
	public MemberVO idChk(String userId) throws Exception;
}
