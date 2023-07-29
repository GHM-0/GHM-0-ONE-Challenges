package model.Moeda;

import java.math.BigDecimal;
import java.math.RoundingMode;


import model.Conversivel;


public class  Moeda extends Conversivel {
	
	private String tipo;                             //Nome por extenso da Moeda
	private String simbolo;                          //Sigla de Identificacao USD = Dolar Amaricano
	private BigDecimal qtd;                         //Quantidade de moeda x
	private BigDecimal cotacao;                     //Cotacao relativa ao Real
	private BigDecimal cotacaoRelativa;             //Cotacao relativa ao USD         
	
	private  Integer Precision=4;
	private  RoundingMode Mode=RoundingMode.HALF_EVEN;

	public Moeda(String tipo, String simbolo, BigDecimal cotacaoRelativa,BigDecimal cotacao) {
		this.tipo=tipo;
		this.simbolo=simbolo;
		this.cotacaoRelativa=cotacaoRelativa;
		this.cotacao=cotacao;
		
	}
	
	public Moeda() {};
	public Moeda(String tipo,String simbolo) {
		this.tipo=tipo;
		this.simbolo=simbolo;
	}

	public void setTipo(String nomeFormatado) {
		this.tipo = nomeFormatado;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public void setValor(BigDecimal qtd) {
		this.qtd= qtd;
	}
	public BigDecimal getCotacao() {
		return this.cotacao;
	}

	public void setCotacao(BigDecimal cotacao) {
		this.cotacao = cotacao;
	}

	public BigDecimal getCotacaoRelativa() {
		return this.cotacaoRelativa;
	}

	public void setCotacaoRelativa(BigDecimal cotacaoRelativa) {
		this.cotacaoRelativa = cotacaoRelativa;
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}
	@Override
	public String getSimbolo() {
		return this.simbolo;
	}
	@Override
	public BigDecimal getValor() {
		return this.qtd;
	}
	@Override
	protected void setValor(Number qtd) {
		this.qtd=(new BigDecimal(qtd.toString())
				.setScale(Precision,Mode )
		);
	}
}
