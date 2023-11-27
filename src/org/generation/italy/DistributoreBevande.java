package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class DistributoreBevande {
	
	Scanner sc = new Scanner(System.in);
	
	float credito, inserisciMoneta; //credito contiene il credito attuale del distributore, inserisciMoneta è la variabile in cui l'utente inserisce i valori delle monete
	String risposta, scelta; //risposta permette all'utente di aggiungere ulteriori monete, scelta permette di scegliere una delle bevande
	boolean check = true, check1 = true;
	
	private HashMap<String, Float> bevande = new HashMap<>(); //questa hashmap contiene tutte le bevande

	public DistributoreBevande() { //questo costruttore imposta la lista delle bevande e il valore del credito iniziale del distributore
		bevande.put("Acqua naturale", 0.5f);
		bevande.put("Acqua frizzante", 0.75f);
		bevande.put("Limonata", 1f);
		bevande.put("Coca Cola", 1.5f);
		bevande.put("Fanta", 1.5f);
		bevande.put("Sprite", 1.5f);
		bevande.put("Chinotto", 1.5f);
		bevande.put("Estathè limone", 1.25f);
		bevande.put("Estathè pesca", 1.25f);
		credito = 0;
	}

	public void credito() {
		
		do
		{
			System.out.print("Inserisci una moneta (€0.10/€0.20/€0.50/€1/€2): ");
			inserisciMoneta = Float.parseFloat(sc.nextLine());
			
			if(inserisciMoneta == 0.1||inserisciMoneta == 0.2||inserisciMoneta == 0.5||inserisciMoneta == 1||inserisciMoneta == 2)
			{
				credito = credito+inserisciMoneta;
				System.out.println("Vuoi inserire un'altra moneta?");
				risposta = sc.nextLine();
				risposta = risposta.toLowerCase();
				check1 = true;
			}
			else
			{
				System.out.println("La moneta inserita non è valida.");
				check1 = false;
			}
			
		} while(risposta.equals("si")||check1 == false);
	}
	
	public void erogaBevanda() {
		
		for(String s : bevande.keySet())
		{
			System.out.println("€"+bevande.get(s)+" - "+s);
		}
		
		do
		{
			System.out.println("\n\nScegli una bevanda da bere:");
			scelta = sc.nextLine();
			
			if(bevande.containsKey(scelta))
			{
				System.out.println("\n"+scelta+" costa €"+bevande.get(scelta)+"\n");
				check = true;
			}
			else
			{
				System.out.println("La bevanda scelta non è disponibile.");
				check = false;
			}
		} while(check == false);
		
		do
		{
			if(credito < bevande.get(scelta))
			{
				System.out.println("Il credito attuale non è sufficiente per acquistare la bevanda scelta. (€"+credito+")\n");
				credito();
			}
		} while(credito < bevande.get(scelta));
		
		credito = credito-bevande.get(scelta);
		System.out.println("Hai acquistato un'unità di "+scelta+".\nSono stati detratti €"+bevande.get(scelta)+" dal credito. Il credito attuale è €"+credito);
	}
	
	
}
