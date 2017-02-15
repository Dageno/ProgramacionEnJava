package lista;

import utiles.Menu;
import utiles.MenuSinSalir;
import utiles.Teclado;

public class TestLista {
	static Menu menuLista = new Menu("Configurando un equipo de Jugadores: ",
			new String[] { "Añadir jugador", "Insertar jugador en una posición", "Modificar jugador por otro",
					"Numero de jugadores en el equipo", "Eliminar jugador", "Buscar jugador", "Copiar alineación" });
	static MenuSinSalir menuTitular = new MenuSinSalir("Menu  Titular ", new String[] { "Titular", "Reserva" });
	static Lista alineacion = new Lista();
	static Lista alineacionBackup = new Lista();

	public static void main(String[] args) {
		int opcion;

		do {
			opcion = menuLista.gestionar();
			switch (opcion) {
			case 1:
				addJugador();
				break;
			case 2:
				insertarPosicion();
				break;
			case 3:
				modificarJugador();
				break;
			case 4:
				System.out.println("La alineación contiene " + alineacion.size() + " jugadores.");
				break;
			case 5:
				eliminarJugador();
				break;
			case 6:
				buscarJugador();
				break;
			case 7:
				copiarAlineacion();
				break;
			default:
				System.out.println("Saliendo de programa.");
			}

		} while (opcion != menuLista.getNumOpciones());

	}

	private static void copiarAlineacion() {
		alineacionBackup = (Lista) alineacion.clone();

	}

	private static void buscarJugador() {
		Jugador jugador = crearJugador();
		if (alineacion.contains(jugador))
			System.out.println(jugador.toString());
		else
			System.out.println("El jugador buscado no existe.");
	}

	private static void eliminarJugador() {
		Jugador jugador = crearJugador();

		if (alineacion.contains(jugador))
			alineacion.remove(jugador);
		else
			System.out.println("El jugador que desea borrar no existe.");

	}

	private static void modificarJugador() {

		Jugador jugador = crearJugador();

		if (alineacion.contains(jugador))
			alineacion.replace(jugador, crearJugador());
		else
			System.out.println("El jugador que desea borrar no existe.");
	}

	private static void insertarPosicion() {
		alineacion.add(crearJugador(), seleccionarPosicion());

	}

	private static int seleccionarPosicion() {
		int opcion;
		for (int i = 0; i < alineacion.size(); i++)
			System.out.println("Posicion " + i);
		do {
			opcion = Teclado.leerEntero("Introduce la posición deseada: ");
		} while (opcion < 0 || opcion >alineacion.size());
		return opcion;

	}

	private static void addJugador() {

		alineacion.add(crearJugador());

	}

	private static Jugador crearJugador() {
		return new Jugador(Teclado.leerCadena("Introduce nombre:"), Teclado.leerCadena("Introduce apellido: "),
				seleccionarTitulo());
	}

	private static Titular seleccionarTitulo() {

		int opcion = menuTitular.gestionar();
		switch (opcion) {
		case 1:
			return Titular.TITULAR;
		case 2:
			return Titular.RESERVA;
		default:
			return null;
		}

	}

}
