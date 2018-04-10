package com.KND.chequera.model;

public class EstadoCuentaModel {

	private String m_concepto;
	private Double m_monto;
	private String mFecha;
	private String tipo_Operacion;
	
	
	public EstadoCuentaModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EstadoCuentaModel(String m_concepto, Double m_monto, String mFecha, String tipo_Operacion) {
		super();
		this.m_concepto = m_concepto;
		this.m_monto = m_monto;
		this.mFecha = mFecha;
		this.tipo_Operacion = tipo_Operacion;
	}


	public String getM_concepto() {
		return m_concepto;
	}


	public void setM_concepto(String m_concepto) {
		this.m_concepto = m_concepto;
	}


	public Double getM_monto() {
		return m_monto;
	}


	public void setM_monto(Double m_monto) {
		this.m_monto = m_monto;
	}


	public String getmFecha() {
		return mFecha;
	}


	public void setmFecha(String mFecha) {
		this.mFecha = mFecha;
	}


	public String getTipo_Operacion() {
		return tipo_Operacion;
	}


	public void setTipo_Operacion(String tipo_Operacion) {
		this.tipo_Operacion = tipo_Operacion;
	}
	
	
	
	//Parameters
	/*
	Banco
		*Entidad
		Sucursal
		//Direccion
	 	
	Cliente
		RFC
	 	
	Chequera
		*N° cuenta(id)
		//Saldo
	 	
	Estado de cuenta
		*Fecha corte
		*Periodo
	 	
		Retiros
		Depositos
		Saldo
		*/

	//datasource
	/* 	
	Movimiento
		Fecha
		Concepto
		Monto
	*/
	

}
