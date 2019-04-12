package view;

import javax.swing.*;

import controller.TestDocuments;
import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;

public class Affichage extends JFrame{

	private JButton b1 ;
	private JButton bcl;
	private JButton bcr ;
	private JButton bcm;
	private JButton br ;
	private JButton remove ;
	private JButton afficherR;
	private JButton afficherL;
	private JButton sauvegarder;
	private JLabel titre =     new JLabel("Titre:                            ");
	private JLabel auteur =  new JLabel("Auteur:                        ");
	private JLabel nbPage = new JLabel("NB Page:                     ");
	private JLabel prix = new JLabel("Prix litteraire:             ");
	private JLabel niveau = new JLabel("Niveau :                       ");
	private JLabel num = new JLabel("Numero de livre :                       ");
	private JLabel title = new JLabel("BIBLIOTHEQUE");
	private JTextField t1= new JTextField(26),
			a1= new JTextField(26),
			n1= new JTextField(6),
			nu1 = new JTextField(6),
			nv1 = new JTextField(6);

	private JRadioButton aucun = new JRadioButton("Aucun");
	private JRadioButton goncourt = new JRadioButton("Goncourt");
	private JRadioButton medicis = new JRadioButton("Medicis");
	private JRadioButton interaille = new JRadioButton("Interaille");
	private String radio1 = null;

	public class chercherManuel extends JFrame{
		private JTextArea t2= new JTextArea(10,5);
		private  List<Document> documents ;
		private  List<Manuel> manuel=new LinkedList<Manuel>();
		public chercherManuel(String titre,String auteur,String nbPage,String niveau) {

			this.setLocationRelativeTo(null);
			int nb=0,niveauint=0;
			try {
				nb = Integer.parseInt(nbPage);
			}catch(Exception e) {
				nb =0;
			}
			try {
				niveauint = Integer.parseInt(niveau);
			}catch(Exception e) {
				niveauint =0;
				System.out.print(niveauint);
			}

			this.setTitle("resultat");
			this.setSize(800,600);
			JPanel panel_1 = new JPanel();
			this.setLayout(new BorderLayout());
			this.add(panel_1,BorderLayout.CENTER);
			panel_1.add(t2);
			documents = Bibliotheque.getDocuments();
			for(Document doc:documents) {
				if(doc.getClass().equals(Manuel.class)) {
					Manuel r = (Manuel)doc;
					manuel.add(r);
				}
			}
			t2.append("Livre:\n\n");
			for(Manuel r:manuel) {
				if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					t2.append(r.toString());
					t2.append("\n");
				}

				if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					if(r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if(r.getNbPages()==nb) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if(r.getNiveau()==niveauint) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}



				if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&r.getNiveau()==niveauint) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}

				if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if((r.getNiveau()==niveauint)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if((r.getNiveau()==niveauint)&&r.getNbPages()==nb) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}

