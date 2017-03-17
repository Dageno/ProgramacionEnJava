package sieteYMedia;

import java.util.regex.Pattern;

public class Jugador {

	private double Puntuacion;
	private Boolean plantado = false;
	private String Nombre;
	private static final String NOMBRE = "\\w+";
	private int PartidasGanadas;
	private int PartidasPerdidas;

	public Jugador(String nombre) throws NombreNoValidoException {
		setNombre(nombre);
	}

	public Double getPuntuacion() {
		return Puntuacion;
	}

	public Boolean getPlantado() {
		return plantado;
	}

	public void setPlantado(Boolean plantado) {
		this.plantado = plantado;
	}

	public void setPuntuacion(double puntuacion) {
		Puntuacion += puntuacion;
	}

	public String getNombre() {
		return Nombre;
	}

	private void setNombre(String nombre) throws NombreNoValidoException {
		if (!Pattern.matches(NOMBRE, nombre))
			throw new NombreNoValidoException("El nombre no es válido.");
		Nombre = nombre;
	}

	public Integer getPartidasPerdidas() {
		return PartidasPerdidas;
	}

	public void setPartidasPerdidas(int partidasPerdidas) {
		PartidasPerdidas += partidasPerdidas;
	}

	public Integer getPartidasGanadas() {
		return PartidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		PartidasGanadas += partidasGanadas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		Jugador other = (Jugador) obj;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}

	
	public String toCadena() {
		return "\nJugador " + getNombre() + ", puntuación: " + getPuntuacion();
	}
	
	@Override
	public String toString() {
		return "\nJugador " + getNombre() + ", Partidas ganadas: " + getPartidasGanadas()+" y Partidas perdidas: "+ getPartidasPerdidas();
	}

	public void setPuntuacionReal(int i) {
		Puntuacion = i;
	}

}
