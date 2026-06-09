package es.juan.biblioteca.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.juan.biblioteca.Conexion;
import es.juan.biblioteca.modelo.entidad.Editorial;
import es.juan.biblioteca.modelo.entidad.Genero;
import es.juan.biblioteca.modelo.entidad.Libro;

public class LibroDAO {

    // INSERT
    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO libros (isbn, titulo, fechaPublicacion, precio, " +
                     "sinopsis, portadaURL, encuadernacion, numeroPaginas, idGenero, idEditorial) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, libro.getIsbn());
            sentencia.setString(2, libro.getTitulo());
            sentencia.setInt(3, libro.getFechaPublicacion());
            sentencia.setDouble(4, libro.getPrecio());
            sentencia.setString(5, libro.getSinopsis());
            sentencia.setString(6, libro.getPortadaURL());
            sentencia.setString(7, libro.getEncuadernacion());
            sentencia.setInt(8, libro.getNumeroPaginas());
            sentencia.setInt(9, libro.getGenero().getIdGenero());
            sentencia.setInt(10, libro.getEditorial().getIdEditorial());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar libro: " + e.getMessage());
            return false;
        }
    }

    // SELECT ALL
    public List<Libro> obtenerListado() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT l.*, g.nombre AS nombreGenero, " +
                     "e.nombre AS nombreEditorial, e.telefono, e.email " +
                     "FROM libros l " +
                     "JOIN generos g ON l.idGenero = g.idGenero " +
                     "JOIN editoriales e ON l.idEditorial = e.idEditorial";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet rs = sentencia.executeQuery()) {

            while (rs.next()) {
                Genero genero = new Genero(
                        rs.getInt("idGenero"),
                        rs.getString("nombreGenero"));

                Editorial editorial = new Editorial(
                        rs.getInt("idEditorial"),
                        rs.getString("nombreEditorial"),
                        rs.getString("telefono"),
                        rs.getString("email"));

                Libro libro = new Libro(
                        rs.getInt("idLibro"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getInt("fechaPublicacion"),
                        rs.getDouble("precio"),
                        rs.getString("sinopsis"),
                        rs.getString("portadaURL"),
                        rs.getString("encuadernacion"),
                        rs.getInt("numeroPaginas"),
                        genero,
                        editorial);

                lista.add(libro);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener libros: " + e.getMessage());
        }
        return lista;
    }

    // SELECT BY ID
    public Libro obtenerPorId(int idLibro) {
        String sql = "SELECT l.*, g.nombre AS nombreGenero, " +
                     "e.nombre AS nombreEditorial, e.telefono, e.email " +
                     "FROM libros l " +
                     "JOIN generos g ON l.idGenero = g.idGenero " +
                     "JOIN editoriales e ON l.idEditorial = e.idEditorial " +
                     "WHERE l.idLibro = ?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idLibro);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                Genero genero = new Genero(
                        rs.getInt("idGenero"),
                        rs.getString("nombreGenero"));

                Editorial editorial = new Editorial(
                        rs.getInt("idEditorial"),
                        rs.getString("nombreEditorial"),
                        rs.getString("telefono"),
                        rs.getString("email"));

                return new Libro(
                        rs.getInt("idLibro"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getInt("fechaPublicacion"),
                        rs.getDouble("precio"),
                        rs.getString("sinopsis"),
                        rs.getString("portadaURL"),
                        rs.getString("encuadernacion"),
                        rs.getInt("numeroPaginas"),
                        genero,
                        editorial);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener libro: " + e.getMessage());
        }
        return null;
    }

    // UPDATE
    public boolean actualizar(Libro libro) {
        String sql = "UPDATE libros SET isbn=?, titulo=?, fechaPublicacion=?, precio=?, " +
                     "sinopsis=?, portadaURL=?, encuadernacion=?, numeroPaginas=?, " +
                     "idGenero=?, idEditorial=? WHERE idLibro=?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, libro.getIsbn());
            sentencia.setString(2, libro.getTitulo());
            sentencia.setInt(3, libro.getFechaPublicacion());
            sentencia.setDouble(4, libro.getPrecio());
            sentencia.setString(5, libro.getSinopsis());
            sentencia.setString(6, libro.getPortadaURL());
            sentencia.setString(7, libro.getEncuadernacion());
            sentencia.setInt(8, libro.getNumeroPaginas());
            sentencia.setInt(9, libro.getGenero().getIdGenero());
            sentencia.setInt(10, libro.getEditorial().getIdEditorial());
            sentencia.setInt(11, libro.getIdLibro());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar libro: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminar(int idLibro) {
        String sql = "DELETE FROM libros WHERE idLibro = ?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idLibro);
            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar libro: " + e.getMessage());
            return false;
        }
    }
}