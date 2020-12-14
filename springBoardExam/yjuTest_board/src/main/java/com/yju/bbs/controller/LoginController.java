package com.yju.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yju.bbs.dto.Member;
import com.yju.bbs.service.MainService;

@Controller
public class LoginController {
	
	@Autowired
	private MainService main;
	
	@RequestMapping("/")
	public String HomeController(HttpSession sess) {
		
		String check = (String) sess.getAttribute("logId");
		String checkInfo = (String) sess.getAttribute("logInfo");
		System.out.println("sess: " + check);
		
		if(check != null) {
			System.out.println("user: " +  check + " : " + checkInfo);
			return "redirect:/view";
		}
		
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpSession sess) {
		String inputId = req.getParameter("userid");
		String inputPw = req.getParameter("userpw");
		
		System.out.println(inputId + " : " + inputPw);
		
		Member member = main.MemberView(inputId);
		
		if(member != null) {
			System.out.println(member);
			if(member.getUserpw().equals(inputPw)) {
				System.out.println("connect");
				sess.setAttribute("logId", member.getUserid());
				sess.setAttribute("logInfo", member.getInfo());
			}
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession sess) {
		sess.removeAttribute("logId");
		sess.removeAttribute("logInfo");
		return "redirect:/";
	}
	
}
