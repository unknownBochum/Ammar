package gui.guiStaedtischeEinrichtungen;


import business.SportvereinModel;
import javafx.stage.Stage;


public class FreizeitangeboteControl  {
	
	private SportvereinModel sportvereinModel;
	
	private FreizeitangeboteView freizeitangeboteView;
	
	
	public FreizeitangeboteControl(Stage stage) {

		this.sportvereinModel = sportvereinModel.getInstens();
		this.freizeitangeboteView = new FreizeitangeboteView(this, stage, sportvereinModel);
		

	}

	
}


