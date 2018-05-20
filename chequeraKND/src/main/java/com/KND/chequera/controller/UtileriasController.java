package com.KND.chequera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.service.BancosService;
import com.KND.chequera.service.ChequeraService;
import com.KND.chequera.service.ClientesService;
import com.KND.chequera.service.UtileriasService;

@Controller
@RequestMapping("utilerias")
public class UtileriasController {
	
	@Autowired
	@Qualifier("utileriasService")
	private UtileriasService utileriasService;
	
	@GetMapping("")
	public String utilerias() {
		return ViewConstant.UTILERIAS_VIEW;
	}
	
	
	@PostMapping("removeallmovimientos")
	public String removeAllMovimientos() {	
		utileriasService.eliminarMovimientos();
		return "redirect:/index";
	}
	
	@PostMapping("removeallchequeras")
	public String removeAllChequeras() {
		utileriasService.eliminarChequeras();
		return "redirect:/index";
	}
	
	@PostMapping("removeallbancos")
	public String removeAllBancos() {
		utileriasService.eliminarBancos();
		return "redirect:/index";
	}
	
	@PostMapping("removeallclientes")
	public String removeAllClientes() {
		utileriasService.eliminarClientes();
		return "redirect:/index";
	}
	
}
