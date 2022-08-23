package com.uce.edu.service.funcional;

@FunctionalInterface
public interface IPersonaFunction <R,T>{

	R aplicar(T arg1);
}
