package com.KND.chequera.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.service.Tipo_MovimientoService;

@Controller
@RequestMapping("/tipo_movimientos")
public class Tipo_MovimientoController {

	@Autowired
	@Qualifier("tipo_MovimientoService")
	private Tipo_MovimientoService tipo_MovimientoService;
	
	private static final Log LOG = LogFactory.getLog(Tipo_MovimientoController.class);
	
	@GetMapping("/listtipomovimientos")
	public ModelAndView listAllTipoMovimientos() {
		ModelAndView mav = new ModelAndView(ViewConstant.LIST_TM_VIEW);
		mav.addObject("listTipoMovimientos", tipo_MovimientoService.listAllMovimientos());
		
		return mav;
	}
	
}
