package com.it.eng.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndirizzoDTO2 implements Serializable{

	private String via;
	private int numero;
	
	public String toString() {
		return "[ Via: " + via + ", numero: " + numero + " ]";
	}
}
