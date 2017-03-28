package mamiferos;

public class Perro extends Mamifero{


	
	private static final int PATAS = 4;
	public Perro(String nombre) {
		super(nombre, PATAS);
	}
	@Override
		public String toString() {
			return getClass().getSimpleName()+", Nombre: " + super.getNombre() + ", patas " + super.getPatas()+ " y ladra";
		}

}
