package com.KND.chequera.controller;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.KND.chequera.constant.ViewConstant;
import com.KND.chequera.model.EstadoCuentaModel;
import com.KND.chequera.service.EstadoDeCuentaService;
import com.KND.chequera.service.MovimientosService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Controller
@RequestMapping("/reporte")
public class EstadoDeCuentaController {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("movimientosService")
	private MovimientosService movimientosService;

	@Autowired
	@Qualifier("estadoDeCuentaService")
	private EstadoDeCuentaService estadoDeCuentaService;
	
	@GetMapping("/estadodecueta")
	public ModelAndView estadoDeCuenta(
			@RequestParam(name="idChequera", required=true) int idChequera,
			@RequestParam(name="fechaInicio", required=true) String fechaInicio,
			@RequestParam(name="fechaCorte", required=true) String fechaCorte) {
		
		//Variables
		JasperReportsPdfView cerView = new JasperReportsPdfView();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		//
		cerView.setUrl("classpath:reports/estado_de_cuenta.jrxml");
		cerView.setApplicationContext(applicationContext);
		
		parameters=estadoDeCuentaService.EdoCuentaEnRangoDeFechas(idChequera, fechaInicio, fechaCorte);
		//
		return new ModelAndView(cerView, parameters);
	}
	
	@GetMapping("/estadodecuetamensual")
	public ModelAndView estadoDeCuentaMensual(
			@RequestParam(name="idChequera", required=true) int idChequera,
			@RequestParam(name="yearMonth", required=true) String yearMonth) {
		
		//Variables
		JasperReportsPdfView cerView = new JasperReportsPdfView();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		//
		cerView.setUrl("classpath:reports/estado_de_cuenta.jrxml");
		cerView.setApplicationContext(applicationContext);
		
		parameters=estadoDeCuentaService.EdoCuentaMensual(idChequera, yearMonth);
		//
		return new ModelAndView(cerView, parameters);
	}
	
	@GetMapping("/estadodecuentaform")
	public String edoCuentaForm(
			Model model,
			@RequestParam(name="idChequera", required=true) int idChequera) {
		//model.addAttribute("estadoCuentaModel", new EstadoCuentaModel());
		model.addAttribute("idChequera", idChequera);
		return ViewConstant.ADD_EDOCUENTA_VIEW;
	}
}
