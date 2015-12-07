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
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.Fatorial;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.Lista;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
import br.unb.cic.poo.MiniHaskell.ValorInteiro;

public class SubExpVisitor implements Visitor{

	private int total = 0;
	
	public void init() {
		total = 0;
	}
	
	public void visitar(ValorInteiro exp) {
		total += 1; 
	}

	public void visitar(ValorBooleano exp) {
		total += 1; 
	}

	public void visitar(ExpressaoSoma exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	public void visitar(IfThenElse exp) {
		total += 1;
		exp.condicao().aceitar(this);
		exp.expThen().aceitar(this);
		exp.expElse().aceitar(this);
	}
	
	public int getTotal() {
		return total;
	}

	public void visitar(ExpressaoLet exp) {
		total += 1;
		exp.getAtribuicao().aceitar(this);
		exp.getCorpo().aceitar(this);
	}

	public void visitar(Expressao exp) {
	}

	@Override
	public void visitar(ExpRef exp) {
		total += 1;
	}

	@Override
	public void visitar(ExpressaoIgualdade exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	@Override
	public void visitar(AplicacaoDeFuncao exp) {
		total += 1;
		for (Expressao e : exp.getArgumentos()) {
			e.aceitar(this);
		}
	}

	@Override
	public void visitar(ExpressaoMaiorIgual exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoMenorIgual exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);		
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	@Override
	public void visitar(Fatorial exp) {
		total += 1;
		exp.getExp().aceitar(this);	
	}

	@Override
	public void visitar(Lista exp) {
		total += 1;
		exp.getExpTopo().aceitar(this);
		exp.getProximo().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoAddLista exp) {
		total += 1;
		exp.getExp().aceitar(this);
		exp.getList().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoGetElemLista exp) {
		total += 2;
		exp.getList().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoGetTamLista exp) {
		total += 1;
		exp.getList().aceitar(this);
	}

}
