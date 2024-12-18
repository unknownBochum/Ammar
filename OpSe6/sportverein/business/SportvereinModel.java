package business;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fabrik.ConcreteCreatorAB;
import fabrik.Creator;
import fabrik.Product;
import ownUtil.*;

public class SportvereinModel implements Observable{

	private Vector<Observer> observers = new Vector<Observer>();

	private static SportvereinModel ob;
//	private Sportverein sportverein ;
	private  ArrayList<Sportverein> sportverineArrayList = new ArrayList<Sportverein>();
	 
	private SportvereinModel() {
	}
	
	public static SportvereinModel getInstens ()
	{
		if(ob == null)
		{
			
			ob  = new SportvereinModel();
		}
		return ob;
	}

	


	public void addsportvereine(Sportverein sportverein) {
		sportverineArrayList.add(sportverein);
	}

	 public ArrayList<Sportverein> getSportverineArrayList() {
		return sportverineArrayList;
	}


	 
		
	 public void leseAusDatei(String typ) throws IOException{
	    	
	 		
		 	Creator creator = new ConcreteCreatorAB();
		 	Product product = creator.factoryMethod(typ);
		 	
		 	String [] zeile = product.leseAusDatei();
		 	
		 	
  			addsportvereine( new Sportverein(
  										zeile[0],
  										zeile[1],
  										Integer.parseInt(zeile[2]),
  										Integer.parseInt(zeile[3]),
  										zeile[4].split("_")));


	      			product.schliesseDatei();
	      			notifyObservers();
	      	  			
		}
		public void schreibesportvereinInCsvDatei() throws IOException{
			
				BufferedWriter aus = new BufferedWriter(new FileWriter("SportvereinAusgabe.csv", true));
			
				
				
			

				
				for (Sportverein sportverein : sportverineArrayList) {
				
					aus.write(sportverein.gibSportvereinZurueck(';') + "\n");
					
//					aus.write(sportverein.getName()+"\n");
//					aus.write(sportverein.getOrt()+"\n");
//					aus.write(sportverein.getAnzahlMitglieder()+"\n");
//					aus.write(sportverein.getAnzahlEhemaligerMitglieder()+"\n");
//					aus.write(sportverein.getFarbenAlsString('_')+"\n");
//					aus.newLine();
	}
				aus.close();
				
		}
		


		@Override
		public void addObserver(Observer obs) {

			observers.add(obs);
			
		}

		@Override
		public void removeObserver(Observer obs) {

			
			observers.remove(obs);
		}

		@Override
		public void notifyObservers() {

			
			for (Observer observer : observers) {
				observer.update();
			}
		}


	



	

	
		}


	
		
