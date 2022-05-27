package com.javalec.spring_mvc_board_std_my2.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.spring_mvc_board_std_my2.dto.BDto;
import com.javalec.spring_mvc_board_std_my2.service.BService;



@Controller
public class BController {
	
	@Autowired
	private BService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("@@@### BController.list() start");
		
		ArrayList<BDto> list = service.list();
		model.addAttribute("list", list);
		
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
		
		System.out.println("@@@### BController.write() end");
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		
		System.out.println("@@@### BController.content_view() start");
		
		BDto dto = service.contentView(param);
		model.addAttribute("content_view", dto);
		
		System.out.println("@@@### BController.content_view() end");
		
		return "content_view";
	}
	
	@RequestMapping("/upHit")
	public String upHit(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("@@@### BController.upHit() start");
		
		service.upHit(param);
		
		System.out.println("@@@### BController.upHit() end");
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(@RequestParam HashMap<String, String> param, Model model) {
		
		System.out.println("@@@### BController.modify_view() start");
		
		BDto dto = service.modifyView(param);
		model.addAttribute("modify_view", dto);
		
		System.out.println("@@@### BController.modify_view() end");
		
		return "modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam HashMap<String, String> param, Model model) {
		
		System.out.println("@@@### BController.modify() start");
		
		service.modify(param);
		
		System.out.println("@@@### BController.modify() end");
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam HashMap<String, String> param, Model model) {
		
		System.out.println("@@@### BController.delete() start");
		
		service.delete(param);
		
		System.out.println("@@@### BController.delete() end");
		
		return "redirect:list";
	}
}
