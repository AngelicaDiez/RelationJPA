package com.it.eng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.eng.dto.PossedereDTO;
import com.it.eng.dto.PossedereDTO2;
import com.it.eng.entity.Libreria;
import com.it.eng.entity.Libro;
import com.it.eng.entity.LibroKeys;
import com.it.eng.entity.Possedere;
import com.it.eng.repository.LibreriaRepository;
import com.it.eng.repository.LibroRepository;
import com.it.eng.repository.PossedereRepository;
import com.it.eng.utils.CustomObjectMapper;

@Service
public class PossedereCRUDServiceImpl implements PossedereCRUDService{
	
	@Autowired
	private PossedereRepository repository;
	
	@Autowired
	private LibreriaRepository libreriaRepository;
	
	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<PossedereDTO> findAll() {
		List<Possedere> entityList = repository.findAll();
		List<PossedereDTO> result = CustomObjectMapper.mapAll(entityList, PossedereDTO.class);
		
		return result;
	}

	@Override
	public void add(PossedereDTO2 dto) {
		Libreria libreria = libreriaRepository.findById(dto.getId_libreria()).get();
		LibroKeys keys = new LibroKeys(dto.getTitolo_libro(), dto.getAutore_libro());
		Libro libro = libroRepository.findById(keys).get();
		
		Possedere entity = CustomObjectMapper.map(dto, Possedere.class);
		entity.setId_libreria(libreria);
		entity.setLibro(libro);
		
		repository.save(entity);
		
	}

	@Override
	public PossedereDTO findById(int id) {
		Possedere entity = repository.findById(id).get();
		PossedereDTO dto = CustomObjectMapper.map(entity, PossedereDTO.class);
		
		return dto;
	}

	@Override
	public void update(int id, PossedereDTO2 dto) {
		Possedere entity = repository.findById(id).get();
		
		Libreria libreria = libreriaRepository.findById(dto.getId_libreria()).get();
		LibroKeys keys = new LibroKeys(dto.getTitolo_libro(), dto.getAutore_libro());
		Libro libro = libroRepository.findById(keys).get();
		
		entity = CustomObjectMapper.map(dto, Possedere.class);
		entity.setId(id);
		entity.setId_libreria(libreria);
		entity.setLibro(libro);
		
		repository.save(entity);
	}

	@Override
	public void delete(int id) {
		Possedere entity = repository.findById(id).get();
		repository.delete(entity);
	}

}
