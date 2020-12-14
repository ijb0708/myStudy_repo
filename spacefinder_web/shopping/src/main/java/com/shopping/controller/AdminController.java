package com.shopping.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.domain.CategoryVO;
import com.shopping.domain.GoodPVO;
import com.shopping.domain.GoodsVO;
import com.shopping.domain.GoodsViewVO;
import com.shopping.domain.GpCategoryVO;
import com.shopping.domain.GpViewVO;
import com.shopping.domain.MemberVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;
import com.shopping.service.AdminService;
import com.shopping.service.GpService;
import com.shopping.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	AdminService adminService;
	
	@Inject
	GpService gpService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 관리자 화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}

	// 상품 등록
	@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("get goods register");

		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	// 상품 등록
	@RequestMapping(value = "/goods/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setGdsThumbImg(
				File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

		adminService.register(vo);

		return "redirect:/admin/index";
	}

	// 상품 목록
	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		logger.info("get goods list");

		List<GoodsVO> list = adminService.goodslist();

		model.addAttribute("list", list);

	}

	// 상품 조회
	@RequestMapping(value = "/goods/view", method = RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods view");

		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
	}

	// 상품 수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("get goods modify");

		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);

		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	// 상품 수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo) throws Exception {
		logger.info("post goods modify");

		adminService.goodsModify(vo);

		return "redirect:/admin/index";
	}

	// 상품 삭제
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("post goods delete");

		adminService.goodsDelete(gdsNum);

		return "redirect:/admin/index";
	}
	

	// 주차장 등록
	@RequestMapping(value = "/goods/gpReg", method = RequestMethod.GET)
	public void getGoodpRegister(Model model) throws Exception {
		logger.info("get goods register");

		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	// 주차장 등록
	@RequestMapping(value = "/goods/gpReg", method = RequestMethod.POST)
	public String postGoodpRegister(GoodPVO vo, MultipartFile file) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

//		vo.setGP_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//		vo.setGP_ThumbImg(
//				File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

		adminService.GP_reg(vo);

		return "redirect:/admin/index";
	}
	
		// 굿플 목록
		@RequestMapping(value = "/goods/gpList", method = RequestMethod.GET)
		public void getGpList(Model model) throws Exception {
			logger.info("get gp list");

			List<GoodPVO> gplist = adminService.gplist();

			model.addAttribute("gplist", gplist);
		}
		
		// 굿플 조회
		@RequestMapping(value = "/goods/gpView", method = RequestMethod.GET)
		public void getGpView(@RequestParam("n") int GP_id, Model model) throws Exception {
			logger.info("get Gp view");

			GpViewVO gpView = adminService.gpView(GP_id);
			model.addAttribute("gpView", gpView);
			
			List<ReplyListVO> reply = gpService.replyList(GP_id);
			model.addAttribute("reply", reply);
			
			
		}
		
		
		//댓글 작성
		@RequestMapping(value = "/goods/gpView", method = RequestMethod.POST)
		public String registReply(ReplyVO reply, HttpSession session) throws Exception {
		 logger.info("regist reply");
		 
		 MemberVO member = (MemberVO)session.getAttribute("member");
		 reply.setUserId(member.getUserId());
		 
		 gpService.registReply(reply);
		 
		 return "redirect:/goods/gpView?n=" + reply.getGP_id();
		}
		

}
