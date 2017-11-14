package br.com.finControl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {

	@RequestMapping("/")
	public String index(){
		return "Index";
	}

	
	@RequestMapping("/dashboard")
	public String dashboard(){
		return "layout/Principal";
	}
}
