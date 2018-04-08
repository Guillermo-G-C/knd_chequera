package com.KND.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.converter.BancoConverter;
import com.KND.chequera.entity.Bancos;
import com.KND.chequera.model.BancoModel;
import com.KND.chequera.repository.BancosRepository;
import com.KND.chequera.service.BancosService;

@Service("bancosService")
public class BancosServiceImpl implements BancosService{
	
	@Autowired
	@Qualifier("bancosRepository")
	private BancosRepository bancosRepository;

	@Autowired
	@Qualifier("bancoConverter")
	private BancoConverter bancoConverter;
	
	@Override
	public BancoModel findByidbanco(int idbancos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BancoModel> listAllBancos() {
		List<Bancos> bancos = bancosRepository.findAll();
		List<BancoModel> bancosModel = new ArrayList<BancoModel>();
		
		for(Bancos banco : bancos) {
			bancosModel.add(bancoConverter.bancoToBancoModel(banco));
		}
		
		return bancosModel;
	}

	@Override
	public BancoModel addBanco(BancoModel bancoModel) {
		Bancos banco = bancosRepository.save(bancoConverter.bancoModelToBancos(bancoModel));
		return bancoConverter.bancoToBancoModel(banco);
	}

	@Override
	public int removeBancos(int idbancos) {
		bancosRepository.deleteById(idbancos);;
		return 0;
	}

	@Override
	public BancoModel updateBanco(BancoModel bancoModel) {
		bancosRepository.save(bancoConverter.bancoModelToBancos(bancoModel));
		return null;
	}

}
