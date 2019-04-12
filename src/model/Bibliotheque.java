package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;


public class Bibliotheque  implements Cloneable{

	// Liste des documents de la bibliotheque
	private static List<Document> documents;

	/**
	 * Constructeur d'une bibliotheque dont la liste de documents est vide.
	 */
	public Bibliotheque() {
		documents = new LinkedList<Document>();


	}

	/**
	 * Renvoie la liste des documents de la bibliotheque.
	 */
	public static List<Document> getDocuments() {
		return documents;
	}

	/**
	 * Renvoie le i 鑝e document de la liste des documents, s抜l existe, 
	 * ou null sinon.
	 */
	public Document getDocument(int i) {
		Document x = null;
		try {
			x = documents.get(i);

		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
		return x;


	}

	/**
	 * Si doc est non null et n'appartient pas d閖� � la liste des documents,
	 * alors ajoute doc � cette liste et renvoie true ;
	 * sinon renvoie faux.
	 */
	public void addDocument(Document doc) {
		try {
			Bibliotheque.documents.add(doc);
		}catch(Exception e) {
			System.out.println("error");
		}
	}

	/**
	 * Si doc est dans la liste des documents, alors l'y supprime et renvoie true;
	 * sinon renvoie false.
	 * @return 
	 */
	public static  void removeDocument(Document doc) {
		try {
			Bibliotheque.documents.remove(doc);
		}catch(Exception e) {
			System.out.println("error");
		}

	}
	public static Bibliotheque ReadCSV(Bibliotheque b, BufferedReader br) throws IOException
	{

		String line = "";
		String cvsSplitBy = ",";

		while ((line = br.readLine()) != null) {

			// use comma as separator
			String[] str = line.split(cvsSplitBy);
			int prix=0;
			switch(str[0]){
			case "Roman":
				//System.out.println("here1");
				if(str[4].equals("AUCUN")) {
					prix=Roman.AUCUN;
				}
				if(str[4].equals("GONCOURT")) {
					prix=Roman.GONCOURT;
				}
				if(str[4].equals("MEDICIS")) {
					prix=Roman.MEDICIS;
				}
				if(str[4].equals("INTERAILLE")) {
					prix=Roman.INTERAILLE;
				}
				b.addDocument(new Roman(str[1], str[2], Integer.parseInt(str[3]),prix));
				break;
			case "Revue":
				//System.out.println("here2");
				b.addDocument(new Revue(str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3])));
				break;
			case "Manuel":
				//System.out.println("here3");
				b.addDocument(new Manuel(str[1], str[2],Integer.parseInt(str[3]), Integer.parseInt(str[4])));
				break;
			case "Livre":
				//System.out.println("here4");
				b.addDocument(new Livre(str[1], str[2], Integer.parseInt(str[3])));
				break;
			}        
		}

		return b;
	}
	public static void saveCSV() throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new File("src\\data.csv"));
		StringBuilder sb = new StringBuilder();

		for(Document doc : documents)
		{
			if(doc instanceof Roman)
			{
				sb.append("Roman");
				sb.append(',');
				sb.append(doc.getTitre());
				sb.append(',');
				sb.append(((Roman) doc).getAuteur());
				sb.append(',');
				sb.append(((Roman) doc).getNbPages());
				sb.append(',');
				switch(((Roman) doc).getPrixLitteraire())
				{
				case 5:
					sb.append("AUCUN");
					break;
				case 10:
					sb.append("GONCOURT");
					break;
				case 15:
					sb.append("MEDICIS");
					break;
				case 20:
					sb.append("INTERALLIE");
					break;
				}

				sb.append('\n');
			}
			else if(doc instanceof Manuel)
			{
				sb.append("Manuel");
				sb.append(',');
				sb.append(doc.getTitre());
				sb.append(',');
				sb.append(((Manuel) doc).getAuteur());
				sb.append(',');
				sb.append(((Manuel) doc).getNbPages());
				sb.append(',');
				sb.append(((Manuel) doc).getNiveau());
				sb.append('\n');

			}else if(doc instanceof Revue)
			{
				sb.append("Revue");
				sb.append(',');
				sb.append(doc.getTitre());
				sb.append(',');
				sb.append(((Revue) doc).getMois());
				sb.append(',');
				sb.append(((Revue) doc).getAnnee());
				sb.append('\n');
			}else if(doc instanceof Livre){
				sb.append("Livre");
				sb.append(',');
				sb.append(doc.getTitre());
				sb.append(',');
				sb.append(((Livre) doc).getAuteur());
				sb.append(',');
				sb.append(((Livre) doc).getNbPages());
				sb.append('\n');
			}
		}

		pw.write(sb.toString());
		pw.close();

		System.out.println("Save Successful");
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return "Bibliotheque de " + documents.size() + " documents";
	}	
}
