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
 * Esta clase se encargara de contener todos los metodos que usara el main, en
 * todos sus metodos recibira la variable csv del main, en caso de que el usuario
 * haya seleccionado csv y haya escrito su ruta el metodo ejecutara otra cosa,
 * si la variable csv esta vacia significara que el usuario habra seleccionado
 * mysql por lo que ejecutara otro codigo sirviendo asi cada metodo para sql o csv
 * seleccionando los metodos de dao.LibroDAO o de util.FromToCsv
 *
 * @version 1.0
 * @author InigoYHugo
 */
public class Funciones {
/**
 * Este metodo se encargara de mostrar por pantalla todos los libros, creara una lista 
 * de libros y en caso de que el usuario haya elegido sql sacara el contenido del dao
 * con el metodo obtenerTodos, en caso contrario llamara al metodo obtenerTodosTxt del
 * FromToCsv
 * 
 * @param csv 
 */
    public static void mostrarTodosLosLibros(String csv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Libros:");
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = new ArrayList<Libro>();
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
        } else {
            libros = util.FromToCsv.obtenerTodosTxt(csv);
        }
        for (Libro libro : libros) {
            System.out.println(libro);

        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
/**
 * Este metodo se encargará de buscar un libro por su Titulo,le pedirá al usuario 
 * el titulo del libro mediante un scanner 
 * y recorrerá el arraylist de libros,si no es csv recorrerá el metodo 
 * de obtenerTodos y si algun libro se llama como el indicado lo mostrará por pantalla.
 * Si es por CSV llama al metodo buscarPorTitulo, lo recorre y lo imprime.
 * 
 * @param csv 
 */

    public static void buscarPorTitulo(String csv) {
        Scanner sc = new Scanner(System.in);
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = new ArrayList<Libro>();
        System.out.println("Titulo: ");
        String titulo = sc.next();
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
            for (Libro libro : libros) {
                if (libro.getTitulo().equals(titulo)) {
                    System.out.println(libro);
                }
            }
        } else {
             libros = util.FromToCsv.buscarPorTitulo(csv, titulo);
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
  /**
   * Este metodo se encargará de buscar un libro por su autor, pedirá un autor 
   * por consola y si no es csv ira al método dao.obtenertodos lo igualará 
   * al ArrayList de libros hará un foreach 
   * y de ahi llamaremos al metodo getAutor si ese autor coincide con alguno 
   * mostrará el libro por pantalla.
   * Si es por CSV llama al metodo buscarPorAutor, lo recorre y lo imprime.
   * @param csv 
   */

    public static void buscarPorAutor(String csv) {
        Scanner sc = new Scanner(System.in);
        LibroDAO dao = new LibroDAO();
        List<Libro> libros = new ArrayList<Libro>();
        System.out.println("Autor: ");
        String autor = sc.next();
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
            for (Libro libro : libros) {
                if (libro.getAutor().equals(autor)) {
                    System.out.println(libro);
                }
            }
        } else {
            libros = util.FromToCsv.buscarPorAutor(csv, autor);
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
    /**
     * Este metodo se encarga de buscar por rango de precios pedirá dos por consola
     * y sino es csv llamará al metodo dao.obtenertodos igualandoló al ArrayList de libros y 
     * lo recorrera y si el precio esta entre esos rangos imprimirá el libro por pantalla.
     * Si es por CSV llama al metodo buscarPorRangoPrecios, lo recorre y lo imprime.
     * @param csv 
     */

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
            libros = util.FromToCsv.buscarPorRangoPrecios(csv, precio1, precio2);
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
    /**
     * Este método se encargará de buscar libro por cantidad de Stock sino es csv 
     * llamará al metodo de dao.obtenertodos y lo convertirá en el arraylist de 
     * tipo libros y lo recorrerá con un foreach llamará getstock y si es mayor o
     * igual al introducido por sacnner lo imprimrá.
     * Si es por CSV llama al metodo buscarPorStockMinimo, lo recorre y lo imprime.
     * @param csv 
     */

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
            libros = util.FromToCsv.buscarPorStockMinimo(csv, stock);
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }

    /**
     * Este metodo insetara un nuevo libro en la base de datos,
     * primero preguntara al usuario todos los parametros del 
     * libro a introducir, despues llamara respectivamente al metodo del dao
     * o de FromToCsv encargado de insertar el libro
     * @param csv 
     */

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
            util.FromToCsv.insertarNuevoLibro(csv, libro);
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }

/**
 * Este metodo se encargara de eliminar un libro, primero le preguntara 
 * al usuario el titulo del libro a eliminar, despues guardara en una lista
 * todos los libros de la tabla y la recorrera, en caso de haber mas de un libro
 * con ese titulo le preguntara al usuario la id del libro que quiere eliminar
 * y llamara al metodo encargado de eliminarlo por id, si solo hay un libro con
 * ese titulo llamara al metodo de eliminarlo por titulo
 * @param csv 
 */
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
            libros = util.FromToCsv.obtenerTodosTxt(csv);
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
                util.FromToCsv.eliminarLibroPorId(csv, id);
            }
        } else {
            if (csv.equals("")) {
                System.out.println(dao.eliminarPorTitulo(titulo));
            } else {
                util.FromToCsv.eliminarLibroPorTitulo(csv, titulo);
            }
            
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }

    /**
     * Este metodo es el encargado de copiar la tabla de sql en un csv o de 
     * copiar un csv en una nueva tabla sql 
     * 
     * En caso de que el usuario haya seleccionado un csv le preguntara a este 
     * el nombre que quiere para la nueva tabla que se va a crear en su sql y 
     * creara esta tabla con el metodo del dao crearTabla, despues insertara 
     * todos sus libros uno a uno en la tabla con el metodo insertarDeCsv
     * 
     * En caso de que el usuario haya seleccionado el sql se le preguntara a este
     * tanto la ruta en el que quiere su csv como el nombre que quiere que tenga,
     * despues llamara al metodo toCSV para crear el csv con todos los libros del
     * sql
     * 
     * 
     * @param csv 
     */
     public static void copiar(String csv) {
        Scanner sc = new Scanner(System.in);
        List<Libro> libros = new ArrayList<Libro>();
        LibroDAO dao = new LibroDAO();
        String ncsv = "";
        String nom = "";
        if (csv.equals("")) {
            libros = dao.obtenerTodos();
            System.out.println("Dime la ruta en la que quieres crear el csv: -> ");
            ncsv = sc.nextLine();
            System.out.println("Dime el nombre que le quieres poner al csv: -> ");
            ncsv = ncsv.concat("/"+sc.nextLine());
            util.FromToCsv.toCSV(ncsv, libros);
        } else {
            libros = util.FromToCsv.obtenerTodosTxt(csv);
            System.out.println("Dime el nombre que le quieres poner a la nueva tabla: -> ");
            nom = sc.nextLine();
            dao.crearTabla(nom);
            for (Libro libro : libros) {
                dao.insertarDeCsv(libro, nom);
            }
        }
        System.out.println("Escribe l para volver al menu: ");
        sc.nextLine();
        Main.menu(csv);
    }
}
