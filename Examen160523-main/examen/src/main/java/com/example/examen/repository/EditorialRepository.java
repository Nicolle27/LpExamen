package com.example.examen.repository;

import com.example.examen.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{
}
