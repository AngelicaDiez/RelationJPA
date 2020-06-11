package com.it.eng.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Possedere {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_libreria", referencedColumnName = "id")
	private Libreria id_libreria;
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "titolo_libro", referencedColumnName = "titolo"),
			@JoinColumn(name = "autore_libro", referencedColumnName = "autore")
	})
	private Libro libro;
}
