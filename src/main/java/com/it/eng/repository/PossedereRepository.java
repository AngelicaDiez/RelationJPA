package com.it.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.eng.entity.Possedere;

@Repository
public interface PossedereRepository extends JpaRepository<Possedere, Integer>{

}
