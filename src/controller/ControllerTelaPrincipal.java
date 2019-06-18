package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import model.Arvore;
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
		this.telaPrincipal.getBtnIniciar().addActionListener(this);
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
	            
	            //System.out.println(dataSet.getRegistros());
	            
	            Collections.shuffle(dataSet.getRegistros());
	            
	            
	            this.telaPrincipal.getLblQtdRegistos().setText("Total de Instâncias: "+dataSet.size());
	            
	            ArrayList<String []> lista = dataSet.getQuantidadeInstanciasPorClasse();
	           
	            this.telaPrincipal.exibirClasses(lista);
	            
	            String atributoClasse = dataSet.getRegistroAt(0).getAtributos().get(dataSet.getRegistroAt(0).getAtributos().size()-1);
	            
	           dataSet.setAtributoDeClasse(atributoClasse);
	            
	           //arvore = new Arvore();
	           //arvore.construir(dataSet);
	           
	           //System.out.println(arvore);
	            
			}
            
		}
		
		if(e.getSource() == this.telaPrincipal.getBtnIniciar()) {
			if(dataSet != null) {
				if(this.telaPrincipal.validarCampoDivisaoBase()) {
					DivisorBase divisor = new DivisorBase(dataSet, Integer.parseInt(this.telaPrincipal.getTextPorcentagem().getText()));
					divisor.separar();
					
					arvore = new Arvore();
			        arvore.construir(divisor.baseTreino());
			           
					
					for(Instancia instancia: divisor.baseTeste().getRegistros()) {
						System.out.println("Valor real: "+instancia.getValor(instancia.getAtributos().get(instancia.getSize()-1)));
						//instancia.getAtributos().remove(instancia.getSize()-1);
						System.out.println("Classificação: "+arvore.predict(instancia)+"\n");
					}
					//this.telaPrincipal.exibirMensagemSucesso("Serão usadas "+numeroInstanciasTreino+" instâncias para treino!");
				}else {
					this.telaPrincipal.exibirMensagemErro("Campo de divisão da base não preenchido!");
				}
			}else {
				this.telaPrincipal.exibirMensagemErro("Nenhuma base foi selecionada!");
			}
		}
	}

}
