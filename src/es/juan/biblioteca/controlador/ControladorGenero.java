package es.juan.biblioteca.controlador;

import es.juan.biblioteca.modelo.entidad.Genero;
import es.juan.biblioteca.servicio.Servicio;
import es.juan.biblioteca.utilidades.Entrada;
import es.juan.biblioteca.vista.VistaGenero;

public class ControladorGenero {

    private VistaGenero vistaGenero;
    private Servicio servicio;

    public ControladorGenero(Servicio servicio) {
        this.vistaGenero = new VistaGenero();
        this.servicio = servicio;
    }

    public void iniciar() {
        int opcion = -1;

        while (opcion != 0) {
            vistaGenero.mostrarMenu();
            opcion = vistaGenero.pedirOpcion();

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    vistaGenero.mostrarGeneros(servicio.getGeneroDAO().obtenerListado());
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 0:
                    break;
                default:
                    vistaGenero.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void insertar() {
        System.out.println("\n--- INSERTAR GÉNERO ---");
        String nombre = vistaGenero.pedirNombre();
        Genero genero = new Genero(nombre);

        if (servicio.getGeneroDAO().insertar(genero)) {
            vistaGenero.mostrarMensaje("Género insertado correctamente.");
        } else {
            vistaGenero.mostrarMensaje("Error al insertar el género.");
        }
    }

    private void modificar() {
        System.out.println("\n--- MODIFICAR GÉNERO ---");
        int id = vistaGenero.pedirId();
        Genero genero = servicio.getGeneroDAO().obtenerPorId(id);

        if (genero == null) {
            vistaGenero.mostrarMensaje("No se encontró el género con ese ID.");
            return;
        }

        vistaGenero.mostrarGenero(genero);
        String nombre = vistaGenero.pedirNombre();
        if (!nombre.isBlank()) genero.setNombre(nombre);

        if (servicio.getGeneroDAO().actualizar(genero)) {
            vistaGenero.mostrarMensaje("Género actualizado correctamente.");
        } else {
            vistaGenero.mostrarMensaje("Error al actualizar el género.");
        }
    }

    private void eliminar() {
        System.out.println("\n--- ELIMINAR GÉNERO ---");
        int id = vistaGenero.pedirId();
        Genero genero = servicio.getGeneroDAO().obtenerPorId(id);

        if (genero == null) {
            vistaGenero.mostrarMensaje("No se encontró el género con ese ID.");
            return;
        }

        vistaGenero.mostrarGenero(genero);
        String confirmar = Entrada.leerTexto("¿Estás seguro? (s/n): ");

        if (confirmar.equalsIgnoreCase("s")) {
            if (servicio.getGeneroDAO().eliminar(id)) {
                vistaGenero.mostrarMensaje("Género eliminado correctamente.");
            } else {
                vistaGenero.mostrarMensaje("Error al eliminar el género.");
            }
        } else {
            vistaGenero.mostrarMensaje("Operación cancelada.");
        }
    }
}