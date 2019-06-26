package model;

import java.util.ArrayList;

public class Atributo {
	
	private String nome;
	private ArrayList<String> valores;
	
	public Atributo(String nome) {
		this.nome = nome;
		valores = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getValores() {
		return valores;
	}
	public void setValores(ArrayList<String> valores) {
		this.valores = valores;
	}

}
