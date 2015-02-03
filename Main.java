import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Fenetre cadrePrincipal = new Fenetre("Plateforme de Simulation");
		cadrePrincipal.setVisible(true);
		
	}
	
	public static void afficher(int x, int y, int z){
		System.out.println("X : "+ x);
		System.out.println("Y : "+ y);
		System.out.println("Z : "+ z);
	}
}
