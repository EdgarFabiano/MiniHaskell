package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.AplicacaoDeFuncao;
import br.unb.cic.poo.MiniHaskell.ExpRef;
import br.unb.cic.poo.MiniHaskell.Expressao;
import br.unb.cic.poo.MiniHaskell.ExpressaoAddLista;
import br.unb.cic.poo.MiniHaskell.ExpressaoGetElemLista;
import br.unb.cic.poo.MiniHaskell.ExpressaoGetTamLista;
import br.unb.cic.poo.MiniHaskell.ExpressaoIgualdade;
import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoMaiorIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMenorIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMultiplicacao;
import br.unb.cic.poo.MiniHaskell.ExpressaoRemoveLista;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.Fatorial;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.Lista;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
import br.unb.cic.poo.MiniHaskell.ValorInteiro;

public interface Visitor {
	public void visitar(ValorInteiro exp);
	public void visitar(ValorBooleano exp);
	public void visitar(ExpressaoSoma exp);
	public void visitar(IfThenElse exp);
	public void visitar(ExpressaoLet exp);
	public void visitar(Expressao exp);
	public void visitar(ExpRef exp);
	public void visitar(ExpressaoIgualdade exp);
	public void visitar(AplicacaoDeFuncao exp);
	public void visitar(ExpressaoMaiorIgual exp);
	public void visitar(ExpressaoMenorIgual exp);
	public void visitar(ExpressaoMultiplicacao exp);
	public void visitar(Fatorial exp);
	public void visitar(Lista exp);
	public void visitar(ExpressaoAddLista exp);
	public void visitar(ExpressaoGetElemLista exp);
	public void visitar(ExpressaoGetTamLista exp);
	public void visitar(ExpressaoRemoveLista exp);
	public void init();
}
