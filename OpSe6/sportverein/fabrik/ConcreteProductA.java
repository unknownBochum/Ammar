package fabrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {

	
BufferedReader bufferedReader ;
	
	
	public ConcreteProductA() throws FileNotFoundException {
		super();
		this.bufferedReader = new BufferedReader(new FileReader("Sportverein.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {

		String [] ergebnisZeile =  new String[5];	
		
		String zeileString =bufferedReader.readLine();
		int i = 0;
		while (i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeileString;
			zeileString = bufferedReader.readLine();
			i++;
		}
		
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		bufferedReader.close();
	}
}
