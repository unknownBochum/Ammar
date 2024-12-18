package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class SportvereinTest {
	
	@Test
	void test() {
		String [] ammarStrings  = {"ammar","Emad"};
		Sportverein sportverein = new Sportverein("ammar", "qsed", 120,230, ammarStrings);
		BooleanSupplier testBooleanSupplier = () -> sportverein.getName().equals("ammar");
		assertTrue(testBooleanSupplier,"Fehler");
		
	}
	@Test
	void test2() {
		assertThrows(IllegalArgumentException.class, () -> new Sportverein("Ammar", "qsed", 120,230, null));

		
	}

}
