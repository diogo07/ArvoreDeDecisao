package model;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class No {

	private String atributo;
	private double ganho;
	private DataSet subSet;	
	private boolean isFolha;
	private String valor;		
	private Map<String,No> descendentes;
	private int nivel;
	
	public No(DataSet baseDados) {
		this.atributo = "<não definido>";
		this.ganho = 0;
		this.subSet = baseDados;
		this.isFolha = false;
		this.valor = "<não definido>";
		this.descendentes = null;
	}

	public String getAtributo() {
		return atributo;
	}

	public String getValor() {
		if (!isFolha)
			throw new RuntimeException("Este não é um nodo folha da árvore, é impossível retornar a classificação a partir dele");
		return valor;
	}
	
	public boolean isFolha() {
		return (isFolha || (descendentes == null));
	}

	private void addDescendente(String valor, No filho) {
		if (descendentes == null)
			descendentes = new LinkedHashMap<String,No>();
		filho.nivel = this.nivel + 1;
		descendentes.put(valor, filho);
	}
	
	public void construir() {
		if (subSet.isEmpty())
			throw new RuntimeException("Base de dados sem registros (vazia), impossível construir uma árvore de decisão.");
		if (subSet.entropia() == 0) {
			isFolha = true;
			valor = subSet.getRegistroAt(0).getValor( subSet.getAtributoDeClasse() );
		}
		else {
			isFolha = false;
			for (String atrib : subSet.getRegistroAt(0).getAtributos()) {
				if ( !atrib.equals(subSet.getAtributoDeClasse()) ) {
					double ganhoAtrib = subSet.ganho(atrib);
					if (ganho < ganhoAtrib) {
						ganho = ganhoAtrib;
						atributo = atrib;
					}
				}
			}
			for (String valor : subSet.getValoresDoAtributo(atributo))
				addDescendente(valor, new No(subSet.getSubSet(atributo, valor)) );
			for (Entry<String, No> e : descendentes.entrySet()) {
				e.getValue().construir();
			}
		}
	}

	public No getProximoNode(String valor) {
		if (isFolha)
			throw new RuntimeException("Nodo folha, use getValor() para determinar a classificação.");		
		return descendentes.get(valor);
	}
	
	@Override
	public String toString() {
		String msg = "";		
		if (isFolha)
			msg += "-> " + valor;
		else {
			msg += "<<" + atributo + ">>";
			for (Entry<String,No> e : descendentes.entrySet()) {
				msg += "\n";
				for (int i = 0; i < nivel; i++) msg += "\t\t";
				msg += "\t+--" + e.getKey() + "--" + e.getValue();
			}
		}
		return msg;
	}

}
