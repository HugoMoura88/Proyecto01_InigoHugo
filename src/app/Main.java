
package app;


import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
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
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;

		default:
			throw new IllegalArgumentException("No exixste ese ejercicio" );
			
		}

	}



    