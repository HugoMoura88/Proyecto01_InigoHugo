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
				=======================================

				               MENU
				     1. Ej 1          2. Ej 2
				     3. Ej 3          4. Ej 4
				     5. Ej 5          6. Ej 6
				     7. Ej 7          8. Ej 8

				======================================""");
		System.out.println("Dime numero de ejercicio:");
		String ejercicio = sc.nextLine();
		int numero = Integer.parseInt(ejercicio);
		switch (numero) {
		case 1:
			Funciones.mostrarTodosLosLibros();
		case 2:
			Funciones.buscarPorTitulo();
		case 3:
			Funciones.buscarPorAutor();
		case 4:
			Funciones.buscarPorRangoPrecios();
		case 5:
			Funciones.buscarPorStockMinimo();
		case 6:
			Funciones.insertarLibros();
		case 7:
			Funciones.eliminarLibro();
		case 8:
			break;

		default:
			throw new IllegalArgumentException("No exixste ese ejercicio" );
			
		}

	}

} 