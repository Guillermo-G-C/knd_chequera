package com.KND.chequera.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.entity.Movimientos;
import com.KND.chequera.repository.MovimientosRepository;
import com.KND.chequera.service.MovimientosService;

@Service("movimientoService")
public class MovimientosServiceImpl implements MovimientosService {
	
	@Autowired
	@Qualifier("movimientosRepository")
	private MovimientosRepository movimientosRepository;
	
	@Override
	public Movimientos findByidmovimiento() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Movimientos> listAllMovimientos() {
		return movimientosRepository.findAll();
	}
	
}
