package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.JButton;

public class viewConversor {

	private JFrame Janela;
	private JLabel lblPara;
	
	private JLabel lblLblTipo;
	private JTextField textValorBase;
	private JTextField  textValorRef;
	
	private JComboBox<String> comboTipoBase;
	private JComboBox<String> comboTipoRef;
	
	private JButton btnSair;
	private JButton btnVoltar;
	private JButton btnSelecionar;
		
	public void setVisible(Boolean b) {
		this.Janela.setVisible(b);
	}

	public JComboBox<String> getComboTipoBase() {
		return comboTipoBase;
	}
	
	public JComboBox<String> getComboTipoRef() {
		return comboTipoRef;
	}
	
	public JTextField getTextValorRef() {
		return textValorRef;
	}
	
	public JTextField getTextValorBase() {
		return textValorBase;
	}
	
	public JButton getBtnSair() {
		return btnSair;
	}
	
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	
	public JButton getBtnSelecionar() {
		return btnSelecionar;
	}
	
	public JLabel getLblLblTipo() {
		return lblLblTipo;
	}
	
	public void setJanela(JFrame janela) {
		Janela = janela;
	}

	public void setTextValorRef(String valorRef){
		this.textValorRef.setText(valorRef);
	}

	public void setComboTipoBase(JComboBox<String> comboTipoBase) {
		this.comboTipoBase = comboTipoBase;
	}

	
	//public void setComboTipoRef(JComboBox comboTipoRef) {
	//	this.comboTipoRef = comboTipoRef;
	//}

	//public void setBtnSair(JButton btnSair) {
	//	this.btnSair = btnSair;
	//}

	//public void setBtnVoltar(JButton btnVoltar) {
	//	this.btnVoltar = btnVoltar;
	//}

	//public void setBtnSelecionar(JButton btnSelecionar) {
	///	this.btnSelecionar = btnSelecionar;
	//}

	//Titulo da Janela e Labela do Conversor
	public void setTitle(String s) {
		this.lblLblTipo.setText(s);
		this.Janela.setTitle(s);
	}
	
//	public void setTextValorBase(String string) {
//	this.textValorBase.setText(string);
//}
	

	
	/**
	 * Self Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				viewConversor window = new viewConversor();
	//				window.Janela.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the application.
	 */
	public viewConversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Janela = new JFrame();
		
		// Hardcoded Atributes
		Janela.setBounds(100, 100, 450, 212);
		Janela.setResizable(false);
		Janela.setLocationRelativeTo(null);
		Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblLblTipo = new JLabel("lblConversorTipo");
		
		comboTipoBase = new JComboBox<String>();
		//comboTipoRef.setEnabled(true);      //Quebra Bunito
		
		comboTipoRef = new JComboBox<String>();
		comboTipoRef.setEnabled(true);
		

		textValorBase = new JTextField();
	
		textValorBase.setColumns(20);
		
		textValorRef = new JTextField ();
		textValorRef.setEditable(false);       //deveria poder Copiar
		textValorRef.setColumns(20);
	
		//Imutavel
		lblPara = new JLabel("para");
		
		//Botões
		btnSair = new JButton("sair");
		btnSelecionar = new JButton("selecionar");
		btnVoltar = new JButton("voltar");
		
		GroupLayout groupLayout = new GroupLayout(Janela.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboTipoBase, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textValorBase, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblPara)
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textValorRef, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
										.addComponent(comboTipoRef, Alignment.LEADING, 0, 144, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLblTipo)
									.addPreferredGap(ComponentPlacement.RELATED, 288, GroupLayout.PREFERRED_SIZE)))
							.addGap(34))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnVoltar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSelecionar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair)
							.addGap(20))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLblTipo)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textValorBase, GroupLayout.PREFERRED_SIZE, 
										GroupLayout.DEFAULT_SIZE, 
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPara))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboTipoBase, GroupLayout.PREFERRED_SIZE, 
									GroupLayout.DEFAULT_SIZE, 
									GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textValorRef, GroupLayout.PREFERRED_SIZE, 
									GroupLayout.DEFAULT_SIZE, 
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboTipoRef, GroupLayout.PREFERRED_SIZE, 
									GroupLayout.DEFAULT_SIZE, 
									GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnSelecionar)
						.addComponent(btnVoltar))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnSelecionar, btnVoltar, btnSair});
		Janela.getContentPane().setLayout(groupLayout);
	}
}
