package model.Temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Objects;

import model.Conversivel;


public abstract class Temperatura extends Conversivel {
	
	//private static String SIMBOLO="T";
	//public static String TIPO="Temperatura";
	
	private  Integer precision=2;
	private  RoundingMode Mode=RoundingMode.HALF_EVEN;
	
	private BigDecimal valor;

	//Empty Constructor
	protected Temperatura() {};
	
	//Number Constructor
	Temperatura(Number valor) {
		if(!Objects.isNull(valor)){
			this.setValor(valor);
		}
	}
	
	//String Constructor
	Temperatura(String valor) {
			try {
				if((NumberFormat.getInstance().parse(valor)) != null){
					this.setValor(NumberFormat.getInstance().parse(valor));
				}
			} catch (ParseException e) {
				//this.setValor(0);
				e.printStackTrace();
			}	
	}

//complexity is Foolishness
//Useless: Energy to Temperature && Domain need physic ->(Energy,Temperature), (Currency) Logical (Mathematical,Monetary)
	
	//Temperatura Construtor     
//	public Temperatura(Conversivel T) {
//	     this();
//	     if (T.isConversible(this)) { //isConversibel allways (T Temperatura) true except in same Subtipe of Temperatura
//	     this.setValor(converteFrom(T));
//	     }
//	}
	
	public abstract BigDecimal converteFrom(Conversivel T);
		
	protected void setValor(Number valor) {
		this.valor=(new BigDecimal(valor.toString())
				.setScale(precision, Mode)
		);
	}
	
	protected void setValor(BigDecimal valor) {
		this.valor=(valor).setScale(precision, Mode);
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
//	protected Integer getPrecision() {
//		return precision;
//	}
//	
//	protected RoundingMode getMode() {
//		return Mode;
//	}
//	protected void setPrecision(Integer precision) {
//	this.precision = precision;
//}

//protected void setMode(RoundingMode mode) {
//	Mode = mode;
//}
//	
}
