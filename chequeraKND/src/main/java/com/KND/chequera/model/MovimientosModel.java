package com.KND.chequera.model;

import java.util.Date;

public class MovimientosModel {

	private int idmovimientos;
	private String m_concepto;
	private Double m_monto;
	private Date m_fecha;
	private Boolean m_status;
	
	public MovimientosModel() {}
	
	public MovimientosModel(int idmovimientos, String m_concepto, Double m_monto, Date m_fecha, Boolean m_status) {
		super();
		this.idmovimientos = idmovimientos;
		this.m_concepto = m_concepto;
		this.m_monto = m_monto;
		this.m_fecha = m_fecha;
		this.m_status = m_status;
	}

	public int getIdmovimientos() {
		return idmovimientos;
	}

	public void setIdmovimientos(int idmovimientos) {
		this.idmovimientos = idmovimientos;
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

	public Date getM_fecha() {
		return m_fecha;
	}

	public void setM_fecha(Date m_fecha) {
		this.m_fecha = m_fecha;
	}

	public Boolean getM_status() {
		return m_status;
	}

	public void setM_status(Boolean m_status) {
		this.m_status = m_status;
	}
	
}
