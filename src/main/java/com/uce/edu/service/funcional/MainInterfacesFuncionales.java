package com.uce.edu.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] argas) {
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		// SUPLIER
		// clases

		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());
		// lambdas
		IPersonaSupplier<String> supplierLambda = () -> "David 2";
		LOG.info("Supplier lambda " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambda2 = () -> "David 3";
		LOG.info("Supplier lambda " + supplierLambda2.getNombre());

		// METODOS HIGHORDER
		String respSupplier = metodosHO.consumirSupplier(() -> "Suppier Hello World ");
		LOG.info(respSupplier);

		String respSupplier2 = metodosHO.consumirSupplier(() -> {
			String cedula = "cedula ";
			String valorConsultado = "1111111111";
			return cedula.concat(valorConsultado);
		});
		LOG.info(respSupplier2);
		
		   //JAVA
		     

		// CONSUMER
		// clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba consumer");

		// lambda
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba consumer lamba");

		// METODOS HIGHORDER
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// PREDICATE

		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("z");
		LOG.info("Predica lamda: " + predicateLambda.evaluate("Quizhpe"));

		    // METODOS HIGHORDER

		boolean respuestaPredicate = metodosHO.consumirPredicate(cadena -> cadena.contains("z"), "Quizhpe");
		LOG.info("Predicate respuesta: " + respuestaPredicate);

		// FUNCTION

		IPersonaFunction<Integer, String> functionLambda = cadena -> (Integer.valueOf(cadena) - 2);
		LOG.info("Function lambda: " + functionLambda.aplicar("7"));

		    // METODOS HIGHORDER
		String valorFinal = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + " A";
			return retorno;
		}, 21);
		LOG.info("Respuesta Function " + valorFinal);

		// UNARYOPERATOR

		IPersonaUnaryOperator<String> unaryOperatorLambda = cadena -> cadena.concat("Unary");
		LOG.info("Unary operator Lmabda: " + unaryOperatorLambda.apply("Prueba "));

		
		 // METODOS HIGHORDER
		
		
	}

}
