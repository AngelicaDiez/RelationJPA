package com.it.eng.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Indirizzo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String via;
	private int numero;
}
