package model.Temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import model.Conversivel;

public class Kelvin extends Temperatura {
	
	public  static final String TIPO="Kelvin";
	private static final String SIMBOLO="K";
	
	public Kelvin(Number valor) {
		super(valor);
	}
		
	public Kelvin(Temperatura T) {
	    super();
	    super.setValor(converteFrom(T));
	}
	
	public Kelvin(String valor) {
		super(valor);
	}
	
	public Kelvin() {
		// TODO Auto-generated constructor stub
	}

	//ConverteDe deveria ser um atributo unico de cada subclasse conversivel, pois a implementação  converteFrom é a mesma para todos
	public BigDecimal converteFrom(Conversivel T) {
	@SuppressWarnings("serial")
	HashMap<String,BigDecimal> ConverteDe= new HashMap<String,BigDecimal>(){{
		put(Fahrenheit.TIPO,fromFahrenheit(T.getValor()));
		put(Celcius.TIPO,fromCelcius(T.getValor()));
	}};
	
	if(ConverteDe.containsKey(T.getTipo())){
	  return ConverteDe.get(T.getTipo());
	}
		return null;
	}

	//Celcius Para Kelvin
	private BigDecimal fromCelcius(BigDecimal c) {
		return (c.add(new BigDecimal(273.15)));
	};

	//Farenheint Para Kelvin
	private BigDecimal fromFahrenheit(BigDecimal f) {		
		return (f.subtract(new BigDecimal(32)))
				.multiply(
						(new BigDecimal(5)
								.divide(new BigDecimal(9), 4, RoundingMode.HALF_EVEN)))
				.add(new BigDecimal(273));
	};
	
	public String getSimbolo() {
		return SIMBOLO;
	}
	
	public String getTipo() {
		return TIPO;
	}
}
