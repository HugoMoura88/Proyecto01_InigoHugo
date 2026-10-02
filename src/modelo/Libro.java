/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Esta clase representa un Libro con los atributos : id,titulo,autor,precio y 
 * stock.
 * Cada libro se identifica de forma unica con su @id
 * @author InigoHugo
 * @version 1.0
 */
public class Libro {
    /**
     * Atributos de la clase Libro:
     * 
     */
    protected String id;
    protected String titulo;
    protected String autor;
    protected double precio;
    protected int stock;
    /**
    *Constructor de libro vacio.
    */
    public Libro() {
    }
    /**
     * Constructor de libro con los siguientes atributos,será usado cuando la id
     * del libro no este disponible.
     * @param titulo título del libro
     * @param autor autor del libro
     * @param precio precio del libro
     * @param stock stock cantidad de unidades disponibles
     */
    public Libro(String titulo, String autor, double precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }
    /**
     *  Constructor de libro con todos los atributos
     * @param id identificador único del libro
     * @param titulo título del libro
     * @param autor autor del libro
     * @param precio precio del libro
     * @param stock stock cantidad de unidades disponibles
     */
    

    public Libro(String id, String titulo, String autor, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }
    /**
     * Obtiene el valor del ID.
     * @return valor actual del ID.
     */
    public String getId() {
        return id;
    }
    /**
     * Establce el valor del ID.
     * @param id nuevo valor que se le asgigna al ID.
     */

    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene el valor del Titulo.
     * @return valor actual del Titulo.
     */

    public String getTitulo() {
        return titulo;
    }
    /**
     * Establce el valor del Titulo.
     * @param titulo  nuevo valor que se le asgigna al atributo.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Obtiene el valor del Autor.
     * @return valor actual del Autor.
     */
    public String getAutor() {
        return autor;
    }
    /**
     * Establce el valor del Autor.
     * @param autor nuevo valor que se le asgigna al Autor.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * Obtiene el valor del Precio.
     * @return valor actual del Precio.
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Establce el valor del Precio.
     * @param precio nuevo valor que se le asgigna al Precio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Obtiene el valor del Stock.
     * @return  valor actual del Stock.
     */
    public int getStock() {
        return stock;
    }
    /**
     * Establce el valor del Stock.
     * @param stock nuevo valor que se le asgigna al Stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * Devuelve una representacion en modo texto de la clase libro con sus atributos
     * @return representacion textual de libro
     */

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
}
