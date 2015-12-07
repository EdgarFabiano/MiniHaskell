package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ListaTest extends TestCase {
	
	public void testLista () {
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		
		//Lista inicial com valor 1 na cabeca
		Lista lista = new Lista(v1, null);
		
		ExpressaoAddLista add = new ExpressaoAddLista(v2, lista);
		
		ExpressaoGetTamLista tam = new ExpressaoGetTamLista(lista);
		//verifica o tamanho da lista antes de adicionar
		ValorInteiro tam1 = (ValorInteiro) tam.avaliar();
		
		//adiciona o valor 2 na lista
		lista = (Lista) add.avaliar();
		
		//verifica o tamanho da lista depois de adicionar
		tam = new ExpressaoGetTamLista(lista);
		ValorInteiro tam2 = (ValorInteiro) tam.avaliar();
		
		//verifica que o elemento foi adicionado
		assertNotNull(lista.getProximo());
		
		//verifica que o tamanho mudou
		assertEquals(tam1.getValor().intValue()+1, tam2.getValor().intValue());
		
		//recupera o elemento da cabeca da lista
		ExpressaoGetElemLista get = new ExpressaoGetElemLista(0, lista);
		ValorInteiro res = (ValorInteiro) get.avaliar();
		
		//verifica que ele eh igual ao valor adicionado
		assertEquals(v2.getValor(), res.getValor());
		
		//recupera o elemento depois da cabeca
		get = new ExpressaoGetElemLista(1, lista);
		res = (ValorInteiro) get.avaliar();
		
		//verifica que ele eh igual ao primeiro valor da lista
		assertEquals(v1.getValor(), res.getValor());
		
		//remove o primeiro elemento da lista (no caso, o v2)
		ExpressaoRemoveLista rem = new ExpressaoRemoveLista(0, lista);
		lista = (Lista) rem.avaliar();
		
		//recupera o elemento da cabeca da lista
		get = new ExpressaoGetElemLista(0, lista);
		res = (ValorInteiro) get.avaliar();
		
		//verifica que ele eh igual ao elemento da cabeca da lista
		assertEquals(v1.getValor(), res.getValor());
		
		//verifica se lança exceção ao requerer um elemento nao existente
		try {
			get = new ExpressaoGetElemLista(1, lista);
			res = (ValorInteiro) get.avaliar();
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
		
		//adiciona o valor 2 na cabeca da lista novamente
		lista = (Lista) add.avaliar();
		
		//remove agora o segundo elemento da lista (no caso, o v1)
		rem = new ExpressaoRemoveLista(1, lista);
		lista = (Lista) rem.avaliar();
		
		//recupera o elemento da cabeca da lista
		get = new ExpressaoGetElemLista(0, lista);
		res = (ValorInteiro) get.avaliar();
		
		//verifica que ele eh igual ao elemento da cabeca da lista
		assertEquals(v2.getValor(), res.getValor());
	}

}
