package com.example.examen.dto;

public record LibroRequest(
        Integer idLibro,
        String tituloLibro,
        String descripcionLibro,
        Integer paginaLibro,
        String edicionLibro,
        Integer autor,
        Integer editorial
) {

}
