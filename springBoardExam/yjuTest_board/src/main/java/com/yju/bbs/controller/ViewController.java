package com.yju.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yju.bbs.service.MainService;

@Controller
public class ViewController {
	
	@Autowired
	private MainService main;

	@RequestMapping("/view")
	public String MainView(Model model, HttpSession sess) {

		String check = (String) sess.getAttribute("logId");
		System.out.println("view sess: " + check);
		
		if(check == null) {
			System.out.println("logout");
			return "redirect:/";
		}
		
		model.addAttribute("members", main.MemberList());
		model.addAttribute("boards", main.BoardList());
		
		return "view";
	}

	@RequestMapping("/makeBoardView")
	public String MakeBoardView(HttpSession sess) {

		String check = (String) sess.getAttribute("logId");
		System.out.println("view sess: " + check);
		
		if(check == null) {
			System.out.println("logout");
			return "redirect:/";
		}
		
		return "makeBoard";
	}

	@RequestMapping("/boardDetail/{dno}")
	public String BoardDetail(@PathVariable int dno, Model model, HttpSession sess) {

		String check = (String) sess.getAttribute("logId");
		System.out.println("view sess: " + check);
		
		if(check == null) {
			System.out.println("logout");
			return "redirect:/";
		}
		
		model.addAttribute("board", main.BoardView(dno));
		
		return "BoardDetail";
	}
	
	@RequestMapping("/boardDetailNon/{dno}")
	public String BoardDetailNon(@PathVariable int dno, Model model, HttpSession sess) {

		String check = (String) sess.getAttribute("logId");
		System.out.println("view sess: " + check);
		
		if(check == null) {
			System.out.println("logout");
			return "redirect:/";
		}
		
		model.addAttribute("board", main.BoardView(dno));
		
		return "BoardDetail";
	}
	
}
