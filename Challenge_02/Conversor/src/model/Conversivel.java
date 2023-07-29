package model;

import java.math.BigDecimal;

/* Um Tipo é Conversivel para Outro Tipo se Ambos Forem do mesmo Dominio */
/* Um Tipo é Conversivel Para si mesmo mas Isso não é Útil             */

/* Deve Implementar Metodos Logo não é uma Interface */


public abstract class Conversivel {

	//SIMBOLO;
	//TIPO;
	
	//Verificar Declarações
	public abstract String getTipo();
	public abstract String getSimbolo();


	public abstract BigDecimal getValor();
	protected abstract void setValor(Number valor);
	
	
	//Certifica Que Ambos A ser convertido e Conversor estejam no mesmo dominio
	private boolean isConversible(Conversivel Base,Object Ref) {
		if(             //Uma instrução complexa deveria ser dividida em em funções de logica auxilar menores e concisas
		//As classes devem Estar no Mesmo dominio da "Classe Mãe"
				(Base.getClass().getSuperclass())==(Ref.getClass().getSuperclass())
				&& (
			    //Estas Não devem ser do Supertipo (Conversivel), mas de uma subclasses
					(Base.getClass().getSuperclass()!=this.getClass()) && 
					(Ref.getClass().getSuperclass()!=this.getClass())
					))
				/*&&(
				//Não é util Converter para o proprio Tipo -> 5C é 5C
				//Mas é util Converte para o propriotipo quando este e moeda
						Base.getClass()!=Ref.getClass())
				)*/
		{
			return true;    //Mesmo Dominio
		}else {
			return false;  //Dominios Diferentes ou Mesmo tipo
		}
	}

	//Método Usado pelas Filhas para checar o Dominio
	public boolean isConversible(Object Ref) {
		return this.isConversible(this,Ref);
	}
	
	public String toString(){
		return this.getValor().toString()+this.getSimbolo();
	}
}
