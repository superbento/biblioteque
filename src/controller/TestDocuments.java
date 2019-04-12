package controller;

import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;
import view.Affichage;

public class TestDocuments {

	public static void main(String[] args)throws IOException  {
		Bibliotheque bibliotheque1 = new Bibliotheque();

		String csvFile = "src\\data.csv";
		BufferedReader br = new BufferedReader(new FileReader(csvFile));	
		Bibliotheque.ReadCSV(bibliotheque1, br);
		try {
			Bibliotheque copy =(Bibliotheque) bibliotheque1.clone();
			System.out.println("clone success");
		}catch(CloneNotSupportedException e) {
			System.out.println("clone fail");
		}
		/*	Document[] documents = {
			new Livre("L'archipel du Goulag", "Soljenitsyne", 250),
			new Roman("Rouge Bréil", "Rufin", 120, Roman.GONCOURT),
			new Revue("Le point", 03, 2014),
			new Roman("Le mendiant", "Wiesel", 150, Roman.MEDICIS),
			new Livre("La condition humaine", "Malraux", 130),
			new Manuel("Manuel qualité ISO 9001", "AFNOR", -1, 3)
		};
	    Bibliotheque b1 = new Bibliotheque();
	    for(Document doc:documents) {
	    	b1.addDocument(doc);
	    }
	    System.out.print(b1.toString());
		for ( Document doc : documents ) {
			System.out.println(doc);
		}*/
		Affichage a1 = new Affichage();

	}

}
