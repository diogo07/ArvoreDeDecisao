package model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataSet {
	
	private List<Instancia> registros;
	private String atributoDeClasse;

	public DataSet() {
		registros = new ArrayList<Instancia>();
		atributoDeClasse = "<não definido>";
	}
	
	public DataSet(List<Instancia> registros, String atributo) {
		this.registros = registros;
		this.atributoDeClasse = atributo;
	}	
	
	public void setAtributoDeClasse(String atributo) {
		this.atributoDeClasse = atributo;
	}
	
	public String getAtributoDeClasse() {
		return this.atributoDeClasse;
	}
	
	public void add(Instancia reg) {
		registros.add(reg);
	}
	
	public Instancia getRegistroAt(int index) {
		if (registros.isEmpty())
			return null;
		else if (registros.size() <= index )
			return null;
		else
			return registros.get(index);
	}
	
	public List<Instancia> getRegistros() {
		return registros;
	}
	
	public DataSet getSubSet(String atributo, String valor) {
		if (registros.isEmpty())
			return null;
		else {
			List<Instancia> subConjunto = new ArrayList<Instancia>();
			for (Instancia registro : registros)
				if (registro.getValor(atributo).equals(valor))
					subConjunto.add(registro);
			return new DataSet(subConjunto, atributoDeClasse);
		}
	}
	
	public Set<String> getValoresDoAtributo(String atributo) {
		if (registros.isEmpty())
			return null;
		else {
			Set<String> listaDeValores = new HashSet<String>();
			for (Instancia registro : registros)
				listaDeValores.add( registro.getValor(atributo) );			
			return listaDeValores;
		}
	}
	
	public double entropia() {
		return entropia(registros);
	}

	private double entropia(List<Instancia> registros) {
		if (atributoDeClasse.equals("<não definido>"))
			throw new RuntimeException("Atributo de classe não definido para o conjunto de dados");		
		else if (registros.isEmpty())
			return 0;
		else {
			double entropia = 0;
			String[] valores = getValoresDoAtributo(atributoDeClasse).toArray(new String[0]);
			for (String valor : valores) {
				DataSet subSet = getSubSet(atributoDeClasse, valor);
				double frac = ((double) subSet.size()) / registros.size();
				entropia += -frac * (Math.log(frac)/Math.log(2));
			}
			return entropia;
		}
	}
	
	public double ganho(String atributo) {
		if (registros.isEmpty())
			return 0;
		else {
			double ganho = entropia();
			String[] valores = getValoresDoAtributo(atributo).toArray(new String[0]);
			for (String valor : valores) {
				DataSet subSet = getSubSet(atributo, valor);
				double frac = ((double) subSet.size()) / registros.size();
				ganho += -frac * subSet.entropia();
			}
			return ganho;
		}
	}

	public int size() {
		return registros.size();
	}
	
	public boolean isEmpty() {
		return registros.isEmpty();
	}

	@Override
	public String toString() {
		String msg = "";
		List<String> atributos = registros.get(0).getAtributos();
		for (int i = 0; i < atributos.size(); i++)
			msg += "+---------------";
		msg += "+\n|";
		for(String atributo : atributos)
			if (atributo.equals(atributoDeClasse))
				msg += String.format("<<%-11s>>|", atributo);
			else
				msg += String.format("%-15s|", atributo);
		msg += "\n";
		for (int i = 0; i < atributos.size(); i++)
			msg += "+---------------";
		msg += "+\n";
		for (Instancia registro : registros) {
			msg += "|";
			for (String valor : registro.getValores())
				msg += String.format("%-15s|", valor);
			msg += "\n";
		}
		for (int i = 0; i < atributos.size(); i++)
			msg += "+---------------";
		msg += "+\n";
		return msg;
	}
	
	
	public ArrayList<String []> getQuantidadeInstanciasPorClasse() {
		ArrayList<String []> classes = new ArrayList<>();
		
		for(Instancia registo:registros) {
			int indiceResultado = classeEstaNaLista(classes, registo.getValores().get(registo.getValores().size()-1));
			if(indiceResultado>=0) {
				classes.get(indiceResultado)[1] = (Integer.parseInt(classes.get(indiceResultado)[1])+1)+"";
			}else {
				String classe [] = new String [2];
				classe[0] = registo.getValores().get(registo.getValores().size()-1);
				classe[1] = "1";
				classes.add(classe);
			}
		}		
		return classes;
	}
	
	private int classeEstaNaLista(List<String []> classes, String classe) {
		for(int i = 0; i < classes.size(); i++) {
			if(classes.get(i)[0].equals(classe)) {
				return i;
			}
		}
		
		return -1;
	}
	
}