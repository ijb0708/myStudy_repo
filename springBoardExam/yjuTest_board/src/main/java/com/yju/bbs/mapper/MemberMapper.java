package com.yju.bbs.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yju.bbs.dto.Member;

@Repository("com.yju.bbs.mapper.MemberMapper")
public interface MemberMapper {
	
	public List<Member> MemberList();
	
	public Member MemberView(String userid);
	
	public void MemberInsert(Member member);
	
	public void MemberDelete(String userid);
}
