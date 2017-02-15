package cola;

/**
 * Crea una clase gen�rica Cola (debe de aceptar cualquier tipo de objeto
 * concreto, utiliza generics). Recuerda que has de evitar la interacci�n con el
 * usuario dentro de Cola. Utilizando generics, implementa las operaciones
 * b�sicas de una estructura de datos cola. Recuerda que una cola es una
 * estructura FIFO donde el primer elemento en entrar es el primero en salir. Un
 * ejemplo b�sico de cola es la de la taquilla de un cine. Las operaciones a
 * implementar son: a. Crear una cola. b. Introducir elemento en la cola
 * (a�adir/enqueue) c. Sacar elemento de la cola (extraer/dequeue) d. Cabeza de
 * la cola. (devuelve el primer elemento de la cola, cabeza o front) Implementa
 * los m�todos necesarios, y recuerda hacer las pruebas precisas. Para ello,
 * crea una clase TestCola donde se a�adan muchos elementos de una clase creada
 * en el mismo fichero (Persona, Paciente, Cartas...) y se invoquen a todos los
 * m�todos. Al final, vac�a la cola con un bucle while que extraiga de la cola
 * hasta que se vac�e.
 * 
 * @author Daniel Gestino Notario
 * @version 1.0
 *
 */

import java.util.ArrayList;

public class Cola<T> {
	
	ArrayList<T> cola = null;
	
	Cola(){
		this.cola = new ArrayList<T>();
	}
	
	void push(T elemento){
		cola.add(elemento);
	}
	
	
	T pop(){
		if(cola.size()==0)
			return null;
		return cola.remove(0);
	}
	

	T head(){
		if(cola.size()==0)
			return null;
		return cola.get(0);
	}
	
	@Override
	public String toString() {
		String cadena= "";
		for(int i = 0; i<cola.size();i++){
			cadena += "Elemento "+ i +" "+ cola.get(i) + "\n";
		}
		
		return cadena ;
	}
}
