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
@Table(name="chequera")
public class Chequera {

	
	//@Column(name="idchequera")
	private int idchequera;
	//@Column(name="ch_fecha_apertura")
	private Date ch_fecha_apertura;
	//@Column(name="ch_saldo")
	private double  ch_saldo;
	//@Column(name="ch_abono")
	private double ch_abono;
	//@Column(name="ch_cargo")
	private String ch_cargo;
	//@Column(name="ch_status")
	private boolean ch_status;
	
	private Clientes clientes;
	
	private Bancos bancos;
	
	
	public Chequera() {
	}

	public Chequera(int idchequera, Date ch_fecha_apertura, double ch_saldo, double ch_abono, String ch_cargo,
			boolean ch_status, Clientes clientes, Bancos bancos) {
		super();
		this.idchequera = idchequera;
		this.ch_fecha_apertura = ch_fecha_apertura;
		this.ch_saldo = ch_saldo;
		this.ch_abono = ch_abono;
		this.ch_cargo = ch_cargo;
		this.ch_status = ch_status;
		this.clientes = clientes;
		this.bancos = bancos;
	}
	
	@Id
	@GeneratedValue
	public int getIdchequera() {
		return idchequera;
	}

	public void setIdchequera(int idchequera) {
		this.idchequera = idchequera;
	}

	public Date getCh_fecha_apertura() {
		return ch_fecha_apertura;
	}

	public void setCh_fecha_apertura(Date ch_fecha_apertura) {
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

	public String getCh_cargo() {
		return ch_cargo;
	}

	public void setCh_cargo(String ch_cargo) {
		this.ch_cargo = ch_cargo;
	}

	public boolean isCh_status() {
		return ch_status;
	}

	public void setCh_status(boolean ch_status) {
		this.ch_status = ch_status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idclientes")
	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idbancos")
	public Bancos getBancos() {
		return bancos;
	}

	public void setBancos(Bancos bancos) {
		this.bancos = bancos;
	}
	
}
