package cl.sentra.micronaut.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.sentra.micronaut.crud.model.LibroBO;

@Singleton
public class LibroBean {
	
	private List<LibroBO> libreria = new ArrayList<>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LibroBO.class);	
	
	public LibroBO add(LibroBO libro) {        
        List<LibroBO> list = libreria.stream().filter(a -> a.resumen().equals(libro.resumen())).collect(Collectors.toList());
        if (list.size()==0){
        	libro.setId((long) (libreria.size() + 1));
        	LOGGER.info("Nuevo Libro: {}", libro.resumen());
        	libreria.add(libro);
        	return libro;
        }
        else{
        	LOGGER.info("Ya Existe Libro: {}", libro.resumen());
        	return list.get(0);
        }
    }

    public LibroBO findById(Long id) {
        Optional<LibroBO> libro = libreria.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (libro.isPresent())
            return libro.get();
        else
            return null;
    }

    public List<LibroBO> findAll() {
        return libreria;
    }

    public List<LibroBO> findByAuthor(String autor) {
        return libreria.stream().filter(a -> a.getAutor().toLowerCase().trim().equals(autor.toLowerCase().trim())).collect(Collectors.toList());
    }

    public List<LibroBO> findByCategory(String categoria) {
        return libreria.stream().filter(a -> a.getCategoria().toLowerCase().trim().equals(categoria.toLowerCase().trim())).collect(Collectors.toList());
    }


}