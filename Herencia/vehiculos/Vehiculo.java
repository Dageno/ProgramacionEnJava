package vehiculos;

public class Vehiculo {
	/** Función principal */
	int ruedas;
	private double velocidad = 0;
	String nombre;
	/** Constructor de Vehiculo */
	Vehiculo(String nombre, int ruedas){
		setNombre(nombre);
		setRuedas(ruedas);
		
	}
	public int getRuedas() {
		return ruedas;
	}
	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return getClass().getSimpleName()+", nombre=" + getNombre()+" ruedas=" + getRuedas() ;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	/** Aumenta la velocidad */
	public void acelerar(double cantidad) {
		velocidad += cantidad;
	}

	/** Disminuye la velocidad */
	public void frenar(double cantidad) {
		velocidad -= cantidad;
	}

	/** Devuelve la velocidad */
	public double obtenerVelocidad() {
		return velocidad;
	}

	public static void main(String args[]){
		Vehiculo miCoche = new Vehiculo("BMW", 4);
		Coche coche = new Coche("Nissan");
		Camion camion1 = new Camion("Cañonero");
		miCoche.acelerar(12);
		miCoche.frenar(5);
		System.out.println(miCoche.obtenerVelocidad());
		System.out.println(miCoche);
		System.out.println(coche);
		System.out.println(camion1);
	} 
}