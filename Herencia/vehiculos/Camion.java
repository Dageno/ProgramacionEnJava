package vehiculos;

public class Camion extends Vehiculo{
	
	
	static final int ruedas = 8;
	
	public Camion(String nombre) {
		super(nombre, ruedas);
	}
	
	
	@Override
		public String toString() {
			return getClass().getSimpleName()+", nombre=" + super.getNombre() + " ruedas=" + super.getRuedas();
		}

}
