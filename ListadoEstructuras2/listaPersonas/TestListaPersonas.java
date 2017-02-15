package listaPersonas;

import java.util.ArrayList;

/**
 * 1. Entrega la clase TestListaPersonas que haga lo siguiente: a. Cree una
 * lista (ArrayList) de personas. ArrayList<Persona> listaPersonas = new
 * ArrayList<Persona>();//Generics b. Añada tres personas a la lista (3
 * elementos). c. Muestre la lista. (implementa toString() en Persona) d.
 * Elimine el último elemento. e. Muestre la lista. f. Elimine el primer
 * elemento. g. Muestre la lista. La persona tiene al menos nombre y apellidos
 * 
 * @author Daniel Gestino Notario
 *
 */
public class TestListaPersonas {

	public static void main(String[] args) {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

		listaPersonas.add(new Persona("Pepe", "Montalban"));
		listaPersonas.add(new Persona("Juanito", "Calvicie"));
		listaPersonas.add(new Persona("Paco", "Peluca"));

		System.out.println(listaPersonas.toString());

		listaPersonas.remove(listaPersonas.size() - 1);

		System.out.println(listaPersonas.toString());

		listaPersonas.remove(0);

		System.out.println(listaPersonas.toString());
	}

}
