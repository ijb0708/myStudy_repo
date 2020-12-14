package com.shopping.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shopping.domain.CategoryVO;
import com.shopping.domain.GoodPVO;
import com.shopping.domain.GoodsVO;
import com.shopping.domain.GoodsViewVO;
import com.shopping.domain.GpViewVO;
import com.shopping.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;

	// 카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

	// 상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);		
	}
	
	// 상품목록
	public List<GoodsVO>  goodslist() throws Exception {
		System.out.println("서비스");
		return dao.goodslist();
	}
	
	// 상품조회 + 카테고리 확인
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}
	
	//상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}
	
	//상품 삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
		
	}
	
	//주차장 등록
	@Override
	public void GP_reg(GoodPVO vo) throws Exception {
		dao.GP_reg(vo);
		
	}
	
	//주차장 목록
	@Override
	public List<GoodPVO> gplist() throws Exception {
		System.out.println("주차장서비스");
		return dao.gplist();
	}
	
	//굿플 조회
	@Override
	public GpViewVO gpView(int GP_id) throws Exception {
		return dao.gpView(GP_id);
	}
	

}
