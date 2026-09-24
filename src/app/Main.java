package app;
/*package app;*/


import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
public class Main {
public static void main(String[] args)  {
    
    Scanner sc = new Scanner(System.in);
   
		System.out.println("""
				============================================================
				               ------------MENU-----------
				1. Todos los libros          2. Buscar por titulo
				3. Buscar por autor          4. Buscar por rango de precios
				5. Buscar por stock minimo   6. Insertar libro
				7. Borrar libro          
				============================================================""");
		System.out.println("Opcion: ");
		String ejercicio = sc.next();
		int numero = Integer.parseInt(ejercicio);
		switch (numero) {
		case 1:
			Funciones.mostrarTodosLosLibros();
                        break;
		case 2:
			Funciones.buscarPorTitulo();
                        break;
		case 3:
			Funciones.buscarPorAutor();
                        break;
		case 4:
			Funciones.buscarPorRangoPrecios();
                        break;
		case 5:
			Funciones.buscarPorStockMinimo();
                        break;
		case 6:
			Funciones.insertarLibros();
                        break;
		case 7:
			Funciones.eliminarLibro();
                        break;
		case 8:
			break;

		default:
			throw new IllegalArgumentException("No exixste ese ejercicio" );
			
		}

	}

} 