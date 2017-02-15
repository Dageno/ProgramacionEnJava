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
* @version 1.0
*
*/

import utiles.*;

public class TestTopMusic {
	
	static Menu menu = new Menu("TopMusic", new String[]{"Añadir canción", "Sacar canción del TopMusic",
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
		listaMusica.add(Teclado.leerCadena("Título de la canción a añadir: "), Teclado.leerCadena("Artista/grupo de la canción a añadir: "),
				Teclado.leerEntero("Año de grabación de la canción a añadir: "));
	}

	
	private static void sacar() {
		System.out.println(listaMusica.toString());
		listaMusica.sacar((Teclado.leerEntero("Posición de la canción que se va a eliminar: ")-1));
	}

	
	private static void subir() {
		System.out.println(listaMusica.toString());
		listaMusica.subirPuesto((Teclado.leerEntero("Posición de la canción que va a subir un puesto: ")));
	}

	
	private static void bajar() {
		listaMusica.bajarPuesto((Teclado.leerEntero("Posición de la canción que va a bajar un puesto: ")));
	}

	private static void mostrarTop() {
		System.out.println(listaMusica.Top());
	}
}