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
@Table(name="bancos")
public class Bancos {

	@Id
	@GeneratedValue
	@Column(name="idbancos")
	private int idbancos;
	@Column(name="b_sucursal")
	private String b_sucursal;
	@Column(name="b_entidad")
	private String b_entidad;
	@Column(name="b_direccion")
	private String b_direccion;
	@Column(name="b_status")
	private boolean b_status;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="bancos"/*, cascade = CascadeType.ALL*/)
	private Set<Chequera> chequera = new HashSet<>();
	
	public Bancos() {}

	public Bancos(int idbancos, String b_sucursal, String b_entidad, String b_direccion, boolean b_status,
			Set<Chequera> chequera) {
		super();
		this.idbancos = idbancos;
		this.b_sucursal = b_sucursal;
		this.b_entidad = b_entidad;
		this.b_direccion = b_direccion;
		this.b_status = b_status;
		this.chequera = chequera;
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
	
	public Set<Chequera> getChequera() {
		return chequera;
	}

	public void setChequera(Set<Chequera> chequera) {
		this.chequera = chequera;
	}
	
}
