package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Arvore;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TelaArvore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	public TelaArvore(Arvore arvore) {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setResizable(false);
		
		setContentPane(contentPane);
		
		
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 470, 301);
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 11, 470, 301);
		contentPane.add(scrollPane);
		
		textArea.setText(arvore.toString());
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
