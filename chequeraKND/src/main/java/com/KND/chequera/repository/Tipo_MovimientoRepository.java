package com.KND.chequera.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KND.chequera.entity.Tipo_Movimiento;

@Repository("tipo_movimientoRepository")
public interface Tipo_MovimientoRepository extends JpaRepository<Tipo_Movimiento, Serializable> {

	public abstract Tipo_Movimiento findByidtipoMovimiento(int idtipomovimiento);
	public abstract List<Tipo_Movimiento> findAll();
	
}
