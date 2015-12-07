package br.unb.cic.poo.MiniHaskell;

public class ExpressaoGetTamLista extends Expressao {
	private Lista list;
	
	public ExpressaoGetTamLista(Lista list) {
		this.list = list;
	}

	//Usando o avaliar(), retorna-se o tamanho da lista dada
	public Valor avaliar() {
		list.contador++;
		
		if(list.getProximo() != null){
			return new ExpressaoGetTamLista(list.getProximo()).avaliar();
		} else{
			ValorInteiro tamanho = new ValorInteiro(list.contador);
			list.contador = 0;
			return tamanho;
		}
	}

	@Override
	public boolean checarTipo() {
		return true;
	}

	@Override
	public Tipo tipo() {
		return Tipo.INTEIRO;
	}

	public Lista getList() {
		return list;
	}

}
