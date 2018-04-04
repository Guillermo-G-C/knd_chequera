package com.KND.chequera.model;

public class Tipo_MovimientoModel {
	
	private int idtipo_movimiento;
	private String tm_operacion;
	private String tm_descripcion;
	
	public Tipo_MovimientoModel(int idtipo_movimiento, String tm_operacion, String tm_descripcion) {
		super();
		this.idtipo_movimiento = idtipo_movimiento;
		this.tm_operacion = tm_operacion;
		this.tm_descripcion = tm_descripcion;
	}

	public int getIdtipo_movimiento() {
		return idtipo_movimiento;
	}

	public void setIdtipo_movimiento(int idtipo_movimiento) {
		this.idtipo_movimiento = idtipo_movimiento;
	}

	public String getTm_operacion() {
		return tm_operacion;
	}

	public void setTm_operacion(String tm_operacion) {
		this.tm_operacion = tm_operacion;
	}

	public String getTm_descripcion() {
		return tm_descripcion;
	}

	public void setTm_descripcion(String tm_descripcion) {
		this.tm_descripcion = tm_descripcion;
	}
	
}
