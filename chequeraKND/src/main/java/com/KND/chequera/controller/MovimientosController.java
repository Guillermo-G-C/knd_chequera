package com.KND.chequera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.service.ChequeraService;
import com.KND.chequera.service.MovimientosService;

@Controller
@RequestMapping("/movimientos")
public class MovimientosController {
	
	@Autowired
	@Qualifier("movimientoService")
	private MovimientosService movimientoService;
	
	@Autowired
	@Qualifier("chequeraService")
	private ChequeraService chequeraService;
	
	@GetMapping("/listmovimientoschequera")
	public ModelAndView listAllMovimientos(@RequestParam(name="chequera", required=true) int idchequera) {
		ModelAndView mav = new ModelAndView(ViewConstant.LIST_MOVIMIENTOS_CHEQUERAS_VIEW);
		mav.addObject("chequera", chequeraService.findByidchequera(idchequera));
		
		return mav;
	}
	
}
