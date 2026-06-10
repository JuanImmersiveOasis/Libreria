package es.juan.biblioteca.controlador;

import es.juan.biblioteca.servicio.Servicio;
import es.juan.biblioteca.vista.VistaPrincipal;

public class ControladorPrincipal {

    private VistaPrincipal vistaPrincipal;
    private Servicio servicio;

    public ControladorPrincipal(VistaPrincipal vistaPrincipal, Servicio servicio) {
        this.vistaPrincipal = vistaPrincipal;
        this.servicio = servicio;
    }

    public void iniciar() {
        int opcion = -1;

        while (opcion != 0) {
            vistaPrincipal.mostrarMenu();
            opcion = vistaPrincipal.pedirOpcion();

            switch (opcion) {
                case 1:
                    ControladorLibro controladorLibro =
                            new ControladorLibro(servicio);
                    controladorLibro.iniciar();
                    break;
                case 2:
                    System.out.println("Autores - pendiente de implementar");
                    break;
                case 3:
                    ControladorGenero controladorGenero =
                    		new ControladorGenero(servicio);
                    controladorGenero.iniciar();
                    break;
                case 4:
                    System.out.println("Editoriales - pendiente de implementar");
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}