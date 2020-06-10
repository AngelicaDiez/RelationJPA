package com.it.eng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.eng.dto.LibroDTO;
import com.it.eng.dto.LibroDTO2;
import com.it.eng.entity.Categoria;
import com.it.eng.entity.Libro;
import com.it.eng.entity.LibroKeys;
import com.it.eng.repository.CategoriaRepository;
import com.it.eng.repository.LibroRepository;
import com.it.eng.utils.CustomObjectMapper;

@Service
public class LibroCRUDServiceImpl implements LibroCRUDService{

	@Autowired
	private LibroRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<LibroDTO> findAll() {
		List<Libro> entityList = repository.findAll();
		List<LibroDTO> result = CustomObjectMapper.mapAll(entityList, LibroDTO.class);
		
		return result;
	}

	@Override
	public void add(LibroDTO2 dto) {
		Categoria categoria = categoriaRepository.findById(dto.getId_categoria()).get();
		Libro entity = CustomObjectMapper.map(dto, Libro.class);
		entity.setId_categoria(categoria);
		
		repository.save(entity);
	}

	@Override
	public LibroDTO findById(String titolo, String autore) {
		LibroKeys keys = new LibroKeys(titolo, autore);
		Libro entity = repository.findById(keys).get();
		
		LibroDTO dto = CustomObjectMapper.map(entity, LibroDTO.class);
		
		return dto;
	}

	@Override
	public void update(String titolo, String autore, LibroDTO2 dto) {
		LibroKeys keys = new LibroKeys(titolo, autore);
		Libro entity = repository.findById(keys).get();
		
		entity = CustomObjectMapper.map(dto, Libro.class);
		
		Categoria categoria = categoriaRepository.findById(dto.getId_categoria()).get();
		
		entity.setId_categoria(categoria);
		repository.save(entity);
	}

	@Override
	public void delete(String titolo, String autore) {
		LibroKeys keys = new LibroKeys(titolo, autore);
		Libro entity = repository.findById(keys).get();
		
		repository.delete(entity);
	}
	
	

}
