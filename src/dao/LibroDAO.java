/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.time.LocalDate;
import java.util.List;
import modelo.Libro;
import java.sql.*;
import java.util.ArrayList;
import util.mysqlconnect;

/**
 *
 * @author 2DAM
 */
public class LibroDAO implements GenericDAO<Libro>{

    @Override
    public boolean insertar(Libro objeto) {
        String sql = "INSERT INTO libros (idlibros,titulo,autor,precio,stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = mysqlconnect.conectar();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, objeto.getId());
            ps.setString(2, objeto.getTitulo());
            ps.setString(3, objeto.getAutor());
            ps.setDouble(4, objeto.getPrecio());
            ps.setInt(5, objeto.getStock());
            int filas = ps.executeUpdate();

            if (filas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    objeto.setId(rs.getString(1));
                }
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Libro> obtenerTodos() {
        List<Libro> libros = new ArrayList<>();
		String sql = "SELECT * FROM libros";

        try (Connection con = mysqlconnect.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                libros.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todos: " + e.getMessage());
        }

        return libros;
    }


    public boolean eliminarPorTitulo(String titulo) {
        String sql = "DELETE FROM libros WHERE titulo = ?";

        try (Connection con = mysqlconnect.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, titulo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
    }
    public boolean eliminarPorId(String id) {
        String sql = "DELETE FROM libros WHERE idlibros = ?";

        try (Connection con = mysqlconnect.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
    }
    public Libro obtenerPorMinimoDeStock(int Stock ) {
		 String sql = "SELECT * from libros WHERE stock >= ? ;";
	        try (Connection con = mysqlconnect.conectar();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setInt(1, Stock);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return mapear(rs);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }
	        return null;
	}
    
    public Libro obtenerPorRangoPrecio(Double precio1,Double precio2) {
		 String sql = "SELECT idlibros,titulo,autor,precio,stock FROM libros WHERE precio between ? and ?";
	        try (Connection con = mysqlconnect.conectar();
	            PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setDouble(1, precio1);
                    ps.setDouble(2, precio1);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return mapear(rs);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }
	        return null;
	}
    public Libro obtenerPorTitulo(String titulo) {
		 String sql = "SELECT idlibros,titulo,autor,precio,stock FROM libros WHERE titulo = ?";
	        try (Connection con = mysqlconnect.conectar();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, titulo);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return mapear(rs);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }
	        return null;
	}
    public Libro obtenerPorAutor(String autor) {
		 String sql = "SELECT idlibros,titulo,autor,precio,stock FROM libros WHERE autor = ?";
	        try (Connection con = mysqlconnect.conectar();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, autor);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return mapear(rs);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener por id: " + e.getMessage());
	        }
	        return null;
	}
    
    private Libro mapear(ResultSet rs) throws SQLException {
	Libro objeto = new Libro();
	objeto.setId(rs.getString("idlibros"));
	objeto.setTitulo(rs.getString("titulo"));
        objeto.setAutor(rs.getString("autor"));
	objeto.setPrecio(rs.getDouble("precio"));
	objeto.setStock(rs.getInt("stock"));
	return objeto;
    }
    
    
}
