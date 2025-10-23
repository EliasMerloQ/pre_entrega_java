import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Juego> juegos = new ArrayList<>();
    private static ArrayList<Categoria> categorias = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        categorias.add(new Categoria("Acción"));
        categorias.add(new Categoria("Aventura"));
        categorias.add(new Categoria("Multijugador"));
        categorias.add(new Categoria("Un jugador"));
        
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearJuego();
                    break;
                case 2:
                    listarJuegos();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Crear juego");
        System.out.println("2. Listar juegos");
        System.out.println("3. Salir");
        System.out.print("Elija una opción: ");
    }

    private static void crearJuego() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        

        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        Categoria categoria = seleccionarOCrearCategoria();

        Juego juego = new Juego(nombre, precio, stock, categoria);
        juegos.add(juego);
        System.out.println("Juego creado: " + juego.getNombre());
    }

    private static Categoria seleccionarOCrearCategoria() {
        System.out.println("Categorías disponibles:");
        for (Categoria C: categorias) {
            System.out.println((C.getId()) + ". " + C.getNombre());
        }
        System.out.println((categorias.size() + 1) + ". Crear nueva categoría");
        System.out.print("Elija una opción: ");

        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion == categorias.size() + 1) {
            return crearCategoria();
        }
        if (opcion >= 1 && opcion <= categorias.size()) {
            return categorias.get(opcion - 1);
        }
        System.out.println("Opción inválida, se le asignar Sin categoria.");
        return new Categoria("Sin categoría");
    }

    private static Categoria crearCategoria() {
        System.out.print("Nombre de la categoría: ");
        String nombre = scanner.nextLine();
        Categoria c = new Categoria(nombre);
        categorias.add(c);
        return c;
    }

    private static void listarJuegos() {
        if (juegos.isEmpty()) {
            System.out.println("No hay juegos registrados.");
            return;
        }
        System.out.println("\n--- Lista de juegos ---");
        for (Juego j : juegos) {
            System.out.println(j.toString());
        }
    }
}