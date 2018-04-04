package com.KND.chequera.model;

import java.util.Date;

public class ChequeraModel {

	private int idchequera;
	private Date ch_fecha_apertura;
	private double  ch_saldo;
	private double ch_abono;
	private String ch_cargo;
	private boolean ch_status;
	
	public ChequeraModel() {
	}

	public ChequeraModel(int idchequera, Date ch_fecha_apertura, double ch_saldo, double ch_abono, String ch_cargo,
			boolean ch_status) {
		super();
		this.idchequera = idchequera;
		this.ch_fecha_apertura = ch_fecha_apertura;
		this.ch_saldo = ch_saldo;
		this.ch_abono = ch_abono;
		this.ch_cargo = ch_cargo;
		this.ch_status = ch_status;
	}

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
	
	
	
	
	
}
