package projetSynthese;


public class Cavalier extends Piece {
	
	
	public Cavalier(String Couleur) {
		super("Cavalier", Couleur);
	}

	
	public boolean estValide(Deplacement deplacement) {
		
		return (Math.abs(deplacement.getDeplacementX() / deplacement.getDeplacementY())) == 2 |
				(Math.abs(deplacement.getDeplacementX() / deplacement.getDeplacementY())) == .5;
	}
}
