package fabrik;

import java.io.FileNotFoundException;

public class ConcreteCreatorAB extends Creator {
	
	
	@Override
	public Product factoryMethod(String type) throws FileNotFoundException {
		if (type.equalsIgnoreCase("csv")) {
			return new ConcreteProductB();
	
		}else {
			return new ConcreteProductA();
		}
	}
}
