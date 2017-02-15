package listaPersonas;

public class Persona {

	private String nombre;
	private String apellido;

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona(String nombre, String apellido) {
		setNombre(nombre);
		setApellido(apellido);
	}

	@Override
	public String toString() {
		return "Mi nombre es: " + getNombre() + " " + getApellido();
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
