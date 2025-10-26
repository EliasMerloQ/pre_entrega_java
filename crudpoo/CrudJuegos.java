import java.util.ArrayList;


public class CrudJuegos extends CrudConsola<Juego> {
    
    private final ArrayList<Juego> juegos;
    private final ArrayList<Categoria> categorias;

    public CrudJuegos(ArrayList<Juego> juegos, ArrayList<Categoria> categorias) {
        this.juegos = juegos;
        this.categorias = categorias;
    }

    @Override
    public void crear() {
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías. Creá una primero.");
            return;
        }
        System.out.println("Categorías:");
        for (Categoria c : categorias) {
            System.out.println(c.getId() + ") " + c.getNombre());
        }
        int idCat = leerEntero("Elegí id de categoría: ");
        Categoria seleccionada = null;
        for (Categoria c : categorias) {
            if (c.getId() == idCat) { seleccionada = c; break; }
        }
        if (seleccionada != null) {
            juegos.add(new Juego(nombre, precio, stock ,seleccionada));
            System.out.println("Juego creado.");
        } else {
            System.out.println("Categoría inválida.");
        }
    }

    @Override
    public void listar() {
        if (juegos.isEmpty()) {
            System.out.println("(sin juegos)");
        } else {
            for (Juego j : juegos) {
                System.out.println(j);
            }
        }
    }

    @Override
    public void actualizar() {
        int id = leerEntero("Id del juego: ");
        for (Juego j : juegos) {
            if (j.getId() == id) {
                String nuevoNombre = leerTexto("Nuevo nombre: ");
                double nuevoPrecio = leerDouble("Nuevo precio: ");
                j.setNombre(nuevoNombre);
                j.setPrecio(nuevoPrecio);

                if (j instanceof Juego) {
                    System.out.println("¿Cambiar categoría? 1=Sí / 0=No");
                    int cam = leerEntero("Opción: ");
                    if (cam == 1) {
                        for (Categoria c : categorias) {
                            System.out.println(c.getId() + ") " + c.getNombre());
                        }
                        int idCat = leerEntero("Elegí id de categoría: ");
                        for (Categoria c : categorias) {
                            if (c.getId() == idCat) { ((Juego)j).setCategoria(c); break; }
                        }
                    }
                }

                System.out.println("Actualizado: " + j);
                return;
            }
        }
        System.out.println("No se encontró producto con id " + id);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id del producto a eliminar: ");
        boolean eliminado = juegos.removeIf(j -> j.getId() == id);
        System.out.println(eliminado ? "Producto eliminado." : "No existía ese id.");
    }
}