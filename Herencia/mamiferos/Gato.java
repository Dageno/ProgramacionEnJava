package mamiferos;

public class Gato extends Mamifero{

	
	private static final int PATAS = 4;
	
	public Gato(String nombre) {
		super(nombre, PATAS);
	}
	@Override
		public String toString() {
			return getClass().getSimpleName()+", Nombre: " + super.getNombre() + ", patas " + super.getPatas()+ " y maulla";
		}
}
