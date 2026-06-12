package es.juan.biblioteca.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.juan.biblioteca.modelo.entidad.Genero;
import es.juan.biblioteca.utilidades.Conexion;

public class GeneroDAO {

    // INSERT
    public boolean insertar(Genero genero) {
        String sql = "INSERT INTO generos (nombre) VALUES (?)";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, genero.getNombre());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar género: " + e.getMessage());
            return false;
        }
    }

    // SELECT ALL
    public List<Genero> obtenerListado() {
        List<Genero> lista = new ArrayList<>();
        String sql = "SELECT * FROM generos";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet rs = sentencia.executeQuery()) {

            while (rs.next()) {
                Genero genero = new Genero(
                        rs.getInt("idGenero"),
                        rs.getString("nombre"));
                lista.add(genero);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener géneros: " + e.getMessage());
        }
        return lista;
    }

    // SELECT BY ID
    public Genero obtenerPorId(int idGenero) {
        String sql = "SELECT * FROM generos WHERE idGenero = ?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idGenero);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                return new Genero(
                        rs.getInt("idGenero"),
                        rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener género: " + e.getMessage());
        }
        return null;
    }

    // UPDATE
    public boolean actualizar(Genero genero) {
        String sql = "UPDATE generos SET nombre=? WHERE idGenero=?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, genero.getNombre());
            sentencia.setInt(2, genero.getIdGenero());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar género: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminar(int idGenero) {
        String sql = "DELETE FROM generos WHERE idGenero = ?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idGenero);
            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar género: " + e.getMessage());
            return false;
        }
    }
}