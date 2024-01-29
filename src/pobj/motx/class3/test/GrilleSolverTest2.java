package pobj.motx.tme3.test;

import org.junit.Test;

import pobj.motx.tme1.*;
import pobj.motx.tme2.*;
import pobj.motx.tme3.*;
import pobj.motx.tme3.adapt.*;


public class GrilleSolverTest2 {

	
	@Test
	public void testEasy() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/easy2.grl");
		System.out.println(gr);
		
		GrillePlaces grille = new GrillePlaces(gr);
		GrilleContrainte gp = new GrilleContrainte(grille, gut);
		
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test 
	public void testMedium() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/medium.grl");
		System.out.println(gr);
		
		GrillePlaces grille = new GrillePlaces(gr);
		GrilleContrainte gp = new GrilleContrainte(grille, gut);
		
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
		
	}
	
	@Test
	public void testHard() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large.grl");
		System.out.println(gr);
		
		GrillePlaces grille = new GrillePlaces(gr);
		GrilleContrainte gp = new GrilleContrainte(grille, gut);
		
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		
		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
}
