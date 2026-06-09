package es.juan.biblioteca.utilidades;

import java.util.Scanner;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Introduce un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        return scanner.nextLine();
    }
}