package es.juan.biblioteca.controlador;

import es.juan.biblioteca.modelo.entidad.Editorial;
import es.juan.biblioteca.modelo.entidad.Genero;
import es.juan.biblioteca.modelo.entidad.Libro;
import es.juan.biblioteca.servicio.Servicio;
import es.juan.biblioteca.utilidades.Entrada;
import es.juan.biblioteca.vista.VistaLibro;

public class ControladorLibro {

    private VistaLibro vistaLibro;
    private Servicio servicio;

    public ControladorLibro(Servicio servicio) {
        this.vistaLibro = new VistaLibro();
        this.servicio = servicio;
    }

    public void iniciar() {
        int opcion = -1;

        while (opcion != 0) {
            vistaLibro.mostrarMenu();
            opcion = vistaLibro.pedirOpcion();

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    vistaLibro.mostrarLibros(servicio.obtenerLibros());
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
                    vistaLibro.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void insertar() {
        System.out.println("\n--- INSERTAR LIBRO ---");

        String isbn = Entrada.leerTexto("ISBN: ");
        String titulo = Entrada.leerTexto("Título: ");
        int anio = Entrada.leerEntero("Año de publicación: ");
        double precio = Entrada.leerDecimal("Precio: ");
        String sinopsis = Entrada.leerTexto("Sinopsis: ");
        String portadaURL = Entrada.leerTexto("URL portada (intro para omitir): ");
        String encuadernacion = Entrada.leerTexto("Encuadernación (Tapa Blanda/Tapa dura): ");
        int paginas = Entrada.leerEntero("Número de páginas: ");
        int idGenero = Entrada.leerEntero("ID Género: ");
        int idEditorial = Entrada.leerEntero("ID Editorial: ");

        Genero genero = new Genero(idGenero, "");
        Editorial editorial = new Editorial(idEditorial, "", "", "");

        Libro libro = new Libro(isbn, titulo, anio, precio, sinopsis,
                portadaURL, encuadernacion, paginas, genero, editorial);

        if (servicio.getLibroDAO().insertar(libro)) {
            vistaLibro.mostrarMensaje("Libro insertado correctamente.");
        } else {
            vistaLibro.mostrarMensaje("Error al insertar el libro.");
        }
    }

    private void modificar() {
        System.out.println("\n--- MODIFICAR LIBRO ---");

        int id = vistaLibro.pedirId();
        Libro libro = servicio.getLibroDAO().obtenerPorId(id);

        if (libro == null) {
            vistaLibro.mostrarMensaje("No se encontró el libro con ese ID.");
            return;
        }

        vistaLibro.mostrarLibro(libro);
        System.out.println("\nIntroduce los nuevos datos (intro para mantener el valor actual):");

        String isbn = Entrada.leerTexto("ISBN (" + libro.getIsbn() + "): ");
        if (!isbn.isBlank()) libro.setIsbn(isbn);

        String titulo = Entrada.leerTexto("Título (" + libro.getTitulo() + "): ");
        if (!titulo.isBlank()) libro.setTitulo(titulo);

        String anio = Entrada.leerTexto("Año (" + libro.getFechaPublicacion() + "): ");
        if (!anio.isBlank()) libro.setFechaPublicacion(Integer.parseInt(anio));

        String precio = Entrada.leerTexto("Precio (" + libro.getPrecio() + "): ");
        if (!precio.isBlank()) libro.setPrecio(Double.parseDouble(precio));

        String paginas = Entrada.leerTexto("Páginas (" + libro.getNumeroPaginas() + "): ");
        if (!paginas.isBlank()) libro.setNumeroPaginas(Integer.parseInt(paginas));

        String encuadernacion = Entrada.leerTexto("Encuadernación (" + libro.getEncuadernacion() + "): ");
        if (!encuadernacion.isBlank()) libro.setEncuadernacion(encuadernacion);

        if (servicio.getLibroDAO().actualizar(libro)) {
            vistaLibro.mostrarMensaje("Libro actualizado correctamente.");
        } else {
            vistaLibro.mostrarMensaje("Error al actualizar el libro.");
        }
    }

    private void eliminar() {
        System.out.println("\n--- ELIMINAR LIBRO ---");

        int id = vistaLibro.pedirId();
        Libro libro = servicio.getLibroDAO().obtenerPorId(id);

        if (libro == null) {
            vistaLibro.mostrarMensaje("No se encontró el libro con ese ID.");
            return;
        }

        vistaLibro.mostrarLibro(libro);
        String confirmar = Entrada.leerTexto("¿Estás seguro? (s/n): ");

        if (confirmar.equalsIgnoreCase("s")) {
            if (servicio.getLibroDAO().eliminar(id)) {
                vistaLibro.mostrarMensaje("Libro eliminado correctamente.");
            } else {
                vistaLibro.mostrarMensaje("Error al eliminar el libro.");
            }
        } else {
            vistaLibro.mostrarMensaje("Operación cancelada.");
        }
    }
}