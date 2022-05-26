package com.javalec.spring_mvc_board_mybatis_my.dao;

import java.util.ArrayList;

import com.javalec.spring_mvc_board_mybatis_my.dto.BDto;

public interface IBDao {
	public ArrayList<BDto> list();
	public void write(String bName, String bTitle,String bContent);
	public BDto contentView(String strID);
	public void upHit(String bId);
	public void modify(String bId, String bTitle, String bContent);
	public BDto modifyView(String strID );
	public void upDate(String bId);
	public void delete(String bId);
}
