package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.service.User4Service;
import kr.co.ch07.vo.User4VO;

@Controller
public class User4Controller {

	@Autowired
	private User4Service service;
	
	@GetMapping("/user4/list")
	public String list(Model model) {
		List<User4VO> users = service.selectUser4s();
		model.addAttribute("users", users);
		
		return "/user4/list";
	}
}
