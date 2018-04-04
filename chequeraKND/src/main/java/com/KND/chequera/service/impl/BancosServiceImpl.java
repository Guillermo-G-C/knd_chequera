package com.KND.chequera.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.KND.chequera.entity.Bancos;
import com.KND.chequera.repository.BancosRepository;
import com.KND.chequera.service.BancosService;

@Service("bancoService")
public class BancosServiceImpl implements BancosService{
	
	@Autowired
	@Qualifier("bancosRepository")
	private BancosRepository bancosRepository;

	@Override
	public Bancos findByidbanco(int idbancos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bancos> listAllBancos() {
		return bancosRepository.findAll();
	}

	@Override
	public Bancos addBanco(Bancos banco) {
		return bancosRepository.save(banco);
	}

	@Override
	public int removeBancos(int idbancos) {
		bancosRepository.deleteById(idbancos);;
		return 0;
	}

	@Override
	public Bancos updateBanco(Bancos banco) {
		bancosRepository.save(banco);
		return null;
	}

}
