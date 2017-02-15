package listaCompra;

/**
* ListaDeLaCompra. Implementa un programa que gestione una lista de la compra de
* forma automática. Se dispondrá de una lista de artículos y de sus existencias. En el
* momento en el que la cantidad de artículos llegue a un límite mínimo, dicho artículo
* aparecerá en la lista de la compra. Cada vez que el usuario utilice uno de los artículos
* se decrementarán las existencias de dicho artículo. De igual forma, cada vez que el
* usuario compre el artículo, se incrementarán las existencias de dicho artículo.
* A modo de ejemplo, supongamos que del artículo "latas de cerveza" se establece a un
* mínimo de 10 cervezas. Actualmente hay 14 y se consumen de golpe 5 cervezas.
* a. Artículo: [nombre = latas de cerveza, cantidad mínima= 10, existencias = 14]
* b. articulo.consumir(5)
* c. Artículo: [nombre = latas de cerveza, cantidad mínima= 10, existencias = 9]
* d. Como (articulo.getExistencias() <= articulo.getCantidadMin()) hay que comprar
* latas de cerveza.
* Quizás sea interesante añadir un campo código del artículo para facilitar la gestión de
* la lista. Este código ha de ser único (static...)
* Para ello, genera un interfaz con el usuario que permita entre otras acciones:
* e. Añadir un producto nuevo a la lista.
* f. Eliminar un elemento de la lista.
* g. Incrementar las existencias de un artículo.
* h. Decrementar las existencias de un artículo.
* i. Modificar la cantidad mínima del artículo.
* j. Mostrar la lista de todos los artículos.
* k. Mostrar la lista de la compra.
* Comienza analizando el diseño. Piensa en el total de clases que vas a utilizar y
* aprovecha aquellas clases que puedas.
*
* @author Daniel GEstino Notario
* @version 1.0
* 
*/

import utiles.Menu;
import utiles.Teclado;

public class TestListaDeLaCompra {
	static ListaDeLaCompra lista = new ListaDeLaCompra();
	static Menu menu = new Menu("Lista de la compra",
			new String[] { "Añadir elemento", "Eliminar elemento", "Incrementar existencias", "Decrementar existencias",
					"Modificar cantidad mínima", "Mostrar todos los artículos", "Mostrar lista de la compra"});

	public static void main(String[] args) {
		int opcion;

		do {
			opcion = menu.gestionar();

			switch (opcion) {
			case 1:
				anadirArticulo();
				break;
			case 2:
				eliminarArticulo();
				break;
			case 3:
				incrementarExistencias();
				break;
			case 4:
				decrementarExistencias();
				break;
			case 5:
				modificarCantidadMinima();
				break;
			case 6:
				System.out.println(lista);
				break;
			case 7:
				System.out.println(lista.generarListaDeLaCompra());
				break;
			case 8:
				System.out.println("\nAdios");
				break;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}
		} while (opcion != 8);
	}

	private static void anadirArticulo() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del artículo: ");
		int existencias = Teclado.leerEntero("Introduzca las existencias del artículo: ");
		int minimo = Teclado.leerEntero("Introduzca la cantidad mínima: ");

		Articulo articulo;
		articulo = new Articulo(nombre, existencias, minimo);
		lista.anadir(articulo);
	}

	private static void eliminarArticulo() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del artículo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.eliminar(articulo);

	}

	private static void incrementarExistencias() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del artículo: ");
		int incremento = Teclado.leerEntero("Introduzca el incremento del artículo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.incrementarExistencias(articulo, incremento);
	}

	private static void decrementarExistencias() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del artículo: ");
		int incremento = Teclado.leerEntero("Introduzca el decremento del artículo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.decrementarExistencias(articulo, incremento);

	}

	private static void modificarCantidadMinima() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del artículo: ");
		int cantidad = Teclado.leerEntero("Introduzca la cantidad mínima del artículo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.setCantidadMinima(articulo, cantidad);

	}

}
