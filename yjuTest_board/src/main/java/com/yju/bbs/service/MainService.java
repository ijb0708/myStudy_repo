package com.yju.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yju.bbs.dto.Board;
import com.yju.bbs.dto.Member;
import com.yju.bbs.mapper.BoardMapper;
import com.yju.bbs.mapper.MemberMapper;

@Service
@Transactional
public class MainService {

	@Resource(name="com.yju.bbs.mapper.MemberMapper")
	@Autowired
	MemberMapper membermapper;
	
	@Resource(name="com.yju.bbs.mapper.BoardMapper")
	@Autowired
	BoardMapper boardmapper;
	
	//member select
	public List<Member> MemberList() {
		return membermapper.MemberList();
	}
	
	public Member MemberView(String userid) {
		return membermapper.MemberView(userid);
	}

	//member insert
	public void MemberInsert(Member member) {
		membermapper.MemberInsert(member);
	}
	
	//member delete
	public void MemberDelete(String userid) {
		membermapper.MemberDelete(userid);
	}
	
	//board select
	public List<Board> BoardList() {
		return boardmapper.BoardList();
	}
	
	public Board BoardView(int idx) {
		return boardmapper.BoardView(idx);
	}
	
	//board insert
	public void BoardInsert(Board board) {
		boardmapper.BoardInsert(board);
	}
	
	//board delete
	public void BoardDelete(int idx) {
		boardmapper.BoardDelete(idx);
	}
	
	public void BoardUpdate(Board board) {
		boardmapper.BoardUpdate(board);
	}
}
