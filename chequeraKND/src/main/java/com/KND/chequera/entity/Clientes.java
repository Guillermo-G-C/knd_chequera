package com.KND.chequera.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "clientes")
public class Clientes {

	@Id
	@GeneratedValue
	@Column(name = "Idclientes")
	private int idclientes;
	@Column(name = "c_nombre")
	private String c_nombre;
	@Column(name = "c_apaterno")
	private String c_apaterno;
	@Column(name = "c_amaterno")
	private String c_amaterno;
	@Column(name = "c_direccion")
	private String c_direccion;
	@Column(name = "c_estado")
	private String c_estado;
	@Column(name = "c_codigo_postal")
	private int c_codigo_postal;
	@Column(name = "c_telefono")
	private int c_telefono;
	@Column(name = "c_correo")
	private String c_correo;
	@Column(name = "c_fecha_nacimiento")
	private String c_fecha_nacimiento;
	@Column(name = "c_rfc")
	private String c_rfc;
	@Column(name = "c_status")
	private boolean c_status;

	public Clientes() {

	}

	public Clientes(int idclientes, String c_nombre, String c_apaterno, String c_amaterno, String c_direccion,
			String c_estado, int c_codigo_postal, int c_telefono, String c_correo, String c_fecha_nacimiento,
			String c_rfc, boolean c_status) {
		super();
		this.idclientes = idclientes;
		this.c_nombre = c_nombre;
		this.c_apaterno = c_apaterno;
		this.c_amaterno = c_amaterno;
		this.c_direccion = c_direccion;
		this.c_estado = c_estado;
		this.c_codigo_postal = c_codigo_postal;
		this.c_telefono = c_telefono;
		this.c_correo = c_correo;
		this.c_fecha_nacimiento = c_fecha_nacimiento;
		this.c_rfc = c_rfc;
		this.c_status = c_status;
	}

	public int getIdclientes() {
		return idclientes;
	}

	public void setIdclientes(int idclientes) {
		this.idclientes = idclientes;
	}

	public String getC_nombre() {
		return c_nombre;
	}

	public void setC_nombre(String c_nombre) {
		this.c_nombre = c_nombre;
	}

	public String getC_apaterno() {
		return c_apaterno;
	}

	public void setC_apaterno(String c_apaterno) {
		this.c_apaterno = c_apaterno;
	}

	public String getC_amaterno() {
		return c_amaterno;
	}

	public void setC_amaterno(String c_amaterno) {
		this.c_amaterno = c_amaterno;
	}

	public String getC_direccion() {
		return c_direccion;
	}

	public void setC_direccion(String c_direccion) {
		this.c_direccion = c_direccion;
	}

	public String getC_estado() {
		return c_estado;
	}

	public void setC_estado(String c_estado) {
		this.c_estado = c_estado;
	}

	public int getC_codigo_postal() {
		return c_codigo_postal;
	}

	public void setC_codigo_postal(int c_codigo_postal) {
		this.c_codigo_postal = c_codigo_postal;
	}

	public int getC_telefono() {
		return c_telefono;
	}

	public void setC_telefono(int c_telefono) {
		this.c_telefono = c_telefono;
	}

	public String getC_correo() {
		return c_correo;
	}

	public void setC_correo(String c_correo) {
		this.c_correo = c_correo;
	}

	public String getC_fecha_nacimiento() {
		return c_fecha_nacimiento;
	}

	public void setC_fecha_nacimiento(String c_fecha_nacimiento) {
		this.c_fecha_nacimiento = c_fecha_nacimiento;
	}

	public String getC_rfc() {
		return c_rfc;
	}

	public void setC_rfc(String c_rfc) {
		this.c_rfc = c_rfc;
	}

	public boolean isC_status() {
		return c_status;
	}

	public void setC_status(boolean c_status) {
		this.c_status = c_status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Clientes [idclientes=" + idclientes + ", c_nombre=" + c_nombre + ", c_apaterno=" + c_apaterno
				+ ", c_amaterno=" + c_amaterno + ", c_direccion=" + c_direccion + ", c_estado=" + c_estado
				+ ", c_codigo_postal=" + c_codigo_postal + ", c_telefono=" + c_telefono + ", c_correo=" + c_correo
				+ ", c_fecha_nacimiento=" + c_fecha_nacimiento + ", c_rfc=" + c_rfc + ", c_status=" + c_status + "]";
	}

}
