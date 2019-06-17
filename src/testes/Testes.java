package testes;

import model.DataSet;
import model.Instancia;

public class Testes {
	
	public static DataSet getDataSet() {
		Instancia instancia;
		DataSet dataset = new DataSet();

		instancia = new Instancia();
		instancia.add("Aparencia", "ensolarado");
		instancia.add("Temperatura", "quente");
		instancia.add("Umidade", "alta");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "não");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "ensolarado");
		instancia.add("Temperatura", "quente");
		instancia.add("Umidade", "alta");
		instancia.add("Ventando", "forte");
		instancia.add("JogouTenis", "não");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "nublado");
		instancia.add("Temperatura", "quente");
		instancia.add("Umidade", "alta");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "chuva");
		instancia.add("Temperatura", "moderada");
		instancia.add("Umidade", "alta");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "chuva");
		instancia.add("Temperatura", "fria");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "chuva");
		instancia.add("Temperatura", "fria");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "forte");
		instancia.add("JogouTenis", "não");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "nublado");
		instancia.add("Temperatura", "fria");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "forte");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "ensolarado");
		instancia.add("Temperatura", "moderada");
		instancia.add("Umidade", "alta");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "não");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "ensolarado");
		instancia.add("Temperatura", "fria");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "chuva");
		instancia.add("Temperatura", "moderada");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "ensolarado");
		instancia.add("Temperatura", "moderada");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "forte");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "nublado");
		instancia.add("Temperatura", "moderada");
		instancia.add("Umidade", "alta");
		instancia.add("Ventando", "forte");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "nublado");
		instancia.add("Temperatura", "quente");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "fraco");
		instancia.add("JogouTenis", "sim");
		dataset.add(instancia);

		instancia = new Instancia();
		instancia.add("Aparencia", "chuva");
		instancia.add("Temperatura", "moderada");
		instancia.add("Umidade", "alta");
		instancia.add("Ventando", "forte");
		instancia.add("JogouTenis", "não");
		dataset.add(instancia);
		
		dataset.setAtributoDeClasse("JogouTenis");
		
		return dataset;
	}
	
	public static Instancia getExemploInstancia() {
		Instancia instancia = new Instancia();
		instancia.add("Aparencia", "nublado");
		instancia.add("Temperatura", "moderada");
		instancia.add("Umidade", "normal");
		instancia.add("Ventando", "fraco");
		
		return instancia;
	}

}
