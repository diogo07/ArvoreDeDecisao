package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
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
	private ArrayList<JLabel> classes;
	private JTextArea textAreaResultado;
	private JPanel panelClasses;
	private JPanel panelTeste;
	private JPanel panelResultado;
	private JButton btnTestar;
	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134, 566);
		getContentPane().setLayout(null);
		
		JPanel panelBuscaBase = new JPanel();
		panelBuscaBase.setBorder(new TitledBorder(null, "Buscar Base", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBuscaBase.setBounds(31, 11, 513, 94);
		getContentPane().add(panelBuscaBase);
		panelBuscaBase.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("Caminho do arquivo");
		textField.setEnabled(false);
		textField.setBounds(10, 31, 388, 20);
		panelBuscaBase.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(408, 30, 89, 23);
		panelBuscaBase.add(btnBuscar);
		
		JLabel lblAjuda = new JLabel("Apenas arquivos com extens\u00E3o .txt");
		lblAjuda.setBounds(10, 58, 210, 14);
		panelBuscaBase.add(lblAjuda);
		
		
		
		MaskFormatter fmt = null;
		try {
			fmt = new MaskFormatter("##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		panelClasses = new JPanel();
		panelClasses.setBorder(new TitledBorder(null, "Classes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClasses.setBounds(0, 0, 514, 339);
		panelClasses.setLayout(new GridLayout(0, 1, 10, 10));
		
		criarLabelsClasse();
        
		JScrollPane scrollPane = new JScrollPane(panelClasses);
		scrollPane.setBounds(30, 116, 514, 339);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);
		
		panelResultado = new JPanel();
		panelResultado.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultado.setBounds(568, 310, 513, 145);
		getContentPane().add(panelResultado);
		panelResultado.setLayout(null);
		
		textAreaResultado = new JTextArea();
		textAreaResultado.setBounds(10, 21, 493, 101);
		textAreaResultado.setEditable(false);
		panelResultado.add(textAreaResultado);
		
		panelTeste = new JPanel();
		panelTeste.setBorder(new TitledBorder(null, "Teste", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTeste.setBounds(0, 0, 513, 230);
		
		panelTeste.setLayout(new GridLayout(0, 1, 10, 10));
		
		JScrollPane scrollPaneTeste = new JScrollPane(panelTeste);
		scrollPaneTeste.setBounds(568, 23, 513, 230);
		scrollPaneTeste.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPaneTeste);
		
		btnTestar = new JButton("Testar");
		btnTestar.setBounds(780, 270, 89, 23);
		getContentPane().add(btnTestar);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	private void criarLabelsClasse() {
		classes = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			JLabel lbl = new JLabel("");
        	lbl.setBounds(30, (i*30)+60, 200, 30);
        	lbl.setVisible(false);
        	panelClasses.add(lbl);
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
	
//	public boolean validarCampoDivisaoBase() {
//		if(textPorcentagem.getText().length() > 0) {
//			try {
//				Integer.parseInt(textPorcentagem.getText());
//				return true;
//			}catch (Exception e) {
//				return false;
//			}
//		}else {
//			return false;
//		}
//	}

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


	public ArrayList<JLabel> getClasses() {
		return classes;
	}


	public void setClasses(ArrayList<JLabel> classes) {
		this.classes = classes;
	}


	public JTextArea getTextAreaResultado() {
		return textAreaResultado;
	}


	public void setTextAreaResultado(JTextArea textAreaResultado) {
		this.textAreaResultado = textAreaResultado;
	}


	public JPanel getPanelClasses() {
		return panelClasses;
	}


	public void setPanelClasses(JPanel panelClasses) {
		this.panelClasses = panelClasses;
	}


	public JPanel getPanelTeste() {
		return panelTeste;
	}


	public void setPanelTeste(JPanel panelTeste) {
		this.panelTeste = panelTeste;
	}


	public JPanel getPanelResultado() {
		return panelResultado;
	}


	public void setPanelResultado(JPanel panelResultado) {
		this.panelResultado = panelResultado;
	}


	public JButton getBtnTestar() {
		return btnTestar;
	}


	public void setBtnTestar(JButton btnTestar) {
		this.btnTestar = btnTestar;
	}
	
	
}
