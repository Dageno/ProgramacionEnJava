package sieteYMedia;

import utiles.*;

public class TestSieteYMedia {

	static Baraja baraja;

	static Menu inicio = new Menu("Bienvenido al juego de las Siete y Media.",
			new String[] { "Iniciar partida", "Ranking de jugadores" });
	static MenuSinSalir partidaIniciada = new MenuSinSalir("Menu de juego",
			new String[] { "Introducir jugadores", "Jugar", "Ver partidas ganadas y perdidas de los jugadores", });

	@SuppressWarnings("null")
	public static void main(String[] args) throws JugadorYaExisteException {
		Partida partidas = new Partida();
		int opcion1;
		do {
			opcion1 = inicio.gestionar();
			switch (opcion1) {
			case 1:

				// jugadores = new ListaJugadores();
				iniciarPartida(partidas);
				break;
			case 2:
				try {
					if (!partidas.isEmpty())
						System.out.println(partidas.ranking() + "\n");
					else
						System.out.println("La lista de jugadores está vacía.");

					break;
				} catch (PartidaNoCreadaException | JugadorYaExisteException e) {
					System.err.println(e.getMessage());
				}

			default:
				System.exit(1);
			}

		} while (partidas != null || !partidas.isEmpty());

	}

	private static boolean jugarDeNuevo(ListaJugadores jugadores, Partida partidas) throws JugadorYaExisteException {

		switch (respuestaCorrecta("¿Desea jugar de nuevo con los mismos jugadores ?")) {
		case 's':
			System.out.println(partidas);

			for (int i = 0; i < jugadores.size(); i++) {
				jugadores.get(i).setPuntuacionReal(0);
				jugadores.get(i).setPlantado(false);
			}

			return true;
		default:

			return false;
		}

	}

	private static void iniciarPartida(Partida partidas) throws JugadorYaExisteException {

		ListaJugadores jugadores = new ListaJugadores();
		baraja = new Baraja();
		int num, opcion;

		do {
			opcion = partidaIniciada.gestionar();
			switch (opcion) {
			case 1:

				try {
					jugadores.clear();
					do {
						num = Teclado.leerEntero("Introduce el numero de jugadores.");
					} while (num < 1);
					for (int i = 0; i < num; i++) {
						jugadores.add(
								new Jugador(Teclado.leerCadena("Introduce el alias del jugador " + (i + 1) + ": ")));

					}
					partidas.add(jugadores);

				} catch (JugadorYaExisteException | NombreNoValidoException e) {
					System.err.println(e.getMessage());
					iniciarPartida(partidas);
				}
			case 2:
				do {
					if (!jugadores.isEmpty())
						jugarPartida(jugadores);
					else {
						System.out.println("La lista de jugadores está vacía.");
						break;
					}
				} while (jugarDeNuevo(jugadores, partidas));
				break;
			default:
				try {
					System.out.println(partidas.verPuntuaciones());
				} catch (JugadorYaExisteException e) {

					System.err.println(e.getMessage());

				}
				break;

			}

		} while (opcion != partidaIniciada.getNumOpciones());

	}

	private static void jugarPartida(ListaJugadores jugadores) {

		System.out.println("\nSacando cartas...:");

		do {
			for (int i = 0; i < jugadores.size(); ) {

				if (!jugadores.get(i).getPlantado()) {

					jugadores.get(i).setPuntuacion(baraja.sacarCarta());
					System.out.println(jugadores.get(i).toCadena());

					if (jugadores.get(i).getPuntuacion() > 7.5) {
						jugadores.get(i).setPlantado(true);
					} else if (jugadores.get(i).getPuntuacion() == 7.5) {
						System.out.println("¡Tenemos un ganador!");
						jugadores.get(i).setPlantado(true);

					} else {
						System.out.println(jugadores.get(i).getNombre() + " no ha llegado aún a las Siete y Media.");
						
					}
					i++;
				} else
					i++;

			}
			if (jugadores.jugadoresPlantados()) {
				System.out.println("se acabó la partida.");
				return;
			}
		} while (seguirJugando(jugadores));

	}

	private static boolean seguirJugando(ListaJugadores jugadores) {
		char respuesta;

		for (int i = 0; i < jugadores.size(); i++) {
			if (!jugadores.get(i).getPlantado()) {
				respuesta = respuestaCorrecta(
						"Jugador " + jugadores.get(i).getNombre() + " ¿ Desea seguir sacando carta ?(s/n)");
				if (respuesta == 'n') 
					jugadores.get(i).setPlantado(true);

				
			}
		}
		if (jugadores.jugadoresPlantados()) {
			return false;

		}
		System.out.println("¡Seguimos jugando!");
		return true;

	}

	private static char respuestaCorrecta(String cadena) {
		char respuesta;
		do {
			respuesta = Teclado.leerCaracter(cadena);
			if (respuesta == 'S' || respuesta == 's')
				return 's';
			else if (respuesta == 'N' || respuesta == 'n')
				return 'n';
		} while (true);
	}

}
