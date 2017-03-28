package estudiantes;

public class Estudiante extends Persona{
	
	
	private Curso curso;
	
	public Estudiante(String nombre, String apellidos, String nif, Curso curso) {
		super(nombre, apellidos, nif);
		setCurso(curso);
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return super.toString()+" curso: " + getCurso();
	}
	
	

}
