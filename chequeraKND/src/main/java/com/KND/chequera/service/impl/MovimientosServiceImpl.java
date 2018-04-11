package com.KND.chequera.service.impl;

import java.sql.Date;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//import javax.mail.MessagingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.ChequeraConverter;
import com.KND.chequera.converter.MovimientosConverter;
import com.KND.chequera.entity.Chequera;
import com.KND.chequera.entity.Movimientos;
import com.KND.chequera.entity.Tipo_Movimiento;
import com.KND.chequera.model.EstadoCuentaModel;
import com.KND.chequera.model.MailModel;
import com.KND.chequera.model.MovimientosModel;
import com.KND.chequera.repository.ChequeraRepository;
import com.KND.chequera.repository.MovimientosRepository;
import com.KND.chequera.repository.Tipo_MovimientoRepository;
import com.KND.chequera.service.ChequeraService;
import com.KND.chequera.service.MovimientosService;
//import com.KND.chequera.service.SendMailService;

@Service("movimientosService")
public class MovimientosServiceImpl implements MovimientosService {
	
	@Autowired
	@Qualifier("movimientosRepository")
	private MovimientosRepository movimientosRepository;
	
	@Autowired
	@Qualifier("movimientosConverter")
	private MovimientosConverter movimientosConverter;
	
	@Autowired
	@Qualifier("chequeraRepository")
	private ChequeraRepository chequeraRepository;
	
	@Autowired
	@Qualifier("chequeraConverter")
	private ChequeraConverter chequeraConverter;
	
	@Autowired
	@Qualifier("tipo_MovimientoRepository")
	private Tipo_MovimientoRepository tipo_MovimientoRepository;
	
	@Autowired
	@Qualifier("sendMailService")
	//private SendMailService sendMailService;
	
	private static final Log LOG = LogFactory.getLog(MovimientosServiceImpl.class);
	
