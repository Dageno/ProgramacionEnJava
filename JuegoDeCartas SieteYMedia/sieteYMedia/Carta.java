package sieteYMedia;

public class Carta {
	
	private Figura figura;
	private Palo palo;
	private double valorCarta;
	
	
	public Carta(Palo palo, Figura figura) {
		setPalo(palo);
		setFigura(figura);
		setValorCarta(figura.getValor());
	}

	private void setValorCarta(double valorCarta) {
		this.valorCarta = valorCarta;
		
	}
	
	double getValorCarta() {
		return valorCarta;
		
	}

	private void setPalo(Palo palo) {
		this.palo = palo;
		
	}
	
	@Override
	public String toString() {
		return "\n"+figura + " de " + palo;
	}

	private void setFigura(Figura figura) {
		this.figura = figura;
		
	}

}
enum Figura{
	AS(1.0), DOS(2.0), TRES(3.0), CUATRO(4.0), CINCO(5.0), SEIS(6.0), SIETE(7.0), SOTA(0.5), CABALLO(0.5), REY(0.5);
	
	private double valor;
	
	Figura(double valor){
		setValor(valor);
	}

	private void setValor(double valor) {
		this.valor = valor;
		
	}
	
	double getValor(){
		return valor;
	}
}
enum Palo{
	OROS, COPAS, ESPADAS, BASTOS;
}
