package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.entity.Clientes;

public interface ClientesService {

	public abstract Clientes findByidclientes(int idclientes);
	public abstract List<Clientes> listAllClientes();
	public abstract Clientes addClientes(Clientes cliente);
	public abstract int removeClientes(int idclientes);
	public abstract Clientes updateClientes(Clientes clientes);
	
}
