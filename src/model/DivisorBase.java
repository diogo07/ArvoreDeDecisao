package model;

public class DivisorBase {
	
	private DataSet dataSet;
	private DataSet dataSetTreino;
	private DataSet dataSetValidacao;
	private int porcentagemTreinamento;
	
	public DivisorBase(DataSet dataSet, int porcentagemTreinamento) {
		this.dataSet = dataSet;
		this.porcentagemTreinamento = porcentagemTreinamento;
	}
	
	public int separar() {
		int registrosTreino = (int) (dataSet.size()*(porcentagemTreinamento*0.01));
		return registrosTreino;
	}
	
	
}
