package es.juan.biblioteca.utilidades;

import java.util.Scanner;

public class Entrada {

    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
        return valor;
    }

    public static double leerDecimal(String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
        return valor;
    }	

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
}