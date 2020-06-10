package com.it.eng.service;

import java.util.List;

import com.it.eng.dto.IndirizzoDTO2;

public interface IndirizzoCRUDService {

	public List<IndirizzoDTO2> findAll();
	
	public void add(IndirizzoDTO2 indirizzo);
	
	public IndirizzoDTO2 findByVia(String via);
	
	public void update(String via, IndirizzoDTO2 indirizzo);
	
	public void delete(String via);
}
