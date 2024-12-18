package main;

import gui.guiBuergeraemter.SportvereinControl;
import gui.guiStaedtischeEinrichtungen.FreizeitangeboteControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new SportvereinControl(primaryStage);
		Stage test = new Stage();
		new FreizeitangeboteControl(test);

	}	
	
	
	public static void main(String[] args){
		launch(args);
	}
}

