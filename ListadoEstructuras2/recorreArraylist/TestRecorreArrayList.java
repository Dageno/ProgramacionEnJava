package recorreArraylist;

/**
 * 2. A continuación se muestra parte de una clase denominada RecorreArrayList:
 * a. Compila y entrega el código donde se invoquen cada uno de los métodos
 * anteriores. Utiliza una lista de String. b. Implementa cómo recorrer una
 * lista al revés en la misma clase
 * 
 * @author Daniel Gestino Notario
 *
 */
public class TestRecorreArrayList {

	public static void main(String[] args) {
		RecorreArrayList lista = new RecorreArrayList();

		lista.add("Paco se fue a la cama");
		lista.add("Paco esta de fiesta");
		lista.add("Simplemente paco");

		System.out.println("Example with Show");
		System.out.println(lista.show());

		System.out.println("Example with Foreach: ");
		lista.showWithForEach();

		System.out.println("Example with Get: ");
		lista.showWithGet();

		System.out.println("Example with Iterator:");
		lista.showWithIterator();

		System.out.println("Example with Iterator2: ");
		lista.showWithIterator2();

	}

}
