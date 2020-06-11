package com.it.eng.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PossedereDTO implements Serializable{

	private int id;
	private LibreriaDTO id_libreria;
	private LibroDTO libro;
	
	public String toString() {
		return "[ id: " + id + ", id libreria: " + id_libreria.getId() + ", titolo libro: " 
				 + libro.getTitolo() + ", autore: " + libro.getAutore() + " ]";
	}
}
