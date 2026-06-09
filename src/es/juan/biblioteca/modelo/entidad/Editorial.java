package es.juan.biblioteca.modelo.entidad;

public class Editorial {
    private int idEditorial;
    private String nombre;
    private String telefono;
    private String email;

    public Editorial() {}

    public Editorial(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Editorial(int idEditorial, String nombre, String telefono, String email) {
        this(nombre, telefono, email);
        this.idEditorial = idEditorial;
    }

    public int getIdEditorial() { return idEditorial; }
    public void setIdEditorial(int idEditorial) { this.idEditorial = idEditorial; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return idEditorial + " | " + nombre;
    }
}
