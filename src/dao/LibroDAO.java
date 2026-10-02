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
 * Esta clase es un DAO que gestiona la lectura y escritura de una base de datos
 * en mysql
 *
 * @version 1.0
 * @author InigoYHugo
 */
public class LibroDAO implements GenericDAO<Libro> {

    /**
     * Este metodo se conectara a mysql mediante la clase util.mysqlconnect.java
     * y ejecutara un insert con los valores del libro introducido
     *
     * @param objeto libro que introduce el usuario
     * @return true si se ha insertado correctamente y false en lo contrario
     */
    @Override
    public boolean insertar(Libro objeto) {
        String sql = "INSERT INTO libros (idlibros,titulo,autor,precio,stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = mysqlconnect.conectar(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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

    /**
     * Este metodo se conectara a la base de datos mediante la clase
     * util.mysqlconnect.java y ejecutara una consulta que devolvera todos los
     * libros de la base de datos, despues añadira todos los libros a una lista
     * mapeando los resultados con el metodo mapear y devolvera la lista con
     * todos los libros
     *
     * @return lista con todos los libros de la tabla
     */
    @Override
    public List<Libro> obtenerTodos() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Connection con = mysqlconnect.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                libros.add(mapear(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todos: " + e.getMessage());
        }

        return libros;
    }

    /**
     * Este metodo sera utilizado para introducir en una tabla nueva creada con
     * el metodo crear tabla todos los libros sacados de un csv uno a uno,
     * Realmente lo que hara sera conectarse a mysql mediante la clase
     * util.mysqlconnect.java y ejecutara un insert con los valores del libro
     * introducido en la tabla introducida
     *
     * @param objeto libro que introduce el usuario
     * @param tabla nombre de la tabla
     * @return true si se ha realizado bien y false en lo contrario
     */
    public boolean insertarDeCsv(Libro objeto, String tabla) {
        String sql = "INSERT INTO " + tabla + " (idlibros,titulo,autor,precio,stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = mysqlconnect.conectar(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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

    /**
     * Este metodo creara una nueva tabla de libros con el nombre introducido,
     * sera usado para volcar en esta todos los libros de un csv
     *
     * @param nombre nombre de la tabla
     */
    public void crearTabla(String nombre) {
        try (Connection con = mysqlconnect.conectar(); Statement ps = con.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS " + nombre + " ( idlibros VARCHAR(255) PRIMARY KEY, titulo VARCHAR(255), autor VARCHAR(255), precio DOUBLE, stock INT);";

            ps.executeUpdate(sql);

        } catch (SQLException ex) {
            System.getLogger(LibroDAO.class.getName()).log(System.Logger.Level.ERROR, "Error al crear la tabla: " + nombre, ex);
        }
    }

    /**
     * Este metodo se conectara a mysql mediante la clase util.mysqlconnect.java
     * y ejecutara un DELETE a un libro que tenga el titulo introducido
     *
     * @param titulo titulo introducido por el usuario
     * @return true si se ha realizado bien y false en lo contrario
     */
    public boolean eliminarPorTitulo(String titulo) {
        String sql = "DELETE FROM libros WHERE titulo = ?";

        try (Connection con = mysqlconnect.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, titulo);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
    }

    /**
     * Este metodo se conectara a mysql mediante la clase util.mysqlconnect.java
     * y ejecutara un DELETE a un libro que tenga el id introducido
     * 
     * @param id la id del libro introducido por el usuario
     * @return true si se ha realizado bien y false en lo contrario
     */
    public boolean eliminarPorId(String id) {
        String sql = "DELETE FROM libros WHERE idlibros = ?";

        try (Connection con = mysqlconnect.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        return false;
    }
    /**
     * Este metodo se conectara a la base de datos mediante la clase
     * util.mysqlconnect.java y ejecutara una consulta que devolvera el
     * libro de la base de datos que tenga el titulo introducido
     * 
     * @param titulo el elegido por el usuario
     * @return libro que tenga el titulo introducido
     */
    public Libro obtenerPorTitulo(String titulo) {
        String sql = "SELECT idlibros,titulo,autor,precio,stock FROM libros WHERE titulo = ?";
        try (Connection con = mysqlconnect.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
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
    
    /**
     * Este metodo se conectara a la base de datos mediante la clase
     * util.mysqlconnect.java y ejecutara una consulta que devolvera el
     * libro de la base de datos que tenga el autor introducido
     * 
     * @param autor el elegido por el usuario
     * @return libro que tenga el autor introducido
     */
    public Libro obtenerPorAutor(String autor) {
        String sql = "SELECT idlibros,titulo,autor,precio,stock FROM libros WHERE autor = ?";
        try (Connection con = mysqlconnect.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
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
    
    
    /**
     * Este metodo se ocupara de transformar la respuesta de la consulta
     * en libros traduciendo cada columna de la tabla en su respectivo atributo
     * del libro
     * 
     * @param rs el resultado de la consulta
     * @return libro con todos los atributos traducidos del sql
     * @throws SQLException 
     */

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
