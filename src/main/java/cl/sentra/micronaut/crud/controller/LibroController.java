package cl.sentra.micronaut.crud.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.sentra.micronaut.crud.model.LibroBO;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;

@Controller("/")
public class LibroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibroController.class);

    @Inject
    LibroBean libreria;

    @Get("/status")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Post
    public LibroBO add(@Body LibroBO libro) {
        LOGGER.info("Agrego Libro: {}", libro);
        return libreria.add(libro);
    }

    @Get("/{id}")
    public LibroBO findById(Long id) {
        LOGGER.info("Busco Libro por : id={}", id);
        return libreria.findById(id);
    }

    @Get("/")
    public List<LibroBO> findAll() {
        LOGGER.info("Obtengo todos los Libros");
        return libreria.findAll();
    }

    @Get("/autor/{author}")
    @ContinueSpan
    public List<LibroBO> findByAuthor(@SpanTag("author") String author) {
        LOGGER.info("Busco el libro por autor={}", author);
        return libreria.findByAuthor(author);
    }

    @Get("/categoria/{category}")
    @ContinueSpan
    public List<LibroBO> findByCategory(@SpanTag("category") String category) {
        LOGGER.info("Busco el libro por categoria={}", category);
        return libreria.findByCategory(category);
    }

}