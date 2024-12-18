package gui.guiBuergeraemter;

import ownUtil.*;
import business.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SportvereinView implements Observer{

	
		private SportvereinModel sportvereinModel; 
		private SportvereinControl sportvereinControl;
//		private Sportverein sportverein;
		private Pane pane = new Pane();
		private Label lblEingabe = new Label("Eingabe");
		private Label lblAnzeige = new Label("Anzeige");
		
		private Label lblName = new Label("Name:");
		private Label lblOrt = new Label("Ort:");
		private Label lblAnzahlMitglieder = new Label("Anzahl Mitglieder:");
		private Label lblAnzahlEhemaligerMitglieder = new Label("Anzahl ehemaliger Mitglieder:");
		private Label lblFarben = new Label("Sportarten:");
		
		private TextField txtName = new TextField();
		private TextField txtOrt = new TextField();
		private TextField txtAnzahlMitglieder = new TextField();
		private TextField txtAnzahlEhemaligerMitglieder = new TextField();
		private TextField txtFarben = new TextField();
		
		private TextArea txtAnzeige = new TextArea();
		private Button btnEingabe = new Button("Eingabe");
		private Button btnAnzeige = new Button("Anzeige");
		private MenuBar mnbrMenuLeiste = new MenuBar();
		private Menu mnDatei = new Menu("Datei");
		private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
		private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
		private MenuItem mnItmCsvExport = new MenuItem("csv-Export");

		public SportvereinView(SportvereinModel sportvereinModel, Stage primaryStage, SportvereinControl sportvereinControl) {
			
			this.sportvereinModel = sportvereinModel;
			this.sportvereinControl = sportvereinControl;
			Scene scene = new Scene(this.pane, 700, 340);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Verwaltung von Sportvereinen");
			primaryStage.show();
			this.initKomponenten();
			this.initListener();
			sportvereinModel.addObserver(this);	
		}
		
		private void initKomponenten() {
			lblEingabe.setLayoutX(20);
			lblEingabe.setLayoutY(40);
			Font font = new Font("Arial", 24); 
			lblEingabe.setFont(font);
			lblEingabe.setStyle("-fx-font-weight: bold;"); 
			lblAnzeige.setLayoutX(400);
			lblAnzeige.setLayoutY(40);
			lblAnzeige.setFont(font);
			lblAnzeige.setStyle("-fx-font-weight: bold;"); 
			
			lblName.setLayoutX(20);
			lblName.setLayoutY(90);
			lblOrt.setLayoutX(20);
			lblOrt.setLayoutY(130);
			lblAnzahlMitglieder.setLayoutX(20);
			lblAnzahlMitglieder.setLayoutY(170);
			lblAnzahlEhemaligerMitglieder.setLayoutX(20);
			lblAnzahlEhemaligerMitglieder.setLayoutY(210);
			lblFarben.setLayoutX(20);
			lblFarben.setLayoutY(250);    	
			pane.getChildren().addAll(lblEingabe, lblAnzeige, lblName, lblOrt, lblAnzahlMitglieder, lblAnzahlEhemaligerMitglieder, lblFarben);
	    
			txtName.setLayoutX(170);
			txtName.setLayoutY(90);
			txtName.setPrefWidth(200);
			txtOrt.setLayoutX(170);
			txtOrt.setLayoutY(130);
			txtOrt.setPrefWidth(200);
			txtAnzahlMitglieder.setLayoutX(170);
			txtAnzahlMitglieder.setLayoutY(170);
			txtAnzahlMitglieder.setPrefWidth(200);
			txtAnzahlEhemaligerMitglieder.setLayoutX(170);
			txtAnzahlEhemaligerMitglieder.setLayoutY(210);
			txtAnzahlEhemaligerMitglieder.setPrefWidth(200);
			txtFarben.setLayoutX(170);
			txtFarben.setLayoutY(250);
			txtFarben.setPrefWidth(200);
			pane.getChildren().addAll(txtName, txtOrt, txtAnzahlMitglieder, txtAnzahlEhemaligerMitglieder, txtFarben);
			
			txtAnzeige.setEditable(false);
			txtAnzeige.setLayoutX(400);
			txtAnzeige.setLayoutY(90);
			txtAnzeige.setPrefWidth(270);
			txtAnzeige.setPrefHeight(185);
			pane.getChildren().add(txtAnzeige); 
			
			btnEingabe.setLayoutX(20);
			btnEingabe.setLayoutY(290);
			btnAnzeige.setLayoutX(400);
			btnAnzeige.setLayoutY(290);
			pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
			this.mnbrMenuLeiste.getMenus().add(mnDatei);
			this.mnDatei.getItems().add(mnItmCsvImport);
			this.mnDatei.getItems().add(mnItmTxtImport);
			this.mnDatei.getItems().add(new SeparatorMenuItem());
			this.mnDatei.getItems().add(mnItmCsvExport);
			pane.getChildren().add(mnbrMenuLeiste);
		}
	   
		private void initListener() {
			btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					nehmeSportvereinAuf();
				}
			});
			btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					update();
				} 
			});
			mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					leseAusDatei("csv");
				}
			});
			mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					leseAusDatei("txt");
				}
			});
			mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					schreibeSportvereinInCsvDatei();
				}	
			});
		}
	    

		private void nehmeSportvereinAuf() {
			try {
				sportvereinModel.addsportvereine(new Sportverein(
					txtName.getText(), 
					txtOrt.getText(),
					Integer.parseInt(txtAnzahlMitglieder.getText()),
					Integer.parseInt(txtAnzahlEhemaligerMitglieder.getText()),
					txtFarben.getText().split(";")
				));
				sportvereinModel.notifyObservers();
			} catch (Exception exc) {
				zeigeFehlermeldungsfensterAn(exc.getMessage());
			}
		}
		
		@Override
		public void update() {
			if (sportvereinModel.getSportverineArrayList().size() > 0) {
			//txtAnzeige.setText(sportvereinModel.getsportverein().gibSportvereinZurueck(' ') );
			StringBuffer text =  new StringBuffer();
			for (Sportverein sportverein : this.sportvereinModel.getSportverineArrayList()) {
				text.append(sportverein.gibSportvereinZurueck(' ') +"\n");
			}
			
			this.txtAnzeige.setText(text.toString());
			
			} else {
				zeigeInformationsfensterAn("Bisher wurde kein Sportverein aufgenommen!");
			}
		} 
	    
		
		public void leseAusDatei(String typ) {

			sportvereinControl.leseAusDatei(typ);
		//	this.sportverein = sportvereinModel.getsportverein();
		}

		public void schreibeSportvereinInCsvDatei() {
		//	sportvereinModel.setsportverein(sportverein);
			sportvereinControl.schreibesportvereinInCsvDatei();
		}
	    
		public void zeigeInformationsfensterAn(String meldung) {
			new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
		}	
		
		public void zeigeFehlermeldungsfensterAn(String meldung) {
			new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
		}

		
	}