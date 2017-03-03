package utiles;

import utiles.Teclado;

public class Menu {
	String TITULO;
	String[] opciones;
	int numOpciones;
	
	public Menu(String titulo, String []opciones){
		setTITULO(titulo);
		setOpciones(opciones);
		setNumOpciones(opciones.length);
	}
	public int gestionar(){
		mostrar();
		return recogerOpcion();
	}
	private int recogerOpcion(){
		
		int opcionSeleccionada = 0;
		
		do{
			opcionSeleccionada = Teclado.leerEntero("Introduce una opción válida: ");
			
			if(opcionSeleccionada>(numOpciones+1) || opcionSeleccionada<1)
				System.out.print("Error. ");
			
		}while(opcionSeleccionada>(numOpciones+1) || opcionSeleccionada<1);
		return opcionSeleccionada;
	}
	
	private void mostrar(){
		System.out.println(TITULO);
		for(int i = 0; i<numOpciones;i++)
			System.out.println((i+1)+". "+opciones[i]);
		System.out.println((numOpciones+1)+". Salir");
		
	}
	public int getNumOpciones() {
		return numOpciones+1;
	}
	private void setNumOpciones(int numOpciones) {
		this.numOpciones = numOpciones;
	}
	@SuppressWarnings("unused")
	private  String getTITULO() {
		return TITULO;
	}

	private void setTITULO(String tITULO) {
		TITULO = tITULO;
	}

	@SuppressWarnings("unused")
	private String[] getOpciones() {
		return opciones;
	}

	private void setOpciones(String[] opciones) {
		this.opciones = opciones;
		
	}
}