package es.juan.biblioteca.vista;

import es.juan.biblioteca.utilidades.Entrada;

public class VistaPrincipal {

    public VistaPrincipal() {
        super();
    }

    public void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Libros");
        System.out.println("2. Autores");
        System.out.println("3. Géneros");
        System.out.println("4. Editoriales");
        System.out.println("0. Salir");
    }

    public int pedirOpcion() {
        return Entrada.leerEntero("Elige una opción: ");
    }
}