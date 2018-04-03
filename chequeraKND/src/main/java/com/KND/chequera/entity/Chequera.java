package com.KND.chequera.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="chequera")
public class Chequera {

	@Id
	@GeneratedValue
	@Column(name="Idchequera")
	private int Idchequera;
	@Column(name="ch_fecha_apertura")
	private Date ch_fecha_apertura;
	@Column(name="ch_saldo")
	private double  ch_saldo;
	@Column(name="ch_abono")
	private double ch_abono;
	@Column(name="ch_cargo")
	private String ch_cargo;
	@Column(name="ch_status")
	private boolean ch_status;
	
	
	
	public Chequera() {
	}



	public Chequera(int idchequera, Date ch_fecha_apertura, double ch_saldo, double ch_abono, String ch_cargo,
			boolean ch_status) {
		super();
		Idchequera = idchequera;
		this.ch_fecha_apertura = ch_fecha_apertura;
		this.ch_saldo = ch_saldo;
		this.ch_abono = ch_abono;
		this.ch_cargo = ch_cargo;
		this.ch_status = ch_status;
	}



	public int getIdchequera() {
		return Idchequera;
	}



	public void setIdchequera(int idchequera) {
		Idchequera = idchequera;
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
	
	
	
	
}
