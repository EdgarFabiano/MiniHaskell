package br.unb.cic.poo.MiniHaskell;

public class ExpressaoGetElemLista extends Expressao {
	private int index;
	private Lista list;
	
	public ExpressaoGetElemLista(int index, Lista list) {
		this.index = index;
		this.list = list;
	}

	//Usando o avaliar(), retorna-se o elemento correspondente ao indice dado
	public Valor avaliar() {
		if(index < 0){
			throw new RuntimeException("Erro: o valor do indice precisa ser maior ou igual a zero");
		} else if(list.contador == index){
			list.contador = 0;
			return list.getExpTopo();
		} else {
			if(list.getProximo() == null){
				list.contador = 0;
				throw new RuntimeException("Erro: a lista não possui tantos indices");
			} else{
				list.contador++;
				return new ExpressaoGetElemLista(index, list.getProximo()).avaliar();
			}
		}
	}

	@Override
	public boolean checarTipo() {
		return list.checarTipo();
	}

	@Override
	public Tipo tipo() {
		return list.tipo();
	}

	public int getIndex() {
		return index;
	}

	public Lista getList() {
		return list;
	}

}
