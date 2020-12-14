package com.shopping.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shopping.domain.CategoryVO;
import com.shopping.domain.GoodPVO;
import com.shopping.domain.GoodsVO;
import com.shopping.domain.GoodsViewVO;
import com.shopping.domain.GpViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	// 매퍼 
	private static String namespace = "com.shopping.mappers.adminMapper";

	// 카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

	// 상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	// 상품목록
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	}
	
	// 상품조회 + 카테고리 확인
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}
	
	//상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
		
	}
	
	//상품 삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sql.delete(namespace + ".goodsDelete", gdsNum);
		
	}
	
	//주차장 등록
	@Override
	public void GP_reg(GoodPVO vo) throws Exception {
		sql.insert(namespace + ".GP_reg", vo);
		
	}
	
	//주차장 목록
	@Override
	public List<GoodPVO> gplist() throws Exception {
		return sql.selectList(namespace + ".gplist");
	}
	
	//굿플 조회
	@Override
	public GpViewVO gpView(int GP_id) throws Exception {
		return sql.selectOne(namespace + ".gpView", GP_id);
	}

}
