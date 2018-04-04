package com.KND.chequera.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_movimiento")
public class Tipo_Movimiento {

	@Id
	@GeneratedValue
	@Column(name = "idtipoMovimiento")
	private int idtipoMovimiento;
	@Column(name = "tm_operacion")
	private String tm_operacion;
	@Column(name = "tm_descripcion")
	private String tm_descripcion;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="tipo_movimiento")
	private Set<Movimientos> movimientos = new HashSet<>();
	
	public Tipo_Movimiento() {
	}

	public Tipo_Movimiento(int idtipoMovimiento, String tm_operacion, String tm_descripcion,
			Set<Movimientos> movimientos) {
		super();
		this.idtipoMovimiento = idtipoMovimiento;
		this.tm_operacion = tm_operacion;
		this.tm_descripcion = tm_descripcion;
		this.movimientos = movimientos;
	}

	public int getIdtipoMovimiento() {
		return idtipoMovimiento;
	}

	public void setIdtipoMovimiento(int idtipoMovimiento) {
		this.idtipoMovimiento = idtipoMovimiento;
	}

	public Set<Movimientos> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimientos> movimientos) {
		this.movimientos = movimientos;
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
