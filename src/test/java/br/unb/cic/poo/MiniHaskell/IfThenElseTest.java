package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class IfThenElseTest extends TestCase {
	private Expressao v1 = new ValorInteiro(15);
	private Expressao v2 = new ValorInteiro(15);
	private Expressao v3 = new ValorInteiro(10);

	public void testIgualdadeIfThenElse(){
		/*Teste para valores inteiros*/
			
		Expressao igual = new ExpressaoIgualdade(v1, v2);
	
		Expressao ifthenelse = new IfThenElse(igual.avaliar(),new ExpressaoSoma(v1, v2), new ExpressaoSoma(v1, v3));
		ValorInteiro res = (ValorInteiro)ifthenelse.avaliar();
		assertEquals(res.getValor(), (Integer) 30);
		
	}
	
	
	public void testMaiorIgualIfThenElse(){
	
		Expressao Maiorigual = new ExpressaoMaiorIgual(v3, v2);
	
		Expressao ifthenelse = new IfThenElse(Maiorigual.avaliar(),new ExpressaoSoma(v1, v2), new ExpressaoSoma(v1, v3));
		ValorInteiro res = (ValorInteiro)ifthenelse.avaliar();
	
		assertEquals(res.getValor(), (Integer) 25);
	}

}
