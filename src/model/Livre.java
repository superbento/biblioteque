package model;

// TO DO ...
public class Livre extends Document implements InterfaceAuteur{

	private String auteur;
	private int nbPages;
	public Livre(String titre,String auteur,int nbPages) {
		super(titre);
		this.auteur=auteur;
		this.nbPages=nbPages;
		// TODO Auto-generated constructor stub
	}
	@Override
	
	public String getAuteur() {
		// TODO Auto-generated method stub
		return this.auteur;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	@Override public String toString() {
		return super.toString()+" "+ this.auteur+" "+this.nbPages;

	}
	@Override
	public int compareTo(Object arg0) {
		Livre livre = (Livre)arg0;
		return this.getTitre().compareTo(livre.getTitre());
	}
	
}
