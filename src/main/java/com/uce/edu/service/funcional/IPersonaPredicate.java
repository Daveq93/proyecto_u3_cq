package com.uce.edu.service.funcional;

@FunctionalInterface
public interface IPersonaPredicate <T> {

	public boolean evaluate(T arg1);
}
