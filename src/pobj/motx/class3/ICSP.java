package pobj.motx.tme3;
import java.util.*;

public interface ICSP {
	//permet d'accéder aux variables du problème
	List<IVariable> getVars();
	
	//permet de tester si un problème est encore satisfiable
	boolean isConsistent();
	
	//affecter une des variables du problème
	ICSP assign(IVariable vi, String val);
}

