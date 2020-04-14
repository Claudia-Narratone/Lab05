package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Ricerca ricerca=new Ricerca();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextArea txtResultCorretti;

    @FXML
    private TextArea txtResultErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {
    	txtResultErrati.clear();
    	txtResultCorretti.clear();
   
    	String parola=txtParola.getText();
    	List<String> soluzioniCorette=new ArrayList<>();
    	soluzioniCorette.addAll(ricerca.doAnagrammaCorretti(parola));
    	for(String s: soluzioniCorette) {
    		txtResultCorretti.appendText(s+"\n");
    	}
    	List<String> soluzioniErrate=new ArrayList<>();
    	soluzioniErrate.addAll(ricerca.doAnagrammaErrati(parola));
    	for(String s: soluzioniErrate) {
    		txtResultErrati.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResultErrati.clear();
    	txtResultCorretti.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultCorretti != null : "fx:id=\"txtResultCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultErrati != null : "fx:id=\"txtResultErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Ricerca model) {
    	this.ricerca=model;
    }
}
