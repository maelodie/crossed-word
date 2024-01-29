package pobj.motx.tme2;

import java.util.*;
import java.io.*;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();
	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	/*
	 * Cette fonctionn vérifie si le dictionnaire est vide
	 * @return true si c'est vide et false sinon
	 */
	public boolean isEmpty() {
		return mots.isEmpty();
	}
	
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len la longueur voulue 
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	/*
	 * Cette fonction charge un dictionnaire depuis un fichier texte, sachant que le fichier en paramètre comporte exactement n mot par ligne
	 */
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire res = new Dictionnaire();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			for (String line = br.readLine() ; line != null ; line = br.readLine() ) {
				res.mots.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	/*
	 * Cette fonction filtre le dictionnaire en gardant uniquement les mots avec c à l'index i
	 */
	public int filtreParLettre(char c, int i) {
		int removed = 0;
		List<String> cible = new ArrayList<String>();
		for(String mot : mots) {
			if(mot.charAt(i) == c) {
				cible.add(mot);
			}
			else {
				removed++;
			}
		}
		this.mots = cible;
		
		return removed;
	}
	/*
	 * Cette fonction ajoute dans newEns l'ensemble de lettres possibles 
	 * pour un mot à une position i
	 */
	public EnsembleLettre getLettres(int index) {
		EnsembleLettre newEns = new EnsembleLettre();
		for(String s : mots)  {
			newEns.add(s.charAt(index));
		}
		return newEns;
	}
	
	public int filtreEnsemble(EnsembleLettre ens, int index) {
		int removed = 0;
		List<String> cible = new ArrayList<String>();
		
		for(String s: mots) {
			if(ens.contains(s.charAt(index))) {
				cible.add(s);
			}
			else {
				removed++;
			}
		}
		this.mots = cible;
		
		return removed;
	}
}
