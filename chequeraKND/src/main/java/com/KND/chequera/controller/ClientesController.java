package com.KND.chequera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.service.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	@Qualifier("clientesService")
	private ClientesService clientesService;
	
	@GetMapping("/listclientes")
	public ModelAndView listAllCliente() {
		ModelAndView mav = new ModelAndView(ViewConstant.LIST_CLIENTES_VIEW);
		mav.addObject("listClientes", clientesService.listAllClientes());
		
		return mav;
	}
	
}
