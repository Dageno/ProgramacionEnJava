package sieteYMedia;

import java.util.ArrayList;

public class Partida {

	static ArrayList<ListaJugadores> partidas;

	Partida() {
		partidas = new ArrayList<ListaJugadores>();
	}

	void add(ListaJugadores jugadores) {
		partidas.add(jugadores);
	}

	String ranking() throws PartidaNoCreadaException, JugadorYaExisteException {
		if (partidas == null)
			throw new PartidaNoCreadaException("No hay partidas guardadas en el sistema.");
		ListaJugadores ranking = new ListaJugadores();
		int i = 0;
		for (ListaJugadores jugadores : partidas)
			for (Jugador jugador : jugadores.jugadores){
				if(i== 10)
					break;
				ranking.add(jugador);
				i++;
			}
		ranking.top10();
		
		return ranking.mostrarRanking();

	}

	public boolean isEmpty() {

		return partidas.isEmpty();
	}

	String obtenerPuntuaciones() throws JugadorYaExisteException {
		ListaJugadores puntuaciones = new ListaJugadores();
		
		for (ListaJugadores jugadores : partidas)
			for (Jugador jugador : jugadores.jugadores) {
				if (puntuaciones.contains(jugador)) {
					puntuaciones.get(jugador).setPartidasGanadas(jugador.getPartidasGanadas());
					puntuaciones.get(jugador).setPartidasPerdidas(jugador.getPartidasPerdidas());
				} else
					puntuaciones.add(jugador);

			}
		puntuaciones.top10();
		return puntuaciones.toString();

	}

	@Override
	public String toString() {
		return "Partidas jugadas " + partidas;
	}

	public int size() {

		return partidas.size();
	}

	public ListaJugadores get(int index) {

		return partidas.get(index);
	}

	public String verPuntuaciones() throws JugadorYaExisteException {
		return obtenerPuntuaciones();
		
	}


}
