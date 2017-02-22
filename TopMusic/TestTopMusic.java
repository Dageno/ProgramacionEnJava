package TopMusic;

/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones m�s
* escuchadas. El usuario podr�:
* a. A�adir una canci�n (en una posici�n) al TopMusic.
* b. Sacar un elemento del TopMusic.
* c. Subir un puesto en el TopMusic.
* d. Bajar un puesto en el TopMusic.
* e. Mostrar la lista TopMusic.
* f. Mostrar la canci�n m�s escuchada.
* Sobre la canci�n se almacenar� el t�tulo, artista o grupo y a�o de grabaci�n
* 
* @author Daniel GEstino Notario
* @version 2.0
*
*/

import utiles.*;

public class TestTopMusic {

	static Menu menu = new Menu("TopMusic", new String[] { "A�adir canci�n", "Sacar canci�n del TopMusic",
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
				if (listaMusica.isEmpty())
					System.out.println("la lista est� vac�a");
				else
					System.out.println(listaMusica.toString());
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
		if (listaMusica.isEmpty()) {
			System.out.println("la lista est� vac�a");
			return;
		}
		System.out.println(listaMusica.top10().toString());

	}

	private static void annadir() {
		if (!posicionValida())
			System.out.println("Posicion incorrecta.");
		else
			if(listaMusica.add(posicion,
					Cancion.getInstance(Teclado.leerCadena("T�tulo de la canci�n a a�adir: "),
							Teclado.leerCadena("Artista/grupo de la canci�n a a�adir: "),
							Teclado.leerEntero("A�o de grabaci�n de la canci�n a a�adir: "))))
			System.out.println("La cancion se ha creado correctamente.");
			else
				System.out.println("La cancion no se ha creado debido a un error.");

	}

	private static boolean posicionValida() {
		posicion = Teclado.leerEntero(
				"introduce la posicion que desea insertar la cancion entre 1 y " + (listaMusica.size() + 1)) - 1;
		if (posicion < 0 || posicion > listaMusica.size())
			return false;
		return true;
		
	}

	private static void sacar() {
		if (listaMusica.isEmpty()) {
			System.out.println("la lista est� vac�a");
			return;
		}
		System.out.println(listaMusica.toString());
		listaMusica.sacar((Teclado.leerEntero("Posici�n de la canci�n que se va a eliminar: ") - 1));
	}

	private static void subir() {
		if (listaMusica.isEmpty()) {
			System.out.println("la lista est� vac�a");
			return;
		}

		System.out.println(
				listaMusica.subirPuesto((Teclado.leerEntero("Posici�n de la canci�n que va a subir un puesto: ") - 1)));
	}

	private static void bajar() {
		if (listaMusica.isEmpty()) {
			System.out.println("la lista est� vac�a");
			return;
		}
		System.out.println(
				listaMusica.bajarPuesto((Teclado.leerEntero("Posici�n de la canci�n que va a bajar un puesto: ") - 1)));
	}

	private static void mostrarTop() {
		if (listaMusica.isEmpty()) {
			System.out.println("la lista est� vac�a");
			return;
		}
		System.out.println(listaMusica.Top());
	}
}