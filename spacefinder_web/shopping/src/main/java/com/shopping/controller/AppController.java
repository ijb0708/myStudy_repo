package com.shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.domain.GoodPVO;
import com.shopping.domain.MemberVO;
import com.shopping.service.AdminService;
import com.shopping.service.MemberService;

/*안드로이드 통신관련*/
@Controller
@RequestMapping("/app")
public class AppController {

	@Inject
	MemberService member_service;

	@Inject
	AdminService admin_service;

	@Autowired
	BCryptPasswordEncoder passEncoder;

	// 주차장조회
	@ResponseBody
	@RequestMapping(value = "/showparking", produces = "application/json;charset=utf-8")
	public Map<String, Object> showparking() {
		ArrayList<GoodPVO> list = null;
		try {
			list = (ArrayList<GoodPVO>) admin_service.gplist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parkinglist", list);

		return map;
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public Map<String, String> idChk(HttpServletRequest req) throws Exception {
		String userId = req.getParameter("id");

		System.out.println(userId);

		MemberVO idChk = member_service.idChk(userId);

		Map<String, String> map = new HashMap<String, String>();

		String result = "가능";

		if (idChk != null) {
			result = "불가능";
		}
		map.put("status", result);

		return map;
	}

	// 회원가입
	@RequestMapping(value = "/create_mem", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, String> create(MemberVO vo, HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pass"));
		System.out.println(request.getParameter("nickname"));
		System.out.println(request.getParameter("phone"));

		vo.setUserId(request.getParameter("id"));

		String inputPass = request.getParameter("pass");
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);
		vo.setUserName(request.getParameter("nickname"));
		vo.setUserPhon(request.getParameter("phone"));

		String result = "실패";

		try {
			member_service.signup(vo);
			result = "성공";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("status", result);

		return map;

	}

	// 앱 로그인
	@RequestMapping(value = "/login/{id}/{pass}", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, String> login(@PathVariable("id") String id, @PathVariable("pass") String pass) {
		String status = "";
		MemberVO check = new MemberVO();
		check.setUserId(id);
		check.setUserPass(pass);
		MemberVO login = null;
		try {
			login = member_service.signin(check);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("id 비교 : " + login);
		boolean passMatch = false;
		if (login != null) {
			passMatch = passEncoder.matches(check.getUserPass(), login.getUserPass());
			if (passMatch) {
				status = "로그인";
			} else {
				status = "비밀번호";
			}
		} else {
			status = "아이디";
		}
		System.out.println("pw 비교: " + passMatch);
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", status);
		return map;

	}

	// 주차장 정보
}
