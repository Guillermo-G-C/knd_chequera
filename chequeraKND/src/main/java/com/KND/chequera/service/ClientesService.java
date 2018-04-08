package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.model.ClienteModel;

public interface ClientesService {

	public abstract ClienteModel findByidclientes(int idclientes);
	public abstract List<ClienteModel> listAllClientes();
	public abstract ClienteModel addClientes(ClienteModel cliente);
	public abstract int removeClientes(int idclientes);
	public abstract ClienteModel updateClientes(ClienteModel clientes);
	
}
