package app;

import controller.ControllerTelaPrincipal;
import model.Arvore;
import testes.Testes;
import view.TelaPrincipal;

public class App {
	
	public static void main(String[] args) {
		
		/*
		Arvore arvore = new Arvore();
		arvore.construir(Testes.getDataSet());
		
		System.out.println("Condi��es: " + Testes.getExemploInstancia());
		System.out.println("Classifica��o: " + arvore.predict(Testes.getExemploInstancia()));
		*/
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		new ControllerTelaPrincipal(telaPrincipal);
	}

}
