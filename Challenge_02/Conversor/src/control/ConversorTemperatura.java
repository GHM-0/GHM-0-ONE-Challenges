package control;

import java.util.HashMap;
import model.Temperatura.Temperatura;
import model.Temperatura.Celcius;
import model.Temperatura.Fahrenheit;
import model.Temperatura.Kelvin;

class ConversorTemperatura extends Conversor {

	static final String TIPO = "Conversor de Temperatura";

	@SuppressWarnings("serial")    
	private static HashMap<String,Class<? extends Temperatura>> Temperaturas= new HashMap<String,Class<? extends Temperatura>>(){{
		put(Celcius.TIPO,Celcius.class);
		put(Kelvin.TIPO,Kelvin.class);
		put(Fahrenheit.TIPO,Fahrenheit.class);
	}};
		
	private static void setActionSelecionar(){
			conversor.getBtnSelecionar().addActionListener((e)->{	
				Temperatura TempBase;
				Temperatura TempRef;
			
				try {
					TempBase = (Temperatura)  Temperaturas.get(
							conversor.getComboTipoBase()
							.getSelectedItem())
							.getConstructor(String.class)
							.newInstance(conversor.getTextValorBase().getText());
	
						TempRef=(Temperatura)Temperaturas.get(
								conversor.getComboTipoRef()
								.getSelectedItem())
								.getConstructor(Temperatura.class)
								.newInstance(TempBase);
					
				conversor.setTextValorRef(TempRef.getValor().toString().replace(".",","));   
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}finally{
					TempBase=null;
					TempRef=null;
				}
			});
		}
	
	public ConversorTemperatura() {
		setTitle(TIPO);
		
		fillSeletor(conversor.getComboTipoBase(),Temperaturas);
		fillSeletor(conversor.getComboTipoRef(),Temperaturas);
       
		setCombo(conversor.getComboTipoBase(),conversor.getComboTipoRef(),Temperaturas);
		
		setFildRestriction(conversor.getTextValorBase());
		setActionSelecionar();
		
		conversor.getBtnSelecionar().setEnabled(false);
		
		enabledActions(conversor.getTextValorBase());
	}
	


}
