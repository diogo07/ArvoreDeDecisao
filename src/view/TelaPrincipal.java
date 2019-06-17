package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class TelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnBuscar;


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
		
		JPanel panelClasses = new JPanel();
		panelClasses.setBorder(new TitledBorder(null, "Classes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClasses.setBounds(31, 117, 712, 108);
		getContentPane().add(panelClasses);
		panelClasses.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(690, 89, -677, -66);
		panelClasses.add(scrollPane);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void abrirSelecionadorDeArquivo() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("TXT", "txt"));
        jFileChooser.setAcceptAllFileFilterUsed(false);
		
		int result = jFileChooser.showOpenDialog(this);
	     
	     
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            textField.setText(selectedFile.getAbsolutePath());
        }
	}


	public JButton getBtnBuscar() {
		return btnBuscar;
	}


	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
	
	
}
