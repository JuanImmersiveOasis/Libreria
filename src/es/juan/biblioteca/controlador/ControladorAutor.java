package es.juan.biblioteca.controlador;

import es.juan.biblioteca.modelo.entidad.Autor;
import es.juan.biblioteca.servicio.Servicio;
import es.juan.biblioteca.vista.VistaAutor;

public class ControladorAutor {

    private Servicio servicio;
    private VistaAutor vista;

    public ControladorAutor(Servicio servicio) {
        this.servicio = servicio;
        this.vista = new VistaAutor();
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.pedirOpcion();
            switch (opcion) {
                case 1 -> insertar();
                case 2 -> listar();
                case 3 -> modificar();
                case 4 -> eliminar();
                case 0 -> vista.mostrarMensaje("Volviendo...");
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void insertar() {
        Autor autor = vista.pedirDatosAutor();
        boolean ok = servicio.getAutorDAO().insertar(autor);
        vista.mostrarMensaje(ok ? "Autor insertado." : "Error al insertar.");
    }

    private void listar() {
        vista.mostrarAutores(servicio.getAutorDAO().listarTodos());
    }

    private void modificar() {
        int id = vista.pedirId();
        Autor autor = servicio.getAutorDAO().buscarPorId(id);
        if (autor == null) {
            vista.mostrarMensaje("Autor no encontrado.");
            return;
        }
        vista.mostrarMensaje("Datos actuales: " + autor);
        Autor nuevo = vista.pedirDatosAutor();
        nuevo.setIdAutor(id);
        boolean ok = servicio.getAutorDAO().modificar(nuevo);
        vista.mostrarMensaje(ok ? "Autor modificado." : "Error al modificar.");
    }

    private void eliminar() {
        int id = vista.pedirId();
        boolean ok = servicio.getAutorDAO().eliminar(id);
        vista.mostrarMensaje(ok ? "Autor eliminado." : "Error al eliminar.");
    }
}