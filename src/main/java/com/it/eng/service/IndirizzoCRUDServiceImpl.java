package com.it.eng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.eng.dto.IndirizzoDTO2;
import com.it.eng.dto.IndirizzoDTO;
import com.it.eng.entity.Indirizzo;
import com.it.eng.repository.IndirizzoRepository;
import com.it.eng.utils.CustomObjectMapper;

@Service
public class IndirizzoCRUDServiceImpl implements IndirizzoCRUDService{
	
	@Autowired
	private IndirizzoRepository repository;

	@Override
	public List<IndirizzoDTO2> findAll() {
		List<Indirizzo> resultList = repository.findAll();
		List<IndirizzoDTO2> indirizzi = CustomObjectMapper.mapAll(resultList, IndirizzoDTO2.class);
		
		return indirizzi;
	}

	@Override
	public void add(IndirizzoDTO2 indirizzo) {
		Indirizzo entity = CustomObjectMapper.map(indirizzo, Indirizzo.class);
		repository.save(entity);
	}

	@Override
	public IndirizzoDTO2 findByVia(String via) {
		Indirizzo entity = repository.findByVia(via);
		IndirizzoDTO result = CustomObjectMapper.map(entity, IndirizzoDTO.class);
		IndirizzoDTO2 dto = new IndirizzoDTO2(result.getVia(), result.getNumero());
		
		return dto;
	}

	@Override
	public void update(String via, IndirizzoDTO2 indirizzo) {
		Indirizzo entity = repository.findByVia(via);
		IndirizzoDTO dto = new IndirizzoDTO(entity.getId(), indirizzo.getVia(), indirizzo.getNumero());
		entity = CustomObjectMapper.map(dto, Indirizzo.class);
		repository.save(entity);
	}

	@Override
	public void delete(String via) {
		IndirizzoDTO2 result = findByVia(via);
		IndirizzoDTO dto = new IndirizzoDTO(repository.findIDByVia(via), result.getVia(), result.getNumero());
		Indirizzo entity = CustomObjectMapper.map(dto, Indirizzo.class);
		repository.delete(entity);
	}

}
