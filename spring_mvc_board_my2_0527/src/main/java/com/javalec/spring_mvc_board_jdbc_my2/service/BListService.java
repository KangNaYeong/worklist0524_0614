package com.javalec.spring_mvc_board_jdbc_my2.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_mvc_board_jdbc_my2.dao.BDao;
import com.javalec.spring_mvc_board_jdbc_my2.dto.BDto;

public class BListService implements BService{

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> list = dao.list();
		
		model.addAttribute("list", list);
	}
	
}
