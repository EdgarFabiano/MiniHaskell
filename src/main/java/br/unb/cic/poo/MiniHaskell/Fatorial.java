package br.unb.cic.poo.MiniHaskell;

public class Fatorial extends Expressao {
	private Expressao exp;
	
	public Fatorial(Expressao exp){
		this.exp = exp;
	}
	
	public Valor avaliar() {
		Valor x = exp.avaliar();
		
		ExpressaoMaiorIgual comparacao1 = new ExpressaoMaiorIgual(x, new ValorInteiro(2));
		ValorBooleano x_MaiorIgual_2 = (ValorBooleano) comparacao1.avaliar();
		ExpressaoMaiorIgual comparacao2 = new ExpressaoMaiorIgual(x, new ValorInteiro(0));
		ValorBooleano x_MaiorIgual_0 = (ValorBooleano) comparacao2.avaliar();
		
		if (x instanceof ValorInteiro) {
			if(x_MaiorIgual_2.getValor()){
				return new ExpressaoMultiplicacao(x, new Fatorial(new ExpressaoSoma(x, new ValorInteiro(-1))).avaliar()).avaliar();
				// Se x >= 2, retorna a multiplicação entre x e o fatorial de x-1
			} else if(x_MaiorIgual_0.getValor()){
				return x;
				// Se 0 <= x < 2, retorna x
			} else {
				throw new RuntimeException("erro de entrada: ela precisa ser maior ou igual a zero");
			}
		} else {
			throw new RuntimeException("erro de tipos");
		}
	}

	public boolean checarTipo() {
		if(exp.tipo().equals(Tipo.INTEIRO)) {
			return true;
		}
		return false;
	}

	public Tipo tipo() {
		if(checarTipo()) {
			return Tipo.INTEIRO;
		}
		return Tipo.ERROR;
	}

	public Expressao getExp() {
		return exp;
	}

}
