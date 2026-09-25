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
 *
 * @author 2DAM
 */
public class FromToTxt {

    public static List<Libro> obtenerTodosTxt(String txt) {
        List<Libro> libros = new ArrayList<Libro>();
        Scanner leer = null;
        List<String> lineas = new ArrayList<String>();
        try {
            leer = new Scanner(new FileReader(txt));
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

    public static List<Libro> buscarPorTitulo(String txt, String titulo) {
        List<Libro> libros = obtenerTodosTxt(txt);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                ret.add(libro);
            }
        }
        return ret;
    }

    public static List<Libro> buscarPorAutor(String txt, String autor) {
        List<Libro> libros = obtenerTodosTxt(txt);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                ret.add(libro);
            }
        }
        return ret;
    }

    public static List<Libro> buscarPorRangoPrecios(String txt, Double m, Double ma) {
        List<Libro> libros = obtenerTodosTxt(txt);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getPrecio() >= m || libro.getPrecio() < ma) {
                ret.add(libro);
            }
        }
        return ret;
    }

    public static List<Libro> buscarPorStockMinimo(String txt, int stock) {
        List<Libro> libros = obtenerTodosTxt(txt);
        List<Libro> ret = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (libro.getStock() >= stock) {
                ret.add(libro);
            }
        }
        return ret;
    }

    public static void insertarNuevoLibro(String txt, Libro objeto) {
        List<Libro> libros = obtenerTodosTxt(txt);
        PrintWriter es = null;
        Boolean esta = false;
        try {
            es = new PrintWriter(new FileWriter(txt));
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

    public static void eliminarLibroPorTitulo(String txt, String titulo) {
        List<Libro> libros = obtenerTodosTxt(txt);
        PrintWriter es = null;
        Boolean esta = false;
        try {
            es = new PrintWriter(new FileWriter(txt));
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
    public static void eliminarLibroPorId(String txt, String id) {
        List<Libro> libros = obtenerTodosTxt(txt);
        PrintWriter es = null;
        Boolean esta = false;
        try {
            es = new PrintWriter(new FileWriter(txt));
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
    
    

}