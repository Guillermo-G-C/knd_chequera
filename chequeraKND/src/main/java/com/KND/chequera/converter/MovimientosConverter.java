package com.KND.chequera.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.KND.chequera.entity.Movimientos;
import com.KND.chequera.model.EstadoCuentaModel;
import com.KND.chequera.model.MovimientosModel;

@Component("movimientosConverter")
public class MovimientosConverter {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date fecha=null;
	
	private static final Log LOG =LogFactory.getLog(MovimientosConverter.class);
	
	//Entity -->to --> Model
	public MovimientosModel movimientosToMovimientoModel(Movimientos mov) {
		MovimientosModel mvm= new MovimientosModel();
		mvm.setIdmovimientos(mov.getIdmovimiento());
		mvm.setM_concepto(mov.getM_concepto());
		/*try {
			fecha=dateFormat.parse(mov.getmFecha().toString());
			LOG.info("Fecha con formato yy-MM-yy: "+fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		mvm.setmFecha(mov.getmFecha());
		mvm.setM_monto(mov.getM_monto());
		mvm.setM_status(mov.getM_status());
		mvm.setChequera(mov.getChequera());
		mvm.setTipo_Movimiento(mov.getTipo_movimiento());
		LOG.info("Movimientos Entity Convertido a Movimientos MOdel");
		return mvm;
	}
	
	//Entity -->to --> Model
	public EstadoCuentaModel movimientosToEstadoCuentaModel(Movimientos mov) {
		EstadoCuentaModel edm= new EstadoCuentaModel();
		edm.setM_concepto(mov.getM_concepto());
		/*try {
			fecha=dateFormat.parse(mov.getmFecha().toString());
			LOG.info("Fecha con formato yy-MM-yy: "+fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		edm.setmFecha(mov.getmFecha().toString());
		edm.setM_monto(mov.getM_monto());
		edm.setTipo_Operacion(mov.getTipo_movimiento().getTm_operacion());
		LOG.info("Movimientos Entity Convertido a EstadoCuentaModel");
		return edm;
	}
	
	//Model --> to -->Entity
	public Movimientos movimientosModelToMovimientos(MovimientosModel mvm) {
		Movimientos mv=new Movimientos();
		mv.setIdmovimiento(mvm.getIdmovimientos());
		mv.setM_concepto(mvm.getM_concepto());
		/*try {
			fecha=dateFormat.parse(mvm.getmFecha());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		mv.setmFecha(mvm.getmFecha());
		mv.setM_monto(mvm.getM_monto());
		mv.setM_status(mvm.getM_status());
		mv.setChequera(mvm.getChequera());
		mv.setTipo_movimiento(mvm.getTipo_Movimiento());
		LOG.info("Movimientos Model convertido a Model Entity");
		return mv;
	}
}
