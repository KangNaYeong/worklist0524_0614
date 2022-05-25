package com.javalec.spring_mvc_board_jdbc_my.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_mvc_board_jdbc_my.service.BContentViewService;
import com.javalec.spring_mvc_board_jdbc_my.service.BDeleteService;
import com.javalec.spring_mvc_board_jdbc_my.service.BListService;
import com.javalec.spring_mvc_board_jdbc_my.service.BModifyService;
import com.javalec.spring_mvc_board_jdbc_my.service.BModifyViewService;
import com.javalec.spring_mvc_board_jdbc_my.service.BService;
import com.javalec.spring_mvc_board_jdbc_my.service.BWriteService;

@Controller
public class BController {
	
	BService service;
	
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### list()");
		
		service = new BListService();
		service.execute(model);
		
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
		
		model.addAttribute("request", request);
		service = new BWriteService();
		service.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("@@@### content_view()");
		
		model.addAttribute("request", request);
		service = new BContentViewService();
		service.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("@@@### modify_view()");
		
		model.addAttribute("request", request);
		service = new BModifyViewService();
		service.execute(model);
		
		return "modify_view";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("@@@### modify()");
		
		model.addAttribute("request", request);
		service = new BModifyService();
		service.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("@@@### delete()");
		
		model.addAttribute("request", request);
		service = new BDeleteService();
		service.execute(model);
		
		return "redirect:list";
	}
}
