package model;

// TO DO ...
public abstract class Document implements Comparable {
	static int num=0;
	private int numEnreg;
	private String titre;
	public Document(String titre) {
		super();
		Document.num++;
		this.numEnreg = Document.num;
		this.titre = titre;
	}
	

	public int getNumEnreg() {
		return numEnreg;
	}

	@Override
	public int compareTo(Object arg0) {
		Document doc = (Document)arg0;
		return this.titre.compareTo(doc.getTitre());
	}


	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	@Override public String toString() {
		return this.titre+"  "+this.numEnreg;

	}
}
