package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.entity.Chequera;

public interface ChequeraService {
	
	public abstract Chequera findByidChequera(int idchequera);
	public abstract List<Chequera> listAllChequeras();
	public abstract Chequera addChequera(Chequera chequera);
	public abstract int removeChequera(int idchequera);
	public abstract Chequera updateChequera();
	
}
