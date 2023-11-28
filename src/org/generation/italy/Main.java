package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DistributoreBevande D = new DistributoreBevande();
		
		System.out.println("Benvenuto al distributore.\n\n\n");
		
			D.credito(); 
			
			System.out.println("\nEcco la lista delle bevande: \n"); 
			 
			D.erogaBevanda();
			
	

		
	}

}
