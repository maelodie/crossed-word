package pobj.motx.tme3.adapt;

import pobj.motx.tme3.*;
import pobj.motx.tme1.*;

import java.util.*;


public class MotX implements ICSP{
	private GrilleContrainte gc;
	private List<DicoVariable> dicovar;
	
	public MotX(GrilleContrainte gc) {
		this.gc = gc;
		dicovar = new ArrayList<DicoVariable>();
		
	}
	@Override  
	public List<IVariable> getVars() {
		List<IVariable> res = new ArrayList<IVariable>();
		List<Emplacement> emp = gc.getGrille().getPlaces();
		for(int i = 0; i < emp.size(); i++) {
			if(emp.get(i).hasCaseVide()) {
				DicoVariable dico = new DicoVariable(i, gc);
				dicovar.add(dico);				
			}
		}
		return res;
	} 
	
	public GrilleContrainte getGC() {
		return gc;
	}
	@Override
	public boolean isConsistent() {
		return !gc.isDead();
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		if(vi instanceof DicoVariable) {
			DicoVariable dico = (DicoVariable)vi;
			gc = gc.fixer(dico.getIndex(),val);
		}
		return this;
	}
	
	@Override
	public String toString() {
		return GrilleLoader.serialize(gc.getGrille().getMatrice(), false);
	}

}
