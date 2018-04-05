package com.KND.chequera.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KND.chequera.entity.Chequera;
import com.KND.chequera.entity.Clientes;

@Repository("chequeraRepository")
public interface ChequeraRepository extends JpaRepository<Chequera, Serializable>{
	public abstract Chequera findByidchequera(int idchequera);
	public abstract List<Chequera> findByclientes(Clientes cliente);
	public abstract List<Chequera> findAll();
}
