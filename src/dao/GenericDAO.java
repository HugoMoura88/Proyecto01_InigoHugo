/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 * Interfaz llamada genericDAO que implementaremos en el main de manera que 
 * tengamos estos metodos de manera obligatoria.
 * @author 2DAM
 * @param <T>
 */
public interface GenericDAO<T> {
    /**
     * Método que nos servirá para insertar libros en este caso a nuestra base 
     * de datos.
     * @param objeto
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
