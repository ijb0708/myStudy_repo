package com.yju.bbs.mapper;

import org.springframework.stereotype.Repository;

import com.yju.bbs.dto.Board;

@Repository("com.yju.bbs.mapper.TestMapper")
public interface TestMapper {
	
	public Board test();
	
	public void BoardInsertTest(Board board);
}
