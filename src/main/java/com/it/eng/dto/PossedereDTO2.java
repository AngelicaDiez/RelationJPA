package com.it.eng.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PossedereDTO2 implements Serializable{

	private int id_libreria;
	private String titolo_libro;
	private String autore_libro;
}
