package model;

public class Arvore {
private Node raiz = null;
	
	public void construir(DataSet baseDados) {
		raiz = new Node(baseDados);
		raiz.construir();
	}
	
	public String predict(Instancia instancia) {
		if (raiz == null)
			throw new RuntimeException("Árvore não foi construída.");
		else {
			Node no = raiz;
			while (!no.isFolha()) {
				String valor = instancia.getValor(no.getAtributo());
				no = no.getProximoNode(valor);
			}
			return no.getValor();
		}
	}

	
	@Override
	public String toString() {
		return raiz.toString();
	}
}
