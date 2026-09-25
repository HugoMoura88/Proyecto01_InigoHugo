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
        List<Libro> libros = util.FromToTxt.obtenerTodosTxt("C:/Users/2DAM/Documents/NetBeansProjects/Proyecto01_InigoHugo/src/app/file.txt/");
        System.out.println("Libros: ");
        for (Libro libro : libros) {
            System.out.println(libro);
            
        }
        
        
    }
    
}
