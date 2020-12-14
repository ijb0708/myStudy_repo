package com.shopping.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.domain.GoodPListVO;
import com.shopping.domain.GoodPVO;
import com.shopping.domain.GpCategoryVO;
import com.shopping.domain.GpUpdateVO;
import com.shopping.domain.GpViewVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;
import com.shopping.service.GpService;
import com.shopping.utils.MultiFiles;
import com.shopping.utils.UploadFileUtils;

@Controller
@RequestMapping("/goodplace")
public class GoodplaceController {

	private static final Logger logger = LoggerFactory.getLogger(GoodplaceController.class);

	@Inject
	GpService gpService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 카테고리 리스트
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void getCategory(Model model) throws Exception {
		logger.info("get gp category");

		List<GpCategoryVO> catelist = gpService.cateList();

		model.addAttribute("catelist", catelist);

		List<GoodPListVO> gplist = gpService.gplist();

		model.addAttribute("gplist", gplist);
	}

	// 카테고리 리스트
	@RequestMapping(value = "/gpReg", method = RequestMethod.GET)
	public void getGoodpRegister(Model model) throws Exception {
		logger.info("get gp category");

		List<GpCategoryVO> catelist = gpService.cateList();

		model.addAttribute("catelist", catelist);
	}

	// 굿플 등록
	@RequestMapping(value = "/gpReg", method = RequestMethod.POST)
	public String postGoodpRegister(GoodPVO vo, MultiFiles multiFiles, HttpServletRequest req) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		int i = 0;
		for (MultipartFile file : multiFiles.getGP_image()) {
			if (file != null) {
				fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
						ymdPath);
			} else {
				fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			}
			switch (i) {
			case 0:
				vo.setGP_image1(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg1(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
						+ fileName);
				break;
			case 1:
				vo.setGP_image2(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg2(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
						+ fileName);
				break;
			case 2:
				vo.setGP_image3(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg3(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
						+ fileName);
				break;
			case 3:
				vo.setGP_image4(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setGP_ThumbImg4(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
						+ fileName);
				break;
			}
			i++;
		}

		String runtime = "평일 : " + req.getParameter("weekday_on_time") + " ~ " + req.getParameter("weekday_close_time")
				+ "/" + "주말(휴일) : " + req.getParameter("weekend_on_time") + " ~ "
				+ req.getParameter("weekend_close_time");
		vo.setGP_Runtime(runtime);
		vo.setGP_REF_ID("");

		gpService.GP_reg(vo);

		return "redirect:/goodplace/main";
	}

	// 굿플 조회
	@RequestMapping(value = "/gpView", method = RequestMethod.GET)
	public void getGpView(@RequestParam("GP_id") int GP_id, Model model) throws Exception {
		logger.info("get Gp view");

		List<GpCategoryVO> catelist = gpService.cateList();
		model.addAttribute("catelist", catelist);

		GpViewVO gpView = gpService.gpView(GP_id);
		model.addAttribute("gpView", gpView);

		List<ReplyListVO> reply = gpService.replyList(GP_id);
		model.addAttribute("reply", reply);

		/*
		 * List<ReplyListVO> reply = gpService.replyList(GP_id);
		 * model.addAttribute("reply", reply);
		 */

	}

	@ResponseBody
	@RequestMapping(value = "/subReply", method = RequestMethod.POST)
	public int subReply(HttpServletRequest req) throws Exception {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setUserId(req.getParameter("userId"));
		replyVO.setGP_content(req.getParameter("reply_content"));
		replyVO.setGP_REF_ID(req.getParameter("GP_REF_ID"));

		gpService.registReply(replyVO);
		return 1;
	}

	// 굿플 업데이트
	@RequestMapping(value = "/gpUpdate", method = RequestMethod.GET)
	public void getGoodpRegister(@RequestParam("GP_id") int GP_id, Model model) throws Exception {

		List<GpCategoryVO> catelist = gpService.cateList();
		model.addAttribute("catelist", catelist);

		GpViewVO gpView = gpService.gpView(GP_id);
		model.addAttribute("gpView", gpView);
	}

	// 굿플 업데이트
	@RequestMapping(value = "/gpUpdate", method = RequestMethod.POST)
	public String postGoodpUpdate(GpUpdateVO vo, MultiFiles multiFiles, HttpServletRequest req) throws Exception {

//		String imgUploadPath = uploadPath + File.separator + "imgUpload";
//		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
//		String fileName = null;

//		int i = 0;
//		for (MultipartFile file : multiFiles.getGP_image()) {
//			if (file != null) {
//				fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
//						ymdPath);
//			} else {
//				fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
//			}
//			switch (i) {
//			case 0:
//				vo.setGP_image1(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//				vo.setGP_ThumbImg1(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
//						+ fileName);
//				break;
//			case 1:
//				vo.setGP_image2(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//				vo.setGP_ThumbImg2(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
//						+ fileName);
//				break;
//			case 2:
//				vo.setGP_image3(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//				vo.setGP_ThumbImg3(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
//						+ fileName);
//				break;
//			case 3:
//				vo.setGP_image4(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//				vo.setGP_ThumbImg4(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
//						+ fileName);
//				break;
//			}
//			i++;
//		}

		String runtime = "평일 : " + req.getParameter("weekday_on_time") + " ~ " + req.getParameter("weekday_close_time")
				+ "/" + "주말(휴일) : " + req.getParameter("weekend_on_time") + " ~ "
				+ req.getParameter("weekend_close_time");
		vo.setGP_Runtime(runtime);

		gpService.GP_up(vo);

		return "redirect:/goodplace/gpView?GP_id=" + vo.getGP_id();
	}

	// 굿플 업데이트
	@RequestMapping(value = "/gpDelete", method = RequestMethod.GET)
	public String getGoodpDelete(@RequestParam("GP_id") int GP_id, Model model) throws Exception {

		gpService.GP_del(GP_id);
		
		return "redirect:/goodplace/main";
	}
}
