package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ListaTest extends TestCase {
	
	public void testLista () {
		Lista lista = new Lista(new ValorInteiro(1), null);
		
		ExpressaoAddLista add = new ExpressaoAddLista(new ValorInteiro(2), lista);
		
		ExpressaoGetTamLista tam = new ExpressaoGetTamLista(lista);
		ValorInteiro v1 = (ValorInteiro) tam.avaliar();
		
		lista = (Lista) add.avaliar();
		
		tam = new ExpressaoGetTamLista(lista);
		ValorInteiro v2 = (ValorInteiro) tam.avaliar();
		
		assertNotNull(lista.getProximo());
		assertEquals(v1.getValor().intValue()+1, v2.getValor().intValue());
		
		ExpressaoGetElemLista get = new ExpressaoGetElemLista(0, lista);
		ValorInteiro res = (ValorInteiro) get.avaliar();
		
		assertEquals(v2.getValor(), res.getValor());
		
		get = new ExpressaoGetElemLista(1, lista);
		res = (ValorInteiro) get.avaliar();
		
		assertEquals(v1.getValor(), res.getValor());
	}

}
