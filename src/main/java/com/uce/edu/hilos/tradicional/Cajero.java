package com.uce.edu.hilos.tradicional;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cajero {
	
	private String nombre;
	private List<String> clientes;
	
}
