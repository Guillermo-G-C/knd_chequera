package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.MovimientosConverter;
import com.KND.chequera.entity.Chequera;
import com.KND.chequera.entity.Movimientos;
import com.KND.chequera.entity.Tipo_Movimiento;
import com.KND.chequera.model.MovimientosModel;
import com.KND.chequera.repository.ChequeraRepository;
import com.KND.chequera.repository.MovimientosRepository;
import com.KND.chequera.repository.Tipo_MovimientoRepository;
import com.KND.chequera.service.MovimientosService;

@Service("movimientoService")
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
	@Qualifier("tipo_MovimientoRepository")
	private Tipo_MovimientoRepository tipo_MovimientoRepository;
	
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
	public MovimientosModel addMovimiento(MovimientosModel movimientosModel, int idChequera, int idTipoMovimiento) {
		Chequera chequera = chequeraRepository.findByidchequera(idChequera);
		Tipo_Movimiento tipo_Movimiento = tipo_MovimientoRepository.findByidtipoMovimiento(idTipoMovimiento);
		
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
		LOG.info("Saldo: "+saldo+", Operación: "+operacion+", Monto: "+monto+", Nuevo Saldo: "+newsaldo);
		
		movimientosModel.setChequera(chequera);
		movimientosModel.setTipo_Movimiento(tipo_Movimiento);
		
		//Guardar Movimiento
		Movimientos movimiento = movimientosRepository.save(movimientosConverter.movimientosModelToMovimientos(movimientosModel));
		
		//Guardar Saldo
		chequeraRepository.save(chequera);
		
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
		
		movimientosRepository.deleteById(idMovimiento);
		return 0;
	}

	@Override
	public MovimientosModel updateMovimiento() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
