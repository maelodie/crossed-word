package pobj.motx.tme3;

import pobj.motx.tme2.EnsembleLettre;
import pobj.motx.tme2.GrillePotentiel;

public class CroixContrainte implements IContrainte {
	private int m1, m2, c1, c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.m2 = m2;
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public int reduce(GrillePotentiel grille) {
		int removed = 0;
		EnsembleLettre l1 = new EnsembleLettre();
		EnsembleLettre l2 = new EnsembleLettre();
		EnsembleLettre s = new EnsembleLettre();
		
		l1.addAll(grille.getMotsPot().get(m1).getLettres(c1));
		l2.addAll(grille.getMotsPot().get(m2).getLettres(c2));
		s.retainAll(l1, l2);
		
		if(l1.size() > s.size()) {
			removed += grille.getMotsPot().get(m1).filtreEnsemble(s, c1);
		}
		
		if(l2.size() > s.size()) {
			removed += grille.getMotsPot().get(m2).filtreEnsemble(s, c2);
		}
		return removed;
	}
	
	public String toString() {
		String s = "{" + m1 + "," + c1 + "," + m2 + "," + c2 + "}";
		return s;
	}
	
	public boolean equals(Object other) {
		if(other instanceof CroixContrainte) {
			CroixContrainte o = (CroixContrainte) other;
				if((m1 == o.m1) && (c1 == o.c1) && (m2 == o.m2) && (c2 == o.c2))
					return true;
		}
		return false;
	}
}