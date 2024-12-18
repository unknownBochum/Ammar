package gui.guiBuergeraemter;


import java.io.IOException;
import business.SportvereinModel;
import javafx.stage.Stage;
import ownUtil.Observer;


public class SportvereinControl{
	
    private SportvereinModel sportvereinModel;
    private SportvereinView sportvereinview;
    public SportvereinControl(Stage stage) {

        this.sportvereinModel = SportvereinModel.getInstens();
        this.sportvereinview = new SportvereinView(sportvereinModel, stage, this);
    }


     public void leseAusDatei(String typ){
            try {
                  if("csv".equals(typ)){
                      sportvereinModel.leseAusDatei(typ);

                  }else if ("txt".equals(typ)) {
                      sportvereinModel.leseAusDatei(typ);       
                }
                   else{
                       sportvereinview.zeigeInformationsfensterAn(
                           "Noch nicht implementiert!");
                   }
            }
            catch(IOException exc){
                sportvereinview.zeigeFehlermeldungsfensterAn(
                    "IOException beim Lesen!");
            }
            catch(Exception exc){
                sportvereinview.zeigeFehlermeldungsfensterAn(
                    "Unbekannter Fehler beim Lesen!");
            	System.out.println(exc.getMessage());

            }
        }

        public void schreibesportvereinInCsvDatei() {
            try {
                sportvereinModel.schreibesportvereinInCsvDatei();
                sportvereinview.zeigeInformationsfensterAn(
                       "Die sportverein wurden gespeichert!");
            }
            catch(IOException exc){
                sportvereinview.zeigeFehlermeldungsfensterAn(
                    "IOException beim Speichern!");
            }
            catch(Exception exc){
                sportvereinview.zeigeFehlermeldungsfensterAn(
                    "Unbekannter Fehler beim Speichern!");
            }
        }


}