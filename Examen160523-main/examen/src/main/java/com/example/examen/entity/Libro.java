package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idlibro;

    @Column(name = "titulo_libro")
    private String tituloLibro;

    @Column(name = "descripcion_libro")
    private String descripcionLibro;

    @Column(name = "pagina_libro")
    private int paginaLibro;

    @Column(name = "edicion_libro")
    private String edicionLibro;

    @ManyToOne
    @JoinColumn(name="ida", nullable=false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="ide", nullable=false)
    private Editorial editorial;
}
