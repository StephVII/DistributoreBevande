package org.generation.italy;

import java.util.Scanner;

public class Bevanda {
	
	Scanner sc = new Scanner(System.in);
	
	int codice, quantitàDisponibile;
	String nome;
	Float prezzo;

	public Bevanda(int codice, String nome, Float prezzo)
	{
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
		quantitàDisponibile = 5;
		
	}
	
	public void eroga() //questo metodo riduce la quantità disponibile di 1
	{
		if(quantitàDisponibile > 0)
			quantitàDisponibile--;
	}
	
	public void carica(int quantità) //questo metodo permette di caricare la quantità desiderata di bevande
	{
		System.out.println("Inserire il numero di unità da aggiungere: ");
		quantità = Integer.parseInt(sc.nextLine());
		quantitàDisponibile += quantità;
	}
}
