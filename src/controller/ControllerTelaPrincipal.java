package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import model.Acuracia;
import model.Arvore;
import model.Atributo;
import model.DataSet;
import model.DivisorBase;
import model.Instancia;
import model.ProcessadorArquivo;
import view.TelaPrincipal;

public class ControllerTelaPrincipal implements ActionListener{

	private TelaPrincipal telaPrincipal;
	private DataSet dataSet;
	private Arvore arvore;
		
	public ControllerTelaPrincipal(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		this.telaPrincipal.getBtnBuscar().addActionListener(this);
		this.telaPrincipal.getBtnTestar().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.telaPrincipal.getBtnBuscar()) {
			String caminho = this.telaPrincipal.abrirSelecionadorDeArquivo();
			
			if(caminho != null) {
				ProcessadorArquivo processadorArquivo = new ProcessadorArquivo();
	            processadorArquivo.setArquivo(caminho);
	            
	            dataSet = null;
	            
	            try {
					dataSet = processadorArquivo.getRegistros();
					this.telaPrincipal.getTextField().setText(caminho);
		            
				} catch (IOException except) {
					this.telaPrincipal.exibirMensagemErro("Arquivo incompatível!");
					return;
				}
	            	            
	            Collections.shuffle(dataSet.getRegistros());            
//	            this.telaPrincipal.getLblQtdRegistos().setText("Total de Instâncias: "+dataSet.size());
	            
	            ArrayList<String []> lista = dataSet.getQuantidadeInstanciasPorClasse();
	            
	            ArrayList<Atributo> atributos = dataSet.getAtributos();
	            
	            for(int i = 0; i < atributos.size(); i++) {
	            	this.telaPrincipal.exibirAtributos(atributos.get(i).getNome());
	            	this.telaPrincipal.exibirComboAtributos(atributos.get(i).getValores());
	            	this.telaPrincipal.repaint();
	            }
	            
	            this.telaPrincipal.reiniciarPanelDataSet();
	            this.telaPrincipal.exibirClasses(lista);
	            
	            String atributoClasse = dataSet.getRegistroAt(0).getAtributos().get(dataSet.getRegistroAt(0).getAtributos().size()-1);
	            
	            dataSet.setAtributoDeClasse(atributoClasse);	            
			}
            
		}
		
		if(e.getSource() == this.telaPrincipal.getBtnTestar()) {
			if(dataSet != null) {
				
				//	Instancia e constroi a árvore
				arvore = new Arvore();
			    arvore.construir(dataSet);
							    
			    Instancia instanciaTeste = new Instancia();
			    
			    for(int i = 0; i < this.telaPrincipal.getAtributos().size() - 1; i++) {
			    	instanciaTeste.add(this.telaPrincipal.getAtributo(i), this.telaPrincipal.getValorSelecionadoComboBox(i));
			    }
			    
			    this.telaPrincipal.getTextAreaResultado().setText(this.telaPrincipal.getAtributo(this.telaPrincipal.getAtributos().size() - 1)+": "+ arvore.predict(instanciaTeste));			    
			    
				
			}else {
				this.telaPrincipal.exibirMensagemErro("Nenhuma base foi selecionada!");
			}
		}
	}

}
