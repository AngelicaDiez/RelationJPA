package com.it.eng.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(LibroKeys.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

	@Id
	private String titolo;

	@Id
	private String autore;

	private String casa_editrice;
	private Date data_pubblicazione;
	private int edizione;

	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id")
	private Categoria id_categoria;
	
}
