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

	Cancion sacar(int posicion) {
		return lista.remove(posicion);
	}

	int size() {
		return lista.size();
	}

	String subirPuesto(int posicion) {
		if (posicion == 0)
			return "El top 1 no puede subir más.";
		Collections.swap(lista, lista.indexOf(lista.get(posicion)), (lista.indexOf(lista.get(posicion)) - 1));
		return "Cancion subida con éxito";
	}

	String bajarPuesto(int posicion) {
		if (posicion >= lista.size() - 1)
			return "La ultima canción no puede bajar más.";
		Collections.swap(lista, lista.indexOf(lista.get(posicion)), (lista.indexOf(lista.get(posicion)) + 1));
		return "Cancion bajada con éxito.";
	}

	Cancion Top() {
		return lista.get(0);
	}

	@Override
	public String toString() {
		String cadena = "";
		if (lista.get(0) == null)
			return "Lista vacía\n";
		cadena += "TopMusic\n";
		for (int i = 0; i < lista.size(); i++)
			cadena += "\n\t " + (i + 1) + ". " + lista.get(i);

		return cadena;
	}

	void add(String titulo, String artista, int grabacion) {
		Cancion cancion = Cancion.getInstance(titulo, artista, grabacion);
		lista.add(cancion);

	}

	public boolean isEmpty() {

		return lista.isEmpty();
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
