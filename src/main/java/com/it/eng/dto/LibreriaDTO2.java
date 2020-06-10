package com.it.eng.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibreriaDTO2 implements Serializable{
	
	private int id_indirizzo;
	private String nome;
	
}
