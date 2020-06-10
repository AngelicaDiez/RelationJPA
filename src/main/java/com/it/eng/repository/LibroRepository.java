package com.it.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.eng.entity.Libro;
import com.it.eng.entity.LibroKeys;

@Repository
public interface LibroRepository extends JpaRepository<Libro, LibroKeys>{

}