	@Override
	public MovimientosModel findByidmovimiento(int idmovimientos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<MovimientosModel> listAllMovimientos() {
		List<Movimientos> movimientos = movimientosRepository.findAll(); 
		List<MovimientosModel> movimientosModel = new ArrayList<MovimientosModel>();
		
		for(Movimientos movimiento : movimientos) {
			movimientosModel.add(movimientosConverter.movimientosToMovimientoModel(movimiento));
		}
		
		return movimientosModel;
	}
	
	@Override
	public List<EstadoCuentaModel> listAllMovimientosEdoCuenta(int idChequera) {
		List<Movimientos> movimientos = movimientosRepository.findAll(); 
		List<EstadoCuentaModel> edoCuentaModel = new ArrayList<EstadoCuentaModel>();
		
		for(Movimientos movimiento : movimientos) {
			edoCuentaModel.add(movimientosConverter.movimientosToEstadoCuentaModel(movimiento));
		}
		
		return edoCuentaModel;
	}
	
	@Override
	public List<EstadoCuentaModel> listAllMovimientosEnRangoDeFechas(String fechaInicio, String fechaCorte) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		/*java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());*/
	    
	    java.sql.Date sqlInicio=Date.valueOf(fechaInicio);
	    java.sql.Date sqlCorte=Date.valueOf(fechaCorte);
	    
	    java.util.Date utilInicio = new java.util.Date(sqlInicio.getTime());
	    java.util.Date utilCorte = new java.util.Date(sqlCorte.getTime());
		/*
		Date fechaInicioF=null;
		Date fechaCorteF=null;
		
		try {
			fechaInicioF=dateFormat.parse(fechaInicio);
			fechaCorteF=dateFormat.parse(fechaCorte);
			
			LOG.info("FechaInicio con formato yyyy-MM-dd: "+dateFormat.format(fechaInicioF).toString());
			LOG.info("FechaCorte con formato yyyy-MM-dd: "+dateFormat.format(fechaCorteF).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		List<Movimientos> movimientos = movimientosRepository.findByMFechaAfterAndMFechaBefore(sqlInicio, sqlCorte);
		List<EstadoCuentaModel> edoCuentaModel = new ArrayList<EstadoCuentaModel>();
		
		for(Movimientos movimiento : movimientos) {
			edoCuentaModel.add(movimientosConverter.movimientosToEstadoCuentaModel(movimiento));
		}
		
		return edoCuentaModel;
	}
	
	@Override
	public List<EstadoCuentaModel> listAllMovimientosEnRangoDeFechasAndChequera(String fechaInicio, String fechaCorte, int idChequera) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		/*java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());*/
	    
	    java.sql.Date sqlInicio=Date.valueOf(fechaInicio);
	    java.sql.Date sqlCorte=Date.valueOf(fechaCorte);
	    
	    java.util.Date utilInicio = new java.util.Date(sqlInicio.getTime());
	    java.util.Date utilCorte = new java.util.Date(sqlCorte.getTime());
		/*
		Date fechaInicioF=null;
		Date fechaCorteF=null;
		
		try {
			fechaInicioF=dateFormat.parse(fechaInicio);
			fechaCorteF=dateFormat.parse(fechaCorte);
			
			LOG.info("FechaInicio con formato yyyy-MM-dd: "+dateFormat.format(fechaInicioF).toString());
			LOG.info("FechaCorte con formato yyyy-MM-dd: "+dateFormat.format(fechaCorteF).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
	    Chequera chequera = chequeraRepository.findByidchequera(idChequera);
		
		List<Movimientos> movimientos = movimientosRepository.findByMFechaAfterAndMFechaBeforeAndChequeraEquals(sqlInicio, sqlCorte, chequera);
		List<EstadoCuentaModel> edoCuentaModel = new ArrayList<EstadoCuentaModel>();
		
		for(Movimientos movimiento : movimientos) {
			edoCuentaModel.add(movimientosConverter.movimientosToEstadoCuentaModel(movimiento));
		}
		
		return edoCuentaModel;
	}

	@Override
	public MovimientosModel addMovimiento(MovimientosModel movimientosModel, int idChequera, int idTipoMovimiento) {
		Chequera chequera = chequeraRepository.findByidchequera(idChequera);
		Tipo_Movimiento tipo_Movimiento = tipo_MovimientoRepository.findByidtipoMovimiento(idTipoMovimiento);
		
		MailModel mailModel = new MailModel();
		
		String operacion = tipo_Movimiento.getTm_operacion();
		double monto = movimientosModel.getM_monto();
		double saldo = chequera.getCh_saldo();
		double newsaldo = 0;
		
		if(operacion.equals("Cargo")) {
			newsaldo = saldo-monto;
			chequera.setCh_saldo(newsaldo);
		}else if (operacion.equals("Abono")) {
			newsaldo = saldo+monto;
			chequera.setCh_saldo(newsaldo);
		}
		LOG.info("Operación: "+operacion+", Saldo: "+saldo+", Monto: "+monto+", Nuevo Saldo: "+newsaldo);
		
		movimientosModel.setChequera(chequera);
		movimientosModel.setTipo_Movimiento(tipo_Movimiento);
		
		//Guardar Movimiento
		Movimientos movimiento = movimientosRepository.save(movimientosConverter.movimientosModelToMovimientos(movimientosModel));
		
		//Guardar Saldo
		chequeraRepository.save(chequera);
		
		//Enviar correo
		/*mailModel.setFrom("chequera@chequera.com");
		mailModel.setTo(chequera.getClientes().getC_correo());
		mailModel.setSubject(operacion+", a la chequera"+chequera.getIdchequera());
		mailModel.setContent("Operación: "+operacion+", Saldo: "+saldo+", Monto: "+monto+", Nuevo Saldo: "+newsaldo);
		*/
		/*try {
			sendMailService.sendMailMessage(mailModel);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return movimientosConverter.movimientosToMovimientoModel(movimiento);
	}

	@Override
	public int removeMovimiento(int idMovimiento) {
		Movimientos movimiento = movimientosRepository.findByidmovimiento(idMovimiento);
		Chequera chequera = movimiento.getChequera();
		
		String operacion = movimiento.getTipo_movimiento().getTm_operacion();
		double monto = movimiento.getM_monto();
		double saldo = chequera.getCh_saldo();
		double newSaldo = 0;
		
		if(operacion.equals("Cargo")) {
			newSaldo = saldo+monto;
			
			chequera.setCh_saldo(newSaldo);
		}else if (operacion.equals("Abono")) {
			LOG.info("If Abono");
			newSaldo = saldo-monto;
			chequera.setCh_saldo(newSaldo);
		}
		LOG.info("Eliminar movimiento, Saldo: "+saldo+", Operación: "+operacion+", Monto: "+monto+", Nuevo Saldo: "+newSaldo);
		
		
		chequeraRepository.save(chequera);
		
		movimientosRepository.delete(idMovimiento);
		return 0;
	}

	@Override
	public MovimientosModel updateMovimiento() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
