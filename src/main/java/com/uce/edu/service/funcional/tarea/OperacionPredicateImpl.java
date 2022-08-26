package com.uce.edu.service.funcional.tarea;

public class OperacionPredicateImpl implements IOperacionPredicate<Persona> {

	@Override
	public boolean evaluate(Persona arg1) {
		boolean flag = false;
		if(arg1.getNombre().equalsIgnoreCase("Ana") && arg1.getEdad()>=15) {
			flag= true;
		}
		return flag;
	}

}
