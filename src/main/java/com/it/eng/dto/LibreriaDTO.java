package com.it.eng.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibreriaDTO implements Serializable{
	
	private int id;
	private IndirizzoDTO id_indirizzo;
	private String nome;
	
	public String toString() {
		return "[ Nome: " + nome + ", via: " + id_indirizzo.getVia() + ", numero: " + id_indirizzo.getNumero() + " ]";
	}
}
