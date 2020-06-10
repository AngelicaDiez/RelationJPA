package com.it.eng.service;

import java.util.List;

import com.it.eng.dto.LibroDTO;
import com.it.eng.dto.LibroDTO2;

public interface LibroCRUDService {

	public List<LibroDTO> findAll();
	
	public void add(LibroDTO2 dto);
	
	public LibroDTO findById(String titolo, String autore);
	
	public void update(String titolo, String autore, LibroDTO2 dto);
	
	public void delete(String titolo, String autore);
}
