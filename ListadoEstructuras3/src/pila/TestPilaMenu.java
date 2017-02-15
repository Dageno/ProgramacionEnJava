package pila;

import utiles.*;

public class TestPilaMenu {
	static boolean pilaCreada = false;
	@SuppressWarnings("rawtypes")
	static Pila pilaPalabras = null;
	static Menu menu = new Menu("Pila",
			new String[] { "Crear pila", "Introducir elemento en la pila (al final)",
					"Sacar elemento de la pila (el último)", "Mostrar cima de la lista (último elemento de la lista)"});
	static MenuSinSalir menuAnnadir= new MenuSinSalir("Menu para añadir a la pila", new String[]{"Persona", "Carta", "Paciente"});

	public static void main(String[] args) {
		
		
		
		int opcion;
	
		
		do{
			opcion=menu.gestionar();
			switch(opcion){
			case 1:
				pilaPalabras = crear();								
				break;
			
			case 2:
				annadir();
				break;
				
			case 3:
				sacar();
				break;
				
			case 4:
				cima();
				break;
				
			default:
				System.out.println("Saliendo de programa.");
			}
			
		}while(opcion!=5);		

	}

	@SuppressWarnings("rawtypes")
	static Pila crear() {
		pilaCreada = true;
		return new Pila();

	}

	static void error() {
		System.out.println("Error. Opción inválida.");
	}

	
	@SuppressWarnings("unchecked")
	static void annadir() {

		if (!pilaCreada)
			System.out.println("Primero tiene que crear la pila.");
		else{
			int opcion;
			
			
			do{
				opcion=menuAnnadir.gestionar();
				switch(opcion){
				case 1:
					pilaPalabras.push(new Persona(Teclado.leerCadena("Introduce el nombre de la persona: ")));
					return;
				
				case 2:
					pilaPalabras.push(new Carta(Teclado.leerCadena("Introduce el palo: "), Teclado.leerEntero("Introduce el numero de la carta:")));
					return;
					
				default:
					pilaPalabras.push(new Persona(Teclado.leerCadena("Introduce el nombre del paciente: ")));
					return;
				}
				
			}while(true);	
		}
	}

	static void sacar() {
		if (!pilaCreada) {
			System.out.println("Primero tiene que crear la pila.");
			return;
		} else if (pilaPalabras.getTop() == null)
			System.out.println("Pila vacía.");
		else
			System.out.println("Sacado el primer elemento." + pilaPalabras.toString());
	}

	
	static void cima() {
		if (pilaPalabras == null)
			System.out.println("Primero tiene que crear la pila.");
		else if (pilaPalabras.getTop() == null)
			System.out.println("Pila vacía.");
		else
			System.out.println(pilaPalabras.getTop());
	}


}