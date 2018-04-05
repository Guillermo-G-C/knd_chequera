package com.KND.chequera.service;

import java.util.List;

import com.KND.chequera.model.ChequeraModel;

public interface ChequeraService {
	
	public abstract ChequeraModel findByidchequera(int idchequera);
	public abstract List<ChequeraModel> listAllChequeras();
	public abstract ChequeraModel addChequera(ChequeraModel chequeraModel);
	public abstract int removeChequera(int idchequera);
	public abstract ChequeraModel updateChequera();
	
}
