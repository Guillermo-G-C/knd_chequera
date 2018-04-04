package com.KND.chequera.model;



public class BancoModel {
	
	
	private int idbancosMod;
	private String b_sucursalMod;
	private String c_entidadMod;
	private String b_direccionMod;
	private boolean b_statusMod;
	
	public BancoModel() {
	}

	public BancoModel(int idbancosMod, String b_sucursalMod, String c_entidadMod, String b_direccionMod,
			boolean b_statusMod) {
		super();
		this.idbancosMod = idbancosMod;
		this.b_sucursalMod = b_sucursalMod;
		this.c_entidadMod = c_entidadMod;
		this.b_direccionMod = b_direccionMod;
		this.b_statusMod = b_statusMod;
	}

	public int getIdbancosMod() {
		return idbancosMod;
	}

	public void setIdbancosMod(int idbancosMod) {
		this.idbancosMod = idbancosMod;
	}

	public String getB_sucursalMod() {
		return b_sucursalMod;
	}

	public void setB_sucursalMod(String b_sucursalMod) {
		this.b_sucursalMod = b_sucursalMod;
	}

	public String getC_entidadMod() {
		return c_entidadMod;
	}

	public void setC_entidadMod(String c_entidadMod) {
		this.c_entidadMod = c_entidadMod;
	}

	public String getB_direccionMod() {
		return b_direccionMod;
	}

	public void setB_direccionMod(String b_direccionMod) {
		this.b_direccionMod = b_direccionMod;
	}

	public boolean isB_statusMod() {
		return b_statusMod;
	}

	public void setB_statusMod(boolean b_statusMod) {
		this.b_statusMod = b_statusMod;
	}
	
	
	
	
}
