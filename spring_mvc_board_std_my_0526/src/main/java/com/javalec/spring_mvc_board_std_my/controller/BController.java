package com.javalec.spring_mvc_board_std_my.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.spring_mvc_board_std_my.dto.BDto;
import com.javalec.spring_mvc_board_std_my.service.BService;

@Controller
public class BController {

//	@Autowired
//	private SqlSession sqlSession;
	
	@Autowired
	private BService service;
	
//	BService service;
	
//	public JdbcTemplate template;
	
//	@Autowired
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//		Constant.template = this.template;
//	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### BController.list() start");
		
		ArrayList<BDto> list = service.list();
		model.addAttribute("list", list);
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		model.addAttribute("list", dao.list()) ;

		System.out.println("@@@### BController.list() end");
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("@@@### write_view()");
		
		return "write_view";
	}
	@RequestMapping("/write")
	public String write(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### BController.write() start");
		
		service.write(param);
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.write(request.getParameter("bName")
//				  , request.getParameter("bTitle")
//				  , request.getParameter("bContent"));
		
		System.out.println("@@@### BController.write() end");

		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### BController.content_view() start");
		
		BDto dto = service.contentView(param);
		model.addAttribute("content_view", dto);
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.upHit(request.getParameter("bId"));
//		model.addAttribute("content_view", dao.contentView(request.getParameter("bId")));
//		
		System.out.println("@@@### BController.content_view() end");

		return "content_view";
	}
	
//	
	@RequestMapping("/modify_view")
	public String modify_view(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### BController.modify_view() start");
	
		BDto dto = service.modifyView(param);
		model.addAttribute("modify_view", dto);
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		model.addAttribute("modify_view", dao.modifyView(request.getParameter("bId"))) ;

		System.out.println("@@@### BController.modify_view() end");
		
		return "modify_view";
	}
	@RequestMapping("/modify")
	public String modify(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### BController.modify() start");
		
		service.modify(param);
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.modify(request.getParameter("bId")
//				  , request.getParameter("bTitle")
//				  , request.getParameter("bContent"));

		
//		dao.upDate(request.getParameter("bId"));
		
		System.out.println("@@@### BController.modify() end");
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### BController.delete() start");
		
		service.delete(param);
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.delete(request.getParameter("bId"));

		System.out.println("@@@### BController.delete() end");
		
		return "redirect:list";
	}
}
