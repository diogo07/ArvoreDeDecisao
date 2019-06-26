package model;

public class Arvore {
private No raiz = null;
	
	public void construir(DataSet baseDados) {
		raiz = new No(baseDados);
		raiz.construir();
	}
	
	public String predict(Instancia instancia) {
		if (raiz == null)
			throw new RuntimeException("Árvore não foi construída.");
		else {
			No no = raiz;
			
			No anterior = null;
			
			try {
				while (!no.isFolha()) {
					String valor = instancia.getValor(no.getAtributo());
					anterior = no;
					no = no.getProximoNode(valor);
				}
				return no.getValor();
			} catch (NullPointerException e) {
				return no.getValor();
			}
		}
	}

	
	@Override
	public String toString() {
		return raiz.toString();
	}
}
