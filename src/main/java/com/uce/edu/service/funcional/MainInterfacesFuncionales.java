package com.uce.edu.service.funcional;

import org.apache.log4j.Logger;


public class MainInterfacesFuncionales {
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] argas) {
		
		//SUPLIER
		//clases 
		
		IPersonaSupplier<String> supplier= new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+supplier.getNombre());
		//lambdas
		IPersonaSupplier<String> supplierLambda = ()->"David 2";
		LOG.info("Supplier lambda "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambda2 = ()->"David 3";
		LOG.info("Supplier lambda "+supplierLambda2.getNombre());
		
		//CONSUMER
		//clases 
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba consumer");
		
		//lambda
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena); 
		consumerLambda.accept("Prueba consumer lamba");
		//PREDICATE
		
		
		//FUNCTION
		
		
		//UNARYOPERATOR
		
		
		
		
	}
	
}
