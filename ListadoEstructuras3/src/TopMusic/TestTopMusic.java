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
* @version 1.0
*
*/

import utiles.*;

public class TestTopMusic {
	
	static Menu menu = new Menu("TopMusic", new String[]{"A�adir canci�n", "Sacar canci�n del TopMusic",
			"Subir puesto", "Bajar puesto", "Mostrar TopMusic", "Mostrar el Top"});
	static Lista listaMusica = new Lista();
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
				System.out.println(listaMusica.toString());
				break;

			case 6:
				mostrarTop();
				break;

			default:
				System.out.println("Adios.");
				
			
				
			}

		} while (opcion != 7);
	}

	
	private static void annadir() {
		listaMusica.add(Teclado.leerCadena("T�tulo de la canci�n a a�adir: "), Teclado.leerCadena("Artista/grupo de la canci�n a a�adir: "),
				Teclado.leerEntero("A�o de grabaci�n de la canci�n a a�adir: "));
	}

	
	private static void sacar() {
		System.out.println(listaMusica.toString());
		listaMusica.sacar((Teclado.leerEntero("Posici�n de la canci�n que se va a eliminar: ")-1));
	}

	
	private static void subir() {
		System.out.println(listaMusica.toString());
		listaMusica.subirPuesto((Teclado.leerEntero("Posici�n de la canci�n que va a subir un puesto: ")));
	}

	
	private static void bajar() {
		listaMusica.bajarPuesto((Teclado.leerEntero("Posici�n de la canci�n que va a bajar un puesto: ")));
	}

	private static void mostrarTop() {
		System.out.println(listaMusica.Top());
	}
}