package com.KND.chequera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.KND.chequera.service.MovimientosService;

@Controller
@RequestMapping("/movimientos")
public class MovimientosController {
	
	@Autowired
	@Qualifier("movimientoService")
	private MovimientosService movimientoService;
	
	@GetMapping("/listMovimientos")
	public ModelAndView listAllMovimientos() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("movimientos", movimientoService.listAllMovimientos());
		
		return mav;
	}
	
}
