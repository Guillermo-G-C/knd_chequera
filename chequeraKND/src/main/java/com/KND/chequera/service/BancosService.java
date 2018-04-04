package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.entity.Bancos;

public interface BancosService {

	public abstract Bancos findByidbanco();
	public abstract List<Bancos> listAllBancos();
	public abstract Bancos addBanco(Bancos banco);
	public abstract int removeBancos(int idbancos);
	public abstract Bancos updateBanco(Bancos banco);
	
}
