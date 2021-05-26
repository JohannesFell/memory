package com.jf.memory;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MemoryFX extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		//den obersten Knoten erzeugen
		//hier verwenden wir ein FlowPane
		//erzeugt wird die Oberfläche über eine eigene Methode in der Klasse MemoryFeld
		FlowPane rootNode = new MemoryFeld().initGUI(new FlowPane());
		//die Szene erzeugen
		//an den Konstruktor werden der oberste Knoten und die Größe übergeben
		//Größe für MacOs 
		Scene meineScene = new Scene(rootNode, 540, 700);
		
		//den Titel über stage setzen
		meineStage.setTitle("Memory");
		//die Szene setzen
		meineStage.setScene(meineScene);
		//Größenänderungen verhindern
		meineStage.setResizable(false);
		//und anzeigen
		meineStage.show();
	}
	
	//Methode zur Ausgabe des Gewinners
	//mit Hilfe der Klasse Alert
	public static void MemoryWinner(String winner,String text) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Herzlichen Glückwunsch");
		alert.setHeaderText("Der Gewinner ist: " + winner);
		alert.setContentText(text);
		
		ButtonType beenden = new ButtonType("Beenden");
		//Default Buttons löschen
		alert.getButtonTypes().clear();
		//Neuer Button beenden hinzufügen
		alert.getButtonTypes().addAll(beenden);
		//Lambda-Expression
		//Eventhandler erstellen, welcher die Platform schließt
		//setOnHidden setzt den Wert auf onHidden
	    alert.setOnHidden(event -> Platform.exit());
	    //showAndWait kann nicht in ener laufenden Animation,
	    //sondern nur in einem EventHandler aufgreufen werden.
	    //Es wird demnach nur alert.show() verwendet.
		alert.show();
	}
	
	public static void main(String[] args) {
		//der Start
		launch(args);
	}
}
