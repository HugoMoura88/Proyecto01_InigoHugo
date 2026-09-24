/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dao.LibroDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    }
//6. Insertar nuevo libro: el usuario proporcionará id, título, autor, precio y stock del nuevo libro.
    public static void insertarLibros() {
        LibroDAO dao = new LibroDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Insertar nuevo libro: ");
        System.out.println("Id: ");
        String id = sc.next();
        System.out.println("Titulo: ");
        String titulo = sc.next();
        System.out.println("Autor: ");
        String autor = sc.next();
        System.out.println("Precio: ");
        Double precio = Double.valueOf(sc.next());
        System.out.println("Stock: ");
        int stock = Integer.parseInt(sc.next());
        Libro libro = new Libro(id,titulo,autor,precio,stock);
        System.out.println(dao.insertar(libro));
    }
        
//7. Eliminar libro por título: elimina un libro por su título. Si hay varios con el mismo título, el usuario elige por id.
            public static void eliminarLibro() {
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = dao.obtenerTodos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Eliminar libro: ");
        System.out.println("Titulo: ");
        String titulo = sc.next();
        int con = 0;
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)){
                System.out.println(libro);
                con++;
            }
        }
        if (con>1){
            System.out.println("Hay varios libros con ese titulo, escribe la id del que quieres eliminar: ");
            String id = sc.next();
            System.out.println(dao.eliminarPorId(id));
        } else {
            System.out.println(dao.eliminarPorTitulo(titulo));
        }
        
    }
            
            
            
            
            
    }
        
    
    
    
    
    
    
    
    
}
