package pobj.motx.tme3.adapt;

import java.util.*;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme3.*;

public class DicoVariable implements IVariable {
	private int index;
	private GrilleContrainte gc;
	
	public DicoVariable(int index, GrilleContrainte gc) {
		this.index = index;
		this.gc = gc;
	}
	
	@Override
	public List<String> getDomain() {
		List<String> res = new ArrayList<String>();
		for(Dictionnaire dico : gc.getMotsPot()) {
			for(int i = 0; i < dico.size(); i++) {
				res.add(dico.get(i));
			}
		}
		return res;
	}
	
	@Override
	public String toString() {
		return index + " " + gc;
	}
	
	public int getIndex() { return this.index; }

}
