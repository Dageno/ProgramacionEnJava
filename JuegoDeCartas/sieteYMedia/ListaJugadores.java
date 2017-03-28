package sieteYMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaJugadores {

	ArrayList<Jugador> jugadores;

	public ListaJugadores() {
		jugadores = new ArrayList<Jugador>();
	}
	/**
	 * Devuelve tru si encuentra al jugador en el arraylist
	 * @param jugador
	 * @return
	 */
	boolean contains(Jugador jugador) {

		return jugadores.contains(jugador);
	}
	/**
	 * Añade al arraylist jugadores
	 * @param jugador
	 * @throws JugadorYaExisteException
	 */
	void add(Jugador jugador) throws JugadorYaExisteException {

//		if (jugadores.contains(jugador))
//			throw new JugadorYaExisteException("El jugador creado ya existe\n");
		jugadores.add(jugador);

	}
	/**
	 * Devuelve la longitud del arraylist
	 * @return
	 */
	int size() {
		return jugadores.size();
	}
	
	/**
	 * Ordena un Ranking de 10 jugadores por partidas ganadas
	 */
	void top10() {
		ordenadorPartidasPerdidas();
		Collections.sort(jugadores, new Comparator<Jugador>() {
			@Override
			public int compare(Jugador t1, Jugador t2) {

				return t2.getPartidasGanadas().compareTo(t1.getPartidasGanadas());
			}
		});

	}
	/**
	 * Ordena a los jugadores con más partidas perdidas en el fondo.
	 */
	private void ordenadorPartidasPerdidas() {
		Collections.sort(jugadores, new Comparator<Jugador>() {
			@Override
			public int compare(Jugador t1, Jugador t2) {

				return t1.getPartidasGanadas().compareTo(t2.getPartidasGanadas());
			}
		});
		
	}
	/**
	 * Ordena las puntuaciones de los jugadores actuales de mayor a menor
	 */
	void ordenarJugadoresPuntuacion() {
		Collections.sort(jugadores, new Comparator<Jugador>() {
			@Override
			public int compare(Jugador t1, Jugador t2) {
				if(t2.getPuntuacion() <7.5 || t1.getPuntuacion()<7.5)
					return t2.getPuntuacion().compareTo(t1.getPuntuacion());
				return 0;
			}
		});
		
	}
	/**
	 * Metodo que devuelve un jugador.
	 * @param jugador
	 * @return Jugador
	 */
	public Jugador get(Jugador jugador) {

		return jugadores.get(jugadores.indexOf(jugador));
	}
	/**
	 * Devuelve el jugador de la posición pasada.
	 * @param index
	 * @return
	 */
	public Jugador get(int index) {

		return jugadores.get(index);
	}

	/**
	 * Devuelve una cadena que muestra las puntuaciones de los 
	 * @return
	 */
	public String mostrarPuntuacion() {
		String cadena = "";
		for (Jugador jugador : jugadores)
			cadena += jugador.toCadena();
		return cadena;
	}
	/**
	 * Borra el jugador pasado por parametro del arraylist;
	 * @param jugador
	 */
	public void remove(Jugador jugador) {
		jugadores.remove(jugadores.indexOf(jugador));
		
	}
	/**
	 * Comprueba si la lista está vacía
	 * @return boolean
	 */
	public boolean isEmpty() {
		
		return jugadores.isEmpty();
	}
	ArrayList<Jugador> toArrayList(){
		return jugadores;
	}
	
	@Override
	public String toString() {
		return "ListaJugadores " + jugadores;
	}
	/**
	 * Limpia el arraylist y lo deja vacío.
	 */
	public void clear() {
		jugadores.clear();
	}
	/**
	 * Metodo que averigua los jugadores que se han plantado y asigna las puntuaciones
	 * correspondientes a cada jugador.
	 * @return
	 */
	boolean jugadoresPlantados() {

		if (!todosPlantados())
			return false;
		ordenarJugadoresPuntuacion();
		Double maximo = maximoValido();
		System.out.println(maximo);
		for (int i = 0; i < jugadores.size(); i++) {
			
			if (jugadores.get(i).getPuntuacion().equals(maximo))
				jugadores.get(i).setPartidasGanadas(1);
			else
				jugadores.get(i).setPartidasPerdidas(1);
		}
		return true;

	}
	/**
	 * Comprueba el valor máximo incluyendo 7.5, para calcular de los plantados quien ganaría
	 * @return
	 */
	private Double maximoValido() {
		for(int i = 0; i <jugadores.size();i++){
			if(jugadores.get(i).getPuntuacion()<=7.5)
				return jugadores.get(i).getPuntuacion();
		}
		return null;
		
	}
	/**
	 * Comprueba si todos los jugadores se han plantado
	 * @return
	 */
	private boolean todosPlantados() {
		int contador = 0;
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getPlantado())
				contador++;
			if (jugadores.size() == contador) {
				return true;
			}
		}
		return false;
	}
	/**
	 * To string del ranking de jugadores
	 * @return
	 */
	public String mostrarRanking() {
		String cadena ="Ranking Top 10: \n\n";
		if(jugadores.size()>10){
			for(int i =0; i<10;i++)
				cadena+=jugadores.get(i)+" \n";
		}else{
			for(int i = 0;i<jugadores.size();i++)
				cadena+=jugadores.get(i)+" \n";
		}
		return cadena;
	}
	/**
	 * Devuelve la posicion del jugador en el arraylist.
	 * @param jugador
	 * @return
	 */
	public int indexOf(Jugador jugador) {
		
		return jugadores.indexOf(jugador);
	}


}
