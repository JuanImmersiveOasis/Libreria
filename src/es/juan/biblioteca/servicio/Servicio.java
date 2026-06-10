package es.juan.biblioteca.servicio;

import java.util.List;

import es.juan.biblioteca.modelo.dao.LibroDAO;
import es.juan.biblioteca.modelo.dao.GeneroDAO;

import es.juan.biblioteca.modelo.entidad.Libro;
import es.juan.biblioteca.modelo.entidad.Genero;


public class Servicio {

    private LibroDAO libroDAO;
    private GeneroDAO generoDAO;

    public Servicio() {
        this.libroDAO = new LibroDAO();
        this.generoDAO = new GeneroDAO();
    }

    public LibroDAO getLibroDAO() {return libroDAO;};
    public GeneroDAO getGeneroDAO() {return generoDAO;}
    
    public List<Libro> obtenerLibros() {
        return libroDAO.obtenerListado();
    }
}

   