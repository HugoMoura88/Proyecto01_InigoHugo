/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Libro;

/**
 * Esta clase gestiona la lectura y escritura de una base de datos en formato csv
 * proporcionado a cada metodo con la variable "csv", principalmente se encargara 
 * de transformar los campos del csv en un objeto de clase libro para
 * ser utilizado en app.Funciones.java, modificar el csv como el usuario elija
 * o crear un csv nuevo
 * 
 * @version 1.0
 * @author InigoYHugo
 */
public class FromToCsv {
    
    /**
     * Este metodo se encargara de leer linea por linea el fichero csv proporcionado
     * mediante un "FileReader", de cada linea que representara un libro
     * sacara cada atributo separado por una "," que es el separador estandar de un csv 
     * creando una lista de libros y añadiendo asi los libros extraidos de cada linea
     * @param csv
     * @return lista de todos los libros que contiene el csv
     */

    public static List<Libro> obtenerTodosTxt(String csv) {
        List<Libro> libros = new ArrayList<Libro>();
        Scanner leer = null;
        List<String> lineas = new ArrayList<String>();
        try {
            leer = new Scanner(new FileReader(csv));
            leer.nextLine();
            while (leer.hasNext()) {
                lineas.add(leer.nextLine());
            }
        } catch (Exception e) {
        }

        for (String linea : lineas) {
            String[] lineaSeparada = linea.split(",");
            libros.add(new Libro(lineaSeparada[0], lineaSeparada[1], lineaSeparada[2], Double.valueOf(lineaSeparada[3]), Integer.parseInt(lineaSeparada[4])));
        }
        return libros;
    }
    
