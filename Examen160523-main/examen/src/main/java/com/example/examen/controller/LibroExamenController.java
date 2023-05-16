package com.example.examen.controller;

import com.example.examen.dto.LibroRequest;
import com.example.examen.entity.Autor;
import com.example.examen.entity.Editorial;
import com.example.examen.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.example.examen.repository.AutorRepository;
import com.example.examen.repository.EditorialRepository;
import com.example.examen.repository.LibroRepository;

import java.util.List;

@Controller
public class LibroExamenController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private LibroRepository libroRepository;

    @QueryMapping
    public List<Libro> listarLibro() {
        return libroRepository.findAll();
    }

    @QueryMapping
    public List<Editorial> listarEditorial() {
        return editorialRepository.findAll();
    }

    @QueryMapping
    public List<Autor> listarAutor() {
        return autorRepository.findAll();
    }
    @QueryMapping
    public Libro listarLibroPorId(@Argument int id) {
        return libroRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public Editorial listarEditorialPorId(@Argument int id) {
        return editorialRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public Autor listarAutorPorId(@Argument int id) {
        return autorRepository.findById(id).orElse(null);


}
    @MutationMapping
    public Libro guardarLibro(@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autor()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorial()).orElse(null);
        Libro libroBD = new Libro();

        libroBD.setTituloLibro(libroRequest.tituloLibro());
        libroBD.setDescripcionLibro(libroRequest.descripcionLibro());
        libroBD.setPaginaLibro(libroRequest.paginaLibro());
        libroBD.setEdicionLibro(libroRequest.edicionLibro());
        libroBD.setAutor(autor);
        libroBD.setEditorial(editorial);

        return libroRepository.save(libroBD);
    }

    @MutationMapping
    public Libro actualizarLibro(@Argument int id ,@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autor()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorial()).orElse(null);
        Libro libroBD = new Libro();

        libroBD.setTituloLibro(libroRequest.tituloLibro());
        libroBD.setDescripcionLibro(libroRequest.descripcionLibro());
        libroBD.setPaginaLibro(libroRequest.paginaLibro());
        libroBD.setEdicionLibro(libroRequest.edicionLibro());
        libroBD.setAutor(autor);
        libroBD.setEditorial(editorial);

        return libroRepository.save(libroBD);
    }

    @MutationMapping
    public void eliminarLibro(@Argument int id) {
        libroRepository.deleteById(id);
    }
}