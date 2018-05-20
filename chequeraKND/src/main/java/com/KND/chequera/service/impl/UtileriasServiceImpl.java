package com.KND.chequera.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.repository.BancosRepository;
import com.KND.chequera.repository.ChequeraRepository;
import com.KND.chequera.repository.ClientesRepository;
import com.KND.chequera.repository.MovimientosRepository;
import com.KND.chequera.service.UtileriasService;

@Service("utileriasService")
public class UtileriasServiceImpl implements UtileriasService{

	@Autowired
	@Qualifier("movimientosRepository")
	private MovimientosRepository movimientosRepository;
	
	@Autowired
	@Qualifier("chequeraRepository")
	private ChequeraRepository chequeraRepository;
	
	@Autowired
	@Qualifier("clientesRepository")
	private ClientesRepository clientesRepository;
	
	@Autowired
	@Qualifier("bancosRepository")
	private BancosRepository bancosRepository;
	
	@Override
	public void eliminarMovimientos() {
		chequeraRepository.deleteAll();
		
	}

	@Override
	public void eliminarChequeras() {
		chequeraRepository.deleteAll();
		
	}

	@Override
	public void eliminarClientes() {
		clientesRepository.deleteAll();
		
	}

	@Override
	public void eliminarBancos() {
		bancosRepository.deleteAll();
		
	}
	
}
