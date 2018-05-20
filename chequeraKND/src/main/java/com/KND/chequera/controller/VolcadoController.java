package com.KND.chequera.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.entity.Tipo_Movimiento;
import com.KND.chequera.repository.Tipo_MovimientoRepository;
import com.KND.chequera.service.Tipo_MovimientoService;

@Controller
@RequestMapping("/volcado")
public class VolcadoController {
	
	@Autowired
	@Qualifier("tipo_MovimientoRepository")
	private Tipo_MovimientoRepository tipo_MovimientoRepository;
	
	private final static Logger LOG = Logger.getLogger(VolcadoController.class);
	
	@GetMapping("")
	public String volcadoInicial(RedirectAttributes redirectAttributes) {
		Tipo_Movimiento abono=new Tipo_Movimiento();
		abono.setTm_operacion("Abono");
		abono.setTm_descripcion("Realizar aumento a la cuenta");
		
		Tipo_Movimiento cargo=new Tipo_Movimiento();
		cargo.setTm_operacion("Cargo");
		cargo.setTm_descripcion("Descontar de la cuenta");
		
		try {
			tipo_MovimientoRepository.save(abono);
			tipo_MovimientoRepository.save(cargo);
		
			redirectAttributes.addFlashAttribute("resultV", 1);
		}catch (Exception e) {
			// TODO: handle exception
			LOG.info("Error al eliminar: "+e.getMessage());
			redirectAttributes.addFlashAttribute("resultV", 2);
		}
		
		return "redirect:/index";
	}
	
}
