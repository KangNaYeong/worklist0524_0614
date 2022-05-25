package com.javalec.spring_mvc_board_jdbc_my.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_mvc_board_jdbc_my.dao.BDao;

public class BModifyService implements BService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();
		dao.modify(bId, bTitle, bContent);
	}

}
