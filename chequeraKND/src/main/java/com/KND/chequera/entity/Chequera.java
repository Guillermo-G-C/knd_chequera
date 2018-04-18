package com.KND.chequera.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="chequera")
public class Chequera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idchequera")
	private int idchequera;
	@Column(name="chClaveInterbancaria")
	private String chClaveInterbancaria;
	@Column(name="chNumCuenta")
	private String chNumCuenta;
	@Column(name="ch_fecha_apertura")
	@Size(min = 1, max = 50)
	private String ch_fecha_apertura;
	@Column(name="ch_saldo")
	private double  ch_saldo;
	@Column(name="ch_abono")
	private double ch_abono;
	@Column(name="ch_cargo")
	private double ch_cargo;
	@Column(name="ch_status")
	private boolean ch_status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idclientes")
	private Clientes clientes;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idbancos")
	private Bancos bancos;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="chequera")
	private Set<Movimientos> movimientos = new HashSet<>();
	
	public Chequera() {
	}

	public Chequera(int idchequera, String chClaveInterbancaria, String chNumCuenta, String ch_fecha_apertura,
			double ch_saldo, double ch_abono, double ch_cargo, boolean ch_status, Clientes clientes, Bancos bancos,
			Set<Movimientos> movimientos) {
		super();
		this.idchequera = idchequera;
		this.chClaveInterbancaria = chClaveInterbancaria;
		this.chNumCuenta = chNumCuenta;
		this.ch_fecha_apertura = ch_fecha_apertura;
		this.ch_saldo = ch_saldo;
		this.ch_abono = ch_abono;
		this.ch_cargo = ch_cargo;
		this.ch_status = ch_status;
		this.clientes = clientes;
		this.bancos = bancos;
		this.movimientos = movimientos;
	}

		public int getIdchequera() {
		return idchequera;
	}

	public void setIdchequera(int idchequera) {
		this.idchequera = idchequera;
	}

	public String getChClaveInterbancaria() {
		return chClaveInterbancaria;
	}

	public void setChClaveInterbancaria(String chClaveInterbancaria) {
		this.chClaveInterbancaria = chClaveInterbancaria;
	}

	public String getChNumCuenta() {
		return chNumCuenta;
	}

	public void setChNumCuenta(String chNumCuenta) {
		this.chNumCuenta = chNumCuenta;
	}
	
	public String getCh_fecha_apertura() {
		return ch_fecha_apertura;
	}

	public void setCh_fecha_apertura(String ch_fecha_apertura) {
		this.ch_fecha_apertura = ch_fecha_apertura;
	}

	public double getCh_saldo() {
		return ch_saldo;
	}

	public void setCh_saldo(double ch_saldo) {
		this.ch_saldo = ch_saldo;
	}

	public double getCh_abono() {
		return ch_abono;
	}

	public void setCh_abono(double ch_abono) {
		this.ch_abono = ch_abono;
	}

	public double getCh_cargo() {
		return ch_cargo;
	}

	public void setCh_cargo(double ch_cargo) {
		this.ch_cargo = ch_cargo;
	}

	public boolean isCh_status() {
		return ch_status;
	}

	public void setCh_status(boolean ch_status) {
		this.ch_status = ch_status;
	}
	
	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	
	public Bancos getBancos() {
		return bancos;
	}

	public void setBancos(Bancos bancos) {
		this.bancos = bancos;
	}
	
	public Set<Movimientos> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimientos> movimientos) {
		this.movimientos = movimientos;
	}
	
}
