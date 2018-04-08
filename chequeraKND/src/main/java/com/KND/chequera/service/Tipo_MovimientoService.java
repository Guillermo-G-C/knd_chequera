package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.model.Tipo_MovimientoModel;

public interface Tipo_MovimientoService {

	public abstract Tipo_MovimientoModel findByidtipoMovimiento(int idtipoMovimiento);
	public abstract List<Tipo_MovimientoModel> listAllMovimientos();
	public abstract Tipo_MovimientoModel addMovimientos();
	public abstract int removeTipo_Movimiento(int idtipoMovimientos);
	public abstract Tipo_MovimientoModel updateTipo_Movimiento(Tipo_MovimientoModel tipo_movimientoModel);
	
}
