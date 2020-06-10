package com.it.eng.service;

import java.util.List;

import com.it.eng.dto.CategoriaDTO;

public interface CategoriaCRUDService{

	public List<CategoriaDTO> findAll();
	
	public void add(CategoriaDTO categoria);
	
	public CategoriaDTO findById(int id);
	
	public void update(int id, CategoriaDTO categoria);
	
	public void delete(int id);
}
