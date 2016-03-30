package Fecha;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Fecha {

	private int dia;
	private int mes;
	private int anno;
	GregorianCalendar cal;
	private static final Pattern REGEX = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[- /](0?[1-9]|1[012])[-/]\\d{4}");

	Fecha(String cadena) throws FormatoFechaNoValido {

		Matcher regex = REGEX.matcher(cadena);
		esValido(regex, cadena);

	}

	private void esValido(Matcher regex, String cadena) throws FormatoFechaNoValido {
		if (regex.matches()) {
			setDia(cadena);
			setMes(cadena);
			setAnno(cadena);
			cal = new GregorianCalendar(anno, mes, dia);

		} else {
			throw new FormatoFechaNoValido("El formato de la fecha no es válido");
		}

	}

	Fecha(int dia, int mes, int anno) {
		setDia(dia);
		setMes(mes);
		setAnno(anno);
		cal = new GregorianCalendar(this.anno, this.mes, this.dia);
	}

	public Fecha(java.util.Date time) {
		dia = time.getDate();
		mes = time.getMonth();
		anno = time.getYear() + 1900;

		cal = new GregorianCalendar(anno, mes, dia);

	}

	private void setDia(int dia2) {

		dia = dia2;

	}

	private void setMes(int mes2) {

		mes = mes2 - 1;

	}

	private void setAnno(int anno2) {

		anno = anno2;

	}

	private void setDia(String cadena) {
		String num = cadena.substring(0, 2);
		dia = Integer.parseInt(num);

	}

	private void setMes(String cadena) {
		String num = cadena.substring(3, 5);
		mes = Integer.parseInt(num) - 1;

	}

	private void setAnno(String cadena) {
		String num = cadena.substring(6, 10);
		anno = Integer.parseInt(num);

	}

	
	Fecha sumarFechas(Fecha fecha) {
		GregorianCalendar sumada = new GregorianCalendar(fecha.anno, fecha.mes, fecha.dia);
		sumada.add(GregorianCalendar.DATE, dia);
		sumada.add(GregorianCalendar.MONTH, mes);
		sumada.add(GregorianCalendar.YEAR, anno);

		return new Fecha(sumada.getTime());
	}

	
	long tiempoTranscurridoDi(Fecha fecha) {

		LocalDate fecha1 = LocalDate.of(fecha.cal.get(GregorianCalendar.YEAR),
				fecha.cal.get(GregorianCalendar.MONTH) + 1, 
				fecha.cal.get(GregorianCalendar.DAY_OF_MONTH));

		LocalDate fecha2 = LocalDate.of(cal.get(GregorianCalendar.YEAR), 
				cal.get(GregorianCalendar.MONTH) + 1,
				cal.get(GregorianCalendar.DAY_OF_MONTH));

		return Math.abs(ChronoUnit.DAYS.between(fecha1, fecha2));

	}

	long tiempoTranscurridoAnnos(Fecha fecha) {

		LocalDate fecha1 = LocalDate.of(fecha.cal.get(GregorianCalendar.YEAR),
				fecha.cal.get(GregorianCalendar.MONTH) + 1, 
				fecha.cal.get(GregorianCalendar.DAY_OF_MONTH));

		LocalDate fecha2 = LocalDate.of(cal.get(GregorianCalendar.YEAR),
				cal.get(GregorianCalendar.MONTH) + 1,
				cal.get(GregorianCalendar.DAY_OF_MONTH));

		return Math.abs(ChronoUnit.YEARS.between(fecha1, fecha2));
	}

	@Override
	public String toString() {

		return "Fecha " + dia + "/" + (mes + 1) + "/" + anno;
	}

	public int getMes() {

		return mes;
	}

}
