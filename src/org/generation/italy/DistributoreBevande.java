package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class DistributoreBevande {
	
	Scanner sc = new Scanner(System.in);
	
	float credito, inserisciMoneta; //credito contiene il credito attuale del distributore, inserisciMoneta è la variabile in cui l'utente inserisce i valori delle monete
	String risposta; //risposta permette all'utente di aggiungere ulteriori monete
	boolean check = true, check1 = true;
	int scelta; //scelta permette di scegliere una delle bevande
	
	private HashMap<Integer, Bevanda> bevande = new HashMap<>(); //questa hashmap contiene tutte le bevande

	public DistributoreBevande() { //questo costruttore imposta la lista delle bevande e il valore del credito iniziale del distributore
		bevande.put(1, new Bevanda(1, "Acqua Naturale", 0.5f));
		bevande.put(2, new Bevanda(2, "Acqua Frizzante", 0.75f));
		bevande.put(3, new Bevanda(3, "Coca Cola", 1.5f));
		bevande.put(4, new Bevanda(4, "Fanta", 1.5f));
		bevande.put(5, new Bevanda(5, "Sprite", 1.5f));
		bevande.put(6, new Bevanda(6, "Chinotto", 1.5f));
		bevande.put(7, new Bevanda(7, "Limonata", 1.25f));
		bevande.put(8, new Bevanda(8, "Estathè Pesca", 1.25f));
		bevande.put(9, new Bevanda(9, "Estathè Limone", 1.25f));
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
		
		for(Integer bevanda : bevande.keySet())
		{
			System.out.println("[0"+bevande.get(bevanda).codice+"]"+" - €"+bevande.get(bevanda).prezzo+" - "+bevande.get(bevanda).nome);
		}
		
		do
		{
			System.out.println("\n\nScegli una bevanda da bere:");
			scelta = Integer.parseInt(sc.nextLine());
			
			if(bevande.containsKey(scelta))
			{
				System.out.println("\n"+bevande.get(scelta).nome+" costa €"+bevande.get(scelta).prezzo+"\n");
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
			if(credito < bevande.get(scelta).prezzo)
			{
				System.out.println("Il credito attuale non è sufficiente per acquistare la bevanda scelta. (€"+credito+")\n");
				credito();
			}
		} while(credito < bevande.get(scelta).prezzo);
		
		credito = credito-bevande.get(scelta).prezzo;
		System.out.println("Hai acquistato un'unità di "+bevande.get(scelta).nome+".\nSono stati detratti €"+bevande.get(scelta).prezzo+" dal credito. Il credito attuale è €"+credito);
	}
	
	
}
