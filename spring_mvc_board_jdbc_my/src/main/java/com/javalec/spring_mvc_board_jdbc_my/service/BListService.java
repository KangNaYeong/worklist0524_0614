package com.javalec.spring_mvc_board_jdbc_my.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_mvc_board_jdbc_my.dao.BDao;
import com.javalec.spring_mvc_board_jdbc_my.dto.BDto;

public class BListService implements BService{

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}

}
