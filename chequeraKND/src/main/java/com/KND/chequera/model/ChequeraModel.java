package com.KND.chequera.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.KND.chequera.entity.Bancos;
import com.KND.chequera.entity.Clientes;
import com.KND.chequera.entity.Movimientos;

public class ChequeraModel {

	private int idchequera;
	private String ch_fecha_apertura;
	private double  ch_saldo;
	private double ch_abono;
	private double ch_cargo;
	private boolean ch_status;
	private Clientes clientes;
	private Bancos bancos;
	private Set<Movimientos> movimientos = new HashSet<>();
	
	public ChequeraModel() {
	}
	
	public ChequeraModel(int idchequera, String ch_fecha_apertura, double ch_saldo, double ch_abono, double ch_cargo,
			boolean ch_status, Clientes clientes, Bancos bancos, Set<Movimientos> movimientos) {
		super();
		this.idchequera = idchequera;
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
