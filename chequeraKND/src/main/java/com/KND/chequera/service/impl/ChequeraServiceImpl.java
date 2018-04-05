package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.ChequeraCoverter;
import com.KND.chequera.entity.Chequera;
import com.KND.chequera.model.ChequeraModel;
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
	@Qualifier("chequeraConverter")
	private ChequeraCoverter chequeraCoverter;

	private static final Log LOG = LogFactory.getLog(ChequeraServiceImpl.class);
	
	@Override
	public ChequeraModel findByidchequera(int idchequera) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChequeraModel> listAllChequeras() {
		List<Chequera> chequeras = chequeraRepository.findAll();
		List<ChequeraModel> chequerasModel = new ArrayList<ChequeraModel>();
		
		for(Chequera chequera : chequeras) {
			chequerasModel.add(chequeraCoverter.chequeraToChequeraModel(chequera));
			//LOG.info("Chequera.Cliente: "+chequera.getClientes().getC_nombre());
		}
		LOG.info("METHOD: listAllChequeras(), PARAMS: "+chequerasModel.size());
		//LOG.info("Chequera by Cliente"+chequeraRepository.findByclientes(clientesRepository.findByidclientes(1)));
		return chequerasModel;
	}

	@Override
	public ChequeraModel addChequera(ChequeraModel chequeraModel) {
		Chequera chequera = chequeraRepository.save(chequeraCoverter.chequeraModelToChequera(chequeraModel));
		return chequeraCoverter.chequeraToChequeraModel(chequera);
	}

	@Override
	public int removeChequera(int idchequera) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChequeraModel updateChequera() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
