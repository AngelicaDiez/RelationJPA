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
public class LibroDTO implements Serializable {

	private String titolo;
	private String autore;
	private String casa_editrice;
	private Date data_pubblicazione;
	private int edizione;
	private CategoriaDTO id_categoria;

	public String toString() {
		return "[ Titolo: " + titolo + ", autore: " + autore + ", casa editrice: " + casa_editrice + ", "
				+ "data pubblicazione: " + data_pubblicazione.toString() + ", edizione: " + edizione
				+ ", id_categoria: " + id_categoria.getId() + ", nome: " + id_categoria.getNome() + " ]";
	}
}
