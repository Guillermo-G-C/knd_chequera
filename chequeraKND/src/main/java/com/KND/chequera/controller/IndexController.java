package com.KND.chequera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KND.chequera.constant.ViewConstant;

@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping("")
	public String index() {
		return ViewConstant.INDEX_VIEW;
	}
	
}
