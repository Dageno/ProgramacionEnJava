package cola;

import utiles.*;

public class TestColaMenu {
	static boolean colaCreada = false;
	@SuppressWarnings("rawtypes")
	static Cola colaPalabras = null;
	static Menu menu = new Menu("Cola",
			new String[] { "Crear cola", "Introducir elemento en la pila (al final)",
					"Sacar elemento de la cola (Primer elemento)", "Mostrar cima de la lista (Primero de la lista)"});
	static MenuSinSalir menuAnnadir= new MenuSinSalir("Menu para añadir a la cola", new String[]{"Persona", "Carta", "Paciente"});

	public static void main(String[] args) {
		
		
		
		int opcion;
	
		
		do{
			opcion=menu.gestionar();
			switch(opcion){
			case 1:
				colaPalabras = crear();								
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
	static Cola crear() {
		colaCreada = true;
		return new Cola();

	}

	static void error() {
		System.out.println("Error. Opción inválida.");
	}

	
	@SuppressWarnings("unchecked")
	static void annadir() {

		if (!colaCreada)
			System.out.println("Primero tiene que crear la pila.");
		else{
			int opcion;
			
			
			do{
				opcion=menuAnnadir.gestionar();
				switch(opcion){
				case 1:
					colaPalabras.push(new Persona(Teclado.leerCadena("Introduce el nombre de la persona: ")));
					return;
				
				case 2:
					colaPalabras.push(new Carta(Teclado.leerCadena("Introduce el palo: "), Teclado.leerEntero("Introduce el numero de la carta:")));
					return;
					
				default:
					colaPalabras.push(new Persona(Teclado.leerCadena("Introduce el nombre del paciente: ")));
					return;
				}
				
			}while(true);	
		}
	}

	static void sacar() {
		if (!colaCreada) {
			System.out.println("Primero tiene que crear la pila.");
			return;
		} else if (colaPalabras.head() == null)
			System.out.println("Cola vacía.");
		else
			System.out.println("Sacado el primer elemento." + colaPalabras.toString());
	}

	
	static void cima() {
		if (colaPalabras == null)
			System.out.println("Primero tiene que crear la pila.");
		else if (colaPalabras.head() == null)
			System.out.println("Cola vacía.");
		else
			System.out.println(colaPalabras.head());
	}


}