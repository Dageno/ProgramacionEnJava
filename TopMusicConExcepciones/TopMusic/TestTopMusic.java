package TopMusic;



/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones más
* escuchadas. El usuario podrá:
* a. Añadir una canción (en una posición) al TopMusic.
* b. Sacar un elemento del TopMusic.
* c. Subir un puesto en el TopMusic.
* d. Bajar un puesto en el TopMusic.
* e. Mostrar la lista TopMusic.
* f. Mostrar la canción más escuchada.
* Sobre la canción se almacenará el título, artista o grupo y año de grabación
* 
* @author Daniel GEstino Notario
* @version 2.0
*
*/

import utiles.*;

public class TestTopMusic {

	static Menu menu = new Menu("TopMusic", new String[] { "Añadir canción", "Sacar canción del TopMusic",
			"Subir puesto", "Bajar puesto", "Mostrar TopMusic", "Mostrar el Top", "Mostrar Top 10" });
	static Lista listaMusica = new Lista();
	static int posicion;

	public static void main(String[] args) {

		int opcion;

		do {
			opcion = menu.gestionar();

			switch (opcion) {

			case 1:
				annadir();
				break;

			case 2:
				sacar();
				break;

			case 3:
				subir();
				break;

			case 4:
				bajar();
				break;

			case 5:
				try {
					listaMusica.isEmpty();
					System.out.println(listaMusica.toString());
				} catch (ListaVaciaException e) {
					
					System.err.println(e.getMessage());
				}
				break;

			case 6:
				mostrarTop();
				break;
			case 7:
				mostrarTop10();
				break;

			default:
				System.out.println("Adios.");

			}

		} while (opcion != menu.getNumOpciones());
	}

	private static void mostrarTop10() {
		try {
			listaMusica.isEmpty();
			System.out.println(listaMusica.top10().toString());
			
		} catch (ListaVaciaException e) {
			
			System.err.println(e.getMessage());
		}
		

	}

	private static void annadir() {
		try {
			posicionValida();
			Cancion.getInstance(Teclado.leerCadena("Título de la canción a añadir: "),
					Teclado.leerCadena("Artista/grupo de la canción a añadir: "),
					Teclado.leerEntero("Año de grabacion de la cancion a añadir: "));
			System.out.println("La cancion se ha creado correctamente.");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static boolean posicionValida() throws PosicionNoValidaException {
		posicion = Teclado.leerEntero(
				"introduce la posicion que desea insertar la cancion entre 1 y " + (listaMusica.size() + 1)) - 1;
		if (posicion < 0 || posicion > listaMusica.size())
			throw new PosicionNoValidaException("La posicion no es válida");
		return true;

	}

	private static void sacar() {

		try {
			listaMusica.isEmpty();
			System.out.println(listaMusica.toString());
			listaMusica.sacar((Teclado.leerEntero("Posición de la canción que se va a eliminar: ") - 1));
		} catch (ListaVaciaException e) {
			System.err.println(e.getMessage());
		}catch(NoSePuedeEliminarException e){
			System.err.println(e.getMessage());
		}
		
	}

	private static void subir() {

		try {

			listaMusica.isEmpty();
			System.out.println(listaMusica
					.subirPuesto((Teclado.leerEntero("Posición de la canción que va a subir un puesto: ") - 1)));
		} catch (ListaVaciaException | NoPuedeSubirMasException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void bajar() {
		try {
			listaMusica.isEmpty();
			System.out.println(
				listaMusica.bajarPuesto((Teclado.leerEntero("Posición de la canción que va a bajar un puesto: ") - 1)));
			
		} catch (ListaVaciaException | NoSePuedeBajarMasException e) {
			
			System.err.println(e.getMessage());
		}
		
	}

	private static void mostrarTop() {
		try {
			listaMusica.isEmpty();
			System.out.println(listaMusica.Top());
		} catch (ListaVaciaException e) {
			
			System.err.println(e.getMessage());
		}
		
	}
}