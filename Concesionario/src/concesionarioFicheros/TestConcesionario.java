package concesionarioFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import utiles.Menu;
import utiles.Teclado;

//P: indica las etiquetas html utilizadas para la documentación de la clase
//P: Indica la utilidad de la etiqueta  -noqualifier  all a la hora de generar la documentación JavaDoc. Entrega un pantallazo indicando cómo se detalla en Eclipse
/**
 * Concesionario de coches con Ficheros
 * 
 * 
 * @author Daniel Gestino Notario
 *
 */

public class TestConcesionario extends Concesionario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Menú principal de la aplicación
	 */
	static Menu menu = new Menu("Concesionario de coches", new String[] { "Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario", "Mostrar coches de un color", "Ficheros" });
	/**
	 * Menú para seleccionar los colores del coche
	 */
	private static Menu menuColores = new Menu("Colores de los coches", Color.AZUL.generarOpcionesMenu());

	/**
	 * Menú para seleccionar los modelos del coche
	 */
	private static Menu menuModelos = new Menu("Modelos de los coches", Modelo.CORDOBA.generarOpcionesMenu());

	private static Menu Ficheros = new Menu("Fichero de concesionario", new String[] { "Nuevo Concesionario",
			"Abrir Concesionario", "Guardar actual Concesionario4" + "", "Guardar como" });
	/**
	 * Donde se gestionará el concesionario
	 */
	static Concesionario concesionario = new Concesionario();

	/**
	 * Arranque del programa
	 * 
	 * @param args
	 *            No se utilizan
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		do {
			switch (menu.gestionar()) {
			case 1:// "Añadir Coche
				annadirCoche();
				break;
			case 2:// Eliminar Coche
				eliminarCoche();
				break;
			case 3:
				modificarCoche();
				break;
			case 4:// Obtener Coche
				getCoche();
				break;
			case 5:// Mostrar lista
				System.out.println(concesionario);
				break;
			case 6:// Contar coches
				System.out.println("Número de coches en el concesionario: " + concesionario.size());
				break;
			case 7:// Mostrar coches de un color
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;
			case 8:// ficheros
				creacionFicheros();
				break;
			default:// Salir
				System.out.println("Aaaaaaaaaaaaaaaaaaaaadios");
				System.out.println(Gestion.modificado);
				return;
			}

		} while (true);

	}

	private static void modificarCoche() {
		try {
			Coche modificado = concesionario.get(Teclado.leerCadena("Introduce la matrícula"));
			modificado.modificarColor(pedirColor());
			concesionario.modificar(modificado);
			Gestion.setModificado(true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static void creacionFicheros() throws FileNotFoundException, IOException, ClassNotFoundException {

		do {

			switch (Ficheros.gestionar()) {
			case 1:// Nuevo
				Gestion.nuevo(concesionario);
				break;
			case 2:// Abrir
				concesionario = Gestion.abrir(
						new File(Teclado.leerCadena("Introduce el nombre del fichero que desea abrir:")),
						concesionario);
				break;
			case 3:// Guardar
				Gestion.guardar(concesionario);
				break;
			case 4:// GuardarComo
				Gestion.guardarComo(
						new File(Teclado.leerCadena("Introduce el nombre del fichero en el que desea guardar:")),
						concesionario);
				break;
			default:// Salir
				return;
			}
		} while (true);

	}

	/**
	 * Muestra por consola el coche solicitando su la matrícula
	 */
	private static void getCoche() {
		// Coche coche;
		try {
			System.out.println(concesionario.get(Teclado.leerCadena("Introduce la matrícula")));

		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			System.out.println(e.getMessage());
		}
		// if (coche == null)
		// System.out.println("No existe el coche en el concesionario.");
		// else
		// System.out.println(coche);
	}

	/**
	 * Elimina un coche solicitando su la matrícula
	 */
	private static void eliminarCoche() {
		try {
			if (concesionario.eliminar(Teclado.leerCadena("Introduce la matrícula"))) {
				System.out.println("Coche eliminado");
				Gestion.setModificado(true);
			} else
				System.out.println(
						"El coche no se ha podido eliminar. No existe un coche con esa matrícula en el concesionario");
		} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage() + "No se ha podido eliminar el coche en el concesionario");
		}
	}

	/**
	 * Añade un coche solicitando sus datos por consola
	 */
	private static void annadirCoche() {

		try {
			concesionario.annadir(Teclado.leerCadena("Introduce la matrícula"), pedirColor(), pedirModelo());
			System.out.println("Coche añadido con éxito");
			Gestion.setModificado(true);

		} catch (Exception e) {
			System.out.println(e.getMessage() + "No se ha podido añadir el coche en el concesionario");
		}

		// else
		// System.out.println("No se ha podido añadir");
	}

	/**
	 * Solicita al usuario un modelo de coche Según el enunciado del examen:
	 * 
	 * <pre>
	 * Para solicitar el Modelo al dar de alta al coche se implementará un método
	 * pedirModelo que mediante la gestión de un menú, devolverá el modelo indicado
	 * </pre>
	 * 
	 * @return modelo introducido por el usuario. null si el usuario no
	 *         introduce ninguno válido
	 */
	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionar();
		Modelo[] arrModelos = Modelo.CORDOBA.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}

	/**
	 * Solicita al usuario un color de coche. Según el enunciado del examen:
	 * 
	 * <pre>
	 * Para solicitar el color al dar de alta al coche se implementará un método
	 * pedirColor que mediante la gestión de un menú, devolverá el color indicado
	 * </pre>
	 * 
	 * @return color introducido por el usuario. null si el usuario no introduce
	 *         ninguno válido
	 */
	private static Color pedirColor() {
		int opcion = menuColores.gestionar();
		Color[] arrColores = Color.AZUL.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}

	public static boolean deseaGuardar(String msg) {
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		char c;
		do {
			c = sc.nextLine().charAt(0);
			if (c == 'y')
				return true;
			else if (c == 'n')
				return false;
			else
				System.err.println("Opcion incorrrecta.");
		} while (c != 'y' || c != 'n');
		return false;

	}
}