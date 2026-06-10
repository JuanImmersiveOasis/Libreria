
package es.juan.biblioteca.vista;

import java.util.List;

import es.juan.biblioteca.modelo.entidad.Genero;
import es.juan.biblioteca.utilidades.Entrada;

public class VistaGenero {
	
	public void mostrarMenu() {
		System.out.println("\n--- GESTIÓN DE GÉNEROS ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("0. Salir");
	}
	
	public int pedirOpcion() {
		return Entrada.leerEntero("Elige la opción: ");
	}
	
	public void mostrarGeneros(List<Genero> generos) {
		System.out.println("\n--- LISTADO DE GENEROS ---");
		for(Genero g :generos) {
			System.out.println(g);
		}
	}
	
	public void mostrarGenero(Genero genero) {
		if(genero != null) {
			System.out.println("\n--- DETALLES DE GENERO ---");
			System.out.println("ID: "+genero.getIdGenero());
			System.out.println("Nombre: "+genero.getNombre());
		}else {
			System.out.println("Genero no encontrado");
		}
	}
	
	public int pedirId() {
		return Entrada.leerEntero("Elige un id de genero: ");
		
	}
	
	public String pedirNombre() {
		return Entrada.leerTexto("Nombre de genero: ");
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

}
