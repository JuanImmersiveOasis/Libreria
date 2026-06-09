package es.juan.biblioteca.modelo.entidad;

public class Libro {
    private int idLibro;
    private String isbn;
    private String titulo;
    private int fechaPublicacion;
    private double precio;
    private String sinopsis;
    private String portadaURL;
    private String encuadernacion;
    private int numeroPaginas;
    private Genero genero;
    private Editorial editorial;

    // Constructor vacío
    public Libro() {}

    // Constructor sin id (para INSERT sin isbn)
    public Libro(String titulo, int fechaPublicacion, double precio,
                 String sinopsis, String portadaURL, String encuadernacion,
                 int numeroPaginas, Genero genero, Editorial editorial) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.portadaURL = portadaURL;
        this.encuadernacion = encuadernacion;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
        this.editorial = editorial;
    }

    // Constructor sin id (para INSERT con isbn)
    public Libro(String isbn, String titulo, int fechaPublicacion, double precio,
                 String sinopsis, String portadaURL, String encuadernacion,
                 int numeroPaginas, Genero genero, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.portadaURL = portadaURL;
        this.encuadernacion = encuadernacion;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
        this.editorial = editorial;
    }

    // Constructor completo (para SELECT)
    public Libro(int idLibro, String isbn, String titulo, int fechaPublicacion, double precio,
                 String sinopsis, String portadaURL, String encuadernacion,
                 int numeroPaginas, Genero genero, Editorial editorial) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.portadaURL = portadaURL;
        this.encuadernacion = encuadernacion;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
        this.editorial = editorial;
    }

    // Getters y Setters
    public int getIdLibro() {
        return idLibro;
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPortadaURL() {
        return portadaURL;
    }
    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    public String getEncuadernacion() {
        return encuadernacion;
    }
    public void setEncuadernacion(String encuadernacion) {
        this.encuadernacion = encuadernacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Editorial getEditorial() {
        return editorial;
    }
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return idLibro + " | " + titulo + " | " + isbn;
    }
}