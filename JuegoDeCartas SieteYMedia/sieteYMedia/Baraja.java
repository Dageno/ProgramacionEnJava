package sieteYMedia;

import java.util.ArrayList;


public class Baraja {
	
	ArrayList<Carta> baraja;
	
	public Baraja() {
		baraja = new ArrayList<Carta>();
		crearBaraja();
	}
	
	void crearBaraja(){
		for(Palo palo: Palo.values())
			for(Figura figura : Figura.values())
				baraja.add(new Carta(palo, figura));
		
		java.util.Collections.shuffle(baraja);
	}

	int size(){
		return baraja.size();
	}
	
	double sacarCarta(){
		Carta carta = baraja.get(0);
		baraja.remove(carta);
		return carta.getValorCarta();
	}

	@Override
	public String toString() {
		return "Baraja:  " + baraja ;
	}
	
	
	
}
