package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.entity.Movimientos;

public interface MovimientosService {

	public abstract Movimientos findByidmovimiento();
	public abstract List<Movimientos> listAllMovimientos();
	
}
