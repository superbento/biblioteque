package model;

// TO DO ...
public class Roman extends Livre implements InterfaceAuteur{
	public static final int AUCUN = 5;
	public static final int GONCOURT = 10;
	public static final int MEDICIS = 15;
	public static final int INTERAILLE = 20;
	private int prixLitteraire;

	public Roman(String titre, String auteur, int nbPages, int prixLitteraire) {
		super(titre, auteur, nbPages);
		this.prixLitteraire = prixLitteraire;
	}
	

	public int getPrixLitteraire() {
		return prixLitteraire;
	}


	public void setPrixLitteraire(int prixLitteraire) {
		this.prixLitteraire = prixLitteraire;
	}


	@Override public String toString() {
		return super.toString()+" "+ this.prixLitteraire;

	}

	
	
	
}
