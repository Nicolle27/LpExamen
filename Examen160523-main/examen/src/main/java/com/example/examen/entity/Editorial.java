package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEditorial;

    @Column(name = "nombre_editorial")
    private String nombreEditorial;

    @Column(name = "pais_editorial")
    private String paisEditorial;

    @OneToMany(mappedBy = "editorial")
    private Set<Libro> libro;
}
