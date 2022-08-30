package com.uce.edu.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

		// JAVA
		Stream<String> test = Stream.generate(() -> "David").limit(2);
		LOG.info("JAVA SUPPLIER");
		test.forEach(System.out::println);

		// CONSUMER
		// clases
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba consumer");

		// lambda
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba consumer lamba");

		// METODOS HIGHORDER
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
		// JAVA
		List<Integer> listaNumeros = Arrays.asList(1, 2, 13, 4, 5, 16, 70, 18, 9);
		LOG.info("JAVA CONSUMER");
		listaNumeros.forEach(System.out::println);

		// PREDICATe
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("z");
		LOG.info("Predica lamda: " + predicateLambda.evaluate("Quizhpe"));

		// METODOS HIGHORDER

		boolean respuestaPredicate = metodosHO.consumirPredicate(cadena -> cadena.contains("z"), "Quizhpe");
		LOG.info("Predicate respuesta: " + respuestaPredicate);

		// JAVA
		LOG.info("PREDICATE JAVA");
		listaNumeros.stream().filter(numero -> numero > 15).forEach(System.out::println);

		listaNumeros.stream().sorted((x, y) -> x.compareTo(y)).forEach(System.out::println);
		
		
		// FUNCTION

		IPersonaFunction<Integer, String> functionLambda = cadena -> (Integer.valueOf(cadena) - 2);
		LOG.info("Function lambda: " + functionLambda.aplicar("7"));

		// METODOS HIGHORDER
		String valorFinal = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + " A";
			return retorno;
		}, 21);
		LOG.info("Respuesta Function " + valorFinal);
		
		//JAVA
		LOG.info("FUNCTION JAVA");
		//RECOMENDACION TRABAJARR CON STREAM PORQUE ES MAS EFICIENTE
		  listaNumeros.stream().map(numero -> "num: "+String.valueOf(numero)).toList().forEach(System.out::println);
          
		  
		// UNARYOPERATOR

		IPersonaUnaryOperator<String> unaryOperatorLambda = cadena -> cadena.concat("Unary");
		LOG.info("Unary operator Lmabda: " + unaryOperatorLambda.apply("Prueba "));

		// METODOS HIGHORDER

	}

}
