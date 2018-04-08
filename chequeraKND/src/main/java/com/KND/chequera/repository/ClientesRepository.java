package com.KND.chequera.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KND.chequera.entity.Clientes;

@Repository("clientesRepository")
public interface ClientesRepository  extends JpaRepository<Clientes, Serializable> {

	public abstract Clientes findByidclientes(int idClientes);
	public abstract List<Clientes> findAll();
	
}
