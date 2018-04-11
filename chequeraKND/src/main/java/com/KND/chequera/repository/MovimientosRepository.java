package com.KND.chequera.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KND.chequera.entity.Chequera;
import com.KND.chequera.entity.Movimientos;

@Repository("movimientosRepository")
public interface MovimientosRepository extends JpaRepository<Movimientos, Serializable> {
	
	//Buscar Mobimientos por idMovimiento
	public abstract Movimientos findByidmovimiento(int idMovimientos);
	public abstract List<Movimientos> findAll();
	List<Movimientos> findByMFechaAfter(Date fechaInicio);
	List<Movimientos> findByMFechaAfterAndMFechaBefore(Date fechaInicio, Date fechaCorte);
	List<Movimientos> findByMFechaAfterAndMFechaBeforeAndChequeraEquals(Date fechaInicio, Date fechaCorte, Chequera chequera);
	//List<Movimientos> findByMFechaStartingWithAndMFechaEndingWith(String fechaInicio, String fechaCorte);
}
