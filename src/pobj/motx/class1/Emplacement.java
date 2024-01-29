package pobj.motx.tme1;

import java.util.*;

public class Emplacement {
	/**
	 * La classe Emplacement représente un mot dans la grille 
	 * c a d une liste de cases contingues
	 */
	private List<Case> cases;
	
	//Constructeur qui crée la liste de cases
	public Emplacement() {
		cases = new ArrayList<Case>();
	}
	
	//Méthode d'ajout d'une case à la fin de la liste cases
	public void add(Case e) {
		cases.add(e);
	}
	
	//retourne la longueur de la liste
	public int size() {
		return cases.size();
	}
	
	//Permet de retrouver la case à l'indice i
	public Case getCase(int i) {
		return cases.get(i);
	}
	
	//Permet de vérifier si les emplacements sont les mêmes
	public boolean equals(Emplacement e) {
		for(Case c : cases) {
			for(Case c2 : e.getList()) {
				if(!c.equals(c2)) {
					return false;
				}
			}
		}
		return true;
	}
	//Permet d'afficher le mot dans l'emplacement
	public String toString() {
		String res = " ";
		for(Case c : cases) {
			res += c.getChar();
		}
		
		return res;
	}
	
	//Cette fonction supprime tous les éléments de l'emplacement
	public void clear() {
		cases.clear();
	}
	
	//Cette fonction retourne a liste de cases
	public List<Case> getList() {
		return cases;
	}
	
	//Vérifie si un emplacement a une case vide
	public boolean hasCaseVide() {
		for(Case c : cases) {
			if(c.isVide()) return true;
		}
		return false;
	}
}
