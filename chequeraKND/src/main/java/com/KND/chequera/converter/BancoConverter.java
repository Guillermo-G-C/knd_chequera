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
		banmod.setIdbancosMod(ban.getIdbancos());
		banmod.setB_direccionMod(ban.getB_direccion());
		banmod.setB_statusMod(ban.isB_status());
		banmod.setB_sucursalMod(ban.getB_sucursal());
		banmod.setC_entidadMod(ban.getC_entidad());
		LOG.info("Banco Entity Convetido con exito a Model ");
		return banmod;
	}
	
	//Model --> to -->Entity
	public Bancos bancoModelToBancos(BancoModel banmod) {
		Bancos ban = new Bancos();
		ban.setB_direccion(banmod.getB_direccionMod());
		ban.setB_status(banmod.isB_statusMod());
		ban.setB_sucursal(banmod.getB_sucursalMod());
		ban.setC_entidad(banmod.getC_entidadMod());
		ban.setIdbancos(banmod.getIdbancosMod());
		LOG.info("BancosModel convertido a Banco con exito ");
		return ban;
	}
	
}