    /**
     * Este metodo se encargara de devolver una lista con todos los libros 
     * del fichero csv introducido cuyo titulo coincida con el introducido 
     * por el usuario
     * 
     * Llamara al metodo obtenerTodosTxt para obtener todos los libros del csv
     * en la lista libros y mediante un foreach añadira a la lista ret
     * todos los libros que coincidan con el titulo introducido, despues lo
     * devolvera
     * 
     * @param csv
     * @param titulo
     * @return lista de todos los libros que tengan el titulo introducido 
     */
    public static List<Libro> buscarPorTitulo(String csv, String titulo) {
        List<Libro> libros = obtenerTodosTxt(csv);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                ret.add(libro);
            }
        }
        return ret;
    }
    
    /**
     * Este metodo se encargara de devolver una lista con todos los libros del 
     * fichero csv introducido cuyo autor coincida con el introducido por el usuario
     * 
     * Llamara al metodo obtenerTodosTxt para obtener todos los libros del csv
     * en la lista libros y mediante un foreach añadira a la lista ret
     * todos los libros que coincidan con el autor introducido, despues lo
     * devolvera
     * @param csv
     * @param autor
     * @return lista de todos los libros que tengan el autor introducido introducido 
     */
    public static List<Libro> buscarPorAutor(String csv, String autor) {
        List<Libro> libros = obtenerTodosTxt(csv);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                ret.add(libro);
            }
        }
        return ret;
    }
     /**
     * Este metodo se encargara de devolver una lista con todos los libros del 
     * fichero csv introducido cuyo precio este entre m y ma "minimo y maximo"
     * 
     * Llamara al metodo obtenerTodosTxt para obtener todos los libros del csv
     * en la lista libros y mediante un foreach añadira a la lista ret
     * todos los libros que esten entre m y ma, despues lo
     * devolvera
     * @param csv
     * @param m
     * @param ma
     * @return lista de todos los libros cuyo precio este entre mayor a m y menor a ma
     */
    public static List<Libro> buscarPorRangoPrecios(String csv, Double m, Double ma) {
        List<Libro> libros = obtenerTodosTxt(csv);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getPrecio() >= m || libro.getPrecio() < ma) {
                ret.add(libro);
            }
        }
        return ret;
    }
    
    /**
     * Este metodo se encargara de devolver una lista con todos los libros del 
     * fichero csv introducido cuyo stock sea mayor al introducido
     * 
     * Llamara al metodo obtenerTodosTxt para obtener todos los libros del csv
     * en la lista libros y mediante un foreach añadira a la lista ret
     * todos los libros cuyo stock sea mayor al introducido
     * @param csv
     * @param stock
     * @return lista de todos los libros cuyo stock sea mayor al introducido
     */

    public static List<Libro> buscarPorStockMinimo(String csv, int stock) {
        List<Libro> libros = obtenerTodosTxt(csv);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getStock() >= stock) {
                ret.add(libro);
            }
        }
        return ret;
    }
    
    
    /**
     * Este metodo se encargara de introducir en el csv elegido un nuevo libro
     * 
     * Mediante un PrintWriter rescribira el fichero desde cero obteniendo los 
     * libros que ya tenia gracias al metodo obtenerTodosTxt junto al libro 
     * introducido, en el caso de que ya exista un libro con la misma id devolvera
     * un mensaje diciendo que ya existe un libro con esa id
     * @param csv
     * @param objeto 
     */

    public static void insertarNuevoLibro(String csv, Libro objeto) {
        List<Libro> libros = obtenerTodosTxt(csv);
        PrintWriter es = null;
        Boolean esta = false;
        try {
            es = new PrintWriter(new FileWriter(csv));
            es.println("idlibros,titulo,autor,precio,stock");
            for (Libro libro : libros) {
                es.println(libro.getId() + "," + libro.getTitulo() + "," + libro.getAutor() + "," + libro.getPrecio() + "," + libro.getStock());
                if (libro.getId().equals(objeto.getId())) {
                    esta = true;
                }
            }
            if (esta) {
                System.out.println("Ya hay un libro con la misma id");
            } else {
                es.println(objeto.getId() + "," + objeto.getTitulo() + "," + objeto.getAutor() + "," + objeto.getPrecio() + "," + objeto.getStock());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        es.close();
    }
    /**
     * Este metodo se encargara de eliminar un libro del csv introducido cuyo
     * titulo coincida con el introducido
     * 
     * Mediante un PrintWriter reescribira el fichero desde cero obteniendo los 
     * libros que ya tenia gracias al metodo obtenerTodosTxt pero al llegar al 
     * libro que tenga el titulo introducido no lo escribira de nuevo haciendo 
     * asi que el csv reconstruido 
     * 
     * @param csv
     * @param titulo 
     */
    public static void eliminarLibroPorTitulo(String csv, String titulo) {
        List<Libro> libros = obtenerTodosTxt(csv);
        PrintWriter es = null;
        Boolean esta = false;
        try {
            es = new PrintWriter(new FileWriter(csv));
            es.println("idlibros,titulo,autor,precio,stock");
            for (Libro libro : libros) {
                if (!(libro.getTitulo().equals(titulo))) {
                    es.println(libro.getId() + "," + libro.getTitulo() + "," + libro.getAutor() + "," + libro.getPrecio() + "," + libro.getStock());
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        es.close();
    }
    /**
     * Este metodo se encargara de eliminar un libro del csv introducido cuya
     * id coincida con el introducido
     * 
     * Mediante un PrintWriter reescribira el fichero desde cero obteniendo los 
     * libros que ya tenia gracias al metodo obtenerTodosTxt pero al llegar al 
     * libro que tenga el id introducido no lo escribira de nuevo haciendo 
     * asi que el csv reconstruido no lo contenga 
     * 
     * @param csv
     * @param titulo 
     * @param csv
     * @param id 
     */
    public static void eliminarLibroPorId(String csv, String id) {
        List<Libro> libros = obtenerTodosTxt(csv);
        PrintWriter es = null;
        Boolean esta = false;
        try {
            es = new PrintWriter(new FileWriter(csv));
            es.println("idlibros,titulo,autor,precio,stock");
            for (Libro libro : libros) {
                if (!(libro.getId().equals(id))) {
                    es.println(libro.getId() + "," + libro.getTitulo() + "," + libro.getAutor() + "," + libro.getPrecio() + "," + libro.getStock());
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        es.close();
    }
    /**
     * Este metodo se encargara de escribir mediante un PrintWriter un nuevo
     * csv con su formato estandar de este
     * 
     * Esto lo hara recibiendo una lista de libros del usuario y la ruta del archivo
     * que sera el nuevo csv, de la ruta cambiara las barras de windows en unas 
     * reconocibles en caso de tenerlas y mediante un PrintWriter escribira el
     * contenido
     * 
     * @param csv
     * @param libros 
     */
    public static void toCSV(String csv, List<Libro> libros) {
        PrintWriter es = null;
        csv = csv.replace("\\", "/");
        csv = csv.replace("\"", "/");
        try {
            es = new PrintWriter(new FileWriter(csv));
            es.println("idlibros,titulo,autor,precio,stock");
            for (Libro libro : libros) {
                es.println(libro.getId() + "," + libro.getTitulo() + "," + libro.getAutor() + "," + libro.getPrecio() + "," + libro.getStock());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        es.close();
    }
    

}