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
import org.springframework.web.servlet.ModelAndView;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.model.ClienteModel;
import com.KND.chequera.service.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	@Qualifier("clientesService")
	private ClientesService clientesService;
	
	private static final Log LOG = LogFactory.getLog(ClientesController.class);
	
	@GetMapping("/listclientes")
	public ModelAndView listAllCliente() {
		ModelAndView mav = new ModelAndView(ViewConstant.LIST_CLIENTES_VIEW);
		mav.addObject("listClientes", clientesService.listAllClientes());
		
		return mav;
	}
	
	@GetMapping("clientesform")
	public String clientesForm(Model model) {
		model.addAttribute("clienteModel", new ClienteModel());
		return ViewConstant.ADD_CLIENTES_VIEW;
	}
	
	@PostMapping("addcliente")
	public String addCliente(@ModelAttribute("clienteModel") ClienteModel clienteModel) {
		LOG.info("METHOD: addBanco() --PARAMS "+clienteModel.toString());
		
		if(null != clientesService.addClientes(clienteModel)) {
			LOG.info("Result: 1");
		}else{
			LOG.info("Result: 0");
		}
		
		return "redirect:/clientes/listclientes";
	}
	
}
