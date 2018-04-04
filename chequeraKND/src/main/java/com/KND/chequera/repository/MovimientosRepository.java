package com.KND.chequera.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KND.chequera.entity.Movimientos;

@Repository("movimientosRepository")
public interface MovimientosRepository extends JpaRepository<Movimientos, Serializable> {
	
	//Buscar Mobimientos por idMovimiento
	public abstract Movimientos findByidmovimiento(int idMovimientos);
	public abstract List<Movimientos> findAll();
}