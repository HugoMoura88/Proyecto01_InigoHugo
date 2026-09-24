/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dao.LibroDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;

/**
 *
 * @author 2DAM
 */
public class Funciones {
//1. Mostrar todos los libros: mostrará por pantalla todos los libros disponibles en el sistema.
    public static void mostrarTodosLosLibros() {
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = dao.obtenerTodos();
        for (Libro libro : libros) {
            System.out.println(libro);
            
        }
//6. Insertar nuevo libro: el usuario proporcionará id, título, autor, precio y stock del nuevo libro.
    
        
    
    
    
    
    
    
    
    
}
