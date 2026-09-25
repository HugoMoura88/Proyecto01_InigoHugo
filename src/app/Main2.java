/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.List;
import modelo.Libro;

/**
 *
 * @author 2DAM
 */
public class Main2 {
    public static void main(String[] args) {
        Libro libronuevo = new Libro("24", "pruebacsv2", "InigoHugo", 2.3,50);
        util.FromToTxt.insertarNuevoLibro("C:/Users/2DAM/Documents/NetBeansProjects/Proyecto01_InigoHugo/src/app/file.csv/", libronuevo);
        List<Libro> libros = util.FromToTxt.obtenerTodosTxt("C:/Users/2DAM/Documents/NetBeansProjects/Proyecto01_InigoHugo/src/app/file.csv/");
        System.out.println("Libros: ");
        for (Libro libro : libros) {
            System.out.println(libro);
            
        }
        
        
    }
    
}
