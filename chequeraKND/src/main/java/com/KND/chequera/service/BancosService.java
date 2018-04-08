package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.model.BancoModel;

public interface BancosService {

	public abstract BancoModel findByidbanco(int idbancos);
	public abstract List<BancoModel> listAllBancos();
	public abstract BancoModel addBanco(BancoModel bancoModel);
	public abstract int removeBancos(int idbancos);
	public abstract BancoModel updateBanco(BancoModel bancoModel);
	
}
