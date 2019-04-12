package model;

// TO DO ...
public class Manuel extends Livre implements InterfaceAuteur{

	private int niveau;

	public Manuel(String titre, String auteur, int nbPages, int niveau) {
		super(titre, auteur, nbPages);
		this.niveau = niveau;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	@Override public String toString() {
		return super.toString()+" "+ this.niveau;

	}

}
