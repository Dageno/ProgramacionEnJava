package pila;

import java.util.ArrayList;

/**
 * 3. Crea una clase genérica Pila (debe de aceptar cualquier tipo de objeto
 * concreto, utiliza generics). Recuerda que has de evitar la interacción con el
 * usuario dentro de Pila. Implementa las operaciones básicas de una estructura
 * de datos pila. Una pila es una estructura LIFO donde el último elemento en
 * entrar es el primero en salir. Un ejemplo básico de pila es la forma de
 * almacenamiento de procesos en la memoria. Las operaciones a implementar son:
 * a. Crear una pila. b. Introducir elemento en la pila (apilar o push) c. Sacar
 * elemento de la pila (extraer o pop) d. Cima de la pila (devuelve el elemento
 * de la cima de la pila o top) Implementa los métodos necesarios, y recuerda
 * hacer las pruebas precisas. Para ello, crea una clase TestPila donde se
 * añadan muchos elementos de una clase creada en el mismo fichero (Persona,
 * Paciente, Cartas...) y se invoquen a todos los métodos. Al final, vacía la
 * pila con un bucle de este estilo: while (!pila.IsEmpty())
 * System.out.println("Desapilo de la pila: " + p.pop());
 * 
 * @author d16genod
 *
 * @param <E>
 */
public class Pila<E> {
	ArrayList<E> pila;

	public Pila() {
		pila = new ArrayList<E>();
	}
	
	void push(E element){
		pila.add(0, element);
	}
	
	void pop(){
		
		 pila.remove(pila.size()-1);
		
	}
	
	@Override
	public String toString() {
		String cadena= "";
		for(int i = 0; i<pila.size();i++){
			cadena += "Elemento "+ i +" "+ pila.get(i) + "\n";
		}
		
		return cadena ;
	}

	@SuppressWarnings("unchecked")
	E getTop(){
		if(!pila.isEmpty())
			return pila.get(0);
		return (E) new String("No hay ningún elemento en la pila.");
	}

}
