package fabrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product{

	BufferedReader bufferedReader ;
	
	
	public ConcreteProductB() throws FileNotFoundException {
		super();
		this.bufferedReader = new BufferedReader(new FileReader("Sportverein.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {

		String [] array =  bufferedReader.readLine().split(";");	
		
		return array;
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		bufferedReader.close();
	}

}
