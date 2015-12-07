package br.unb.cic.poo.MiniHaskell;

public class ExpressaoRemoveLista extends Expressao {
	private Lista list;
	private static Lista listAnterior = null;
	private static Lista cabecaDaLista = null;
	private int index;

	public ExpressaoRemoveLista(int index, Lista list) {
		this.index = index;
		this.list = list;
	}
	
	//Usando o avaliar(), remove-se um elemento em uma posição da lista dada pelo index
	public Valor avaliar() {
		if(list.contador == 0){
			cabecaDaLista = list;
		}
		
		if(index < 0){
			throw new RuntimeException("Erro: o valor do indice precisa ser maior ou igual a zero");
		} else if(list.contador == index){
			if(listAnterior != null){
				listAnterior.setProximo(list.getProximo());
				list.contador = 0;
				listAnterior = null;
				return cabecaDaLista;
			} else{
				return list.getProximo();
			}
			
		} else {
			if(list.getProximo() == null){
				list.contador = 0;
				listAnterior = null;
				throw new RuntimeException("Erro: a lista não possui tantos indices");
			} else{
				list.contador++;
				listAnterior = list;
				return new ExpressaoRemoveLista(index, list.getProximo()).avaliar();
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
