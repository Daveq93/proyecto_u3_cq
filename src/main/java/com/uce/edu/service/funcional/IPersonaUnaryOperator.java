package com.uce.edu.service.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {

	T apply(T arg1);
}
