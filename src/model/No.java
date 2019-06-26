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
		this.atributo = "<n�o definido>";
		this.ganho = 0;
		this.subSet = baseDados;
		this.isFolha = false;
		this.valor = "<n�o definido>";
		this.descendentes = null;
	}

	public String getAtributo() {
		return atributo;
	}

	public String getValor() {
		if (!isFolha)
			throw new RuntimeException("Este n�o � um nodo folha da �rvore, � imposs�vel retornar a classifica��o a partir dele");
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
			throw new RuntimeException("Base de dados sem registros (vazia), imposs�vel construir uma �rvore de decis�o.");
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
			throw new RuntimeException("Nodo folha, use getValor() para determinar a classifica��o.");		
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
