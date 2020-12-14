package com.shopping.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopping.domain.MemberVO;
import com.shopping.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;

	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	// 회원 가입 get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception {
	 logger.info("get signup");
	}
	
	// 회원 가입 post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
	 logger.info("post signup");
	  
	 String inputPass = vo.getUserPass();
	 String pass = passEncoder.encode(inputPass);
	 vo.setUserPass(pass);
	 
	 service.signup(vo);
	 
	 vo.setUserPass(inputPass);

	 return postSignin(vo, req, rttr);
	}
	
	// 로그인  get
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getSignin() throws Exception {
	 logger.info("get signin");
	}
	
	// 로그인 post
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
	 logger.info("post signin");
	   
	 MemberVO login = service.signin(vo);  
	 HttpSession session = req.getSession();
	 
	 if(login != null) {
		 boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
		 if(passMatch) {
			 session.setAttribute("member", login);
		 }else {
			 session.setAttribute("member", null);
			  rttr.addFlashAttribute("msg", "비밀번호");
			  return "redirect:/member/signin";
		 }
	 } else {
	  session.setAttribute("member", null);
	  rttr.addFlashAttribute("msg", "아이디");
	  return "redirect:/member/signin";
	 }  
	 
	 return "redirect:/";
	}
	
	// 로그아웃
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpSession session) throws Exception {
	 logger.info("get logout");
	 
	 service.signout(session);
	   
	 return "redirect:/";
	}
	
	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	public int idChk(HttpServletRequest req) throws Exception {
		logger.info("post idCheck");
		String userId = req.getParameter("userId");
		MemberVO idChk = service.idChk(userId);
		
		int result = 0;
		
		if (idChk != null ) {
			result = 1;
		}
		
		return result;
	}
	
}
