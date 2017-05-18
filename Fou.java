package projetSynthese;


public class Fou extends Piece{

	public Fou(String Couleur) {
		super("Fou", Couleur);
	}
	


	
	public boolean estValide(Deplacement deplacement) {
		
		return Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) == 0 && !deplacement.isNul();
		
	}
}
