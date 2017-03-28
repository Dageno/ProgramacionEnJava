package sieteYMedia;
/**
 * Clase carta que configura cada carta de la baraja española.
 * 
 * @author Daniel Gestino Notario
 * @version 2.0
 *
 */
public class Carta {
	/**
	 * Atributos de la Clase carta.
	 */
	private Figura figura;
	private Palo palo;
	private double valorCarta;

	/**
	 * Constructor propio de cada carta
	 * 
	 * @param palo
	 * @param figura
	 */
	public Carta(Palo palo, Figura figura) {
		setPalo(palo);
		setFigura(figura);
		setValorCarta(figura.getValor());
	}

	/**
	 * Nos guarda en valorCarta la puntuacion de cada carta, 1, 2, 3, 4, 5, 6,
	 * 7, 0'5
	 * 
	 * @param valorCarta
	 */
	private void setValorCarta(double valorCarta) {
		this.valorCarta = valorCarta;
	}

	/**
	 * Obtiene y devuelve el valorCarta
	 * 
	 * @return
	 */
	double getValorCarta() {
		return valorCarta;
	}
	/**
	 * Guarda el palo pasado por parámetro en nuestro atributo palo de la carta.
	 * @param palo
	 */
	private void setPalo(Palo palo) {
		this.palo = palo;
	}
	/**
	 * Guarda el valor de la figura escogida por parámetro
	 * @param figura
	 */
	private void setFigura(Figura figura) {
		this.figura = figura;
	}
	/**
	 * No devuelve una cadena de como se mostrara la carta.
	 */
	@Override
	public String toString() {
		return "\n" + figura + " de " + palo;
	}



}
/**
 * Enumeración figura con cada uno de los valores de la misma.
 * @author Daniel Gestino Notario
 *
 */
enum Figura {
	AS(1.0), DOS(2.0), TRES(3.0), CUATRO(4.0), CINCO(5.0), SEIS(6.0), SIETE(7.0), SOTA(0.5), CABALLO(0.5), REY(0.5);
	/**
	 * Atributo de la enumeración.
	 */
	private double valor;
	
	/**
	 * Constructor de la enumeración figura con el propio valor de la misma.
	 * @param valor
	 */
	Figura(double valor) {
		setValor(valor);
	}
	/**
	 * Recoge el valor de la figura elegida y lo asigna.
	 * @param valor
	 */
	private void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * Devuelve el valor de la figura en la que nos posicionemos.
	 * @return
	 */
	double getValor() {
		return valor;
	}
}
/**
 * Enumeación de los tipos de palos en un abaraja española.
 * 
 * @author Daniel Gestino Notario
 * @version 2.0
 */
enum Palo {
	OROS, COPAS, ESPADAS, BASTOS;
}
