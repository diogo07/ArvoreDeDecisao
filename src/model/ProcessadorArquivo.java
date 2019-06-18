package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProcessadorArquivo {
	
	private static final String DEFAULT_FILE = "dataset.txt";
	
	private String arquivo = DEFAULT_FILE;
	private BufferedReader fileReader = null;

	public void setArquivo(String nomeDoArquivo) {
		arquivo = nomeDoArquivo;
	}
	
	private List<String> getAtributos() throws IOException {
		List<String> atributos = new ArrayList<String>();
		
		String primeiraLinha = fileReader.readLine();
		StringTokenizer st = new StringTokenizer(primeiraLinha, ",");
		while (st.hasMoreTokens()) {
			atributos.add( st.nextToken() );
		}
		return atributos.isEmpty() ? null : atributos;
	}
	
	public DataSet getRegistros() throws IOException {		
		
		File arq = new File(arquivo);
		if (fileReader == null) {
			FileInputStream fis = new FileInputStream(arq);
			fileReader = new BufferedReader(new InputStreamReader(fis));
		}
		
		DataSet dataset = new DataSet();
		List<String> atributos = getAtributos();
		String linha;
		while ((linha = fileReader.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(linha, ",");
			if (st.countTokens() != atributos.size())
				throw new IOException("Comprimento do registro incorreto, valores faltanto.");
			else {
				Instancia reg = new Instancia();
				for (String atributo : atributos)
					reg.add(atributo, st.nextToken());
				dataset.add(reg);
			}
		}
		
		return dataset;
	}
}
