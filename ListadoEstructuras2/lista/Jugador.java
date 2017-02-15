package lista;

public class Jugador {

	private String nombre;
	private String apellido;
	Titular titular;

	public Jugador(String nombre, String apellido, Titular titular) {
		setNombre(nombre);
		setApellido(apellido);
		setTitular(titular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (titular != other.titular)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nMi nombre es " + getNombre() + ", mi apellido " + getApellido() + ", y soy " + getTitular();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
}
