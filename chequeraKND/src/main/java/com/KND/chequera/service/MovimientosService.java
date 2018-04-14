package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.model.EstadoCuentaModel;
import com.KND.chequera.model.MovimientosModel;;

public interface MovimientosService {

	public abstract MovimientosModel findByidmovimiento(int idmovimientos);
	public abstract List<MovimientosModel> listAllMovimientos();
	public List<EstadoCuentaModel> listAllMovimientosEnRangoDeFechasAndChequera(String fechaInicio, String fechaCorte, int idChequera);
	public List<EstadoCuentaModel> listAllMovimientosMensualAndChequera(String yearMonth, int idChequera);
	public abstract MovimientosModel addMovimiento(MovimientosModel movimientosModel, int idChequera, int idTipoMovimiento);
	public abstract int removeMovimiento(int idMovimiento);
	public abstract MovimientosModel updateMovimiento();
}
