package com.javalec.spring_mvc_board_my.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_mvc_board_my.dao.BDao;
import com.javalec.spring_mvc_board_my.dto.BDto;

public class BContentViewService implements BService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bid = request.getParameter("bid");
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bid);
		model.addAttribute("content_view", dto);
	}
}
