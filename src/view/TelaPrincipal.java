package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnBuscar;
	private JPanel panelDataset;
	private JLabel lblQtdRegistos;
	private ArrayList<JLabel> classes;
	private JFormattedTextField textPorcentagem;
	private JButton btnIniciar;
	private JTextArea textAreaResultado;
	
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
		
		JPanel panelDivisaoBase = new JPanel();
		panelDivisaoBase.setBorder(new TitledBorder(null, "Divis\u00E3o da Base", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDivisaoBase.setBounds(31, 322, 712, 71);
		getContentPane().add(panelDivisaoBase);
		panelDivisaoBase.setLayout(null);
		
		JLabel lblTxtDivisao = new JLabel("Parte de Treino:");
		lblTxtDivisao.setBounds(10, 34, 94, 14);
		panelDivisaoBase.add(lblTxtDivisao);
		
		MaskFormatter fmt = null;
		try {
			fmt = new MaskFormatter("##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		textPorcentagem = new JFormattedTextField(fmt);
		textPorcentagem.setBounds(118, 31, 205, 20);
		panelDivisaoBase.add(textPorcentagem);
		textPorcentagem.setColumns(10);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(350, 30, 89, 23);
		panelDivisaoBase.add(btnIniciar);
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultado.setBounds(31, 404, 712, 113);
		getContentPane().add(panelResultado);
		panelResultado.setLayout(null);
		
		textAreaResultado = new JTextArea();
		textAreaResultado.setBounds(10, 21, 692, 81);
		panelResultado.add(textAreaResultado);
		
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
	
	public void reiniciarPanelDataSet() {
		for(int i = 0; i <classes.size(); i++) {
        	classes.get(i).setText("");
        	classes.get(i).setVisible(false);
        }
	}


	public String abrirSelecionadorDeArquivo() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("TXT", "txt"));
        jFileChooser.setAcceptAllFileFilterUsed(false);
		
		int result = jFileChooser.showOpenDialog(this);
	     
	     
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            return trocarBarras(selectedFile.getAbsolutePath());
        }else {
        	return null;
        }
        
	}
	
	public void exibirClasses(ArrayList<String []> l) {
		for(int i = 0; i <l.size(); i++) {
        	classes.get(i).setText(l.get(i)[0]+" : "+l.get(i)[1]);
        	classes.get(i).setVisible(true);
        }
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
	
	
	public void exibirMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, "Erro", 0);
	}

	public void exibirMensagemSucesso(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, "", 1);
	}
	
	public boolean validarCampoDivisaoBase() {
		if(textPorcentagem.getText().length() > 0) {
			try {
				Integer.parseInt(textPorcentagem.getText());
				return true;
			}catch (Exception e) {
				return false;
			}
		}else {
			return false;
		}
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}


	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}


	public JTextField getTextField() {
		return textField;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public JPanel getPanelDataset() {
		return panelDataset;
	}


	public void setPanelDataset(JPanel panelDataset) {
		this.panelDataset = panelDataset;
	}


	public JLabel getLblQtdRegistos() {
		return lblQtdRegistos;
	}


	public void setLblQtdRegistos(JLabel lblQtdRegistos) {
		this.lblQtdRegistos = lblQtdRegistos;
	}


	public ArrayList<JLabel> getClasses() {
		return classes;
	}


	public void setClasses(ArrayList<JLabel> classes) {
		this.classes = classes;
	}


	public JFormattedTextField getTextPorcentagem() {
		return textPorcentagem;
	}


	public void setTextPorcentagem(JFormattedTextField textPorcentagem) {
		this.textPorcentagem = textPorcentagem;
	}


	public JButton getBtnIniciar() {
		return btnIniciar;
	}


	public void setBtnIniciar(JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
	}


	public JTextArea getTextAreaResultado() {
		return textAreaResultado;
	}


	public void setTextAreaResultado(JTextArea textAreaResultado) {
		this.textAreaResultado = textAreaResultado;
	}
	
	
}
