public abstract class Producto implements Vendible {
        private int id;
        private String nombre;
        private double precio;

        private static int contadorIds = 1;

        public  Producto(String nombre, double precio) {
            this.id = contadorIds++;
            this.nombre = nombre;
            this.precio = precio;
        }
        //getters
        public int getId() {
            return id;
        }
        public String getNombre() {
            return nombre;
        }
        public double getPrecio() {
            return precio;
        }
        //setters
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public void setPrecio(double precio) {
            this.precio = precio;
        }
        public double calcularDescuento() {
            return precio * 0.90; // 10% de descuento
        }

        @Override
        public String toString() {
            return "Producto " +
                    "id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", precio=" + precio;
        }
}
