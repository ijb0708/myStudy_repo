package com.shopping.persistence;

import java.util.List;

import com.shopping.domain.CategoryVO;
import com.shopping.domain.GoodPVO;
import com.shopping.domain.GoodsVO;
import com.shopping.domain.GoodsViewVO;
import com.shopping.domain.GpViewVO;

public interface AdminDAO {
	
	// 카테고리
	public List<CategoryVO> category() throws Exception;
	
	// 상품등록
	public void register(GoodsVO vo) throws Exception;
	
	// 상품 목록
	public List<GoodsVO> goodslist() throws Exception;
	
	// 상품조회 + 캍테고리 조인
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	// 상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//상품 삭제
	public void goodsDelete(int gdsNum) throws Exception;
	
	//주차장 등록
	public void GP_reg(GoodPVO vo) throws Exception;
	
	// 주차장 목록
	public List<GoodPVO> gplist() throws Exception;
	
	// 굿플 조회 
	public GpViewVO gpView(int GP_id) throws Exception;
	
	
	
}
