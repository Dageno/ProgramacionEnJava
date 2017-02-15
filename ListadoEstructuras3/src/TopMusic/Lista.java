package TopMusic;

/**
* @author Daniel Gestino Notario
* @version 1.0
*
*/

import java.util.ArrayList;
import java.util.Collections;

public class Lista{
	
	private ArrayList<Cancion> lista;
	
	
	Lista(){
		lista = new ArrayList<Cancion>();
	}


	void add(Cancion cancion){
		lista.add(cancion);
	}
	
	Cancion sacar(int posicion){
		return lista.remove(posicion);
	}
	
	void subirPuesto(int posicion){
			Collections.swap(lista, lista.indexOf(lista.get(posicion)), (lista.indexOf(lista.get(posicion))-1));	
	}
	
	void bajarPuesto(int posicion){
			Collections.swap(lista, lista.indexOf(lista.get(posicion)), (lista.indexOf(lista.get(posicion))+1));		
	}
	
	Cancion Top(){
		return lista.get(0);		
	}
	
	@Override
	public String toString() {
		String cadena = "";
		if(lista.get(0)==null)
			return "Lista vacía\n";
		cadena+="TopMusic\n";
		for(int i = 0; i <lista.size();i++)
			cadena+= "\n\t "+ i +". "+ lista.get(i);
			
		return cadena;
	}


	void add(String titulo, String artista, int grabacion) {
		Cancion cancion = new Cancion(titulo, artista, grabacion);
		lista.add(cancion);
		
	}	
}
