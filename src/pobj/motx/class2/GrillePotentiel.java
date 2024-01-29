package pobj.motx.tme2;

import java.util.*;
import pobj.motx.tme1.*;
public class GrillePotentiel {
	protected GrillePlaces grille;
	protected Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	
	/*
	 * initialise les attributs aux valeurs données, 
	 * initialise le domaine potientiel (dictionnaire associé au mot)
	 * initialise le domaine des emplacements
	 * filtre les dictionnaires de chaque mot en fonction du mot
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dico = dicoComplet;
		this.motsPot = new ArrayList<Dictionnaire>();
		
		for(Emplacement e : grille.getPlaces()) {
			//Copie du dictionnaire pour ne pas altérer l'original
			Dictionnaire dico2 = dico.copy();
			
			//Filtre selon la longueur
			dico2.filtreLongueur(e.size());
			
			//Filtre selon les lettres
			for(int i = 0; i < e.size(); i++) {
				if(!e.getCase(i).isVide()) {
					dico2.filtreParLettre(e.getCase(i).getChar(), i);
				}
			}
			
			motsPot.add(dico2);
		}
	}
	
	//getter de la grille
	public GrillePlaces getGrille() { return grille; }
	//getter retournant la liste des domaines potentiel
	public List<Dictionnaire> getMotsPot() { return this.motsPot; }
	
	//retourne vrai ssi au moins un emplacement a un domaine potentiel vide
	public boolean isDead() {
		List<Emplacement> list = grille.getPlaces();
		for(int i = 0; i < list.size(); i++) {
			if(motsPot.get(i).isEmpty()) return true;
		}
		return false;
	}
	
	//initialise une nouvelle GrillePotentiel avec la grille résultant de l'affectation
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePotentiel grille_p_copy = new GrillePotentiel(this.grille.fixer(m, soluce), this.dico);
		return grille_p_copy;
	}
}
