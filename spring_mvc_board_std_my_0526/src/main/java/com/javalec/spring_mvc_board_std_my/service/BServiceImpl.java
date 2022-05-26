package com.javalec.spring_mvc_board_std_my.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.spring_mvc_board_std_my.dao.IBDao;
import com.javalec.spring_mvc_board_std_my.dto.BDto;

@Service("BService")
public class BServiceImpl implements BService{
	
	@Autowired
	public SqlSession sqlSession;
	
	@Override
	public ArrayList<BDto> list() {
		System.out.println("@@@### BServiceImpl.list() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		ArrayList<BDto> list = dao.list();
		
		System.out.println("@@@### BServiceImpl.list() end");
		
		return list;
	}

	@Override
//	public void write(String bName, String bTitle, String bContent) {
		public void write(HashMap<String, String> param) {
		
		System.out.println("@@@### BServiceImpl.write() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.write(param);
		
		System.out.println("@@@### BServiceImpl.write() end");
	}

	@Override
//	public BDto contentView(String strID) {
		public BDto contentView(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.contentView() start");
		
		upHit(param);
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.upHit(param);
		BDto dto = dao.contentView(param);
		
		System.out.println("@@@### BServiceImpl.contentView() end");
		
		return dto;
	}

	@Override
	public void upHit(HashMap<String, String> param) {
		
		System.out.println("@@@### BServiceImpl.upHit() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.upHit(param);
		
		System.out.println("@@@### BServiceImpl.upHit() end");
	}

	@Override
//	public void modify(String bId, String bTitle, String bContent) {
		public void modify(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.modify() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.modify(param);
		
		upDate(param);
		
		System.out.println("@@@### BServiceImpl.modify() end");
	}

	@Override
	public BDto modifyView(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.modifyView() start");
		IBDao dao = sqlSession.getMapper(IBDao.class);
		BDto dto = dao.modifyView(param);
		
		System.out.println("@@@### BServiceImpl.modifyView() end");
		return dto;
	}

	@Override
	public void upDate(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.upDate() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.upDate(param);
		
		System.out.println("@@@### BServiceImpl.upDate() end");
		
	}

	@Override
	public void delete(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.delete() start");
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.delete(param);
		System.out.println("@@@### BServiceImpl.delete() end");
		
	}

}
