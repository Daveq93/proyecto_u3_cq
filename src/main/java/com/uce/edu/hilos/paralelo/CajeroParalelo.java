package com.uce.edu.hilos.paralelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CajeroParalelo {
	private String nombre;
	private List<String> clientes;
}
