package com.example.examen.repository;

import com.example.examen.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
}
