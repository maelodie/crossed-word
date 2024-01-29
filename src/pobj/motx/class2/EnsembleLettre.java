package pobj.motx.tme2;

import java.util.*;

public class EnsembleLettre {
	private List<Character> lettres;
	
	public EnsembleLettre() {
		lettres = new ArrayList<Character>();
	}
	
	public EnsembleLettre(List<Character> listChar) {
		lettres = new ArrayList<Character>();
		lettres.addAll(listChar);
	}
	
	public List<Character> getLettres() {
		return lettres;
	}
	
	public boolean add(char c) {
		Character myChar = Character.valueOf(c);
		if(!(lettres.contains(myChar))) {
			lettres.add(myChar);
			return true;
		}
		return false;
	}
	
	public void addAll(EnsembleLettre ens) {
		for(Character c: ens.lettres) {
			this.add(c);
		}
	}
	
	public int size() {
		return lettres.size();
	}
	
	@Override
	public String toString() {
		//Utiliser la méthode string builder après
		String res = " ";
		for(Character c : lettres) {
			res += c;
		}
		res += '\n';
		return res;
	}
	
	public boolean contains(char c) {
	    Character myChar = Character.valueOf(c);
	    return lettres.contains(myChar);
	}
	
	/*
	 * Intersection des deux listes en argument et créant un nouvel EnsembleLettre 
	 */
	public EnsembleLettre retainAll(EnsembleLettre el1, EnsembleLettre el2) {
		List<Character> newList1 = new ArrayList<Character>();
		List<Character> newList2 = new ArrayList<Character>();
		newList1.addAll(el1.lettres);
		newList2.addAll(el2.lettres);
		newList1.retainAll(newList2);
		this.lettres = newList1;
		return this;
	}
	/*
	 * Retourne l'ensemble this sans les lettres en paramètres
	 */
	public void removeAll(EnsembleLettre ens) {
		lettres.removeAll(ens.lettres);
	}
	
	
}
