package com.uce.edu.service.funcional.tarea;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class MainInterfaces {
	private static Logger LOG = Logger.getLogger(MainInterfaces.class);
	
	public static void main(String[] args) {
		ConsumoMetodosHO consumoHO = new ConsumoMetodosHO();
		
		//SUPPLIER
		System.out.println("------------------------ SUPPLIER ----------------------");
		    //clase
		IOperacionSupplier<String> suplierClase = new OperacionSupplierImpl();
		   LOG.info("Ejecuntando supplier clase desde main: "+suplierClase.devuelveDato());
		   
		    //lambda
		   IOperacionSupplier<String> supplierLambda = () -> "Ejecutando lambda Supplier";
		   LOG.info(supplierLambda.devuelveDato());
		    //HighOrder
		   		   LOG.info(consumoHO.consumirSupplier(()->"Cosumiendo Supplier HighOreder"));
		   		   LOG.info(consumoHO.consumirSupplier(()->{
		   			   Persona per = new Persona();
		   			   per.setApellido("Probando ");
		   			   per.setNombre(" HO ");
		   			   return "Supplier --HO->> "+ per.getNombre().concat(per.getApellido());
		   		   }));
		
		//CONSUMER
		   		System.out.println("------------------------ CONSUMER ----------------------");
	       //clase
		   Persona p = new Persona();
			p.setNombre("Ana");
			p.setApellido("Morales");
			p.setEdad(15);	   
		   IOperacionConsumer<Persona> consumerClase = new OperacionConsumerImpl();
		   consumerClase.aceppt(p);
		   
		   //lambda
		   Persona p2 = new Persona();
			p2.setNombre("Kevin");
			p2.setApellido("Riuz");
			p2.setEdad(25);
		   IOperacionConsumer<Persona> consumerLambda = persona-> LOG.info("Consumer con lambda: "+persona);
		   consumerLambda.aceppt(p2);
	       //HighOrder
             consumoHO.consumirConsumer(persona->LOG.info(persona), p);	       
		
		
		//PREDICATE
             System.out.println("------------------------ PREDICATE ----------------------");
	       //clase
		   IOperacionPredicate<Persona> predicateClase = new OperacionPredicateImpl();
		   LOG.info("Predicate clase :"+predicateClase.evaluate(p));
		   LOG.info("Predicate clase :"+predicateClase.evaluate(p2));
	       //lambda
		   IOperacionPredicate<Persona> predicateLambda = persona -> (persona.getNombre().equalsIgnoreCase("ANA") && persona.getEdad()>=15);
		   LOG.info("Predicate Lambda "+predicateLambda.evaluate(p));
		   LOG.info("Predicate Lambda "+predicateLambda.evaluate(p2));
	       //HighOrder
		   LOG.info(consumoHO.consumirPredicate(pers->(pers.getNombre().equalsIgnoreCase("ANA")&&pers.getEdad()>=15), p));
	      LOG.info(consumoHO.consumirPredicate(pers->(pers.getNombre().equalsIgnoreCase("ANA")&&pers.getEdad()>=15), p2));
	      
		
		
		//FUNCTION
		   System.out.println("------------------------ FUNCTION ----------------------");
	       //clase
		   IOperacionFunction<PersonaTO, Persona> functionClase = new OperacionFunctionImpl();
		   LOG.info("Function clase: "+functionClase.aplicar(p2));
		   LOG.info("Function clase: "+functionClase.aplicar(p));
		   
	       //lambda
		   IOperacionFunction<PersonaTO, Persona> functionLambda = persona-> {
			   PersonaTO per = new PersonaTO();
			   per.setNombre(persona.getNombre());
			   per.setApellido(persona.getApellido());
			   return per;
		   };
		   
		   LOG.info("Function Lambda: "+functionLambda.aplicar(p));
		   LOG.info("Function Lambda: "+functionLambda.aplicar(p2));
		   
	       //HighOrder
	      		LOG.info(consumoHO.consumirFunction(persona->{
	      			PersonaTO per = new PersonaTO();
	      			per.setNombre(persona.getNombre());
	      			per.setApellido(persona.getApellido());
	      			
	      			return per;
	      		},p2));
		
		//UNARY OPERATOR
		   System.out.println("------------------------ UNARY OPERATOR ----------------------");
	       //clase
		   IOperacionUnaryOperator<String>  unaryOperatorClase = new OperacionUnaryOperatorImpl();
		   LOG.info(unaryOperatorClase.aplicar(p.toString()));
	       //lambda
		   IOperacionUnaryOperator<PersonaTO> uOLambda = pers -> pers;
		   LOG.info("Unary Operator lambda "+uOLambda.aplicar(functionLambda.aplicar(p2)));
		   
	       //HighOrder
	       LOG.info("Consumiendo UnaryO HO"+consumoHO.consumirUnaryOperator(persona -> persona , functionLambda.aplicar(p2)));
	          
	}
	
}
