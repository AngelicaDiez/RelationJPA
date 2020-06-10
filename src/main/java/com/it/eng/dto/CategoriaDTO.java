package com.it.eng.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable {

	private int id;
	private String nome;
	
	public String toString() {
		return "[ id: "+id+", nome: "+nome+" ]";
	}
}
