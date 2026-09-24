/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author 2DAM
 * @param <T>
 */
public interface GenericDAO<T> {
    
        boolean insertar(T objeto);
	List<T> obtenerTodos();
    
}
