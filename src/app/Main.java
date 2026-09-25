package app;

/*package app;*/
import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
  

    public class Main {

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
    }

    public static void menuCSV(String csv) {
             Scanner scanner = new Scanner(System.in);
            
             System.out.println("Dime la ruta -> ");
             csv= scanner.nextLine();
             csv=csv.replace("\\","/");
             menu(csv)
     
              
    }

    public static void menu(String csv) {
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
                break;

            default:
                throw new IllegalArgumentException("No exixste ese ejercicio");

        }
    }
