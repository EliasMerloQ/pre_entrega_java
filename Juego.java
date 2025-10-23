public class Juego {
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private Categoria categoria;
    //Contador
    private static int contadorIds = 1;
    //Constructor de Juego
    public Juego(String nombre, double precio, int stock, Categoria categoria) {
        this.id = contadorIds++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    //Getters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean actualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio > 0) {
            setPrecio(nuevoPrecio);
            return true;
        } else {
            System.out.println("El precio no puede ser negativo.");
            return false;
        }
    }


    //metodo toString
    @Override
    public String toString() {
        return "Juego " +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoria=" + categoria.getNombre();
    }
}

