package com.KND.chequera.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.KND.chequera.entity.Clientes;
import com.KND.chequera.model.ClienteModel;

@Component("clientesConverter")
public class ClientesConverter {

	private static final Log LOG =LogFactory.getLog(ClientesConverter.class);
	
	//Entity -->to --> Model
	public ClienteModel cientesModelToCliente(Clientes cli) {
		ClienteModel climod=new ClienteModel();
		climod.setC_amaterno(cli.getC_amaterno());
		climod.setC_apaterno(cli.getC_apaterno());
		climod.setC_codigo_postal(cli.getC_codigo_postal());
		climod.setC_correo(cli.getC_correo());
		climod.setC_direccion(cli.getC_direccion());
		climod.setC_estado(cli.getC_estado());
		climod.setC_fecha_nacimiento(cli.getC_fecha_nacimiento());
		climod.setC_nombre(cli.getC_nombre());
		climod.setC_rfc(cli.getC_rfc());
		climod.setC_status(cli.isC_status());
		climod.setC_telefono(cli.getC_telefono());
		climod.setIdclientes(cli.getIdclientes());
		LOG.info("Cliente Convertido a Cliente Model");
		return climod;
	}
	
	//Model --> to -->Entity

	public Clientes clientesToClienteModel(ClienteModel cm) {
		Clientes cli= new Clientes();
		cli.setC_amaterno(cm.getC_amaterno());
		cli.setC_apaterno(cm.getC_apaterno());
		cli.setC_codigo_postal(cm.getC_codigo_postal());
		cli.setC_correo(cm.getC_correo());
		cli.setC_direccion(cm.getC_direccion());
		cli.setC_estado(cm.getC_estado());
		cli.setC_fecha_nacimiento(cm.getC_fecha_nacimiento());
		cli.setC_nombre(cm.getC_nombre());
		cli.setC_rfc(cm.getC_rfc());
		cli.setC_status(cm.isC_status());
		cli.setC_telefono(cm.getC_telefono());
		cli.setIdclientes(cm.getIdclientes());
		LOG.info("Cliente Modelo convertido a Clientes Entity");
		return cli;
	}
}
