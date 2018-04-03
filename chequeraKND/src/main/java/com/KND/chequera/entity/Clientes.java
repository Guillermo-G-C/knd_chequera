package com.KND.chequera.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="clientes")
public class Clientes {

	@Id
	@GeneratedValue
	@Column(name="Idclientes")
	private int idclientes;
	@Column(name="c_nombre")
	private String c_nombre;
	@Column(name="c_apaterno")
	private String c_apaterno;
	@Column(name="c_amaterno")
	private String c_amaterno;
	@Column(name="c_direccion")
	private String c_direccion;
	@Column(name="c_estado")
	private String c_estado;
	@Column(name="c_codigo_postal")
	private int c_codigo_postal;
	@Column(name="c_telefono")
	private int c_telefono;
	@Column(name="c_correo")
	private String c_correo;
	@Column(name="c_fecha_nacimiento")
	private String c_fecha_nacimiento;\
	@Column(name="c_rfc")
	private String c_rfc;
}
