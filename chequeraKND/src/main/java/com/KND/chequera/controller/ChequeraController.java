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
import com.KND.chequera.model.ChequeraModel;
import com.KND.chequera.service.ChequeraService;

@Controller
@RequestMapping("/chequeras")
public class ChequeraController {
	
	@Autowired
	@Qualifier("chequeraService")
	private ChequeraService chequeraService;

	private static final Log LOG = LogFactory.getLog(ChequeraService.class);
	
	@GetMapping("/listChequerasbycliente")
	public ModelAndView listChequerasClientes(@RequestParam(name="cliente", required=false) int idcliente) {
		ModelAndView mav = new ModelAndView(ViewConstant.LIST_CH_CLIENTE_VIEW);
		mav.addObject("listChequerasCliente", chequeraService.listAllChequeras());
		
		return mav;
	}
	
	@GetMapping("/chequeraform")
	public String chequeraForm(Model model) {
		model.addAttribute("chequeraModel", new ChequeraModel());
		return ViewConstant.ADD_CH_VIEW;
	}
	
	@PostMapping("/addchequera")
	public String addChequera(@ModelAttribute("chequeraModel") ChequeraModel chequeraModel, Model model,
			@RequestParam(name="idBanco", required=true) int idBanco,
			@RequestParam(name="idCliente", required=true)int idCliente) {
		LOG.info("METHOD: addChuequera() --PARAMS "+chequeraModel.toString()+" IdCliente: "+idCliente+" IdBanco: "+idBanco);
		if(null != chequeraService.addChequera(chequeraModel, idBanco, idCliente)) {
			LOG.info("Result: 1");
		}else {
			LOG.info("Result: 0");
		}
		
		return "redirect:/chequeras/listChequerasbycliente?cliente="+idCliente;
	}
}
