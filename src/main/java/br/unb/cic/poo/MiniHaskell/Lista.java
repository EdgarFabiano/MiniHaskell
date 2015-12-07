package br.unb.cic.poo.MiniHaskell;

public class Lista extends Valor {

	private Valor expTopo;
	private Lista proximo;
	public static int contador = 0;
	
	public Lista(Valor expTopo, Lista proximo){
		this.expTopo = expTopo;
		this.proximo = proximo;
	}
	
	public Lista getProximo() {
		return proximo;
	}

	public void setProximo(Lista proximo) {
		this.proximo = proximo;
	}
	
	public Valor getExpTopo() {
		return expTopo;
	}
	
	@Override
	public boolean checarTipo() {
		if(proximo != null){
			return (expTopo.tipo() == proximo.expTopo.tipo()) && proximo.checarTipo();
		} else{
			return true;
		}
	}

	@Override
	public Tipo tipo() {
		if(checarTipo()) {
			return expTopo.tipo();
		}
		return Tipo.ERROR;
	}

}
