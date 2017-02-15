package TopMusic;

/**
* @author Daniel Gestino Notario
* @version 1.0
*
*/


public class Cancion {
	
	String titulo;
	String artista;
	int annoGrabacion;
	
	Cancion(String titulo, String artista, int annoGrabacion){
		setTitulo(titulo);
		setArtista(artista);
		setAnnoGrabacion(annoGrabacion);
		
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

	private boolean setAnnoGrabacion(int annoGrabacion){
		if(annoGrabacion>1877 || annoGrabacion<2016)
			this.annoGrabacion=annoGrabacion;
		return false;
	}

	@Override
	public String toString() {
		return "Cancion: " + titulo + ", artista:" + artista + ", año de grabación:" + annoGrabacion + "\n";
	}
}
