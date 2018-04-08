package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.ClientesConverter;
import com.KND.chequera.entity.Clientes;
import com.KND.chequera.model.ClienteModel;
import com.KND.chequera.repository.ClientesRepository;
import com.KND.chequera.service.ClientesService;

@Service("clientesService")
public class ClientesServieImpl  implements ClientesService{
	
	@Autowired
	@Qualifier("clientesRepository")
	private ClientesRepository clientesRepository;
	
	@Autowired
	@Qualifier("clientesConverter")
	private ClientesConverter clientesConverter;

	@Override
	public ClienteModel findByidclientes(int idclientes) {
		ClienteModel clienteModel = clientesConverter.cientesToClienteModel(clientesRepository.findByidclientes(idclientes));
		return clienteModel;
	}

	@Override
	public List<ClienteModel> listAllClientes() {
		List<Clientes> clientes = clientesRepository.findAll();
		List<ClienteModel> clienteModel = new ArrayList<ClienteModel>();
		
		for(Clientes cliente : clientes) {
			clienteModel.add(clientesConverter.cientesToClienteModel(cliente));
		}
		
		return clienteModel;
	}

	@Override
	public ClienteModel addClientes(ClienteModel cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeClientes(int idclientes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ClienteModel updateClientes(ClienteModel clientes) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
