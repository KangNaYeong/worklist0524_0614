package com.javalec.spring_mvc_board_jdbc_my.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_mvc_board_jdbc_my.dao.BDao;
import com.javalec.spring_mvc_board_jdbc_my.dto.BDto;

public class BModifyViewService implements BService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.modifyView(bId);
		model.addAttribute("modify_view", dto);
		
	}

}
