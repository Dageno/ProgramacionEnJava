package Fecha;

import java.util.Calendar;
import java.util.Date;

import utiles.Teclado;

public class TestFecha {

	public static void main(String[] args) throws FechaTranscurridaException, FormatoFechaNoValido {
		Fecha fecha = new Fecha("07/03/1993");
		System.out.println(fecha.cal.getTime());
		System.out.println(fecha.toString());

		sumar(fecha);
		diaSemana(fecha);
		mesAnno(fecha);
		tiempoTranscurrido(fecha);

	}

	private static void tiempoTranscurrido(Fecha fecha) throws FormatoFechaNoValido{
		try{
			String cadeno = Teclado.leerCadena("Introduce una fecha correcta: ");
			long dias_transcurridos=fecha.tiempoTranscurridoDi(new Fecha(cadeno));
			long annos_transcurridos = fecha.tiempoTranscurridoAnnos(new Fecha(cadeno));
			System.out.println("Han transcurrido "+annos_transcurridos+" años,  o "+dias_transcurridos+" días.");
		}catch(FormatoFechaNoValido e){
			System.out.println(e.getMessage());
		}
		

	}

	private static void mesAnno(Fecha fecha) {

		switch (fecha.getMes()) {

		case 0:
			System.out.println("Enero");
			break;

		case 1:
			System.out.println("Febrero");
			break;

		case 2:
			System.out.println("Marzo");
			break;

		case 3:
			System.out.println("Abril");
			break;

		case 4:
			System.out.println("Mayo");
			break;

		case 5:
			System.out.println("Junio");
			break;

		case 6:
			System.out.println("Julio");
			break;

		case 7:
			System.out.println("Agosto");
			break;

		case 8:
			System.out.println("Septiembre");
			break;

		case 9:
			System.out.println("Octubre");
			break;

		case 10:
			System.out.println("Noviembre");
			break;

		case 11:
			System.out.println("Diciembre");
			break;
		}
	}

	@SuppressWarnings("static-access")
	private static void diaSemana(Fecha fecha) {
		switch (fecha.cal.get(Calendar.DAY_OF_WEEK)) {

		case 1:
			System.out.println("Domingo");
			break;

		case 2:
			System.out.println("Lunes");
			break;

		case 3:
			System.out.println("Martes");
			break;

		case 4:
			System.out.println("Miércoles");
			break;

		case 5:
			System.out.println("Jueves");
			break;

		case 6:
			System.out.println("Viernes");
			break;

		case 7:
			System.out.println("Sábado");
			break;
		}

	}

	private static void sumar(Fecha fecha) {

		Fecha fech = fecha.sumarFechas(new Fecha(29, 03, 1993));
		System.out.println(fech.toString());

	}

}
