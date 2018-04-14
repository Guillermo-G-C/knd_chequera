package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.MovimientosConverter;
import com.KND.chequera.model.ChequeraModel;
import com.KND.chequera.model.EstadoCuentaModel;
import com.KND.chequera.model.MovimientosModel;
import com.KND.chequera.repository.MovimientosRepository;
import com.KND.chequera.service.ChequeraService;
import com.KND.chequera.service.EstadoDeCuentaService;
import com.KND.chequera.service.MovimientosService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service("estadoDeCuentaService")
public class EstadoDeCuentaServiceImpl implements EstadoDeCuentaService{
	
	@Autowired
	@Qualifier("movimientosRepository")
	private MovimientosRepository movimientosRepository;
	
	@Autowired
	@Qualifier("movimientosConverter")
	private MovimientosConverter movimientosConverter;
	
	@Autowired
	@Qualifier("movimientosService")
	private MovimientosService movimientosService;
	
	@Autowired
	@Qualifier("chequeraService")
	private ChequeraService chequeraService;

	@Override
	public Map<String, Object> EdoCuentaEnRangoDeFechas(int idChequera, String fechaInicio, String fechaCorte) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		ChequeraModel chequeraModel = new ChequeraModel();
		JRBeanCollectionDataSource movimientosJRDS =new JRBeanCollectionDataSource(null);
		List<EstadoCuentaModel> listMovimientosModel = new ArrayList<EstadoCuentaModel>();
		//List<MovimientosModel> listMovimientosModel = new ArrayList<MovimientosModel>();
		
		chequeraModel=chequeraService.findByidchequera(idChequera);
		
		listMovimientosModel= movimientosService.listAllMovimientosEnRangoDeFechasAndChequera(fechaInicio, fechaCorte, idChequera);
		movimientosJRDS=new JRBeanCollectionDataSource(listMovimientosModel);
		
		//List<EstadoCuentaModel> listEstadoCuentaModel = movimientosService.listAllMovimientosEdoCuenta(idChequera);
		//movimientosJRDS=new JRBeanCollectionDataSource(listEstadoCuentaModel);
		
		parameters.put("banco", chequeraModel.getBancos().getB_entidad());
		parameters.put("chequera", Integer.toString(chequeraModel.getIdchequera()));
		parameters.put("fechaInicio", fechaInicio);
		parameters.put("fechaFin", fechaCorte);
		parameters.put("datasource", movimientosJRDS);
		
		return parameters;
	}
	
	@Override
	public Map<String, Object> EdoCuentaMensual(int idChequera, String yearMonth) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		ChequeraModel chequeraModel = new ChequeraModel();
		JRBeanCollectionDataSource movimientosJRBDS =new JRBeanCollectionDataSource(null);
		List<EstadoCuentaModel> listMovimientosModel = new ArrayList<EstadoCuentaModel>();
		
		chequeraModel=chequeraService.findByidchequera(idChequera);
		
		listMovimientosModel= movimientosService.listAllMovimientosMensualAndChequera(yearMonth, idChequera);
		movimientosJRBDS=new JRBeanCollectionDataSource(listMovimientosModel);
		
		parameters.put("banco", chequeraModel.getBancos().getB_entidad());
		parameters.put("chequera", Integer.toString(chequeraModel.getIdchequera()));
		parameters.put("fechaInicio", yearMonth);
		parameters.put("fechaFin", yearMonth);
		parameters.put("datasource", movimientosJRBDS);
		
		return parameters;
	}

	@Override
	public Map<String, Object> EdoCuentaMensual() {
		// TODO Auto-generated method stub
		return null;
	}

}
