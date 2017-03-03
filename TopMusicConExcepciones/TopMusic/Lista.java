package TopMusic;

/**
* @author Daniel Gestino Notario
* @version 1.0
*
*/

import java.util.ArrayList;
import java.util.Collections;

public class Lista {

	private ArrayList<Cancion> lista;

	Lista() {
		lista = new ArrayList<Cancion>();
	}

	void add(Cancion cancion) {
		lista.add(cancion);
	}

	boolean add(int posicion, Cancion cancion) {
		if (cancion == null)
			return false;
		lista.add(posicion, cancion);
		return true;

	}

	Cancion sacar(int posicion) throws NoSePuedeEliminarException {
		if(lista.remove(posicion) != null)
			return lista.remove(posicion);
		throw new NoSePuedeEliminarException("Error al eliminar la cancion en la posici�n indicada.");
	}

	int size() {
		return lista.size();
	}

	String subirPuesto(int posicion) throws NoPuedeSubirMasException {
		if (posicion == 0)
			throw new NoPuedeSubirMasException("La canci�n no puede subir m�s.");
		Collections.swap(lista, lista.indexOf(lista.get(posicion)), (lista.indexOf(lista.get(posicion)) - 1));
		return "Cancion subida con �xito";
	}

	String bajarPuesto(int posicion) throws NoSePuedeBajarMasException {
		if (posicion >= lista.size() - 1)
			throw new NoSePuedeBajarMasException("La cancion no puede bajar m�s.");
		Collections.swap(lista, lista.indexOf(lista.get(posicion)), (lista.indexOf(lista.get(posicion)) + 1));
		return "Cancion bajada con �xito.";
	}

	Cancion Top() {
		return lista.get(0);
	}

	@Override
	public String toString() {
		String cadena = "";
		if (lista.get(0) == null)
			return "Lista vac�a\n";
		cadena += "TopMusic\n";
		for (int i = 0; i < lista.size(); i++)
			cadena += "\n\t " + (i + 1) + ". " + lista.get(i);

		return cadena;
	}

	void add(String titulo, String artista, int grabacion) throws CancionNoValidaException {
		Cancion cancion = Cancion.getInstance(titulo, artista, grabacion);
		lista.add(cancion);

	}

	public boolean isEmpty() throws ListaVaciaException {
		if(!lista.isEmpty())
			return lista.isEmpty();
		throw new ListaVaciaException("La lista esta vac�a.");
	}

	public Lista top10() {
		int i = 0;
		int maximo = 0;
		Lista Top10 = new Lista();
		if (lista.size() < 10)
			maximo = lista.size();
		for (Cancion song : lista) {
			Top10.add(song);
			i++;
			if (i > 9 || i > maximo)
				break;

		}
		return Top10;
	}
}
