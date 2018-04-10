package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.ChequeraCoverter;
import com.KND.chequera.converter.ClientesConverter;
import com.KND.chequera.entity.Bancos;
import com.KND.chequera.entity.Chequera;
import com.KND.chequera.entity.Clientes;
import com.KND.chequera.model.ChequeraModel;
import com.KND.chequera.repository.BancosRepository;
import com.KND.chequera.repository.ChequeraRepository;
import com.KND.chequera.repository.ClientesRepository;
import com.KND.chequera.service.ChequeraService;

@Service("chequeraService")
public class ChequeraServiceImpl implements ChequeraService{

	@Autowired
	@Qualifier("chequeraRepository")
	private ChequeraRepository chequeraRepository;
	
	@Autowired
	@Qualifier("clientesRepository")
	private ClientesRepository clientesRepository;
	
	@Autowired
	@Qualifier("bancosRepository")
	private BancosRepository bancosRepository;
	
	@Autowired
	@Qualifier("chequeraConverter")
	private ChequeraCoverter chequeraCoverter;
	
	@Autowired
	@Qualifier("clientesConverter")
	private ClientesConverter clientesConverter;

	private static final Log LOG = LogFactory.getLog(ChequeraServiceImpl.class);
	
	@Override
	public ChequeraModel findByidchequera(int idchequera) {
		ChequeraModel chequeraModel = chequeraCoverter.chequeraToChequeraModel(chequeraRepository.findByidchequera(idchequera));
		return chequeraModel;
	}

	@Override
	public List<ChequeraModel> listAllChequeras() {
		List<Chequera> chequeras = chequeraRepository.findAll();
		List<ChequeraModel> chequerasModel = new ArrayList<ChequeraModel>();
		
		for(Chequera chequera : chequeras) {
			chequerasModel.add(chequeraCoverter.chequeraToChequeraModel(chequera));
			//LOG.info("Cliente: "+chequera.getClientes().getC_nombre());
		}
		//LOG.info("METHOD: listAllChequeras(), PARAMS: "+chequerasModel.size());
		//LOG.info("Chequera by Cliente"+chequeraRepository.findByclientes(clientesRepository.findByidclientes(1)));
		return chequerasModel;
	}

	@Override
	public ChequeraModel addChequera(ChequeraModel chequeraModel, int idCliente, int idBanco) {
		LOG.info("addChequera() -- ChequeraServiceImpl, IdCliente: "+idCliente);
		Clientes cliente = clientesRepository.findByidclientes(idCliente);
		//LOG.info("Cliente repository: "+cliente.toString());
		Bancos banco = bancosRepository.findByidbancos(idBanco);
		
		chequeraModel.setClientes(cliente);
		chequeraModel.setBancos(banco);
		//LOG.info("ChequeraModel: "+chequeraModel.toString());
		Chequera chequera = chequeraRepository.save(chequeraCoverter.chequeraModelToChequera(chequeraModel));
		return chequeraCoverter.chequeraToChequeraModel(chequera);
	}
	
	@Override
	public ChequeraModel addChequera(ChequeraModel chequeraModel, int idCliente) {
		LOG.info("addChequera() -- ChequeraServiceImpl, IdCliente: "+idCliente);
		Clientes cliente = clientesRepository.findByidclientes(idCliente);
		//LOG.info("Cliente repository: "+cliente.toString());
		
		chequeraModel.setClientes(cliente);
		//LOG.info("ChequeraModel: "+chequeraModel.toString());
		Chequera chequera = chequeraRepository.save(chequeraCoverter.chequeraModelToChequera(chequeraModel));
		return chequeraCoverter.chequeraToChequeraModel(chequera);
	}

	@Override
	public int removeChequera(int idchequera) {
		chequeraRepository.delete(idchequera);
		return 0;
	}

	@Override
	public ChequeraModel updateChequera(ChequeraModel chequeraModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
