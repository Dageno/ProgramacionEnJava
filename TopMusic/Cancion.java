package TopMusic;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
* @author Daniel Gestino Notario
* @version 2.0
*
*/


public class Cancion {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annoGrabacion;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Cancion other = (Cancion) obj;
		if (annoGrabacion != other.annoGrabacion)
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	String titulo;
	String artista;
	int annoGrabacion;
	
	Cancion(String titulo, String artista, int annoGrabacion){
		setTitulo(titulo);
		setArtista(artista);
		setAnnoGrabacion(annoGrabacion);
		
	}
	
	static Cancion getInstance(String titulo, String artista, int annoGrabacion ){
		String cadena = Integer.toString(annoGrabacion);
		Calendar calendario = Calendar.getInstance();
		if(!(Pattern.matches("[1-2]\\d{3}", cadena)&& calendario.get(Calendar.YEAR)>annoGrabacion&& Pattern.matches("\\w+", titulo) && Pattern.matches("\\w+", artista)))
			return null;
		return new Cancion(titulo, artista, annoGrabacion);
	}

	String getTitulo() {
		return titulo;
	}

	private boolean setTitulo(String titulo){
		if(titulo.length()!=0)
			this.titulo = titulo;
		return false;
	}

	String getArtista() {
		return artista;
	}

	private boolean setArtista(String artista){
		if(artista.length()!=0)
			this.artista=artista;
		return false;
	}

	int getAnnoGrabacion() {
		return annoGrabacion;
	}

	private void setAnnoGrabacion(int annoGrabacion){
		this.annoGrabacion=annoGrabacion;
		
	}

	@Override
	public String toString() {
		return "Cancion: " + titulo + ", artista:" + artista + ", año de grabación:" + annoGrabacion + "\n";
	}
}
