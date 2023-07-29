package model.Temperatura;

import java.math.BigDecimal;
//import java.math.RoundingMode;
import java.util.HashMap;

import model.Conversivel;

public class Fahrenheit extends Temperatura {
	
	
	public static final String TIPO="Fahrenheit";
	private static final String SIMBOLO="ºF";
		
	public Fahrenheit(Number valor) {
		super(valor);
	}
	
	public Fahrenheit(Temperatura T) {
	    super();
	    super.setValor(converteFrom(T));
	}
	
	public Fahrenheit(String valor) {
		super(valor);
	}

	public Fahrenheit() {
		// TODO Auto-generated constructor stub
	}

	//Celcius Para Farenheint
    private BigDecimal fromCelcius(BigDecimal c) {
	    return (c.multiply(new BigDecimal((1.8))).add(new BigDecimal(32)));
	};
	
	//Kelvin Para Farenheint
	private BigDecimal fromKelvin(BigDecimal k) {
		return (k.multiply(new BigDecimal(1.8)).subtract(new BigDecimal(459.67)));
	};
	
	//ConverteDe deveria ser um atributo unico de cada subclasse conversivel, 
	//pois a implementação  converteFrom é a mesma para todos
	@SuppressWarnings("serial")
	public BigDecimal converteFrom(Conversivel T) {
	HashMap<String,BigDecimal> ConverteDe= new HashMap<String,BigDecimal>(){{
		put(Celcius.TIPO,fromCelcius(T.getValor()));
		put(Kelvin.TIPO,fromKelvin(T.getValor()));
	}};
	
	if(ConverteDe.containsKey(T.getTipo())){
	  return ConverteDe.get(T.getTipo());
	}
		return null;
	}
	
	public String getSimbolo() {
		return SIMBOLO;
	}
	
	public String getTipo() {
		return TIPO;
	}
	
}
