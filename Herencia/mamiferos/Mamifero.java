package mamiferos;

public class Mamifero {
	
	private String nombre;
	private int patas;
	
	public Mamifero(String nombre, int patas) {
		setNombre(nombre);
		setPatas(patas);
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPatas() {
		return patas;
	}

	public void setPatas(int patas) {
		this.patas = patas;
	}

	@Override
	public String toString() {
		return " nombre:" + getNombre() + ", patas" + getPatas();
	}
	
	public static void main(String[] args){
		Gato gato = new Gato("Garfield");
		Perro perro = new Perro("Milú");
		
		System.out.println(gato);
		System.out.println(perro);
	}
	

}
