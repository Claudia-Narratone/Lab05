package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Ricerca {
	
	private List<String> soluzione;
	private List<String> solCorrette;
	private List<String> solErrate;
	private AnagrammaDAO anagrammaDAO;
	
	//Errore nella connessione al DB
	
	public List<String> doAnagrammaCorretti(String parola){
		solCorrette=new ArrayList<String>();
		parola=parola.toLowerCase();
		List<Character> disponibili=new ArrayList<>();
		for(int i=0; i<parola.length();i++)
			disponibili.add(parola.charAt(i));
		cerca("",0,disponibili);
		return solCorrette;
	}
	
	public List<String> doAnagrammaErrati(String parola){
		solErrate=new ArrayList<String>();
		parola=parola.toLowerCase();
		List<Character> disponibili=new ArrayList<>();
		for(int i=0; i<parola.length();i++)
			disponibili.add(parola.charAt(i));
		cerca("",0,disponibili);
		return solErrate;
	}
	
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		//caso terminale
		if(disponibili.size()==0) {
			if(anagrammaDAO.isCorrect(parziale)) 
				this.solCorrette.add(parziale);
			else
				this.solErrate.add(parziale);
		}
		//caso normale
		for(Character ch:disponibili) {
			String tentativo=parziale+ch;
			List<Character> rimanenti=new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			cerca(tentativo,livello+1,rimanenti);
		}
	}

}
