public class Categoria {
	private int id;
	private String nombre;
	private static int contador = 1;

	public Categoria(String nombre) {
		this.id = contador++;
		this.nombre = nombre;
	}

	//getters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

	//setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
