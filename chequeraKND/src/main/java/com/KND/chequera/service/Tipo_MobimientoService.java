package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.entity.Tipo_Movimiento;

public interface Tipo_MobimientoService {

	public abstract Tipo_Movimiento findByidtipoMovimiento(int idtipoMovimiento);
	public abstract List<Tipo_Movimiento> listAllMovimientos();
	public abstract Tipo_Movimiento addMovimientos();
	public abstract int removeTipo_Movimiento(int idtipoMovimientos);
	public abstract Tipo_Movimiento updateTipo_Movimiento(Tipo_Movimiento tipo_movimiento);
	
}
