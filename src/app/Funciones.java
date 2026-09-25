/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dao.LibroDAO;
import java.io.InputStream;
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

    public static void mostrarTodosLosLibros(String csv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Libros:");
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = new ArrayList<Libro>();
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
        } else {
            libros = util.FromToTxt.obtenerTodosTxt(csv);
        }
        for (Libro libro : libros) {
            System.out.println(libro);

        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
//2. Buscar libro por título: permite buscar un libro específico por su título.

    public static void buscarPorTitulo(String csv) {
        Scanner sc = new Scanner(System.in);
        LibroDAO dao = new LibroDAO();
        System.out.println("Titulo: ");
        String titulo = sc.next();
        if (csv.equals("")) {
            System.out.println(dao.obtenerPorTitulo(titulo));
        } else {
            System.out.println(util.FromToTxt.buscarPorTitulo(csv, titulo));
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
    //3. Buscar libros por autor: permite buscar libros de un autor específico.

    public static void buscarPorAutor(String csv) {
        Scanner sc = new Scanner(System.in);
        LibroDAO dao = new LibroDAO();
        System.out.println("Autor: ");
        String autor = sc.next();
        if (csv.equals("")) {
            System.out.println(dao.obtenerPorAutor(autor));
        } else {
            System.out.println(util.FromToTxt.buscarPorAutor(csv, autor));
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
//4. Buscar libros por rango de precios: permite buscar libros dentro de un rango de precios indicado por el usuario.

    public static void buscarPorRangoPrecios(String csv) {
        Scanner sc = new Scanner(System.in);
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = new ArrayList<Libro>();
        System.out.println("Rango de precios: ");
        System.out.println("De: ");
        Double precio1 = Double.valueOf(sc.next());
        System.out.println("Hasta: ");
        Double precio2 = Double.valueOf(sc.next());
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
            for (Libro libro : libros) {
                if (libro.getPrecio() > precio1 && libro.getPrecio() < precio2) {
                    System.out.println(libro);
                }
            }
        } else {
            libros = util.FromToTxt.buscarPorRangoPrecios(csv, precio1, precio2);
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
//5. Buscar libros por cantidad mínima en stock: permite buscar libros con stock igual o mayor al especificado.

    public static void buscarPorStockMinimo(String csv) {
        Scanner sc = new Scanner(System.in);
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = new ArrayList<Libro>();
        System.out.println("Stock minimo: ");
        int stock = Integer.parseInt(sc.next());
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
            for (Libro libro : libros) {
                if (libro.getStock() >= stock) {
                    System.out.println(libro);
                }
            }
        } else {
            libros = util.FromToTxt.buscarPorStockMinimo(csv, stock);
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
//6. Insertar nuevo libro: el usuario proporcionará id, título, autor, precio y stock del nuevo libro.

    public static void insertarLibros(String csv) {
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
        Libro libro = new Libro(id, titulo, autor, precio, stock);
        if (csv.equals("")) {
            System.out.println(dao.insertar(libro));
        } else {
            util.FromToTxt.insertarNuevoLibro(csv, libro);
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }

//7. Eliminar libro por título: elimina un libro por su título. Si hay varios con el mismo título, el usuario elige por id.
    public static void eliminarLibro(String csv) {
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = new ArrayList<Libro>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Eliminar libro: ");
        System.out.println("Titulo: ");
        String titulo = sc.next();
        int con = 0;
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
        } else {
            libros = util.FromToTxt.obtenerTodosTxt(csv);
        }
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                System.out.println(libro);
                con++;
            }
        }
        if (con > 1) {
            System.out.println("Hay varios libros con ese titulo, escribe la id del que quieres eliminar: ");
            String id = sc.next();
            if (csv.equals("")) {
                System.out.println(dao.eliminarPorId(id));
            } else {
                util.FromToTxt.eliminarLibroPorId(csv, id);
            }
        } else {
            if (csv.equals("")) {
                System.out.println(dao.eliminarPorTitulo(titulo));
            } else {
                util.FromToTxt.eliminarLibroPorTitulo(csv, titulo);
            }
            
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }

//8. Hacer copia: copia todos los datos del repositorio activo al otro (de archivo a MySQL o viceversa).      
}
