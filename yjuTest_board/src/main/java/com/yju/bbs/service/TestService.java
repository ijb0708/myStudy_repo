package com.yju.bbs.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yju.bbs.dto.Board;
import com.yju.bbs.mapper.TestMapper;

@Service
@Transactional
public class TestService {

	@Resource(name="com.yju.bbs.mapper.TestMapper")
	@Autowired
	private TestMapper testmapper;
	
	public Board testService() {
		return testmapper.test();
	}
	
	public String testString() {
		return "test";
	}
	
	public void BoardInsertTest(Board board) {
		testmapper.BoardInsertTest(board);
	}
}
