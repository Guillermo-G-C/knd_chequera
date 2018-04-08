package com.KND.chequera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KND.chequera.service.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	@Qualifier("clientesService")
	private ClientesService clientesService;
	
}
