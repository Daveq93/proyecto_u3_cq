package com.uce.edu.service.funcional;

@FunctionalInterface //no necesario pero es buena practica, para mostrar que es funcional
public interface IPersonaSupplier <T> {
	public T getNombre (); //para supplier debo utilizar el get
}
