package com.KND.chequera.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="bancos")
public class Banco {

	@Id
	@GeneratedValue
	@Column(name="Idbancos")
	private int idbancos;
	@Column(name="b_sucursal")
	private String b_sucursal;
	@Column(name="b_entidad")
	private String c_entidad;
	@Column(name="b_direccion")
	private String b_direccion;
	@Column(name="b_status")
	private boolean b_status;
	
	
}
