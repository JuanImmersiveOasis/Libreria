package es.juan.biblioteca.vista;

import java.util.List;

import es.juan.biblioteca.modelo.entidad.Autor;
import es.juan.biblioteca.utilidades.Entrada;

public class VistaAutor {
	
	public void mostrarMenu() {
		System.out.println("\n--- GESTIÓN DE AUTORES ---");
		System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");
	}
	
	public int pedirOpcion() {
		return Entrada.leerEntero("Elige una opcion");
	}

	public Autor pedirDatosAutor() {
		String nombre = Entrada.leerTexto("Nombre: ");
		String apellidos = Entrada.leerTexto("Apellidos: ");
		String nacionalidad = Entrada.leerTexto("Nacionalidad: ");
		return new Autor(nombre, apellidos, nacionalidad);
		}
	
	public int pedirId() {
		return Entrada.leerEntero("ID del Autor");
	}
	
    public void mostrarAutores(List<Autor> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
	
}
