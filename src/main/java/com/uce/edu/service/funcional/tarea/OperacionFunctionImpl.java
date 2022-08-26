package com.uce.edu.service.funcional.tarea;

public class OperacionFunctionImpl implements IOperacionFunction<PersonaTO, Persona>{

	@Override
	public PersonaTO aplicar(Persona arg1) {
		PersonaTO pTO = new PersonaTO();
		pTO.setNombre(arg1.getNombre());
		pTO.setApellido(arg1.getApellido());
		
		return pTO;
	}



}
