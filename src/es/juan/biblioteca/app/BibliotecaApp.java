package es.juan.biblioteca.app;

import es.juan.biblioteca.controlador.ControladorPrincipal;
import es.juan.biblioteca.servicio.Servicio;
import es.juan.biblioteca.vista.VistaPrincipal;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.ejecutar();
    }

    private void ejecutar() {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        Servicio servicio = new Servicio();

        ControladorPrincipal controlador =
                new ControladorPrincipal(vistaPrincipal, servicio);

        controlador.iniciar();
    }
}