package model.Temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import model.Conversivel;

//import org.reflections.Reflections;

public class Celcius extends Temperatura {

	public static final String TIPO="Celcius";
	private static final String SIMBOLO="ºC";
	
	private HashMap<String,BigDecimal> ConverteDe;
	
	public Celcius(String valor) {
		super(valor);
	}
	
	public Celcius(Number valor) {
		super(valor);
	}
	
	public Celcius(Temperatura T) {
     super();
     super.setValor(converteFrom(T));
    }

	public Celcius() {
		// TODO Auto-generated constructor stub
	}

	//Farenheint Para Celcius
	private static BigDecimal fromFahrenheit(BigDecimal f) {
		return (f.subtract(new BigDecimal(32))).divide(new BigDecimal((1.8)),4, RoundingMode.HALF_EVEN);
	};
	//Rounding Deve ser usado apenas em setValor da superClasse
	
	//Kelvin Para Celcius
	private static BigDecimal fromKelvin(BigDecimal k) {
		return (k.subtract(new BigDecimal(273.15)));
	};

	//Por que isto so funciona das subclasses?
	@Override
	public String getSimbolo() {
		return SIMBOLO;
	}
	@Override
	public String getTipo() {
		return TIPO;
	}

	//ConverteDe deveria ser um atributo unico de cada subclasse conversivel,
	//pois a implementação  converteFrom é a mesma para todos
	@SuppressWarnings("serial")
	public BigDecimal converteFrom(Conversivel T) {
	ConverteDe= new HashMap<String,BigDecimal>(){{
			put(Fahrenheit.TIPO,fromFahrenheit(T.getValor()));
			put(Kelvin.TIPO,fromKelvin(T.getValor()));
	}};
	
	if(ConverteDe.containsKey(T.getTipo())){
	  return ConverteDe.get(T.getTipo());
	}
		return null;
	}

}


