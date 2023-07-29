package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class viewSeletor {

	private JFrame Janela;
	private JButton btnSelecionar;
	private JButton btnSair;
	private JComboBox<String> ComboOpcoesSeletor;
	private JLabel lblSelecao;

    //Titulo
	public void setTitulo(String s) {
		this.Janela.setTitle(s);
	}
	
//	public String getTitulo() {
//		return this.Janela.getTitle();
//	}
//	
	public void setLblSelecao(String s) {
		this.lblSelecao.setText(s);
	}
	
//	public String getLblSelecao() {
//		return this.lblSelecao.getText();
//	}
	
	public void setVisible(Boolean b) {
		this.Janela.setVisible(b);
	}
	
//	public Boolean getVisible() {
//		return Janela.isVisible();
//	}
	
	//Botões
	public JButton getBtnSelecionar() {
		return btnSelecionar;
	}
	
	public JButton getBtnSair() {
		return btnSair;
	}

	
	public JComboBox<String> getComboOpcoesSeletor() {
		return ComboOpcoesSeletor;
	}
	
//	public JFrame getJanela() {
//		return Janela;
//	}	
	
//	protected void setBtnSelecionar(JButton btnSelecionar) {
//		this.btnSelecionar = btnSelecionar;
//	}
//
//	protected void setBtnSair(JButton btnSair) {
//		this.btnSair = btnSair;
//	}
//
//	protected void setComboOpcoesSeletor(JComboBox<?> comboOpcoesSeletor) {
//		ComboOpcoesSeletor = comboOpcoesSeletor;
//	}
	
	
	
	/**
	 * Self Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewSeletor window = new viewSeletor();
					window.JanelaSeletor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public viewSeletor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//@SuppressWarnings("rawtypes")             //É apenas um template GUI
	private void initialize() {
		Janela = new JFrame();
		
		Janela.setTitle("Seletor");
		JLabel lblSelecao = new JLabel("Selecione uma Opção de Conversor:");
		ComboOpcoesSeletor = new JComboBox<String>();
		ComboOpcoesSeletor.setEditable(true);
		
		btnSair = new JButton("sair");
		btnSelecionar = new JButton("selecionar");

		//HardCoded Atributes
		Janela.setBounds(100, 100, 450, 190);
		Janela.setResizable(false);
        Janela.setLocationRelativeTo(null);
		Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Don't Touch it
		GroupLayout groupLayout = new GroupLayout(Janela.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(ComboOpcoesSeletor, 0, 422, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblSelecao))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(267, Short.MAX_VALUE)
							.addComponent(btnSelecionar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelecao)
					.addGap(17)
					.addComponent(ComboOpcoesSeletor, 
							GroupLayout.PREFERRED_SIZE, 36,
							GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnSelecionar))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		Janela.getContentPane().setLayout(groupLayout);
	}
}
