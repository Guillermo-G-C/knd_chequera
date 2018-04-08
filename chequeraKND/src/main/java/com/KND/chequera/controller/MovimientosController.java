package com.KND.chequera.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.model.MovimientosModel;
import com.KND.chequera.service.ChequeraService;
import com.KND.chequera.service.MovimientosService;
import com.KND.chequera.service.Tipo_MovimientoService;

@Controller
@RequestMapping("/movimientos")
public class MovimientosController {
	
	@Autowired
	@Qualifier("movimientoService")
	private MovimientosService movimientoService;
	
	@Autowired
	@Qualifier("chequeraService")
	private ChequeraService chequeraService;
	
	@Autowired
	@Qualifier("tipo_MovimientoService")
	private Tipo_MovimientoService tipo_MovimientoService;
	
	private static final Log LOG = LogFactory.getLog(MovimientosController.class);
	
	@GetMapping("/listmovimientoschequera")
	public ModelAndView listAllMovimientos(@RequestParam(name="chequera", required=true) int idchequera) {
		ModelAndView mav = new ModelAndView(ViewConstant.LIST_MOVIMIENTOS_CHEQUERAS_VIEW);
		mav.addObject("chequera", chequeraService.findByidchequera(idchequera));	
		return mav;
	}
	
	@GetMapping("/movimientosform")
	public String movimientoForm(
			Model model,
			@RequestParam(name="chequera", required=true)int idchequera) {
		model.addAttribute("movimientoModel", new MovimientosModel());
		model.addAttribute("tiposMovimientos", tipo_MovimientoService.listAllMovimientos());
		model.addAttribute("chequera", idchequera);
		
		return ViewConstant.ADD_MOVIMIENTO_VIEW;
	}
	
	@PostMapping("/addmovimiento")
	public String addMovimiento(
			@ModelAttribute("movimientoModel") MovimientosModel movimientoModel, 
			Model model,
			@RequestParam(name="idChequera", required=true)int idChequera,
			@RequestParam(name="idTipoMovimiento", required=true) int idTipoMovimiento) {
		LOG.info("METHOD: addMovimiento() --PARAMS "+movimientoModel.toString()+" IdChequera: "+idChequera+" IdTipoMovimiento: "+idTipoMovimiento);
		if(null != movimientoService.addMovimiento(movimientoModel, idChequera, idTipoMovimiento)) {
			
		}else {
			
		}
		
		return "redirect:/movimientos/listmovimientoschequera?chequera="+idChequera;
	}
	
	@GetMapping("removemovimientochequera")
	public String removeMovimientoChequera(
			@RequestParam(name="idChequera", required=true) int idChequera,
			@RequestParam(name="idMovimiento", required=true) int idMovimiento) {
		movimientoService.removeMovimiento(idMovimiento);
		return "redirect:/movimientos/listmovimientoschequera?chequera="+idChequera;
	} 
	
}
