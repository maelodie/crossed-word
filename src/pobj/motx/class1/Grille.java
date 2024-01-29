package pobj.motx.tme1;

public class Grille {
	/**
	 * Cette classe représente une grille constituée d'une matrice de 
	 * cases de hauteur lignes sur largeur colonnes
	 */
	private Case[][] matrice;
	
	/**
	 * Constructeur avec:
	 * @param hauteur
	 * @param largeur
	 */
	public Grille(int hauteur, int largeur) {
		matrice = new Case[hauteur][largeur];
		for(int i = 0; i < hauteur; i++) //i ligne
			for(int j = 0; j < largeur; j++) //j colonne
				matrice[i][j] = new Case(i, j, ' '); 
	}
	
	/**
	 * Permet d'accéder à une case avec les coordonnées en paramètres
	 * @param lig: numero de ligne de la case
	 * @param col: numero de colone 
	 * @return
	 */
	public Case getCase(int lig, int col) {
		return this.matrice[lig][col];
	}
	
	/**
	 * Permet d'afficher une grille avec la méthode statique de grilleLoader
	 */
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	/**
	 * @return le nombre de lignes de la matrice
	 */
	public int nbLig() { return matrice.length; }
	/**
	 * 
	 * @return le nombre de colonnes de la matrice
	 */
	public int nbCol() { return matrice[0].length; }
	
	/**
	 * Crée une copie de la grille (un objet différent avec les mêmes valeurs)
	 * et aussi avec des nouvelles cases clonées
	 * @return une copie de la grille
	 */
	public Grille copy() {
		Grille g = new Grille(this.nbLig(), this.nbCol());
		for(int i = 0; i < this.nbLig(); i++) //i ligne
			for(int j = 0; j < this.nbCol(); j++) //j colonne
				g.matrice[i][j] = this.matrice[i][j].clone();
		return g;
	}
	
}
