package gui.guiStaedtischeEinrichtungen;

import ownUtil.*;
import business.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FreizeitangeboteView implements Observer {
		
	private FreizeitangeboteControl freizeitangeboteControl;
	private SportvereinModel sportvereineModel;		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeSportvereine     
 		= new Label("Anzeige Sportvereine");
    	private TextArea txtAnzeigeSportvereine  = new TextArea();
    	private Button btnAnzeigeSportvereine = new Button("Anzeige");
		// -------Ende Attribute der grafischen Oberflaeche-------

		public FreizeitangeboteView(FreizeitangeboteControl freizeitangeboteControl, Stage primaryStage, SportvereinModel sportvereineModel) {
			Scene scene = new Scene(this.pane, 560, 340);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Anzeige von Freizeitangeboten");
			primaryStage.show();
			this.freizeitangeboteControl = freizeitangeboteControl;
			this.sportvereineModel = sportvereineModel;
			this.initKomponenten();
			this.initListener();
			sportvereineModel.addObserver(this);
			
			

		}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeSportvereine.setLayoutX(310);
    		lblAnzeigeSportvereine.setLayoutY(40);
    		lblAnzeigeSportvereine.setFont(font);
    		lblAnzeigeSportvereine.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeSportvereine);           
// Textbereich	
        	txtAnzeigeSportvereine.setEditable(false);
     		txtAnzeigeSportvereine.setLayoutX(310);
    		txtAnzeigeSportvereine.setLayoutY(90);
     		txtAnzeigeSportvereine.setPrefWidth(220);
    		txtAnzeigeSportvereine.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeSportvereine);        	
        	// Button
          	btnAnzeigeSportvereine.setLayoutX(310);
        	btnAnzeigeSportvereine.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeSportvereine); 
   }
   
   private void initListener() {
	    btnAnzeigeSportvereine.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	update();
	        	} 
   	    });
    }
   
   @Override
	public void update() {

		if (sportvereineModel.getSportverineArrayList().size() > 0) {
			//txtAnzeige.setText(sportvereinModel.getsportverein().gibSportvereinZurueck(' ') );
			StringBuffer text =  new StringBuffer();
			for (Sportverein sportverein : this.sportvereineModel.getSportverineArrayList()) {
				text.append(sportverein.gibSportvereinZurueck(' ')+"\n" );
			}
			
			this.txtAnzeigeSportvereine.setText(text.toString());
			 
		}

    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Sportverein aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }

	

    
}
