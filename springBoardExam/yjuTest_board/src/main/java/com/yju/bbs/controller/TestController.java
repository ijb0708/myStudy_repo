package com.yju.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yju.bbs.dto.Board;
import com.yju.bbs.dto.Member;
import com.yju.bbs.service.MainService;
import com.yju.bbs.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService test;
	
	@Autowired
	private MainService main;
	
	@RequestMapping("/test")
	public String Test(Model model) {
		
		System.out.println(test.testService());
		System.out.println(main.MemberList());
		System.out.println(main.BoardList());
		System.out.println(main.MemberView("ȫ�浿"));
		System.out.println(main.BoardView(0));
		System.out.println("select Pass");
		
		Member member = new Member();
		member.setUserid("test");
		member.setUserpw("test");
		member.setInfo("man");
		main.MemberInsert(member);
		System.out.println("Member insert Pass");
		
		test.testString();
		System.out.println("string Test : "+test.testString());
		
		Board board1 = new Board();
		board1.setTitle("test");
		board1.setCont("test");
		board1.setUserid("ȫ�浿");
		test.BoardInsertTest(board1);
		System.out.println("Board insert Pass");

		test.testString();
		System.out.println("string Test : "+test.testString());
		
		Board board2 = new Board();
		board2.setIdx(0);
		board2.setMan_hit(1);
		board2.setMan_like(1);
		board2.setNor_hit(1);
		board2.setNor_like(1);
		main.BoardUpdate(board2);
		System.out.println("Board update Pass");
		
		main.MemberDelete("test");
		System.out.println("Member delete Pass");
		
		main.BoardDelete(0);
		System.out.println("Board delete Pass");
		
		model.addAttribute("board", test.testService());
		
		return "Test";
	}
	
}
