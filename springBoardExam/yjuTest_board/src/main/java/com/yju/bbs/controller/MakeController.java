package com.yju.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yju.bbs.dto.Board;
import com.yju.bbs.service.MainService;

@Controller
public class MakeController {
	
	@Autowired
	private MainService main;
	
	@RequestMapping("/makeBoardView/make")
	public String MakeBoard(HttpServletRequest req, HttpSession sess) {
		
		String inputTitle = req.getParameter("title");
		String inputCont = req.getParameter("cont");
		String userid = (String) sess.getAttribute("logId");
		
		Board board = new Board();
		board.setTitle(inputTitle);
		board.setCont(inputCont);
		board.setUserid(userid);
		
		main.BoardInsert(board);
		
		return "redirect:/view";
	}
	
	@RequestMapping("/like/{dno}")
	public String LikeBoard(@PathVariable int dno, HttpSession sess) {
		
		String userInfo = (String) sess.getAttribute("logInfo");
		
		Board board = new Board();
		board.setIdx(dno);
		board.setMan_hit(main.BoardView(dno).getMan_hit());
		board.setMan_hit(main.BoardView(dno).getNor_hit());
		
		if(userInfo.equals("nor")) {
			board.setNor_like(main.BoardView(dno).getNor_like()+1);
			board.setMan_like(main.BoardView(dno).getMan_like());
		}
		if(userInfo.equals("man")) {
			board.setMan_like(main.BoardView(dno).getMan_like()+1);
			board.setNor_like(main.BoardView(dno).getNor_like());
		}
		main.BoardUpdate(board);
		
		return "redirect:/boardDetailNon/"+dno;
	}
}
