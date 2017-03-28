package vehiculos;

public class Coche extends Vehiculo{
	
	static final int ruedas = 4;
	public Coche(String nombre) {
		super(nombre, ruedas);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+",  nombre=" + super.getNombre() +" ruedas=" + super.getRuedas() ;
	}

}
