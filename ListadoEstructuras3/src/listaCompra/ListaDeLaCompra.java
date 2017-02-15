package listaCompra;

/**
 * 
 * @author Daniel Gestino Notario
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeLaCompra {

	private ArrayList<Articulo> lista = null;

	ListaDeLaCompra() {
		lista = new ArrayList<Articulo>();
	}

	void anadir(Articulo articulo) {
		if (lista.contains(articulo))
			System.out.println("La lista ya contiene al artículo");
		else
			lista.add(articulo);
	}

	boolean eliminar(Articulo articulo) {
		return lista.remove(articulo);
	}

	void setCantidadMinima(Articulo articulo, int cantidad) {
		articulo = lista.get(lista.indexOf(articulo));
		articulo.setMinimo(cantidad);

	}

	void incrementarExistencias(Articulo articulo, int incremento) {
		articulo = lista.get(lista.indexOf(articulo));
		articulo.incrementar(incremento);
	}

	void decrementarExistencias(Articulo articulo, int decremento) {

		articulo = lista.get(lista.indexOf(articulo));
		articulo.decrementar(decremento);

	}

	String generarListaDeLaCompra() {
		if (lista.isEmpty()) {
			return "La lista está vacia";
		} else {
			String cadena = new String();
			Iterator<Articulo> iterator = lista.iterator();
			while (iterator.hasNext()) {
				Articulo articulo = (Articulo) iterator.next();
				if (articulo.bajoMinimo())
					cadena += "\n(" + Integer.valueOf(articulo.getExistencias() - articulo.getMinimo()) + ") "
							+ articulo.getNombre();
			}
			return cadena;
		}
	}

	@Override
	public String toString() {
		return lista.toString();
	}
}
