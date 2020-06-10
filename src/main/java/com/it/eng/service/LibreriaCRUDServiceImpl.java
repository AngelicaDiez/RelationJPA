package com.it.eng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.eng.dto.LibreriaDTO;
import com.it.eng.dto.LibreriaDTO2;
import com.it.eng.entity.Indirizzo;
import com.it.eng.entity.Libreria;
import com.it.eng.repository.IndirizzoRepository;
import com.it.eng.repository.LibreriaRepository;
import com.it.eng.utils.CustomObjectMapper;

@Service
public class LibreriaCRUDServiceImpl implements LibreriaCRUDService{

	@Autowired
	private LibreriaRepository repository;
	
	@Autowired
	private IndirizzoRepository indirizzoRepository;

	@Override
	public List<LibreriaDTO> findAll() {
		List<Libreria> entityList = repository.findAll();
		List<LibreriaDTO> result = CustomObjectMapper.mapAll(entityList, LibreriaDTO.class);
		
		return result;
	}

	@Override
	public void add(LibreriaDTO2 dto) {
		Indirizzo indirizzo = indirizzoRepository.findById(dto.getId_indirizzo()).get();
		Libreria entity = CustomObjectMapper.map(dto, Libreria.class);
		entity.setId_indirizzo(indirizzo);
		
		repository.save(entity);
	}

	@Override
	public LibreriaDTO findById(int id) {
		Libreria entity = repository.findById(id).get();
		LibreriaDTO dto = CustomObjectMapper.map(entity, LibreriaDTO.class);
		
		return dto;
	}

	@Override
	public void update(int id, LibreriaDTO2 dto) {
		repository.update(id, dto.getId_indirizzo(), dto.getNome());
	}

	@Override
	public void delete(int id) {
		LibreriaDTO dto = findById(id);
		
		Libreria entity = CustomObjectMapper.map(dto, Libreria.class);
		repository.delete(entity);
	}

	
}
