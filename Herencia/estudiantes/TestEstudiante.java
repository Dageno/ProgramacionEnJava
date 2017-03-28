package estudiantes;

public class TestEstudiante {

	public static void main(String[] args) {
		Persona persona = new Persona("Pepe", "Fernandez", "30993145R");
		Persona persona1 = new Persona("Paco", "Fernandez", "30993145P");
		
		Estudiante estudiante = new Estudiante("Dani", "Gestino", "31993145R", Curso.BACHILLERATO);
		Estudiante estudiante1 = new Estudiante("Rufa", "Mullado", "30943145R", Curso.UNIVERSIDAD);
		
		persona = estudiante;
		
		persona.getApellidos();
		persona.getNif();
		
		//Solo puedes acceder a los métodos del padre.
		estudiante1 = (Estudiante) persona1;
		
		estudiante1.setCurso(Curso.ESO);
		estudiante.getNombre();
		
		//Podemos acceder tanto a los metodos del hijo (Estudiante) como a los del padre (Persona)

	}

}
