package com.KND.chequera.service;

import java.util.Map;

public interface EstadoDeCuentaService {

	public abstract Map<String, Object> EdoCuentaEnRangoDeFechas(int idChequera, String fechaInicio, String fechaCorte);
	public abstract Map<String, Object> EdoCuentaMensual();
	
}
