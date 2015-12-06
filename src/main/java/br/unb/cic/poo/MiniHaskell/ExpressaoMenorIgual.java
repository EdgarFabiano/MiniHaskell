package br.unb.cic.poo.MiniHaskell;

public class ExpressaoMenorIgual extends ExpressaoBinInt {

	public ExpressaoMenorIgual(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	@Override
	public Valor avaliar(Integer x, Integer y) {
		return new ValorBooleano(x <= y);
	}

}
