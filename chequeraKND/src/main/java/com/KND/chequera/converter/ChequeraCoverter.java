package com.KND.chequera.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.KND.chequera.entity.Chequera;
import com.KND.chequera.model.ChequeraModel;

@Component("chequeraConverter")
public class ChequeraCoverter {

	private static final Log LOG =LogFactory.getLog(ChequeraCoverter.class);

	//Entity -->to --> Model
	public ChequeraModel chequeraToChequeraModel(Chequera ch) {
		ChequeraModel chem=new ChequeraModel();
		chem.setCh_abono(ch.getCh_abono());
		chem.setCh_cargo(ch.getCh_cargo());
		chem.setCh_fecha_apertura(ch.getCh_fecha_apertura());
		chem.setCh_saldo(ch.getCh_saldo());
		chem.setCh_status(ch.isCh_status());
		chem.setIdchequera(ch.getIdchequera());
		chem.setClientes(ch.getClientes());
		chem.setBancos(ch.getBancos());
		LOG.info("Chequera Convertido a Model Exitosamente");
		return chem;
	}
	
	//Model --> to -->Entity
	public Chequera chequeraModelToChequera(ChequeraModel chem) {
		Chequera ch = new Chequera();
		ch.setCh_abono(chem.getCh_abono());
		ch.setCh_cargo(chem.getCh_cargo());
		ch.setCh_fecha_apertura(chem.getCh_fecha_apertura());
		ch.setCh_saldo(chem.getCh_saldo());
		ch.setCh_status(chem.isCh_status());
		ch.setIdchequera(chem.getIdchequera());
		ch.setClientes(chem.getClientes());
		ch.setBancos(chem.getBancos());
		LOG.info("Chequera Model Convetido a Chequera Entity");
		return ch;
	}
}
