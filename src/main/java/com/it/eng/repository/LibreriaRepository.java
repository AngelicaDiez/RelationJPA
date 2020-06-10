package com.it.eng.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.eng.entity.Libreria;

@Repository
public interface LibreriaRepository extends JpaRepository<Libreria, Integer>{

	@Transactional
	@Modifying
	@Query(value = "UPDATE libreria SET id_indirizzo = :id_indirizzo, nome = :nome "
			+ "WHERE id = :id", nativeQuery = true)
	void update(@Param("id") int id, @Param("id_indirizzo") int id_indirizzo, 
				@Param("nome") String nome);
}
