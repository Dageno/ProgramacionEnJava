package listaCompra;

/**
 * 
 * @author Daniel Gestino Notario
 * @version 1.0
 * 
 */

public class Articulo {

	private String nombre;
	private int existencias;
	private int minimo;

	public Articulo(String nombre, int existencias, int minimo) {
		setNombre(nombre);
		setExistencias(existencias);
		setMinimo(minimo);
	}

	public Articulo(String nombre) {
		setNombre(nombre);
	}

	boolean incrementar(int incremento) {
		if (incremento > 0)
			setExistencias(getExistencias() + incremento);
		return false;
	}

	boolean decrementar(int decremento) {
		if (decremento >= 0)
			setExistencias(getExistencias() - decremento);
		return false;

	}

	public boolean bajoMinimo() {
		if (getExistencias() < getMinimo())
			return true;
		return false;
	}

	String getNombre() {
		return nombre;
	}

	private boolean setNombre(String nombre) {
		if (nombre.length() != 0)
			this.nombre = nombre;
		return false;
	}

	int getExistencias() {
		return existencias;
	}

	private boolean setExistencias(int existencias) {
		if (existencias >= 0)
			this.existencias = existencias;
		return false;
	}

	int getMinimo() {
		return minimo;
	}

	boolean setMinimo(int minimo) {
		if (minimo < 0)
			return false;

		this.minimo = minimo;
		return true;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nExistencias: " + existencias + "\nMinimo: " + minimo + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
