package sieteYMedia;

import java.util.regex.Pattern;

public class Jugador {

	private double puntuacion;
	private Boolean plantado = false;
	private String nombre;
	private static final String NOMBRE = "\\w+";
	private int partidasGanadas;
	private int partidasPerdidas;

	public Jugador(String nombre) throws NombreNoValidoException {
		setNombre(nombre);
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public Boolean getPlantado() {
		return plantado;
	}

	public void setPlantado(Boolean plantado) {
		this.plantado = plantado;
	}

	public void setPuntuacion(double puntuacion) {
		puntuacion += puntuacion;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws NombreNoValidoException {
		if (!Pattern.matches(NOMBRE, nombre))
			throw new NombreNoValidoException("El nombre no es válido.");
		this.nombre = nombre;
	}

	public Integer getPartidasPerdidas() {
		return partidasPerdidas;
	}

	public void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas += partidasPerdidas;
	}

	public Integer getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas += partidasGanadas;
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
		Jugador other = (Jugador) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
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
		puntuacion = i;
	}

}
