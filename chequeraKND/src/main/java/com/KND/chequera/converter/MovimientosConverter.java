package com.KND.chequera.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.KND.chequera.entity.Movimientos;
import com.KND.chequera.model.MovimientosModel;

@Component("movimientosConverter")
public class MovimientosConverter {

	private static final Log LOG =LogFactory.getLog(MovimientosConverter.class);
	
	//Entity -->to --> Model
	public MovimientosModel movimientosToMovimientoModel(Movimientos mov) {
		MovimientosModel mvm= new MovimientosModel();
		mvm.setIdmovimientos(mov.getIdmovimiento());
		mvm.setM_concepto(mov.getM_concepto());
		mvm.setM_fecha(mov.getM_fecha());
		mvm.setM_monto(mov.getM_monto());
		mvm.setM_status(mov.getM_status());
		mvm.setChequera(mov.getChequera());
		mvm.setTipo_Movimiento(mov.getTipo_movimiento());
		LOG.info("Movimientos Entity Convertido a Movimientos MOdel");
		return mvm;
	}
	
	//Model --> to -->Entity
	public Movimientos movimientosModelToMovimientos(MovimientosModel mvm) {
		Movimientos mv=new Movimientos();
		mv.setIdmovimiento(mvm.getIdmovimientos());
		mv.setM_concepto(mvm.getM_concepto());
		mv.setM_fecha(mvm.getM_fecha());
		mv.setM_monto(mvm.getM_monto());
		mv.setM_status(mvm.getM_status());
		mv.setChequera(mvm.getChequera());
		mv.setTipo_movimiento(mvm.getTipo_Movimiento());
		LOG.info("Movimientos Model convertido a Model Entity");
		return mv;
	}
}
