package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DataSet;
import model.ProcessadorArquivo;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class TelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnBuscar;
	private JPanel panelDataset;
	private JLabel lblQtdRegistos;
	private ArrayList<JLabel> classes;
	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 566);
		getContentPane().setLayout(null);
		
		JPanel panelBuscaBase = new JPanel();
		panelBuscaBase.setBorder(new TitledBorder(null, "Buscar Base", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBuscaBase.setBounds(31, 11, 712, 94);
		getContentPane().add(panelBuscaBase);
		panelBuscaBase.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("Caminho do arquivo");
		textField.setEnabled(false);
		textField.setBounds(10, 31, 593, 20);
		panelBuscaBase.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(613, 30, 89, 23);
		panelBuscaBase.add(btnBuscar);
		
		JLabel lblAjuda = new JLabel("Apenas arquivos com extens\u00E3o .txt");
		lblAjuda.setBounds(10, 58, 210, 14);
		panelBuscaBase.add(lblAjuda);
		
		panelDataset = new JPanel();
		panelDataset.setBorder(new TitledBorder(null, "Classes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDataset.setBounds(0, 0, 712, 194);
		
		criarLabelsClasse();
		panelDataset.setLayout(null);
		
		lblQtdRegistos = new JLabel("Total de Instâncias: 0");
        lblQtdRegistos.setBounds(30, 30, 200, 30);
        panelDataset.add(lblQtdRegistos);
		
        
        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLayout(null);
		scrollPane.setBounds(31, 117, 712, 194);
		getContentPane().add(scrollPane);
		
		scrollPane.add(panelDataset);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	private void criarLabelsClasse() {
		classes = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			JLabel lbl = new JLabel("");
        	lbl.setBounds(30, (i*30)+60, 200, 30);
        	lbl.setVisible(false);
        	panelDataset.add(lbl);
        	classes.add(lbl);
		}
		
	}


	public void abrirSelecionadorDeArquivo() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("TXT", "txt"));
        jFileChooser.setAcceptAllFileFilterUsed(false);
		
		int result = jFileChooser.showOpenDialog(this);
	     
	     
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            ProcessadorArquivo processadorArquivo = new ProcessadorArquivo();
            processadorArquivo.setArquivo(trocarBarras(selectedFile.getAbsolutePath()));
            
            DataSet dataSet = null;
            
            try {
				dataSet = processadorArquivo.getRegistros();
				textField.setText(trocarBarras(selectedFile.getAbsolutePath()));
	            
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Arquivo incompatível!", "Erro", 0);
				return;
			}
            
            lblQtdRegistos.setText("Total de Instâncias: "+dataSet.size());
            
            ArrayList<String []> l = dataSet.getQuantidadeInstanciasPorClasse();
           
            for(int i = 0; i <l.size(); i++) {
            	classes.get(i).setText(l.get(i)[0]+" : "+l.get(i)[1]);
            	classes.get(i).setVisible(true);
            }

        }
	}
	
	public void exibirClasses(DataSet dataSet) {
		
	}
	
	public String trocarBarras(String texto) {
		String end = "";
		for (int i = 0; i < texto.length(); i++) {

			if (texto.charAt(i) == '\\') {
				end += "/";

			} else {
				end += texto.charAt(i);
			}

		}

		return end;
	}


	public JButton getBtnBuscar() {
		return btnBuscar;
	}


	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
}
