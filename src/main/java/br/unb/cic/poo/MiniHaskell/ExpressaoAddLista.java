package br.unb.cic.poo.MiniHaskell;

public class ExpressaoAddLista extends Expressao {
	private Valor exp;
	private Lista list;
	
	public ExpressaoAddLista(Valor exp, Lista list) {
		this.exp = exp;
		this.list = list;
	}
	
	//Usando o avaliar(), adiciona-se o elemento dado no inicio da lista dada
	public Valor avaliar() {
		return new Lista(exp, list);
	}

	@Override
	public boolean checarTipo() {
		return list.checarTipo();
	}

	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return list.tipo();
	}

	public Valor getExp() {
		return exp;
	}

	public Lista getList() {
		return list;
	}

}
