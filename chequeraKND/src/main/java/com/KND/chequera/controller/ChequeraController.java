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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.model.ChequeraModel;
import com.KND.chequera.service.BancosService;
import com.KND.chequera.service.ChequeraService;
import com.KND.chequera.service.ClientesService;

@Controller
@RequestMapping("/chequeras")
public class ChequeraController {
	
	@Autowired
	@Qualifier("chequeraService")
	private ChequeraService chequeraService;

	@Autowired
	@Qualifier("clientesService")
	private ClientesService clientesService;
	
	@Autowired
	@Qualifier("bancosService")
	private BancosService bancosService;
	
	private static final Log LOG = LogFactory.getLog(ChequeraController.class);
	
	@GetMapping("/listChequerasbycliente")
	public ModelAndView listChequerasClientes(@RequestParam(name="cliente", required=false) int idcliente) {
		ModelAndView mav = new ModelAndView(ViewConstant.LIST_CH_CLIENTE_VIEW);
		mav.addObject("cliente", clientesService.findByidclientes(idcliente));
		
		return mav;
	}
	
	@GetMapping("/chequeraform")
	public String chequeraForm(Model model,
			@RequestParam(name="cliente", required=true) int idcliente) {
		model.addAttribute("chequeraModel", new ChequeraModel());
		model.addAttribute("bancos", bancosService.listAllBancos());
		model.addAttribute("cliente", idcliente);
		return ViewConstant.ADD_CH_VIEW;
	}
	
	@PostMapping("/addchequera")
	public String addChequera(@ModelAttribute("chequeraModel") ChequeraModel chequeraModel, Model model,
			@RequestParam(name="idBanco", required=true) int idBanco,
			@RequestParam(name="idCliente", required=true)int idCliente,
			RedirectAttributes redirectAttributes) {
		LOG.info("METHOD: addChuequera() --PARAMS "+chequeraModel.toString()+" IdCliente: "+idCliente+" IdBanco: "+idBanco);
		if(null != chequeraService.addChequera(chequeraModel, idCliente, idBanco)) {
			redirectAttributes.addFlashAttribute("result", 1);
			LOG.info("Result: 1");
		}else {
			redirectAttributes.addFlashAttribute("result", 2);
			LOG.info("Result: 0");
		}
		
		return "redirect:/chequeras/listChequerasbycliente?cliente="+idCliente;
	}
	
	@GetMapping("removechequeracliente")
	public String removeChequeraCliente(
				@RequestParam(name="chequera",required=true)int chequera,
				@RequestParam(name="cliente", required=true)int cliente,
				RedirectAttributes redirectAttributes
			) {
		LOG.info("IdChequera: "+chequera+", Idcliente: "+cliente);
		
		try {
			chequeraService.removeChequera(chequera);
			redirectAttributes.addFlashAttribute("resultE", 1);
		}catch (Exception e) {
			// TODO: handle exception
			LOG.info("Error al eliminar: "+e.getMessage());
			redirectAttributes.addFlashAttribute("resultE", 2);
		}
		
		return "redirect:/chequeras/listChequerasbycliente?cliente="+cliente;
	}
}
