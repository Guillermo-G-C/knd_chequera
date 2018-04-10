package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.Tipo_MovimientoConverter;
import com.KND.chequera.entity.Tipo_Movimiento;
import com.KND.chequera.model.Tipo_MovimientoModel;
import com.KND.chequera.repository.Tipo_MovimientoRepository;
import com.KND.chequera.service.Tipo_MovimientoService;

@Service("tipo_MovimientoService")
public class Tipo_MovimientosServieImpl implements Tipo_MovimientoService{

	@Autowired
	@Qualifier("tipo_MovimientoRepository")
	private Tipo_MovimientoRepository tipo_MovimientoRepository;
	
	@Autowired
	@Qualifier("tipo_MovimientoConverter")
	private Tipo_MovimientoConverter tipo_MovimientoConverter;

	@Override
	public Tipo_MovimientoModel findByidtipoMovimiento(int idtipoMovimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tipo_MovimientoModel> listAllMovimientos() {
		Log.info("METHOD: listAllMovimientos()");
		List<Tipo_Movimiento> tipo_movimientos = tipo_MovimientoRepository.findAll();
		List<Tipo_MovimientoModel> tipo_movimientoModel = new ArrayList<Tipo_MovimientoModel>();
		
		for(Tipo_Movimiento t_m : tipo_movimientos) {
			tipo_movimientoModel.add(tipo_MovimientoConverter.tipoMovimientoModelToTipoMovimiento(t_m));
			Log.info("TipoMovimiento: "+t_m.toString());
		}
		return tipo_movimientoModel;
	}

	@Override
	public Tipo_MovimientoModel addMovimientos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeTipo_Movimiento(int idtipoMovimientos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tipo_MovimientoModel updateTipo_Movimiento(Tipo_MovimientoModel tipo_movimientoModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
