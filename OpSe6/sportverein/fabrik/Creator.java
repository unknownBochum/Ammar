package fabrik;

import java.io.FileNotFoundException;

public abstract class Creator {
	
	public abstract Product factoryMethod(String type) throws FileNotFoundException;
}
