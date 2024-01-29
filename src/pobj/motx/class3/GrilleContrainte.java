package pobj.motx.tme3;
import pobj.motx.tme1.*;
import java.util.*;
import pobj.motx.tme2.*;

public class GrilleContrainte extends GrillePotentiel{
	private List<IContrainte> contraintes;
	
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		this.contraintes = new ArrayList<IContrainte>();
		this.addContraintes();
		this.propage();
	}
	
	public void addContraintes() {
		//On prend la liste de la grille
		ArrayList<Emplacement> listeGrille = (ArrayList<Emplacement>) grille.getPlaces();
		
		//Cette liste sert à stocker les cases pour ne plus retravailler sur elles après
		ArrayList<Case> casesTraitees = new ArrayList<Case>();
		
		//On regarde chaque emplacement de la liste de la grille
		for (int m1 = 0; m1 < listeGrille.size(); m1++) {
			Emplacement mot1 = listeGrille.get(m1);
			
			//Itération sur toutes les case 1 par 1
			for (int c1 = 0; c1 < mot1.size(); c1++) {
				Case maCase = mot1.getCase(c1);
				if(maCase.isVide()) {
					if(!casesTraitees.contains(maCase)) {
						casesTraitees.add(maCase);
						this.compareMot2(mot1, maCase, m1, c1, listeGrille);
					}
				}
			}
		}
	}
	
	private void compareMot2(Emplacement mot1, Case maCase, int m1, int c1, ArrayList<Emplacement> listeGrille) {
		//On itère une deuxième fois sur la liste
		for(int m2 = 0; m2 < listeGrille.size(); m2++) {
			//On exécute le reste seulement si ce n'est pas le même mot (horizontal vs vertical)
			if(!(listeGrille.get(m2) == mot1)) {
				for(int c2 = 0; c2 < listeGrille.get(m2).size(); c2++) {
					//On compare toutes les cases 1 par 1 et si c'est la même case, on ajout une nouvelle contrainte
					if(maCase.equals(listeGrille.get(m2).getCase(c2))) {
						CroixContrainte croix=new CroixContrainte(m1, c1, m2, c2); 
						contraintes.add(croix);
						croix.reduce(this);
					}
				}
			}
		}
	}
	
	public List<IContrainte> getContraintes() {
		return contraintes;
	}
	public GrilleContrainte fixer(int m, String soluce) {
		GrilleContrainte grille_c_copy = new GrilleContrainte(super.grille.fixer(m, soluce), super.dico);
		return grille_c_copy;
		
	}
	
	@Override
	public String toString() {
		String s = "";
		for(IContrainte c : contraintes) {
			s += c.toString();
			s += "\n";
		}
		return s;
	}
	
	public boolean propage() {
		//Nombre de mots éliminés
		int deleted;
		
		while(true) {
			deleted = 0;
			for(IContrainte contrainte : contraintes) {
				deleted += contrainte.reduce(this);
			}
			
			if(this.isDead()) return false;
			
			if(deleted == 0) return true;
		}
	}
}
