package com.it.eng.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libreria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libreria {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id_indirizzo", referencedColumnName = "id")
	private Indirizzo id_indirizzo;
	
	private String nome;
}
