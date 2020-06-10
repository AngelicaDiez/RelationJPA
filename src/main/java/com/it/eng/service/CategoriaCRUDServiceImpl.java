package com.it.eng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.eng.dto.CategoriaDTO;
import com.it.eng.entity.Categoria;
import com.it.eng.repository.CategoriaRepository;
import com.it.eng.utils.CustomObjectMapper;

@Service
public class CategoriaCRUDServiceImpl implements CategoriaCRUDService{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public List<CategoriaDTO> findAll() {
		List<Categoria> entityList = repository.findAll();
		List<CategoriaDTO> result = CustomObjectMapper.mapAll(entityList, CategoriaDTO.class);
		
		return result;
	}

	@Override
	public void add(CategoriaDTO categoria) {
		Categoria entity = CustomObjectMapper.map(categoria, Categoria.class);
		repository.save(entity);
	}

	@Override
	public CategoriaDTO findById(int id) {
		Categoria entity = repository.findById(id).get();
		CategoriaDTO dto = CustomObjectMapper.map(entity, CategoriaDTO.class);
		
		return dto;
	}

	@Override
	public void update(int id, CategoriaDTO categoria) {
		Categoria entity = repository.findById(id).get();
		entity = CustomObjectMapper.map(categoria, Categoria.class);
		repository.save(entity);
	}

	@Override
	public void delete(int id) {
		Categoria entity = repository.findById(id).get();
		repository.delete(entity);
	}

}
