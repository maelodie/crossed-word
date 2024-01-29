package pobj.motx.tme1;

public class Case {
	/**
	 * Cette classe représente une case dans une grille de mots croisé
	 */
	private int ligne; //coordonées de la ligne
	private int colonne; //coordonnées de la colonne
	private char value; //valeur '*' case pleine, ' ' case vide ou 26 lettres de l'alphabet
	
	//COnstructeur prenant les coordonnées et la valeur en argument
	public Case(int lig, int col, char c) {
		ligne = lig;
		colonne = col;
		value = c;
	}
	
	//getters
	public int getLig() { return this.ligne; }
	
	public int getCol() { return this.colonne; }
	
	public char getChar() { return this.value; }
	
	
	//setters
	//modifie le contenu de value
	public void setChar(char c) { this.value = c; }
	
	
	//operations
	//vérifie si la case est vide
	public boolean isVide() {
		return this.value == ' ';
	}
	
	//vérifie si la vase est pleine
	public boolean isPleine() {
		return this.value == '*';
	}
	
	/**
	 * Permet de créer un nouvel objet de type 
	 * Case avec les mêmes données que l'objet sur lequel on appelle la fonction
	 */
	public Case clone() {
		return new Case(this.ligne, this.colonne, this.value);
	}
	
	public String toString() {
		return " " + value;
	}
}
