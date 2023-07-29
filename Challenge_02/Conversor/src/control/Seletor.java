package control;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import view.viewSeletor;

public class Seletor {
	
	private static Conversor conversor;
	private static viewSeletor Janela;
	
	@SuppressWarnings("serial")           //Alimentado por Refexão
	private static HashMap<String,Class<? extends Conversor>> Conversores= 
	new HashMap<String,Class<? extends Conversor>>(){{
		put(ConversorTemperatura.TIPO,ConversorTemperatura.class);
		put(ConversorMoeda.TIPO,ConversorMoeda.class);
	}};
	                                                        //?Deveria ser mais Generico e Reutilizavel
	private static void fillSeletor(JComboBox<String> combo,HashMap<String,Class<? extends Conversor>> map) {
		for( Map.Entry<String,Class<? extends Conversor>> entry: map.entrySet()) {
			Object Opcoes = entry.getKey();
			combo.addItem((String) Opcoes);
		}
	}
	
	private static void setActionSair(){
      Janela.getBtnSair().addActionListener(e->{
  		System.exit(0);
  	  });
	}
	
	private static void setActionSelecionar() {
    	Janela.getBtnSelecionar().addActionListener(
    			e->{
    				//System.out.println(Janela.getComboOpcoesSeletor().getSelectedItem());
    				if(Conversores.get(Janela.getComboOpcoesSeletor().getSelectedItem())!=null) {
							try {
								conversor =(Conversor) Conversores.get(Janela.getComboOpcoesSeletor().getSelectedItem())
										.getDeclaredConstructor().newInstance();
							} catch (Exception ex) {           //Bad Practices
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}
							Janela.setVisible(false);
				            conversor.setActionVoltar(Janela);
				            conversor.setVisible(true);
    			}});
   }
	
	public static void main(String[] args) {
		try {
			Janela= new viewSeletor();
            Janela.setVisible(true);
            setActionSair();
            
            fillSeletor(Janela.getComboOpcoesSeletor(), Conversores);
            Janela.getComboOpcoesSeletor().setEditable(false);
            setActionSelecionar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
