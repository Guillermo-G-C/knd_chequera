package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		
		movimientosModel.setChequera(chequera);
		movimientosModel.setTipo_Movimiento(tipo_Movimiento);
		
		Movimientos movimiento = movimientosRepository.save(movimientosConverter.movimientosModelToMovimientos(movimientosModel));
		return movimientosConverter.movimientosToMovimientoModel(movimiento);
	}

	@Override
	public int removeChequera(int idMovimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MovimientosModel updateMovimiento() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
