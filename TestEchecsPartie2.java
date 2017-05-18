package Test;


import org.junit.Before;
import org.junit.Test;

import projetSynthese.*;
import static org.junit.Assert.*;

public class TestEchecsPartie2 {

	
	Echiquier e;

	public void setUp() {

		e = new Echiquier();
		e.getCase(0, 2).setPiece(new Reine("Noir"));
		e.getCase(0, 4).setPiece(new Pion("Blanc"));
		e.getCase(0, 5).setPiece(new Tour("Blanc"));
		e.getCase(1, 0).setPiece(new Tour("Noir"));
		e.getCase(1, 1).setPiece(new Pion("Noir"));
		e.getCase(2, 5).setPiece(new Fou("Noir"));
		e.getCase(3, 3).setPiece(new Cavalier("Noir"));
		e.getCase(4, 1).setPiece(new Pion("Blanc"));
		e.getCase(4, 4).setPiece(new Roi("Blanc"));
		e.getCase(4, 7).setPiece(new Cavalier("Noir"));
		e.getCase(5, 2).setPiece(new Pion("Noir"));
		e.getCase(6, 1).setPiece(new Pion("Blanc"));
		e.getCase(6, 3).setPiece(new Pion("Blanc"));
		e.getCase(6, 4).setPiece(new Pion("Noir"));
		e.getCase(6, 5).setPiece(new Reine("Blanc"));
		e.getCase(7, 7).setPiece(new Tour("Blanc"));
	}

	public void test1() {
		Position depart = new Position(0, 4);
		Position arrivee = new Position(0, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test2() {
		Position depart = new Position(0, 4);
		Position arrivee = new Position(0, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test3() {
		Position depart = new Position(0, 2);
		Position arrivee = new Position(0, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test4() {
		Position depart = new Position(0, 5);
		Position arrivee = new Position(2, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test5() {
		Position depart = new Position(2, 5);
		Position arrivee = new Position(0, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test6() {
		Position depart = new Position(2, 5);
		Position arrivee = new Position(4, 7);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	public void test7() {
		Position depart = new Position(1, 1);
		Position arrivee = new Position(1, 2);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test8() {
		Position depart = new Position(3, 3);
		Position arrivee = new Position(2, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test9() {
		Position depart = new Position(3, 3);
		Position arrivee = new Position(1, 2);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test10() {
		Position depart = new Position(3, 3);
		Position arrivee = new Position(4, 1);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test11() {
		Position depart = new Position(4, 4);
		Position arrivee = new Position(3, 3);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	public void test12() {
		Position depart = new Position(4, 4);
		Position arrivee = new Position(5, 4);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test13() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(1, 0);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test14() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(1, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	
	public void test15() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(2, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test16() {
		Position depart = new Position(6, 5);
		Position arrivee = new Position(3, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test17() {
		Position depart = new Position(6, 4);
		Position arrivee = new Position(6, 5);
		assertEquals(false, e.cheminPossible(new Deplacement(depart, arrivee)));
	}


	public void test18() {
		Position depart = new Position(7, 7);
		Position arrivee = new Position(7, 0);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	public void test19() {
		Position depart = new Position(7, 7);
		Position arrivee = new Position(7, 5);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	public void test20() {
		Position depart = new Position(0, 2);
		Position arrivee = new Position(0, 2);
		assertEquals(true, e.cheminPossible(new Deplacement(depart, arrivee)));
	}

	
	public void testUn() {
		Position depart = new Position(4, 1);
		Position arrivee = new Position(5, 0);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}


	public void testDeux() {
		Position depart = new Position(4, 1);
		Position arrivee = new Position(5, 2);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}


	public void testTrois() {
		Position depart = new Position(2, 5);
		Position arrivee = new Position(6, 1);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}


	public void testQuatre() {
		Position depart = new Position(6, 1);
		Position arrivee = new Position(5, 2);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	
	public void testCinq() {
		Position depart = new Position(6, 1);
		Position arrivee = new Position(7, 2);
		assertEquals(false, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}


	public void testSix() {
		Position depart = new Position(5, 2);
		Position arrivee = new Position(6, 3);
		assertEquals(true, e.captureParUnPionPossible(new Deplacement(depart,
				arrivee)));
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("projetSynthese.TestEchecsPartie2");
	}

}