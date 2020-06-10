package com.it.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.eng.entity.Indirizzo;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Integer>{

	@Query(value = "SELECT * FROM indirizzo WHERE via = :via", nativeQuery = true)
	Indirizzo findByVia(@Param("via") String via);
	
	@Query(value = "SELECT id FROM indirizzo WHERE via = :via", nativeQuery = true)
	int findIDByVia(@Param("via") String via);
}
