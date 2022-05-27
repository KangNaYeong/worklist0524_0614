package com.javalec.spring_mvc_board_std_my2.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.javalec.spring_mvc_board_std_my2.dto.BDto;

public interface BService {
	public ArrayList<BDto> list();
	public void write(HashMap<String, String> param);
	public BDto contentView(HashMap<String, String> param);
	public void upHit(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public BDto modifyView(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}
