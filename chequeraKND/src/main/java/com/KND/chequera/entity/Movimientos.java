package com.KND.chequera.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimientos {

	@Id
	@GeneratedValue
	@Column(name = "idmovimiento")
	private int idmovimiento;
	@Column(name="m_concepto")
	private String m_concepto;
	@Column(name="m_monto")
	private Double m_monto;
	@Column(name="m_fecha")
	private Date m_fecha;
	@Column(name="m_status")
	private Boolean m_status;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tm_idtipo_movimiento")
	private Tipo_Movimiento tipo_movimiento;
	@Column(name="ch_idchequera")
	private int ch_idchequera;
	
	public Movimientos() {}
	
	public Movimientos(int idmovimiento, String m_concepto, Double m_monto, Date m_fecha, Boolean m_status,
			Tipo_Movimiento tipo_movimiento, int ch_idchequera) {
		super();
		this.idmovimiento = idmovimiento;
		this.m_concepto = m_concepto;
		this.m_monto = m_monto;
		this.m_fecha = m_fecha;
		this.m_status = m_status;
		this.tipo_movimiento = tipo_movimiento;
		this.ch_idchequera = ch_idchequera;
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
	public Tipo_Movimiento getTipo_movimiento() {
		return tipo_movimiento;
	}
	public void setTipo_movimiento(Tipo_Movimiento tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}
	public int getCh_idchequera() {
		return ch_idchequera;
	}
	public void setCh_idchequera(int ch_idchequera) {
		this.ch_idchequera = ch_idchequera;
	}
	
}
