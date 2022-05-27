package com.javalec.spring_mvc_board_std_my2.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.spring_mvc_board_std_my2.dao.IBDao;
import com.javalec.spring_mvc_board_std_my2.dto.BDto;

@Service("Bservice")
public class BServiceImpl implements BService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<BDto> list() {
		System.out.println("@@@### BServiceImpl.list() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		ArrayList<BDto> list = dao.list();
		
		System.out.println("@@@### BServiceImpl.list() end");
		
		return list;
	}

	@Override
	public void write(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.write() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.write(param);
		
		System.out.println("@@@### BServiceImpl.write() end");
	}

	@Override
	public BDto contentView(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.contentView() start");
		
		upHit(param);                       
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
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
	public void modify(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.modify() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.modify(param);
		
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
	public void delete(HashMap<String, String> param) {
		System.out.println("@@@### BServiceImpl.delete() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.delete(param);
		
		System.out.println("@@@### BServiceImpl.delete() end");
		
	}

}
