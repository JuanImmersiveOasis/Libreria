package es.juan.biblioteca.servicio;

import java.util.List;

import es.juan.biblioteca.modelo.dao.LibroDAO;
import es.juan.biblioteca.modelo.dao.AutorDAO;
import es.juan.biblioteca.modelo.dao.GeneroDAO;

import es.juan.biblioteca.modelo.entidad.Libro;
import es.juan.biblioteca.modelo.entidad.Autor;
import es.juan.biblioteca.modelo.entidad.Genero;


public class Servicio {

    private LibroDAO libroDAO;
    private GeneroDAO generoDAO;
    private AutorDAO autorDAO;

    public Servicio() {
        this.libroDAO = new LibroDAO();
        this.generoDAO = new GeneroDAO();
        this.autorDAO = new AutorDAO();
        
    }

    public LibroDAO getLibroDAO() {return libroDAO;};
    public GeneroDAO getGeneroDAO() {return generoDAO;}
    public AutorDAO getAutorDAO() {return autorDAO;}
    
    
    public List<Libro> obtenerLibros() {
        return libroDAO.obtenerListado();
    }
    
    public List<Autor> obtenerAutor() {
    	return autorDAO.listarTodos();
    }
    
    public List<Genero> obtenerGenero(){
    	return generoDAO.obtenerListado();
    }
}

   