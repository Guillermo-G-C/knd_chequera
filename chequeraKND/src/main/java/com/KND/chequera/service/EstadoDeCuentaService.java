package com.KND.chequera.service;

import java.util.Map;

public interface EstadoDeCuentaService {

	public abstract Map<String, Object> EdoCuentaEnRangoDeFechas(int idChequera, String fechaInicio, String fechaCorte);
	public Map<String, Object> EdoCuentaMensual(int idChequera, String yearMonth);//yearMonth = 2018-01
	public abstract Map<String, Object> EdoCuentaMensual();
	
}
