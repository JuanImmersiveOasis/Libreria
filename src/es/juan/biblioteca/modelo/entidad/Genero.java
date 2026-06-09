package es.juan.biblioteca.modelo.entidad;

public class Genero {
    private int idGenero;
    private String nombre;

    public Genero() {}

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Genero(int idGenero, String nombre) {
        this(nombre);
        this.idGenero = idGenero;
    }

    public int getIdGenero() { return idGenero; }
    public void setIdGenero(int idGenero) { this.idGenero = idGenero; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return idGenero + " | " + nombre;
    }
}