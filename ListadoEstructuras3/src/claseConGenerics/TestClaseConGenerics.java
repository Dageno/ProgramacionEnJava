package claseConGenerics;

/**
 * 1. Explica con tus propias palabras qué es una clase parametrizada (definida
 * con Generics)
 * 
 * Una clase parametrizada es aquella que acepta todo tipo de objetos dentro de la clase, propia del 
 * envoltorio arraylist.
 * 
 * 2. Reproduce una clase con Generics. Llámala ClaseConGenerics. Entrega su
 * esqueleto donde: a. Definas una variable de objeto. Ha de ser una colección
 * homogénea (del tipo parametrizado de la clase) b. Definas un constructor
 * donde instancies el atributo anterior c. Definas un método metodo1 cuyo
 * parámetro sea del tipo parametrizado d. Definas un método metodo2 cuyo valor
 * devuelto sea del tipo parametrizado
 * 
 * @author d16genod
 *
 */
public class TestClaseConGenerics {
	@SuppressWarnings("rawtypes")
	static ClaseConGenerics lista = new ClaseConGenerics();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		lista.add(new String("Hola mundo"));
		lista.add(new Integer(4));
		System.out.println(lista.get(0));
		System.out.println(lista.get(1));

	}

}
