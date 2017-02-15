package lista;

import java.util.ArrayList;

public class Lista {
	
	ArrayList<Jugador> equipo;

	public Lista() {
		equipo = new ArrayList<Jugador>();
	}
	
	void add(Jugador jugador){
		equipo.add(jugador);
	}
	
	void add(Jugador jugador, int posicion){
		equipo.add(posicion, jugador);
	}
	
	void replace(Jugador jugadorExistente, Jugador jugadorReemplazo){
		equipo.set(equipo.indexOf(jugadorExistente), jugadorReemplazo);
	}
	
	boolean contains(Jugador jugador){
		return equipo.contains(jugador);
	}
	
	int size(){
		return equipo.size();
	}
	
	void remove(Jugador jugador){
		equipo.remove(jugador);
	}
	
	Jugador get(int index){
		return equipo.get(index);
	}
	
	protected Object clone(){
		return equipo.clone();
	}
}
