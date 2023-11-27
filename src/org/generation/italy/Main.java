package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DistributoreBevande D = new DistributoreBevande();
		
		String decisione;
		
		System.out.println("Benvenuto al distributore.\n\n\n");
		
		do
		{
		
			D.credito(); 
			
			System.out.println("\nEcco la lista delle bevande: \n"); 
			 
			D.erogaBevanda();
			
		System.out.println("\n\nVuoi acquistare un'altra bevanda?");
		decisione = sc.nextLine();
		decisione = decisione.toLowerCase();
		
		} while(decisione.equals("si"));
		
	}

}
