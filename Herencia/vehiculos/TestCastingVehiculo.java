package vehiculos;

public class TestCastingVehiculo {

	public static void main(String[] args){
		Vehiculo vehiculo = new Vehiculo("Opel", 4);
		Coche coche = new Coche("Mercedes");
		Camion camion = new Camion("Cañonero");
		
		System.out.println(((Vehiculo)(coche)).toString());
		System.out.println((Vehiculo)(camion));
		
//		System.out.println((Coche)(vehiculo));
//		System.out.println((Coche)(camion));
		
//		System.out.println((Camion)(vehiculo));
//		System.out.println((Camion)(coche));
	}

}
