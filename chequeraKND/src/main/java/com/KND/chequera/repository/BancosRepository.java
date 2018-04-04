package com.KND.chequera.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KND.chequera.entity.Bancos;

@Repository("bancosRepository")
public interface BancosRepository extends JpaRepository<Bancos, Serializable> {
	
	public abstract Bancos findByidbancos(int idBanco);
	public abstract List<Bancos> findAll();

}
