package model;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Instancia {

	private static int cont = 0;	
	private int id;					
	private Map<String, String> lista;

	public Instancia() {
		lista = new LinkedHashMap<String, String>();
		id = ++cont;
	}

	public void add(String atributo, String valor) {
		lista.put(atributo, valor);
	}
	
	public int getID() {
		return id;
	}
	
	public int getSize() {
		return lista.size();
	}
	
	public String getValor(String atributo) {
		return lista.get(atributo);
	}
	
	public List<String> getValores() {
		if (lista.isEmpty())
			return null;
		else {
			List<String> listaDeValores = new ArrayList<String>();
			for(Entry<String,String> e : lista.entrySet()) {
				listaDeValores.add( e.getValue() );
			}
			return listaDeValores;
		}
	}
	
	public List<String> getAtributos() {
		if (lista.isEmpty())
			return null;
		else {
			List<String> listaDeValores = new ArrayList<String>();
			for(Entry<String,String> e : lista.entrySet()) {
				listaDeValores.add( e.getKey() );
			}
			return listaDeValores;
		}
	}

	@Override
	public String toString() {
		String msg = "";
		for(Entry<String,String> e : lista.entrySet())
			msg += e.getKey() + "=\"" + e.getValue() + "\" ";
		return msg;
	}
}
