package com.KND.chequera.model;



public class BancoModel {
	
	
	private int idbancos;
	private String b_sucursal;
	private String b_entidad;
	private String b_direccion;
	private boolean b_status;
	
	public BancoModel() {
	}

	public BancoModel(int idbancos, String b_sucursal, String b_entidad, String b_direccion, boolean b_status) {
		super();
		this.idbancos = idbancos;
		this.b_sucursal = b_sucursal;
		this.b_entidad = b_entidad;
		this.b_direccion = b_direccion;
		this.b_status = b_status;
	}

	public int getIdbancos() {
		return idbancos;
	}

	public void setIdbancos(int idbancos) {
		this.idbancos = idbancos;
	}

	public String getB_sucursal() {
		return b_sucursal;
	}

	public void setB_sucursal(String b_sucursal) {
		this.b_sucursal = b_sucursal;
	}

	public String getB_entidad() {
		return b_entidad;
	}

	public void setB_entidad(String b_entidad) {
		this.b_entidad = b_entidad;
	}

	public String getB_direccion() {
		return b_direccion;
	}

	public void setB_direccion(String b_direccion) {
		this.b_direccion = b_direccion;
	}

	public boolean isB_status() {
		return b_status;
	}

	public void setB_status(boolean b_status) {
		this.b_status = b_status;
	}

	@Override
	public String toString() {
		return "BancoModel [idbancos=" + idbancos + ", b_sucursal=" + b_sucursal + ", b_entidad=" + b_entidad
				+ ", b_direccion=" + b_direccion + ", b_status=" + b_status + "]";
	}	
}
