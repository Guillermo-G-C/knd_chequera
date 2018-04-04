package com.KND.chequera.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.KND.chequera.entity.Tipo_Movimiento;
import com.KND.chequera.model.Tipo_MovimientoModel;

@Component("tipo_MovimientoConverter")
public class Tipo_MovimientoConverter {

	private static final Log LOG = LogFactory.getLog(Tipo_MovimientoConverter.class);

	// Entity -->to --> Model
	public Tipo_MovimientoModel tipoMovimientoModelToTipoMovimiento(Tipo_Movimiento tm) {
		Tipo_MovimientoModel tmm = new Tipo_MovimientoModel();
		tmm.setIdtipo_movimiento(tm.getIdtipoMovimiento());
		tmm.setTm_descripcion(tm.getTm_descripcion());
		tmm.setTm_operacion(tm.getTm_operacion());
		LOG.info("Tipo_Movimiento convetrido a Tipo_MovimientoModel");
		return tmm;
	}

	// Model --> to -->Entity
	public Tipo_Movimiento tipoMovimientoToTipoMovimientoModel(Tipo_MovimientoModel tmm) {
		Tipo_Movimiento tm = new Tipo_Movimiento();
		tm.setIdtipoMovimiento(tmm.getIdtipo_movimiento());
		tm.setTm_descripcion(tmm.getTm_descripcion());
		tm.setTm_operacion(tmm.getTm_operacion());
		LOG.info("Tipo_MovimientoModel se ha convertido a Tipo_Movimiento Entity");
		return tm;
	}
}
