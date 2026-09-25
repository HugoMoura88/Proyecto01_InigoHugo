/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Libro;

/**
 *
 * @author 2DAM
 */
public class FromToTxt {
    
    public return List<Libro> void obtenerTodosTxt(String txt) {
        ArrayList<Libro> libros = new ArrayList<Libro>();
        Scanner leer = null;
        ArrayList<String> lineas = new ArrayList<String>();
        try {
            leer = new Scanner(new FileReader(txt));
            while (leer.hasNext()) {
                lineas.add(leer.nextLine());
            }
        } catch (Exception e) {
        }
        
        for (String linea : lineas) {
            String[] lineaSeparada = linea.split(",");
            libros.add(new Libro(lineaSeparada[0],lineaSeparada[1],lineaSeparada[2],Double.valueOf(lineaSeparada[3]),Integer.parseInt(lineaSeparada[4])));
        }
        return libros;
    }
    
    
    
}
