package com.yju.bbs.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yju.bbs.dto.Board;

@Repository("com.yju.bbs.mapper.BoardMapper")
public interface BoardMapper {
	
	public List<Board> BoardList();
	
	public Board BoardView(int idx);
	
	public void BoardInsert(Board board);
	
	public void BoardDelete(int idx);
	
	public void BoardUpdate(Board board);
}
