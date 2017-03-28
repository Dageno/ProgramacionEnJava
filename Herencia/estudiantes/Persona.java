package estudiantes;

public class Persona {

	private String nombre;
	private String apellidos;
	private String nif;

	public Persona(String nombre, String apellidos, String nif) {
		setNombre(nombre);
		setApellidos(apellidos);
		setNif(nif);
	}
	public String getNombre() {
			return nombre;
		}
	
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	
		public String getApellidos() {
			return apellidos;
		}
	
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
	
		public String getNif() {
			return nif;
		}
	
		public void setNif(String nif) {
			this.nif = nif;
		}
		@Override
		public String toString() {
			return getClass().getSimpleName()+" nombre=" + getNombre() + ", apellidos=" + getApellidos() + ", nif=" + getNif();
		}
}
