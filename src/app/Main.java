/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Scanner;

/**
 * Clase principal en el que se permite al usuario seleccionar el origen de los datos 
 * que podrá ser mediante fichero CSV o una conexion de mysql.
 * @author InigoHugo
 * @version 1.0
 */
public class Main {
   /**
    * Solicita al usuario que seleccione el origen de acceso a los datos 
    * y lo dirige al menu correspondiente.
    * @param args 
    */
    
    public static void main(String[] args) {
        String csv = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                             ============================================================
                                            ------------Selecciona Origen-----------
                                                      1.CSV         2. MySQL
                             ============================================================""");
            System.out.println("Opcion:");
            int opcion = scanner.nextInt();
            switch (opcion) {

                case 1:
                    menuCSV(csv);
                    break;

                case 2:
                    menu(csv);
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    /**
     * Solicita al usuario la ruta del fichero CSV, luego transformará las barras 
     * de windows en unas reconocibles.
     * @param csv ruta del fichero CSV.
     */
    public static void menuCSV(String csv) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime la ruta -> ");
        csv = scanner.nextLine();
        csv = csv.replace("\\", "/");
        csv = csv.replace("\"", "/");
        menu(csv);     
    }
        
     /**
      * Muestra al usuario el menu principal de gestion de libros y ejecutará la 
      * operación seleccionada por el usuario.
      * @param csv ruta del fichero CSV en caso de no haberlo sera vacio
      */
        
        
     public static void menu(String csv) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                             ============================================================
                                            ------------MENU-----------
                             1. Todos los libros          2. Buscar por titulo
                             3. Buscar por autor          4. Buscar por rango de precios
                             5. Buscar por stock minimo   6. Insertar libro
                             7. Borrar libro              8. Copiar
                             9. Salir
                             ============================================================""");
        System.out.println("Opcion: ");
        String ejercicio = sc.next();
        int numero = Integer.parseInt(ejercicio);
        switch (numero) {
            case 1:
                Funciones.mostrarTodosLosLibros(csv);
                break;
            case 2:
                Funciones.buscarPorTitulo(csv);
                break;
            case 3:
                Funciones.buscarPorAutor(csv);
                break;
            case 4:
                Funciones.buscarPorRangoPrecios(csv);
                break;
            case 5:
                Funciones.buscarPorStockMinimo(csv);
                break;
            case 6:
                Funciones.insertarLibros(csv);
                break;
            case 7:
                Funciones.eliminarLibro(csv);
                break;
            case 8:
                Funciones.copiar(csv);
                break;
            case 9:
                break;
            default:
                throw new IllegalArgumentException("No exixste ese ejercicio");

        }
    
     }
}
