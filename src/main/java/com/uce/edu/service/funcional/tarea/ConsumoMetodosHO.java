package com.uce.edu.service.funcional.tarea;

public class ConsumoMetodosHO {

	
	public String consumirSupplier(IOperacionSupplier<String> funcion) {
		return funcion.devuelveDato();
	}
	
	
	public void consumirConsumer(IOperacionConsumer<Persona> funcion,Persona persona) {
		funcion.aceppt(persona);
	}
	
	
	public boolean consumirPredicate(IOperacionPredicate<Persona> funcion, Persona persona) {
		return funcion.evaluate(persona);
	}
	
	
	public PersonaTO consumirFunction(IOperacionFunction<PersonaTO, Persona> funcion,Persona persona) {
		return funcion.aplicar(persona);
	}
	
	public PersonaTO consumirUnaryOperator(IOperacionUnaryOperator<PersonaTO> funcion, PersonaTO personaTO) {
		return funcion.aplicar(personaTO);
	}
}
