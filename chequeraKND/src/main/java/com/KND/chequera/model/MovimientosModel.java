package com.KND.chequera.model;



import java.sql.Date;

import com.KND.chequera.entity.Chequera;
import com.KND.chequera.entity.Tipo_Movimiento;

public class MovimientosModel {

	private int idmovimientos;
	private String m_concepto;
	private Double m_monto;
	private Date mFecha;
	private Boolean m_status;
	private Tipo_Movimiento tipo_Movimiento;
	private Chequera chequera;
	
	public MovimientosModel() {}
	
	public MovimientosModel(int idmovimientos, String m_concepto, Double m_monto, Date mFecha, Boolean m_status,
			Tipo_Movimiento tipo_Movimiento, Chequera chequera) {
		super();
		this.idmovimientos = idmovimientos;
		this.m_concepto = m_concepto;
		this.m_monto = m_monto;
		this.mFecha = mFecha;
		this.m_status = m_status;
		this.tipo_Movimiento = tipo_Movimiento;
		this.chequera = chequera;
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
	
	public Date getmFecha() {
		return mFecha;
	}

	public void setmFecha(Date mFecha) {
		this.mFecha = mFecha;
	}

	public Boolean getM_status() {
		return m_status;
	}

	public void setM_status(Boolean m_status) {
		this.m_status = m_status;
	}

	public Tipo_Movimiento getTipo_Movimiento() {
		return tipo_Movimiento;
	}

	public void setTipo_Movimiento(Tipo_Movimiento tipo_Movimiento) {
		this.tipo_Movimiento = tipo_Movimiento;
	}

	public Chequera getChequera() {
		return chequera;
	}

	public void setChequera(Chequera chequera) {
		this.chequera = chequera;
	}

	@Override
	public String toString() {
		return "MovimientosModel [idmovimientos=" + idmovimientos + ", m_concepto=" + m_concepto + ", m_monto="
				+ m_monto + ", mFecha=" + mFecha + ", m_status=" + m_status + ", tipo_Movimiento=" + tipo_Movimiento
				+ ", chequera=" + chequera + "]";
	}

	
	
}
