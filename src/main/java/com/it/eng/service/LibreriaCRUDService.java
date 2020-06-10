package com.it.eng.service;

import java.util.List;

import com.it.eng.dto.LibreriaDTO;
import com.it.eng.dto.LibreriaDTO2;

public interface LibreriaCRUDService {

	public List<LibreriaDTO> findAll();
	
	public void add(LibreriaDTO2 dto);
	
	public LibreriaDTO findById(int id);
	
	public void update(int id, LibreriaDTO2 dto);
	
	public void delete(int id);
}
