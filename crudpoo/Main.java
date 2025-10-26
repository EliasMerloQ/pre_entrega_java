import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final ArrayList<Juego> juegos = new ArrayList<>();
        final ArrayList<Categoria> categorias = new ArrayList<>();

        categorias.add(new Categoria("Un jugador"));
        categorias.add(new Categoria("Multijugador"));
        categorias.add(new Categoria("Aventura"));
        categorias.add(new Categoria("Estrategia"));
        categorias.add(new Categoria("Terror"));
        
        final CrudJuegos crudJuegos = new CrudJuegos(juegos, categorias);
        final CrudCategorias crudCat = new CrudCategorias(categorias);

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1) CRUD de Juegos");
            System.out.println("2) CRUD de Categorías");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String linea = crudJuegos.scanner.nextLine();
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        crudJuegos.mostrarOpciones();
                        op = crudJuegos.leerEntero("");
                        switch (op) {
                            case 1 -> crudJuegos.crear();
                            case 2 -> crudJuegos.listar();
                            case 3 -> crudJuegos.actualizar();
                            case 4 -> crudJuegos.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 2 -> {
                    int op;
                    do {
                        crudCat.mostrarOpciones();
                        op = crudCat.leerEntero("");
                        switch (op) {
                            case 1 -> crudCat.crear();
                            case 2 -> crudCat.listar();
                            case 3 -> crudCat.actualizar();
                            case 4 -> crudCat.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}