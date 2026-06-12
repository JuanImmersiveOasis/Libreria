package es.juan.biblioteca.modelo.dao;

import java.sql.*;
import java.util.*;
import es.juan.biblioteca.utilidades.Conexion;
import es.juan.biblioteca.modelo.entidad.Autor;

public class AutorDAO {

    public boolean insertar(Autor autor) {
        String sql = "INSERT INTO autores (nombre, apellidos, nacionalidad) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellidos());
            ps.setString(3, autor.getNacionalidad());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Autor> listarTodos() {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autores";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Autor(
                    rs.getInt("idAutor"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("nacionalidad")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Autor buscarPorId(int id) {
        String sql = "SELECT * FROM autores WHERE idAutor = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Autor(
                    rs.getInt("idAutor"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("nacionalidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean modificar(Autor autor) {
        String sql = "UPDATE autores SET nombre=?, apellidos=?, nacionalidad=? WHERE idAutor=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellidos());
            ps.setString(3, autor.getNacionalidad());
            ps.setInt(4, autor.getIdAutor());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM autores WHERE idAutor = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}