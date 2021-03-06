package projetSynthese;

import javax.swing.JFrame;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class FenetreJeu extends JFrame {
	
	private Echiquier e; // echiquier
	private JLabel[][] tab; // tableau de JLabels

	private JPanel panelControle = new JPanel(); // panel du haut
	private JPanel panelGrille = new JPanel(); // panel du bas ( grille )
	GridLayout gridLayout1 = new GridLayout();

	private JButton boutonDebuter = new JButton();
	private JTextField champTexte = new JTextField();
	private JButton boutonReset = new JButton();
	private JPanel panelblanc = new JPanel();
	private JPanel panelnoir = new JPanel();

	public FenetreJeu() 
	{
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	private void jbInit() throws Exception {

		tab = new JLabel[8][8]; // création du tableau de JLabel
		e = new Echiquier(); // création de l'échiquier

		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(784, 585));
		this.setTitle("Jeu d'Echecs");
		panelControle.setBounds(new Rectangle(5, 10, 550, 45));
		panelControle.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));
		panelControle.setLayout(null);
		panelGrille.setBounds(new Rectangle(5, 65, 550, 465));
		panelGrille.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));
		panelGrille.setLayout(gridLayout1);
		gridLayout1.setColumns(8);
		gridLayout1.setRows(8);
		this.getContentPane().add(panelnoir, null);
		this.getContentPane().add(panelblanc, null);
		this.getContentPane().add(panelGrille, null);
		panelControle.add(boutonReset, null);
		panelControle.add(champTexte, null);
		panelControle.add(boutonDebuter, null);
		this.getContentPane().add(panelControle, null);
		boutonDebuter.setBounds(new Rectangle(15, 10, 130, 25));
		boutonDebuter.setText("DEBUTER");
		champTexte.setBounds(new Rectangle(160, 10, 215, 25));

		// les écouteurs
		boutonReset.setText("RESET");
		boutonReset.setBounds(new Rectangle(390, 10, 130, 25));
		GestionnaireEvenement gest = new GestionnaireEvenement();
		boutonDebuter.addMouseListener(gest);
		boutonReset.addMouseListener(gest);
		
		//crŽation des labels
		panelblanc.setBounds(new Rectangle(570, 65, 75, 480));
		panelblanc.setBackground(new Color(255, 255, 255));
		panelblanc.setLayout(new FlowLayout());
		panelnoir.setBounds(new Rectangle(655, 65, 75, 475));
		panelnoir.setBackground(new Color(100, 100, 100));
		panelnoir.setLayout(new FlowLayout());
		
		//J'attribue la couleur aux JLabels
		int a = 1;
		for (int ligne = 0; ligne < 8; ligne++) {
			a = a == 1 ? 0 : 1;
			for (int colonne = 0; colonne < 8; colonne++) {
				tab[colonne][ligne] = new JLabel(); // crÌöation du JLabel
				tab[colonne][ligne].setOpaque(true);
				panelGrille.add(tab[colonne][ligne]); // ajouter au Panel
				tab[colonne][ligne].setOpaque(true);
				tab[colonne][ligne].setHorizontalAlignment(SwingConstants.CENTER); // pour
				tab[colonne][ligne].addMouseListener(gest); // ajouter l'Ìöcouteur aux
				if ((colonne + 1) % 2 == a)
					tab[colonne][ligne].setBackground(new Color(255, 255, 255));
				else
					tab[colonne][ligne].setBackground(new Color(100, 100, 100));

			}
		}

	}


	private class GestionnaireEvenement extends MouseAdapter {

		Piece pieceTampon = null;
		ImageIcon iconeTampon;
		int ligneClic;
		int colonneClic;
		Position depart, arrivee;
		String couleurControle = "blanc";
		Position temp = null;



	
		public void mouseClicked(MouseEvent eve) {
			// si on clique sur le bouton débuter
			if (eve.getSource() == boutonDebuter) {
				//initialise le champ texte, apelle la mŽthode dŽbuter, et initialise toute les variables 
				champTexte.setText("C'est le tour aux blanc");
				boutonDebuter.setEnabled(false);
				e.debuter(); // code
				String dossierIcone = "Icone/";
				char[] ordrePiece = { 'T', 'C', 'F', 'D', 'R', 'F', 'C', 'T' };
				int increment = 1;
				int ligne = 0;
				char couleur = 'N';
				Piece tempo = null;
				e.debuter(); // code

			
				while (increment >= -1) {
					for (int ctr = 0; ctr <= 7; ctr++) {
						tab[ctr][ligne].setIcon(new ImageIcon(dossierIcone + ordrePiece[ctr] + couleur + ".gif"));
						switch(ordrePiece[ctr])
						{
						case 'T':
							tempo = new Tour(ligne < 5 ? "noir" : "blanc");
						break;
						
						case 'C':
							tempo = new Cavalier(ligne < 5 ? "noir" : "blanc");
						break;
						
						case 'F':
							tempo = new Fou(ligne < 5 ? "noir" : "blanc");
						break;
						
						case 'D':
							tempo = new Reine(ligne < 5 ? "noir" : "blanc");
						break;
						
						case 'R':
							tempo = new Roi(ligne < 5 ? "noir" : "blanc");
						break;
						}
						e.getCase(ctr, ligne).setPiece(tempo);
						tab[ctr][ligne + increment].setIcon(new ImageIcon(dossierIcone + 'P' + couleur + ".gif"));
						e.getCase(ctr, ligne + increment).setPiece(new Pion(ligne < 5 ? "noir" : "blanc"));

					}
					couleur = 'B';
					increment -= 2;
					ligne = 7;
				}

			}
			// si on clique sur le bouton reset
			else if (eve.getSource() == boutonReset) {
				//j'appelle la Žthode RAZ
				RAZ();

				
			}

			else if (eve.getSource() instanceof JLabel) // donc on a cliqué sur un Label
			{
				for (int i = 0; i < 8; i++)
					//je dŽtermine sur quelle Jlabel on a cliquŽ
					for (int j = 0; j < 8; j++) 
						if (eve.getSource() == tab[j][i]) {
							ligneClic = i;
							colonneClic = j;
						}
					//si on a cliquŽ sur une case non vide et que le tampon n'est pas null
					if((e.getCase(colonneClic, ligneClic).getPiece() != null | pieceTampon != null) )
					{
						//si le tampon est null
						if(pieceTampon == null )
						{
							//si c'est au tour de la couleur de controle ˆ jouer
							if(e.getCase(colonneClic, ligneClic).getPiece().getCouleur().equals(couleurControle)){
								//J'initialise la piece tampon a la piece sur laquelle on a cliquŽ
								pieceTampon = e.getCase(colonneClic, ligneClic).getPiece();
								iconeTampon = (ImageIcon)tab[colonneClic][ligneClic].getIcon();
								temp = new Position(colonneClic,ligneClic);
								tab[colonneClic][ligneClic].setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0),5));
							}
							
						}
						else
						{
							//je crŽŽ un dŽplacement
							Deplacement deplacement = new Deplacement(temp, new Position(colonneClic,ligneClic));
							//je vŽrifie si le dŽplacement est valide, si le chemin est possible et si il est possible, pour un pion de manger la piece
							if ((pieceTampon.estValide(deplacement) && e.cheminPossible(deplacement)) | e.captureParUnPionPossible(deplacement))
							{
								//je crŽŽ un jLabel avec l'ic™ne de la pice manger
								JLabel manger = new JLabel(tab[colonneClic][ligneClic].getIcon());
								manger.setHorizontalAlignment(SwingConstants.CENTER);
								
								//je l'ajoute au bon jPanel
								if (couleurControle.equals("blanc"))
									panelblanc.add(manger);
								else		
									panelnoir.add(manger);
								
								/* je vŽrifie si la pice manger est un roi, si oui le jeu est terminŽ et L'utilisateurs 
								peut choisir si il veut continuer a jouer ou non*/
								if(e.getCase(colonneClic, ligneClic).getPiece() instanceof Roi)
								{
									if(JOptionPane.showConfirmDialog(null, "FŽlicitation vous avez gagnŽ ! DŽsirez-vous jouer de nouveau ?\n", "Mine !", JOptionPane.YES_NO_OPTION) == 0){
										RAZ();
										tab[temp.getColonne()][temp.getLigne()].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),0));
									}

									else
										System.exit(0);

								}
								else//si on dŽpose la piece sur une case vide
								{
									//on met le tampon sur la case vide et on vide le tampon aprs
									e.getCase(temp.getColonne(), temp.getLigne()).setPiece(null);
									tab[temp.getColonne()][temp.getLigne()].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),0));
	
									tab[colonneClic][ligneClic].setIcon(iconeTampon);
									e.getCase(colonneClic, ligneClic).setPiece(pieceTampon);
									tab[temp.getColonne()][temp.getLigne()].setIcon(null);
	
	
									pieceTampon = null;
									iconeTampon = null;
									temp = null;
	
									couleurControle = couleurControle.equals("blanc") ? "noir" : "blanc";
									champTexte.setText("C'est le tour aux " + couleurControle);
								}
							}
							else
							{
								tab[temp.getColonne()][temp.getLigne()].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),0));
								pieceTampon = null;
								iconeTampon = null;
								temp = null;

							}
						
						}

					}
					
				}

		}
	}

	public void RAZ()
	{
		for (int ligne = 0; ligne < 8; ligne++) 
			for (int colonne = 0; colonne < 8; colonne++) {
				tab[colonne][ligne].setIcon(null);
				e.getCase(colonne, ligne).setPiece(null);
				
			}
		champTexte.setText("");
		boutonDebuter.setEnabled(true);
		e.debuter();
		String couleurControle = "noir";

		panelblanc.removeAll();
		panelblanc.repaint();
		panelnoir.removeAll();
		panelnoir.repaint();

	}

	// main pour pouvoir exécuter l'interface graphique
	public static void main(String[] args) {
		FenetreJeu j = new FenetreJeu();
		j.setVisible(true);
		j.setLocation(100, 130);
		j.setDefaultCloseOperation(EXIT_ON_CLOSE); // ferme le processus associé
	}
}
