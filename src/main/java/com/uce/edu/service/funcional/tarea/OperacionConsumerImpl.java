package com.uce.edu.service.funcional.tarea;

import org.apache.log4j.Logger;

public class OperacionConsumerImpl implements IOperacionConsumer<Persona>{
	private static Logger LOG = Logger.getLogger(OperacionConsumerImpl.class);
	@Override
	public void aceppt(Persona arg1) {
			LOG.info("Consumer desde clase: "+arg1.toString());
	}

}
