package com.javalec.spring_mvc_board_mybatis_my.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_mvc_board_mybatis_my.dao.IBDao;

@Controller
public class BController {

	@Autowired
	public SqlSession sqlSession;
//	BService service;
	
//	public JdbcTemplate template;
	
//	@Autowired
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//		Constant.template = this.template;
//	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### list()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("list", dao.list()) ;
//		service = new BListService();
//		service.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("@@@### write_view()");
		
		return "write_view";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("@@@### write()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.write(request.getParameter("bName")
				  , request.getParameter("bTitle")
				  , request.getParameter("bContent"));
		
//		model.addAttribute("request", request);
//		service = new BWriteService();
//		service.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("@@@### content_view()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.upHit(request.getParameter("bId"));
		model.addAttribute("content_view", dao.contentView(request.getParameter("bId")));
		
//		model.addAttribute("request", request);
//		service = new BContentViewService();
//		service.execute(model);
		
		return "content_view";
	}
	
//	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("@@@### modify_view()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("modify_view", dao.modifyView(request.getParameter("bId")));
//		model.addAttribute("request", request);
//		service = new BModifyViewService();
//		service.execute(model);
		
		return "modify_view";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("@@@### modify()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.modify(request.getParameter("bId")
				  , request.getParameter("bTitle")
				  , request.getParameter("bContent"));
//		model.addAttribute("request", request);
//		service = new BModifyService();
//		service.execute(model);
		
		dao.upDate(request.getParameter("bId"));
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("@@@### delete()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.delete(request.getParameter("bId"));
//		model.addAttribute("request", request);
//		service = new BDeleteService();
//		service.execute(model);
		
		return "redirect:list";
	}
}
