package pobj.motx.tme2;

import java.util.*;
import pobj.motx.tme1.*;
public class GrillePlaces {
	private Grille grille;
	private List<Emplacement> places;
 	private int nbHor;
	
	/*
	 * Ce constructeur explore la grille fournie et calcule les emplacements de mot qu'elle contient
	 * Ces emplacements sont ensuite trouvé dans places
	 * 
	 */
	public GrillePlaces(Grille grille) {
		this.grille = grille;
		places = new ArrayList<Emplacement>();
		
		//Emplacement horizontaux
		for(int i = 0; i < grille.nbLig(); i++) {
			this.cherchePlaces(this.getLig(i));
		}
		nbHor = places.size();
		
		//Emplacement verticaux
		for(int j = 0; j < grille.nbCol(); j++) {
			this.cherchePlaces(this.getCol(j));
		}
	}
	
	//Cette méthode permet de retourner les emplacements détectés
	public List<Emplacement> getPlaces() { return this.places; }
	
	//Cette méthode retourne la taille de la liste
	public int size() { return places.size(); }
	
	//Cette méthode retourne l'élément i de places
	public Emplacement get(int i) { return places.get(i); };
	
;	//Cette méthode retourne la grille matrice
	public Grille getMatrice() {
		return grille;
	}
	//Cette méthode permet d'obtenir le nombre total d'emplacements détectés.
	public int getNbHorizontal() { return this.nbHor; }
	
	@Override 
	public String toString() {
		String s = " ";
		for(Emplacement e : places) {
			s += e.toString() + " ";
		}
		return s + "\n";
	}
	
	//Cette méthode retourne les cases qui constituent une ligne
	private List<Case> getLig(int lig) {
		List<Case> res = new ArrayList<Case>();
		for(int i = 0; i < grille.nbCol(); i++) {
			res.add(grille.getCase(lig, i));
		}
		return res;
	}
	
	//Cette méthode retourne les cases qui constituent une colonne
	private List<Case> getCol(int col) {
		List<Case> res = new ArrayList<Case>();
		for(int i = 0; i < grille.nbLig(); i++) {
			res.add(grille.getCase(i, col));
		}
		return res;
	}
	
	//Cette méthode cherche les emplacements dans la liste de cases fournie et les ajoute à la liste
	private void cherchePlaces(List<Case> cases) {
		Emplacement emp = new Emplacement();
		for(Case c : cases) {
			if(!(c.isPleine())) {
				emp.add(c);
			}
			else {
				if(emp.size() > 1) places.add(emp); 
				emp = new Emplacement();
			}
		}
		if(emp.size() > 1) places.add(emp); 
		
	}
	
	//Cette méthode retourne une nouvelle grille où les cases constituant 
	//l'emplacement de mot d'indice m sont remplacés par soluce
	public GrillePlaces fixer(int m, String soluce) {
		GrillePlaces grille_copy = new GrillePlaces(this.grille.copy());
		Emplacement e = grille_copy.getPlaces().get(m);
		for(int i = 0; i < e.size(); i++) {
			e.getCase(i).setChar(soluce.charAt(i));
		}
		return grille_copy;
	}
}
