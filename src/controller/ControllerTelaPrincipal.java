package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import model.Acuracia;
import model.Arvore;
import model.DataSet;
import model.DivisorBase;
import model.ProcessadorArquivo;
import view.TelaPrincipal;

public class ControllerTelaPrincipal implements ActionListener{

	private TelaPrincipal telaPrincipal;
	private DataSet dataSet;
	private Arvore arvore;
		
	public ControllerTelaPrincipal(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		this.telaPrincipal.getBtnBuscar().addActionListener(this);
//		this.telaPrincipal.getBtnIniciar().addActionListener(this);
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
	            
	           // System.out.println(dataSet);
	            
	            Collections.shuffle(dataSet.getRegistros());            
//	            this.telaPrincipal.getLblQtdRegistos().setText("Total de Instâncias: "+dataSet.size());
	            
	            ArrayList<String []> lista = dataSet.getQuantidadeInstanciasPorClasse();
	            this.telaPrincipal.reiniciarPanelDataSet();
	            this.telaPrincipal.exibirClasses(lista);
	            
	            String atributoClasse = dataSet.getRegistroAt(0).getAtributos().get(dataSet.getRegistroAt(0).getAtributos().size()-1);
	            
	            dataSet.setAtributoDeClasse(atributoClasse);	            
			}
            
		}
		
//		if(e.getSource() == this.telaPrincipal.getBtnIniciar()) {
//			if(dataSet != null) {
//				if(this.telaPrincipal.validarCampoDivisaoBase()) {
//					DivisorBase divisor = new DivisorBase(dataSet, Integer.parseInt(this.telaPrincipal.getTextPorcentagem().getText()));
//					//  Separa a base em Treinamento e teste
//					divisor.separar();
//					//	Instancia e constroi a árvore
//					arvore = new Arvore();
//			        arvore.construir(divisor.baseTreino());
//					DataSet baseTeste = divisor.baseTeste();
//					
//					double resultado [] = null;
//					
//					// Realiza a predição e calcula a frequência de acertos
//					try {
//						resultado  = Acuracia.calcular(baseTeste, arvore);
//					//  Exibe os acertos, erros e o resultado da acurácia
//						this.telaPrincipal.getTextAreaResultado().setText("Acertos: "+ String.format("%.0f", resultado[0])+"\nErros: "+ String.format("%.0f", resultado[1])+"\nAcurácia: " + String.format("%.2f", resultado[2])+"%");
//					}catch (NullPointerException except) {
//						this.telaPrincipal.exibirMensagemErro("A árvore não conseguiu classificar a base de teste!");
//					}					
//					
//				}else {
//					this.telaPrincipal.exibirMensagemErro("Campo de divisão da base não preenchido!");
//				}
//			}else {
//				this.telaPrincipal.exibirMensagemErro("Nenhuma base foi selecionada!");
//			}
//		}
	}

}
