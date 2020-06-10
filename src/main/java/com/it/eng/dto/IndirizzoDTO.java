package com.it.eng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndirizzoDTO {
	private int id;
	private String via;
	private int numero;
}
