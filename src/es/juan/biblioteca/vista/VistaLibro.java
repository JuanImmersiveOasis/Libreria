package es.juan.biblioteca.vista;

import java.util.List;

import es.juan.biblioteca.utilidades.Entrada;
import es.juan.biblioteca.modelo.entidad.Libro;

public class VistaLibro {

    public VistaLibro() {
        super();
    }

    public void mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE LIBROS ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("0. Salir");
    }

    public int pedirOpcion() {
        return Entrada.leerEntero("Elige una opción: ");
    }

    public void mostrarLibros(List<Libro> libros) {
        System.out.println("\n--- LISTADO DE LIBROS ---");
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public void mostrarLibro(Libro libro) {
        if (libro != null) {
            System.out.println("\n--- DETALLE DEL LIBRO ---");
            System.out.println("ID:           " + libro.getIdLibro());
            System.out.println("ISBN:         " + libro.getIsbn());
            System.out.println("Título:       " + libro.getTitulo());
            System.out.println("Año:          " + libro.getFechaPublicacion());
            System.out.println("Precio:       " + libro.getPrecio());
            System.out.println("Páginas:      " + libro.getNumeroPaginas());
            System.out.println("Encuad.:      " + libro.getEncuadernacion());
            System.out.println("Género:       " + libro.getGenero().getNombre());
            System.out.println("Editorial:    " + libro.getEditorial().getNombre());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public int pedirId() {
        return Entrada.leerEntero("Introduce el ID del libro: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}