package com.it.eng.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO2 implements Serializable{

	private String titolo;
	private String autore;
	private String casa_editrice;
	private Date data_pubblicazione;
	private int edizione;
	private int id_categoria;
}
