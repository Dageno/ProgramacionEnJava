package sieteYMedia;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BarajaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Baraja baraja = new Baraja();
		baraja.crearBaraja();
		System.out.println(baraja.toString());
		
		baraja.sacarCarta();
		System.out.println(baraja.toString());
	}

}
