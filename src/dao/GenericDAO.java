/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 * Interfaz llamada genericDAO que implementaremos en el main de manera que 
 * tengamos estos metodos de manera obligatoria.
 * @author InigoHugo
 * @version 1.0

 * @param <T> tipo de objeto que gestionará el DAO
 */
public interface GenericDAO<T> {
    /**
     * Método que nos servirá para insertar libros en este caso a nuestra base 
     * de datos.
     * @param objeto  que se desea insertar
     * @return booleano
     */
        boolean insertar(T objeto);
     /**
      * Método por el cual obtendremos una lista con todos nuestros objetos en 
      * nuestro caso de tipo libro.
      * @return lista de libros 
      */
	List<T> obtenerTodos();
    
}