				if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getNiveau()==niveauint) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNiveau()==niveauint)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if(r.getNiveau()==niveauint&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}

				if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&r.getNiveau()==niveauint&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
			}
			t2.append("\n\nAuteur:\n\n");
			for(Manuel r:manuel) {
				if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					t2.append(r.getAuteur().toString());
					t2.append("\n");
				}

				if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					if(r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if(r.getNbPages()==nb) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if(r.getNiveau()==niveauint) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}



				if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&r.getNiveau()==niveauint) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}

				if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if((r.getNiveau()==niveauint)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if((r.getNiveau()==niveauint)&&r.getNbPages()==nb) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}

				if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getNiveau()==niveauint) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNiveau()==niveauint)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if(r.getNiveau()==niveauint&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}

				if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")&&!niveau.equals("")){
					if(r.getTitre().equals(titre)&&r.getNiveau()==niveauint&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur().toString());
						t2.append("\n");
					}
				}


			}
			br=new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			panel_1.add(br);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	public class chercherLivre extends JFrame{
		private JTextArea t2= new JTextArea(10,5);
		private  List<Document> documents ;
		private  List<Livre> livre=new LinkedList<Livre>();
		public chercherLivre(String titre,String auteur,String nbPage) {
			this.setLocationRelativeTo(null);
			int nb=0,radioint=0;
			try {
				nb = Integer.parseInt(nbPage);
			}catch(Exception e) {
				nb =0;
			}
			try {
				radioint = Integer.parseInt(nbPage);
			}catch(Exception e) {
				radioint =0;
			}

			this.setTitle("resultat");
			this.setSize(800,600);
			JPanel panel_1 = new JPanel();
			this.setLayout(new BorderLayout());
			this.add(panel_1,BorderLayout.CENTER);
			panel_1.add(t2);
			documents = Bibliotheque.getDocuments();
			for(Document doc:documents) {
				if(doc.getClass().equals(Livre.class)) {
					Livre r = (Livre)doc;
					livre.add(r);
				}
			}
			t2.append("Livre:\n\n");
			for(Livre r:livre) {
				if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
					t2.append(r.toString());
					t2.append("\n");
				}

				if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
					if(r.getTitre().equals(titre)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
					if(r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
					if(r.getNbPages()==nb) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
					if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
					if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.toString());
						t2.append("\n");
					}
				}
			}
			t2.append("\n\nAuteur:\n\n");
			for(Livre r:livre) {

				if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
					t2.append(r.getAuteur());
					t2.append("\n");
				}

				if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
					if(r.getTitre().equals(titre)) {
						t2.append(r.getAuteur());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
					if(r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
					if(r.getNbPages()==nb) {
						t2.append(r.getAuteur());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
					if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)) {
						t2.append(r.getAuteur());
						t2.append("\n");
					}
				}
				if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
					if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur());
						t2.append("\n");
					}
				}
				if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
					if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
						t2.append(r.getAuteur());
						t2.append("\n");
					}
				}


			}
			br=new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			panel_1.add(br);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	public class chercherRoman extends JFrame{
		private JTextArea t2= new JTextArea(10,5);
		private  List<Document> documents ;
		private  List<Roman> roman =new LinkedList<Roman>();
		public chercherRoman(String titre,String auteur,String nbPage, String radio) {
			this.setLocationRelativeTo(null);
			int nb=0,radioint=0;
			try {
				nb = Integer.parseInt(nbPage);
			}catch(Exception e) {
				nb =0;
			}
			try {
				radioint = Integer.parseInt(nbPage);
			}catch(Exception e) {
				radioint =0;
			}

			this.setTitle("resultat");
			this.setSize(800,600);
			JPanel panel_1 = new JPanel();
			this.setLayout(new BorderLayout());
			this.add(panel_1,BorderLayout.CENTER);
			panel_1.add(t2);
			System.out.print(radio);
			documents = Bibliotheque.getDocuments();
			for(Document doc:documents) {
				if(doc.getClass().equals(Roman.class)) {
					Roman r = (Roman)doc;
					roman.add(r);
				}
			}
			t2.append("Livre:\n\n");
			for(Roman r:roman) {
				if(radio.equals("aucun")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						t2.append(r.toString());
						t2.append("\n");
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getNbPages()==nb) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
				}



				if(radio.equals("goncourt")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
				}



				if(radio.equals("medicis")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
				}



				if(radio.equals("interaille")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.toString());
							t2.append("\n");
						}
					}
				}
			}
			t2.append("\n\nAuteur:\n\n");
			for(Roman r:roman) {
				if(radio.equals("aucun")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						t2.append(r.getAuteur());
						t2.append("\n");
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getNbPages()==nb) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
				}



				if(radio.equals("goncourt")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.GONCOURT) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
				}



				if(radio.equals("medicis")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.MEDICIS) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
				}



				if(radio.equals("interaille")) {
					if(titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}

					if(!titre.equals("")&&auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&nbPage.equals("")){
						if(r.getTitre().equals(titre)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if((r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
					if(!titre.equals("")&&!auteur.equals("")&&!nbPage.equals("")){
						if(r.getTitre().equals(titre)&&(r.getNbPages()==nb)&&r.getAuteur().equals(auteur)&&r.getPrixLitteraire()==Roman.INTERAILLE) {
							t2.append(r.getAuteur());
							t2.append("\n");
						}
					}
				}
			}
			this.setVisible(true);
			br=new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			panel_1.add(br);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	public Affichage(){
		menu m = new menu();

	}
	public class menu extends JFrame{
		public menu(){
			this.setTitle("Saisie Document");
			this.setSize(800,600);

			this.setLayout(new GridLayout(8,1));
			JPanel jpt = new JPanel();
			JPanel jp1 = new JPanel();
			JPanel jp2 = new JPanel();
			JPanel jp3 = new JPanel();
			JPanel jp4 = new JPanel();
			JPanel jp5 = new JPanel();
			JPanel jp6 = new JPanel();
			JPanel jp7 = new JPanel();
			jpt.setLayout(new FlowLayout());
			jp1.setLayout(new FlowLayout());
			jp2.setLayout(new FlowLayout());
			jp3.setLayout(new FlowLayout());
			jp4.setLayout(new FlowLayout());
			jp5.setLayout(new FlowLayout());
			jp6.setLayout(new FlowLayout());
			jp7.setLayout(new FlowLayout());
			this.add(jpt);
			this.add(jp1);
			this.add(jp2);
			this.add(jp3);
			this.add(jp4);
			this.add(jp5);
			this.add(jp6);
			this.add(jp7);
			title.setFont(new Font("Comic Sans MS",Font.PLAIN,   30));   
			jpt.add(title);
			bcr= new JButton("chercher roman");
			bcm= new JButton("chercher manuel");
			bcl = new JButton("chercher Livre");
			remove = new JButton("supprimer livre");
			afficherR = new JButton("afficher des revues");
			afficherL = new JButton("afficher tous les livres (tri lexicographique)");
			sauvegarder = new JButton("sauvegarder les changes");
			jp1.add(bcr);
			jp2.add(bcl);
			jp3.add(bcm);
			jp4.add(remove);
			jp5.add(afficherR);
			jp6.add(afficherL);
			jp7.add(sauvegarder);
			sauvegarder.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						Bibliotheque.saveCSV();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			afficherL.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					afficherLivre al = new afficherLivre();
					dispose();
				}
			});
			afficherR.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					afficherRevue ar = new afficherRevue();
					dispose();
				}
			});
			bcr.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					chercherRomanInput cri = new chercherRomanInput();
					dispose();
				}
			});
			bcl.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					chercherLivreInput cli = new chercherLivreInput();
					dispose();
				}
			});
			bcm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					chercherManuelInput cli = new chercherManuelInput();
					dispose();
				}
			});
			remove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					removeInput ri = new removeInput();
					dispose();
				}
			});
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
			this.setVisible(true);
		}
	}
	public class afficherLivre extends JFrame{
		private JTextArea t2= new JTextArea(10,5);
		private  List<Document> documents ;
		private  List<Document> doc2 ;
		public afficherLivre(){
			this.setTitle("tous les livres");
			this.setSize(800, 600);
			documents = Bibliotheque.getDocuments();
			doc2 = new LinkedList<Document>();
			br= new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			for(Document doc:documents) {
				if((doc.getClass().equals(Livre.class))||(doc.getClass().equals(Manuel.class))||(doc.getClass().equals(Roman.class))) {
					doc2.add(doc);
				}
			}
			Collections.sort(doc2);
			for(Document doc:doc2) {
				if((doc.getClass().equals(Livre.class))||(doc.getClass().equals(Manuel.class))||(doc.getClass().equals(Roman.class))) {
					t2.append(doc.toString());
		            t2.append("\n");
				}
			}
			JPanel p = new JPanel();
			this.setLayout(new BorderLayout());
			p.setLayout(new FlowLayout());
			this.add(t2,BorderLayout.CENTER);
			this.add(p,BorderLayout.SOUTH);
			p.add(br);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
	}
	public class afficherRevue extends JFrame{
		private JTextArea t2= new JTextArea(10,5);
		private  List<Document> documents ;
		public afficherRevue(){
			this.setTitle("des revues");
			this.setSize(800, 600);
			documents = Bibliotheque.getDocuments();
			br= new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			for(Document doc:documents) {
				if(doc.getClass().equals(Revue.class)) {
					t2.append(doc.toString());
		            t2.append("\n");
				}
			}
			JPanel p = new JPanel();
			this.setLayout(new BorderLayout());
			p.setLayout(new FlowLayout());
			this.add(t2,BorderLayout.CENTER);
			this.add(p,BorderLayout.SOUTH);
			p.add(br);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
	}
	public class Remove extends JFrame{
		private JTextArea t2= new JTextArea(10,5);
		private  List<Document> documents ;
		public Remove(String titre,String prix){
			int num=0;
			if(prix.equals("Goncourt")) {
				num=Roman.GONCOURT;
			}
			if(prix.equals("Medicis")) {
				num=Roman.MEDICIS;
			}
			if(prix.equals("Interaille")) {
				num=Roman.INTERAILLE;
			}
			documents = Bibliotheque.getDocuments();
			for(Document doc:documents) {
				if(!titre.equals("")&&prix.equals("")) {
					if((doc.getClass().equals(Manuel.class))||(doc.getClass().equals(Livre.class))||(doc.getClass().equals(Roman.class))) {
						if(doc.getTitre().equals(titre)) {
							Bibliotheque.removeDocument(doc);
						}
					}}
				if(titre.equals("")&&!prix.equals("")) {
					if(doc.getClass().equals(Roman.class)) {
						Roman r = (Roman)doc; 
						if(r.getPrixLitteraire()==num) {
							Bibliotheque.removeDocument(doc);
						}
					}
				}
				if(!titre.equals("")&&!prix.equals("")) {
					if(doc.getClass().equals(Roman.class)) {
						Roman r = (Roman)doc; 
						if(r.getPrixLitteraire()==num) {
							if(doc.getTitre().equals(titre)) {
								Bibliotheque.removeDocument(doc);
							}
						}
					}
				}

			}
			this.setTitle("remove");
			this.setSize(600, 200);
			br= new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			JPanel p = new JPanel();
			this.setLayout(new FlowLayout());
			p.setLayout(new FlowLayout());
			this.add(p);
			p.add(br);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
	}
	public class removeInput extends JFrame{
		public removeInput() {
			this.setTitle("remove");
			this.setSize(800, 600);
			JPanel panel_up = new JPanel();
			JPanel panel_bottom = new JPanel();
			this.setLayout(new BorderLayout());
			this.add(panel_up,BorderLayout.CENTER);
			this.add(panel_bottom,BorderLayout.SOUTH);

			JPanel Rop = new JPanel();
			Rop.setLayout(new FlowLayout());
			Rop.add(titre);
			Rop.add(t1);
			Rop.add(prix);
			Rop.add(nu1);
			panel_up.add(Rop);
			br= new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			b1= new JButton("valider");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Remove r = new Remove(t1.getText(),nu1.getText());
					dispose();

				}
			});
			panel_bottom.add(b1);
			panel_bottom.add(br);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
	}
	public class chercherManuelInput extends JFrame{
		public chercherManuelInput() {

			this.setTitle("chercher manuel");
			this.setSize(800,600);
			JPanel panel_up = new JPanel();
			JPanel panel_bottom = new JPanel();
			this.setLayout(new BorderLayout());
			this.add(panel_up,BorderLayout.CENTER);
			this.add(panel_bottom,BorderLayout.SOUTH);

			panel_up.setLayout(new GridLayout(4,1));
			JPanel panel_12 = new JPanel();
			JPanel panel_22 = new JPanel();
			JPanel panel_32 = new JPanel();
			JPanel panel_42 = new JPanel();

			panel_up.add(panel_12);
			panel_up.add(panel_22);
			panel_up.add(panel_32);
			panel_up.add(panel_42);
			FlowLayout fl = new FlowLayout();
			fl.setAlignment(FlowLayout.LEFT);
			panel_12.setLayout(fl);
			panel_12.add(titre);
			panel_12.add(t1);
			panel_22.setLayout(fl);
			panel_22.add(auteur);
			panel_22.add(a1);
			panel_32.setLayout(fl);
			panel_32.add(nbPage);
			panel_32.add(n1);
			panel_42.setLayout(fl);
			panel_42.add(niveau);
			panel_42.add(nv1);

			b1= new JButton("valider");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chercherManuel c = new chercherManuel(t1.getText(),a1.getText(),n1.getText(),nv1.getText());
					dispose();

				}
			});
			br= new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			panel_bottom.add(br);
			panel_bottom.add(b1);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
	}
	public class chercherLivreInput extends JFrame{
		public chercherLivreInput() {

			this.setTitle("chercher livre");
			this.setSize(800,600);
			JPanel panel_up = new JPanel();
			JPanel panel_bottom = new JPanel();
			this.setLayout(new BorderLayout());
			this.add(panel_up,BorderLayout.CENTER);
			this.add(panel_bottom,BorderLayout.SOUTH);

			panel_up.setLayout(new GridLayout(4,1));
			JPanel panel_12 = new JPanel();
			JPanel panel_22 = new JPanel();
			JPanel panel_32 = new JPanel();
			JPanel panel_42 = new JPanel();

			panel_up.add(panel_12);
			panel_up.add(panel_22);
			panel_up.add(panel_32);
			panel_up.add(panel_42);
			FlowLayout fl = new FlowLayout();
			fl.setAlignment(FlowLayout.LEFT);
			panel_12.setLayout(fl);
			panel_12.add(titre);
			panel_12.add(t1);
			panel_22.setLayout(fl);
			panel_22.add(auteur);
			panel_22.add(a1);
			panel_32.setLayout(fl);
			panel_32.add(nbPage);
			panel_32.add(n1);

			panel_42.setLayout(fl);
			b1= new JButton("valider");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chercherLivre c = new chercherLivre(t1.getText(),a1.getText(),n1.getText());
					dispose();

				}
			});
			br= new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			panel_bottom.add(br);
			panel_bottom.add(b1);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
	}
	public class chercherRomanInput extends JFrame{
		public chercherRomanInput() {

			this.setTitle("Saisie Document");
			this.setSize(800,600);
			JPanel panel_up = new JPanel();
			JPanel panel_bottom = new JPanel();
			this.setLayout(new BorderLayout());
			this.add(panel_up,BorderLayout.CENTER);
			this.add(panel_bottom,BorderLayout.SOUTH);

			panel_up.setLayout(new GridLayout(4,1));
			JPanel panel_12 = new JPanel();
			JPanel panel_22 = new JPanel();
			JPanel panel_32 = new JPanel();
			JPanel panel_42 = new JPanel();

			panel_up.add(panel_12);
			panel_up.add(panel_22);
			panel_up.add(panel_32);
			panel_up.add(panel_42);
			FlowLayout fl = new FlowLayout();
			fl.setAlignment(FlowLayout.LEFT);
			panel_12.setLayout(fl);
			panel_12.add(titre);
			panel_12.add(t1);
			panel_22.setLayout(fl);
			panel_22.add(auteur);
			panel_22.add(a1);
			panel_32.setLayout(fl);
			panel_32.add(nbPage);
			panel_32.add(n1);

			panel_42.setLayout(fl);
			ButtonGroup bg = new ButtonGroup();
			bg.add(aucun);
			bg.add(goncourt);
			bg.add(medicis);
			bg.add(interaille);
			panel_42.add(prix);
			panel_42.add(aucun);
			panel_42.add(goncourt);
			panel_42.add(medicis);
			panel_42.add(interaille);
			FlowLayout fl2 = new FlowLayout();
			fl2.setAlignment(FlowLayout.RIGHT);
			panel_bottom.setLayout(fl2);

			aucun.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (aucun.isSelected()) {
						radio1="aucun";
					}
				}
			});
			goncourt.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (goncourt.isSelected()) {
						radio1="goncourt";
					}
				}
			});
			medicis.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (medicis.isSelected()) {
						radio1="medicis";
					}
				}
			});
			interaille.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (interaille.isSelected()) {
						radio1="interaille";
					}
				}
			});
			b1= new JButton("valider");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chercherRoman c = new chercherRoman(t1.getText(),a1.getText(),n1.getText(),radio1);
					dispose();
				}
			});
			br= new JButton("retourner ид menu");
			br.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu m = new menu();
					dispose();
				}
			});
			panel_bottom.add(br);
			panel_bottom.add(b1);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	// TO DO ...

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a1 == null) ? 0 : a1.hashCode());
		result = prime * result + ((aucun == null) ? 0 : aucun.hashCode());
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((b1 == null) ? 0 : b1.hashCode());
		result = prime * result + ((goncourt == null) ? 0 : goncourt.hashCode());
		result = prime * result + ((interaille == null) ? 0 : interaille.hashCode());
		result = prime * result + ((medicis == null) ? 0 : medicis.hashCode());
		result = prime * result + ((n1 == null) ? 0 : n1.hashCode());
		result = prime * result + ((nbPage == null) ? 0 : nbPage.hashCode());
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
		result = prime * result + ((radio1 == null) ? 0 : radio1.hashCode());
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affichage other = (Affichage) obj;
		if (a1 == null) {
			if (other.a1 != null)
				return false;
		} else if (!a1.equals(other.a1))
			return false;
		if (aucun == null) {
			if (other.aucun != null)
				return false;
		} else if (!aucun.equals(other.aucun))
			return false;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (b1 == null) {
			if (other.b1 != null)
				return false;
		} else if (!b1.equals(other.b1))
			return false;
		if (goncourt == null) {
			if (other.goncourt != null)
				return false;
		} else if (!goncourt.equals(other.goncourt))
			return false;
		if (interaille == null) {
			if (other.interaille != null)
				return false;
		} else if (!interaille.equals(other.interaille))
			return false;
		if (medicis == null) {
			if (other.medicis != null)
				return false;
		} else if (!medicis.equals(other.medicis))
			return false;
		if (n1 == null) {
			if (other.n1 != null)
				return false;
		} else if (!n1.equals(other.n1))
			return false;
		if (nbPage == null) {
			if (other.nbPage != null)
				return false;
		} else if (!nbPage.equals(other.nbPage))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		if (radio1 == null) {
			if (other.radio1 != null)
				return false;
		} else if (!radio1.equals(other.radio1))
			return false;
		if (t1 == null) {
			if (other.t1 != null)
				return false;
		} else if (!t1.equals(other.t1))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}





}
