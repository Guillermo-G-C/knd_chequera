package com.KND.chequera.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.KND.chequera.entity.Bancos;
import com.KND.chequera.model.BancoModel;

@Component("bancoConverter")
public class BancoConverter {

	private static final Log LOG =LogFactory.getLog(BancoConverter.class);

	//Entity -->to --> Model
	public BancoModel bancoToBancoModel(Bancos ban) {
		BancoModel banmod= new BancoModel();
		banmod.setIdbancos(ban.getIdbancos());
		banmod.setB_direccion(ban.getB_direccion());
		banmod.setB_status(ban.isB_status());
		banmod.setB_sucursal(ban.getB_sucursal());
		banmod.setB_entidad(ban.getB_entidad());
		LOG.info("Banco Entity Convetido con exito a Model ");
		return banmod;
	}
	
	//Model --> to -->Entity
	public Bancos bancoModelToBancos(BancoModel banmod) {
		Bancos ban = new Bancos();
		ban.setB_direccion(banmod.getB_direccion());
		ban.setB_status(banmod.isB_status());
		ban.setB_sucursal(banmod.getB_sucursal());
		ban.setB_entidad(banmod.getB_entidad());
		ban.setIdbancos(banmod.getIdbancos());
		LOG.info("BancosModel convertido a Banco con exito ");
		return ban;
	}
	
}
