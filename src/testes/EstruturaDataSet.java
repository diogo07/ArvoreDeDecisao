package testes;

import java.util.ArrayList;

public class EstruturaDataSet {
	
	public static void main(String[] args) {
		String dados = "5.1,3.5,1.4,0.2,Iris-setosa\r\n" + 
				"4.9,3,1.4,0.2,Iris-setosa\r\n" + 
				"4.7,3.2,1.3,0.2,Iris-setosa\r\n" + 
				"4.6,3.1,1.5,0.2,Iris-setosa\r\n" + 
				"5,3.6,1.4,0.2,Iris-setosa\r\n" + 
				"5.4,3.9,1.7,0.4,Iris-setosa\r\n" + 
				"4.6,3.4,1.4,0.3,Iris-setosa\r\n" + 
				"5,3.4,1.5,0.2,Iris-setosa\r\n" + 
				"4.4,2.9,1.4,0.2,Iris-setosa\r\n" + 
				"4.9,3.1,1.5,0.1,Iris-setosa\r\n" + 
				"5.4,3.7,1.5,0.2,Iris-setosa\r\n" + 
				"4.8,3.4,1.6,0.2,Iris-setosa\r\n" + 
				"4.8,3,1.4,0.1,Iris-setosa\r\n" + 
				"4.3,3,1.1,0.1,Iris-setosa\r\n" + 
				"5.8,4,1.2,0.2,Iris-setosa\r\n" + 
				"5.7,4.4,1.5,0.4,Iris-setosa\r\n" + 
				"5.4,3.9,1.3,0.4,Iris-setosa\r\n" + 
				"5.1,3.5,1.4,0.3,Iris-setosa\r\n" + 
				"5.7,3.8,1.7,0.3,Iris-setosa\r\n" + 
				"5.1,3.8,1.5,0.3,Iris-setosa\r\n" + 
				"5.4,3.4,1.7,0.2,Iris-setosa\r\n" + 
				"5.1,3.7,1.5,0.4,Iris-setosa\r\n" + 
				"4.6,3.6,1,0.2,Iris-setosa\r\n" + 
				"5.1,3.3,1.7,0.5,Iris-setosa\r\n" + 
				"4.8,3.4,1.9,0.2,Iris-setosa\r\n" + 
				"5,3,1.6,0.2,Iris-setosa\r\n" + 
				"5,3.4,1.6,0.4,Iris-setosa\r\n" + 
				"5.2,3.5,1.5,0.2,Iris-setosa\r\n" + 
				"5.2,3.4,1.4,0.2,Iris-setosa\r\n" + 
				"4.7,3.2,1.6,0.2,Iris-setosa\r\n" + 
				"4.8,3.1,1.6,0.2,Iris-setosa\r\n" + 
				"5.4,3.4,1.5,0.4,Iris-setosa\r\n" + 
				"5.2,4.1,1.5,0.1,Iris-setosa\r\n" + 
				"5.5,4.2,1.4,0.2,Iris-setosa\r\n" + 
				"4.9,3.1,1.5,0.1,Iris-setosa\r\n" + 
				"5,3.2,1.2,0.2,Iris-setosa\r\n" + 
				"5.5,3.5,1.3,0.2,Iris-setosa\r\n" + 
				"4.9,3.1,1.5,0.1,Iris-setosa\r\n" + 
				"4.4,3,1.3,0.2,Iris-setosa\r\n" + 
				"5.1,3.4,1.5,0.2,Iris-setosa\r\n" + 
				"5,3.5,1.3,0.3,Iris-setosa\r\n" + 
				"4.5,2.3,1.3,0.3,Iris-setosa\r\n" + 
				"4.4,3.2,1.3,0.2,Iris-setosa\r\n" + 
				"5,3.5,1.6,0.6,Iris-setosa\r\n" + 
				"5.1,3.8,1.9,0.4,Iris-setosa\r\n" + 
				"4.8,3,1.4,0.3,Iris-setosa\r\n" + 
				"5.1,3.8,1.6,0.2,Iris-setosa\r\n" + 
				"4.6,3.2,1.4,0.2,Iris-setosa\r\n" + 
				"5.3,3.7,1.5,0.2,Iris-setosa\r\n" + 
				"5,3.3,1.4,0.2,Iris-setosa\r\n" + 
				"7,3.2,4.7,1.4,Iris-versicolor\r\n" + 
				"6.4,3.2,4.5,1.5,Iris-versicolor\r\n" + 
				"6.9,3.1,4.9,1.5,Iris-versicolor\r\n" + 
				"5.5,2.3,4,1.3,Iris-versicolor\r\n" + 
				"6.5,2.8,4.6,1.5,Iris-versicolor\r\n" + 
				"5.7,2.8,4.5,1.3,Iris-versicolor\r\n" + 
				"6.3,3.3,4.7,1.6,Iris-versicolor\r\n" + 
				"4.9,2.4,3.3,1,Iris-versicolor\r\n" + 
				"6.6,2.9,4.6,1.3,Iris-versicolor\r\n" + 
				"5.2,2.7,3.9,1.4,Iris-versicolor\r\n" + 
				"5,2,3.5,1,Iris-versicolor\r\n" + 
				"5.9,3,4.2,1.5,Iris-versicolor\r\n" + 
				"6,2.2,4,1,Iris-versicolor\r\n" + 
				"6.1,2.9,4.7,1.4,Iris-versicolor\r\n" + 
				"5.6,2.9,3.6,1.3,Iris-versicolor\r\n" + 
				"6.7,3.1,4.4,1.4,Iris-versicolor\r\n" + 
				"5.6,3,4.5,1.5,Iris-versicolor\r\n" + 
				"5.8,2.7,4.1,1,Iris-versicolor\r\n" + 
				"6.2,2.2,4.5,1.5,Iris-versicolor\r\n" + 
				"5.6,2.5,3.9,1.1,Iris-versicolor\r\n" + 
				"5.9,3.2,4.8,1.8,Iris-versicolor\r\n" + 
				"6.1,2.8,4,1.3,Iris-versicolor\r\n" + 
				"6.3,2.5,4.9,1.5,Iris-versicolor\r\n" + 
				"6.1,2.8,4.7,1.2,Iris-versicolor\r\n" + 
				"6.4,2.9,4.3,1.3,Iris-versicolor\r\n" + 
				"6.6,3,4.4,1.4,Iris-versicolor\r\n" + 
				"6.8,2.8,4.8,1.4,Iris-versicolor\r\n" + 
				"6.7,3,5,1.7,Iris-versicolor\r\n" + 
				"6,2.9,4.5,1.5,Iris-versicolor\r\n" + 
				"5.7,2.6,3.5,1,Iris-versicolor\r\n" + 
				"5.5,2.4,3.8,1.1,Iris-versicolor\r\n" + 
				"5.5,2.4,3.7,1,Iris-versicolor\r\n" + 
				"5.8,2.7,3.9,1.2,Iris-versicolor\r\n" + 
				"6,2.7,5.1,1.6,Iris-versicolor\r\n" + 
				"5.4,3,4.5,1.5,Iris-versicolor\r\n" + 
				"6,3.4,4.5,1.6,Iris-versicolor\r\n" + 
				"6.7,3.1,4.7,1.5,Iris-versicolor\r\n" + 
				"6.3,2.3,4.4,1.3,Iris-versicolor\r\n" + 
				"5.6,3,4.1,1.3,Iris-versicolor\r\n" + 
				"5.5,2.5,4,1.3,Iris-versicolor\r\n" + 
				"5.5,2.6,4.4,1.2,Iris-versicolor\r\n" + 
				"6.1,3,4.6,1.4,Iris-versicolor\r\n" + 
				"5.8,2.6,4,1.2,Iris-versicolor\r\n" + 
				"5,2.3,3.3,1,Iris-versicolor\r\n" + 
				"5.6,2.7,4.2,1.3,Iris-versicolor\r\n" + 
				"5.7,3,4.2,1.2,Iris-versicolor\r\n" + 
				"5.7,2.9,4.2,1.3,Iris-versicolor\r\n" + 
				"6.2,2.9,4.3,1.3,Iris-versicolor\r\n" + 
				"5.1,2.5,3,1.1,Iris-versicolor\r\n" + 
				"5.7,2.8,4.1,1.3,Iris-versicolor\r\n" + 
				"6.3,3.3,6,2.5,Iris-virginica\r\n" + 
				"5.8,2.7,5.1,1.9,Iris-virginica\r\n" + 
				"7.1,3,5.9,2.1,Iris-virginica\r\n" + 
				"6.3,2.9,5.6,1.8,Iris-virginica\r\n" + 
				"6.5,3,5.8,2.2,Iris-virginica\r\n" + 
				"7.6,3,6.6,2.1,Iris-virginica\r\n" + 
				"4.9,2.5,4.5,1.7,Iris-virginica\r\n" + 
				"7.3,2.9,6.3,1.8,Iris-virginica\r\n" + 
				"6.7,2.5,5.8,1.8,Iris-virginica\r\n" + 
				"7.2,3.6,6.1,2.5,Iris-virginica\r\n" + 
				"6.5,3.2,5.1,2,Iris-virginica\r\n" + 
				"6.4,2.7,5.3,1.9,Iris-virginica\r\n" + 
				"6.8,3,5.5,2.1,Iris-virginica\r\n" + 
				"5.7,2.5,5,2,Iris-virginica\r\n" + 
				"5.8,2.8,5.1,2.4,Iris-virginica\r\n" + 
				"6.4,3.2,5.3,2.3,Iris-virginica\r\n" + 
				"6.5,3,5.5,1.8,Iris-virginica\r\n" + 
				"7.7,3.8,6.7,2.2,Iris-virginica\r\n" + 
				"7.7,2.6,6.9,2.3,Iris-virginica\r\n" + 
				"6,2.2,5,1.5,Iris-virginica\r\n" + 
				"6.9,3.2,5.7,2.3,Iris-virginica\r\n" + 
				"5.6,2.8,4.9,2,Iris-virginica\r\n" + 
				"7.7,2.8,6.7,2,Iris-virginica\r\n" + 
				"6.3,2.7,4.9,1.8,Iris-virginica\r\n" + 
				"6.7,3.3,5.7,2.1,Iris-virginica\r\n" + 
				"7.2,3.2,6,1.8,Iris-virginica\r\n" + 
				"6.2,2.8,4.8,1.8,Iris-virginica\r\n" + 
				"6.1,3,4.9,1.8,Iris-virginica\r\n" + 
				"6.4,2.8,5.6,2.1,Iris-virginica\r\n" + 
				"7.2,3,5.8,1.6,Iris-virginica\r\n" + 
				"7.4,2.8,6.1,1.9,Iris-virginica\r\n" + 
				"7.9,3.8,6.4,2,Iris-virginica\r\n" + 
				"6.4,2.8,5.6,2.2,Iris-virginica\r\n" + 
				"6.3,2.8,5.1,1.5,Iris-virginica\r\n" + 
				"6.1,2.6,5.6,1.4,Iris-virginica\r\n" + 
				"7.7,3,6.1,2.3,Iris-virginica\r\n" + 
				"6.3,3.4,5.6,2.4,Iris-virginica\r\n" + 
				"6.4,3.1,5.5,1.8,Iris-virginica\r\n" + 
				"6,3,4.8,1.8,Iris-virginica\r\n" + 
				"6.9,3.1,5.4,2.1,Iris-virginica\r\n" + 
				"6.7,3.1,5.6,2.4,Iris-virginica\r\n" + 
				"6.9,3.1,5.1,2.3,Iris-virginica\r\n" + 
				"5.8,2.7,5.1,1.9,Iris-virginica\r\n" + 
				"6.8,3.2,5.9,2.3,Iris-virginica\r\n" + 
				"6.7,3.3,5.7,2.5,Iris-virginica\r\n" + 
				"6.7,3,5.2,2.3,Iris-virginica\r\n" + 
				"6.3,2.5,5,1.9,Iris-virginica\r\n" + 
				"6.5,3,5.2,2,Iris-virginica\r\n" + 
				"6.2,3.4,5.4,2.3,Iris-virginica\r\n" + 
				"5.9,3,5.1,1.8,Iris-virginica";
		
		String lista [] = dados.split("\\r\\n");
		ArrayList<String> listaTratada = new ArrayList<>();
		
		for(String l: lista) {
			String atributos [] = l.split(",");
			
			String sepallength, sepalwidth, petallength, petalwidth, classe;
			
			// Verificar tamanho sepallength
			
			if(Double.parseDouble(atributos[0]) <= 5.5) {
				sepallength = "curta";
			}else if(Double.parseDouble(atributos[0]) > 5.5 && Double.parseDouble(atributos[0]) <= 6.7) {
				sepallength = "m�dia";
			}else {
				sepallength = "longa";
			}
			
			// Verificar tamanho sepalwidth
			
			if(Double.parseDouble(atributos[1]) <= 2.8) {
				sepalwidth = "fina";
			}else if(Double.parseDouble(atributos[1]) > 2.8 && Double.parseDouble(atributos[1]) <= 3.2) {
				sepalwidth = "m�dia";
			}else {
				sepalwidth = "larga";
			}
			
			// Verificar tamanho petallength
			
			if(Double.parseDouble(atributos[2]) <= 3.0) {
				petallength = "curta";
			}else if(Double.parseDouble(atributos[2]) > 3.0 && Double.parseDouble(atributos[2]) <= 5.0) {
				petallength = "m�dia";
			}else {
				petallength = "longa";
			}
			
			// Verificar tamanho petalwidth
			
			if(Double.parseDouble(atributos[3]) <= 0.9) {
				petalwidth = "fina";
			}else if(Double.parseDouble(atributos[3]) > 0.9 && Double.parseDouble(atributos[3]) <= 1.7) {
				petalwidth = "m�dia";
			}else {
				petalwidth = "larga";
			}
			
			if(!EstruturaDataSet.instanciaJaExisteNaLista(listaTratada, sepallength + "," + sepalwidth + "," + petallength + "," + petalwidth + "," + atributos[4])){
				listaTratada.add(sepallength + "," + sepalwidth + "," + petallength + "," + petalwidth + "," + atributos[4]);
				System.out.println(sepallength + "," + sepalwidth + "," + petallength + "," + petalwidth + "," + atributos[4]);
			}
		}
		
	}
	
	
	public static boolean instanciaJaExisteNaLista(ArrayList<String> lista, String instancia) {
		for(String l: lista) {
			if(l.equals(instancia)) {
				return true;
			}
		}
		
		return false;
	}

}