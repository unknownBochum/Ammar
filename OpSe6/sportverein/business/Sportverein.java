package business;

import java.util.ArrayList;

public class Sportverein {
	
    private String name;
    private String ort;
    private int anzahlMitglieder;
    private int anzahlEhemaligerMitglieder;
 //   private String[] farben;
    private ArrayList<String> sportverineArrayList ;
    public Sportverein(String name, String ort, int anzahlMitglieder, int anzahlEhemaligerMitglieder, String[] sportvereine) {
        
    	if (sportvereine == null) {
			throw new IllegalArgumentException();
		}
    	
    	this.name = name;
        this.ort = ort;
        this.anzahlMitglieder = anzahlMitglieder;
        this.anzahlEhemaligerMitglieder = anzahlEhemaligerMitglieder;
     //   this.farben = farben;       
        setSportvereineAusStringArray(sportvereine);

        
    }

   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getAnzahlMitglieder() {
        return anzahlMitglieder;
    }

    public void setAnzahlMitglieder(int anzahlMitglieder) {
        this.anzahlMitglieder = anzahlMitglieder;
    }

    public int getAnzahlEhemaligerMitglieder() {
        return anzahlEhemaligerMitglieder;
    }

    public void setAnzahlEhemaligerMitglieder(int anzahlEhemaligerMitglieder) {
        this.anzahlEhemaligerMitglieder = anzahlEhemaligerMitglieder;
    }


    public ArrayList<String> getSportverineArrayList() {
		return sportverineArrayList;
	}

	public void setSportverineArrayList(ArrayList<String> sportverineArrayList) {
		this.sportverineArrayList = sportverineArrayList;
	}
	
	
	 
    public void setSportvereineAusStringArray(String[] sportvereine) {
    	this.sportverineArrayList = new ArrayList<String>();
    	for (int i = 0; i < sportvereine.length; i++) {
			this.sportverineArrayList.add(sportvereine[i]);
		}
    }

	public String getFarbenAlsString(char trenner) {
        String ergebnis = "";
        int i = 0;
        for (i = 0; i < this.getSportverineArrayList().size() - 1; i++) {
            ergebnis = ergebnis + this.getSportverineArrayList().get(i) + trenner;
        }
        return ergebnis + this.getSportverineArrayList().get(i);
    }

    public String gibSportvereinZurueck(char trenner) {
        return this.getName() + trenner 
            + this.getOrt() + trenner
            + this.getAnzahlMitglieder() + trenner
            + this.getAnzahlEhemaligerMitglieder() + trenner + "\n"
            + this.getFarbenAlsString(trenner) + "\n";
    }
}