package com.KND.chequera.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimientos {

	@Id
	@GeneratedValue
	@Column(name = "idmovimiento")
	private int idmovimiento;
	@Column(name = "m_concepto")
	private String m_concepto;
	@Column(name = "m_monto")
	private Double m_monto;
	@Column(name = "mFecha")
	private Date mFecha;
	@Column(name = "m_status")
	private Boolean m_status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tm_idtipo_movimiento")
	private Tipo_Movimiento tipo_movimiento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ch_idchequera")
	private Chequera chequera;

	public Movimientos() {
	}

	public Movimientos(int idmovimiento, String m_concepto, Double m_monto, Date mFecha, Boolean m_status,
			Tipo_Movimiento tipo_movimiento, Chequera chequera) {
		super();
		this.idmovimiento = idmovimiento;
		this.m_concepto = m_concepto;
		this.m_monto = m_monto;
		this.mFecha = mFecha;
		this.m_status = m_status;
		this.tipo_movimiento = tipo_movimiento;
		this.chequera = chequera;
	}

	public int getIdmovimiento() {
		return idmovimiento;
	}

	public void setIdmovimiento(int idmovimiento) {
		this.idmovimiento = idmovimiento;
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

	public Tipo_Movimiento getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(Tipo_Movimiento tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	public Chequera getChequera() {
		return chequera;
	}

	public void setChequera(Chequera chequera) {
		this.chequera = chequera;
	}

}
