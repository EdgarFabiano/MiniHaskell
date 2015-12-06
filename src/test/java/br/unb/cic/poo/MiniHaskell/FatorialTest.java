package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class FatorialTest extends TestCase {
	
	public void testFatorialSimples() {
		Expressao v1 = new ValorInteiro(1);
		Expressao v5 = new ValorInteiro(5);
		Expressao fatorial = new Fatorial(v1);
		
		ValorInteiro res = (ValorInteiro)fatorial.avaliar();
		
		assertEquals(new Integer(1), res.getValor());
		
		fatorial = new Fatorial(v5);
		res = (ValorInteiro)fatorial.avaliar();
		
		assertEquals(new Integer(120), res.getValor());
	}
	
	public void testFatorialErroEntrada() {
		Expressao vMenos1 = new ValorInteiro(-1);;
		Expressao fatorial = new Fatorial(vMenos1);
		
		try {
			Valor res = fatorial.avaliar();
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}
	
	public void testFatorialErroTipo() {
		Expressao vTrue = new ValorBooleano(true);
		Expressao fatorial = new Fatorial(vTrue);
		
		try {
			Valor res = fatorial.avaliar();
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}
	
}
