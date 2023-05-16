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
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;

    @Column(name = "nombre_autor")
    private String nombreAutor;

    @Column(name = "apellido_autor")
    private String apellidoAutor;

    @Column(name = "pais_autor")
    private String paisAutor;

    @OneToMany(mappedBy = "autor")
    private Set<Libro> libro;
}
