package es.juan.biblioteca.vista;

import java.util.List;

import es.juan.biblioteca.modelo.dao.LibroDAO;
import es.juan.biblioteca.modelo.entidad.Libro;
import es.juan.biblioteca.servicio.*;

public class Servicio {

    private LibroDAO libroDAO;

    public Servicio() {
        this.libroDAO = new LibroDAO();
    }

    public List<Libro> obtenerLibros() {
        return libroDAO.obtenerListado();
    }

    public Libro obtenerLibroPorId(int id) {
        return libroDAO.obtenerPorId(id);
    }

    public boolean insertarLibro(Libro libro) {
        return libroDAO.insertar(libro);
    }

    public boolean actualizarLibro(Libro libro) {
        return libroDAO.actualizar(libro);
    }

    public boolean eliminarLibro(int id) {
        return libroDAO.eliminar(id);
    }
}