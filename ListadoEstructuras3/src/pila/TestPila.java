package pila;

public class TestPila {
	
	
	
	@SuppressWarnings("rawtypes")
	static Pila pila = new Pila();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		pila.push(new Integer("54"));
		pila.push(new String("San jacobo"));
		pila.push(new Persona("Manuel Garrido"));
		pila.push(new Paciente("Genario"));
		pila.push(new Carta("BASTOS", 7));
		
		
		System.out.println(pila.toString());
		System.out.println(pila.getTop());
		pila.pop();
		System.out.println(pila.toString());

	}

}

class Persona{
	private String nombre;
	public Persona(String nombre){
		setNombre(nombre);
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	String getNombre(){
		return nombre;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  getNombre();
	}
}

class Paciente{
	private String nombre;
	public Paciente(String nombre){
		setNombre(nombre);
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  getNombre();
	}
	String getNombre(){
		return nombre;
		
	}
}

class Carta{
	private String Palo;
	private int Figura;
	
	public Carta(String Palo, int Figura) {
		setPalo(Palo);
		setFigura(Figura);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Figura;
		result = prime * result + ((Palo == null) ? 0 : Palo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (Figura != other.Figura)
			return false;
		if (Palo == null) {
			if (other.Palo != null)
				return false;
		} else if (!Palo.equals(other.Palo))
			return false;
		return true;
	}

	public int getFigura() {
		return Figura;
	}
	public void setFigura(int figura) {
		Figura = figura;
	}
	public String getPalo() {
		return Palo;
	}
	public void setPalo(String palo) {
		Palo = palo;
	}

	@Override
	public String toString() {
		return "Carta " + getFigura()+ " de "+getPalo();
	}
	
}







