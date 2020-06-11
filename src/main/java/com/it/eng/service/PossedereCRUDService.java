package com.it.eng.service;

import java.util.List;

import com.it.eng.dto.PossedereDTO;
import com.it.eng.dto.PossedereDTO2;

public interface PossedereCRUDService {

	public List<PossedereDTO> findAll();
	
	public void add(PossedereDTO2 dto);
	
	public PossedereDTO findById(int id);
	
	public void update(int id, PossedereDTO2 dto);
	
	public void delete(int id);
}
