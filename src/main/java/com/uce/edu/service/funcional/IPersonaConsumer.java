package com.uce.edu.service.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {

	public void accept(T arg1);
}
