package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.model.MovimientosModel;;

public interface MovimientosService {

	public abstract MovimientosModel findByidmovimiento(int idmovimientos);
	public abstract List<MovimientosModel> listAllMovimientos();
	public abstract MovimientosModel addMovimiento(MovimientosModel movimientosModel, int idChequera, int idTipoMovimiento);
	public abstract int removeChequera(int idMovimiento);
	public abstract MovimientosModel updateMovimiento();
}
