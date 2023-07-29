package control;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import model.Moeda.Moeda;

class ConversorMoeda extends Conversor {
	
	static final String TIPO = "Conversor de Moeda";

	@SuppressWarnings("serial")
	private HashMap<String, Moeda> Moedas= new HashMap<String,Moeda>(){{
		put("Real",new Moeda("Real","BRL",new BigDecimal(4.7247), new BigDecimal(1)));
		put("Coroa Dinamarquesa",new Moeda("Coroa Dinamarquesa","DKK", new BigDecimal(6.7693), new BigDecimal(0.6972)));
		put("Coroa Norueguesa",new Moeda("Coroa Norueguesa","NOK", new BigDecimal(10.1638), new BigDecimal(0.4643)));
		put("Coroa Sueca",new Moeda("Coroa Sueca","SEK", new BigDecimal(10.5106), new BigDecimal(0.449)));
		put("Dólar Australiano",new Moeda("Dólar Australiano","AUD", new BigDecimal(0.6663), new BigDecimal(3.1451)));
		put("Dólar Canadense",new Moeda("Dólar Canadense","CAD", new BigDecimal(1.3217), new BigDecimal(3.57)));
		put("Dólar dos Estados Unidos",new Moeda("Dólar dos Estados Unidos","USD", new BigDecimal(1), new BigDecimal(4.7202)));
		put("Euro",new Moeda("Euro","EUR", new BigDecimal(1.1007), new BigDecimal(5.1955)));
		put("Franco Suiço",new Moeda("Franco Suiço","CHF", new BigDecimal(0.8682), new BigDecimal(5.4343)));
		put("Iene",new Moeda("Iene","JPY", new BigDecimal(139.97), new BigDecimal(0.03372)));
		put("Libra Esterlina",new Moeda("Libra Esterlina","GBP", new BigDecimal(1.2868), new BigDecimal(6.074)));
	}};
	

	private  void setActionSelecionar(){
			conversor.getBtnSelecionar().addActionListener((e)->{
				Moeda MoedaBase;
				Moeda MoedaRef;

				try {
					MoedaBase = Moedas.get(
							conversor.getComboTipoBase()
							.getSelectedItem());
							MoedaBase.setValor(new BigDecimal(conversor.getTextValorBase()
									.getText()).setScale(4,RoundingMode.HALF_EVEN));

						MoedaRef=(Moeda)Moedas.get(
								conversor.getComboTipoRef()
								.getSelectedItem());

						
						if(MoedaBase.getTipo()!="USD"||MoedaRef.getTipo()!="USD") {
							
							MoedaRef.setValor(
								    new BigDecimal(				
								    (MoedaBase.getValor()          
									.divide(
									(MoedaBase.getCotacaoRelativa()),2,RoundingMode.HALF_EVEN)  
									.multiply(MoedaRef.getCotacaoRelativa()).setScale(2,RoundingMode.HALF_EVEN)).toString()));
						   
						}else {
                            if(MoedaBase.getTipo()=="USD") {
                            	MoedaRef.setValor(MoedaRef.getCotacaoRelativa()   
                            			.multiply(MoedaBase.getValor()));         
                            }
                            if(MoedaRef.getTipo()=="USD") {

                            	MoedaRef.setValor(MoedaBase.getValor()   
                            			.divide(MoedaBase.getCotacaoRelativa()));         
                            }
                            	
                     }
				conversor.setTextValorRef(MoedaRef.getValor().toString().replace(",","."));

				} catch (Exception ex) {
					ex.printStackTrace();
				}finally{

					MoedaBase=null;
					MoedaRef=null;
				}
			});
		}

	public ConversorMoeda() {
		setTitle(TIPO);
				
		fillSeletor(conversor.getComboTipoBase(),Moedas);
		fillSeletor(conversor.getComboTipoRef(),Moedas);
		setCombo(conversor.getComboTipoBase(),conversor.getComboTipoRef(),Moedas);
		
	
		setFildRestriction(conversor.getTextValorBase());
		setActionSelecionar();
		
		conversor.getBtnSelecionar().setEnabled(false); 
		
		enabledActions(conversor.getTextValorBase());
	}

}
