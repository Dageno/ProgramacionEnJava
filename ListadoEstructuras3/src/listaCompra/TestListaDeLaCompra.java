package listaCompra;

/**
* ListaDeLaCompra. Implementa un programa que gestione una lista de la compra de
* forma autom�tica. Se dispondr� de una lista de art�culos y de sus existencias. En el
* momento en el que la cantidad de art�culos llegue a un l�mite m�nimo, dicho art�culo
* aparecer� en la lista de la compra. Cada vez que el usuario utilice uno de los art�culos
* se decrementar�n las existencias de dicho art�culo. De igual forma, cada vez que el
* usuario compre el art�culo, se incrementar�n las existencias de dicho art�culo.
* A modo de ejemplo, supongamos que del art�culo "latas de cerveza" se establece a un
* m�nimo de 10 cervezas. Actualmente hay 14 y se consumen de golpe 5 cervezas.
* a. Art�culo: [nombre = latas de cerveza, cantidad m�nima= 10, existencias = 14]
* b. articulo.consumir(5)
* c. Art�culo: [nombre = latas de cerveza, cantidad m�nima= 10, existencias = 9]
* d. Como (articulo.getExistencias() <= articulo.getCantidadMin()) hay que comprar
* latas de cerveza.
* Quiz�s sea interesante a�adir un campo c�digo del art�culo para facilitar la gesti�n de
* la lista. Este c�digo ha de ser �nico (static...)
* Para ello, genera un interfaz con el usuario que permita entre otras acciones:
* e. A�adir un producto nuevo a la lista.
* f. Eliminar un elemento de la lista.
* g. Incrementar las existencias de un art�culo.
* h. Decrementar las existencias de un art�culo.
* i. Modificar la cantidad m�nima del art�culo.
* j. Mostrar la lista de todos los art�culos.
* k. Mostrar la lista de la compra.
* Comienza analizando el dise�o. Piensa en el total de clases que vas a utilizar y
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
			new String[] { "A�adir elemento", "Eliminar elemento", "Incrementar existencias", "Decrementar existencias",
					"Modificar cantidad m�nima", "Mostrar todos los art�culos", "Mostrar lista de la compra"});

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

		String nombre = Teclado.leerCadena("Introduzca el nombre del art�culo: ");
		int existencias = Teclado.leerEntero("Introduzca las existencias del art�culo: ");
		int minimo = Teclado.leerEntero("Introduzca la cantidad m�nima: ");

		Articulo articulo;
		articulo = new Articulo(nombre, existencias, minimo);
		lista.anadir(articulo);
	}

	private static void eliminarArticulo() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del art�culo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.eliminar(articulo);

	}

	private static void incrementarExistencias() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del art�culo: ");
		int incremento = Teclado.leerEntero("Introduzca el incremento del art�culo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.incrementarExistencias(articulo, incremento);
	}

	private static void decrementarExistencias() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del art�culo: ");
		int incremento = Teclado.leerEntero("Introduzca el decremento del art�culo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.decrementarExistencias(articulo, incremento);

	}

	private static void modificarCantidadMinima() {

		String nombre = Teclado.leerCadena("Introduzca el nombre del art�culo: ");
		int cantidad = Teclado.leerEntero("Introduzca la cantidad m�nima del art�culo: ");

		Articulo articulo;
		articulo = new Articulo(nombre);
		lista.setCantidadMinima(articulo, cantidad);

	}

}
