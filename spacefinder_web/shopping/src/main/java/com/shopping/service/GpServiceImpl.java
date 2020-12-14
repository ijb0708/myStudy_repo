package com.shopping.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shopping.domain.GoodPListVO;
import com.shopping.domain.GoodPVO;
import com.shopping.domain.GpCategoryVO;
import com.shopping.domain.GpUpdateVO;
import com.shopping.domain.GpViewVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;
import com.shopping.persistence.GpDAO;

@Service
public class GpServiceImpl implements GpService {

	@Inject
	private GpDAO dao;

	// 댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		dao.registReply(reply);
	}

	// 댓글 리스트
	@Override
	public List<ReplyListVO> replyList(int GP_id) throws Exception {
		return dao.replyList(GP_id);
	}

	@Override
	public List<GpCategoryVO> cateList() throws Exception {
		// TODO Auto-generated method stub
		return dao.cateList();
	}

	// 굿플 등록
	@Override
	public void GP_reg(GoodPVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.GP_reg(vo);
	}

	// 굿플 목록
	@Override
	public List<GoodPListVO> gplist() throws Exception {
		System.out.println("굿플서비스");
		return dao.gplist();
	}

	// 굿플 조회
	@Override
	public GpViewVO gpView(int GP_id) throws Exception {
		return dao.gpView(GP_id);
	}

	@Override
	public void GP_up(GpUpdateVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.GP_up(vo);
	}

	@Override
	public void GP_del(int GP_id) throws Exception {
		// TODO Auto-generated method stub
		dao.GP_del(GP_id);
	}

}
