public class Usuario {
    private int id;
    private String nombre;

    private static int contadorIds = 1;
    //constructor
    public Usuario(int id, String nombre) {
        this.id = contadorIds++;
        this.nombre = nombre;
    }
}
