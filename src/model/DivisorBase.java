package model;

public class DivisorBase {
	
	private DataSet dataSet;
	private DataSet dataSetTreino;
	private DataSet dataSetTeste;
	private int porcentagemTreinamento;
	private int registrosTreino;
	
	
	
	public DivisorBase(DataSet dataSet, int porcentagemTreinamento) {
		this.dataSet = dataSet;
		this.porcentagemTreinamento = porcentagemTreinamento;
	}
	
	public void separar() {
		registrosTreino = (int) (dataSet.size()*(porcentagemTreinamento*0.01));
	}
	
	public DataSet baseTreino() {
		dataSetTreino = new DataSet();
		dataSetTreino.setAtributoDeClasse(dataSet.getAtributoDeClasse());
		
		for(int i = 0; i<registrosTreino;i++) {
			dataSetTreino.add(dataSet.getRegistroAt(i));
		}
		
		return dataSetTreino;
	}
	
	public DataSet baseTeste() {
		dataSetTeste = new DataSet();
		dataSetTeste.setAtributoDeClasse(dataSet.getAtributoDeClasse());
		
		for(int i = registrosTreino; i<dataSet.size();i++) {
			dataSetTeste.add(dataSet.getRegistroAt(i));
		}
		
		return dataSetTeste;
	}
	
	
	
}
