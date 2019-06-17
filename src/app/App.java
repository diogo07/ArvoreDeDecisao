package app;

import model.Arvore;
import testes.Testes;

public class App {
	
	public static void main(String[] args) {
		
		Arvore arvore = new Arvore();
		arvore.construir(Testes.getDataSet());
		
		System.out.println("Condições: " + Testes.getExemploInstancia());
		System.out.println("Classificação: " + arvore.predict(Testes.getExemploInstancia()));
	}

}
