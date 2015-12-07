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

public class PrettyPrinter implements Visitor {

	String res = "";
	
	public String getRes() {
		return res;
	}
	
	public void visitar(ValorInteiro exp) {
		res += exp.getValor();
	}

	public void visitar(ValorBooleano exp) {
		res += exp.getValor();
	}

	public void visitar(ExpressaoSoma exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " + ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(IfThenElse exp) {
		res += "if(";
		exp.condicao().aceitar(this);
		res += ")";
		res += " then {";
		exp.expThen().aceitar(this);
		res += " } else {";
		exp.expElse().aceitar(this);
		res += "}";
	}

	public void init() {
		res = "";
	}

	public void visitar(ExpressaoLet exp) {
		res += "Let (" + exp.getId();
		res += " = ";
		exp.getAtribuicao().aceitar(this);
		res += ") in ";
		exp.getCorpo().aceitar(this);
	}

	public void visitar(Expressao exp) {		
	}

	@Override
	public void visitar(ExpRef exp) {
		res += exp.getId();
	}

	@Override
	public void visitar(ExpressaoIgualdade exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " == ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	@Override
	public void visitar(AplicacaoDeFuncao exp) {
		res += exp.getNome();
		res += "(";
		for (Expressao e : exp.getArgumentos()) {
			e.aceitar(this);
			res += " ";
		}
		res += ")";
	}

	@Override
	public void visitar(ExpressaoMaiorIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " >= ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	@Override
	public void visitar(ExpressaoMenorIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " <= ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " * ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	@Override
	public void visitar(Fatorial exp) {
		res += "(";
		exp.getExp().aceitar(this);
		res += ")!";
	}

	@Override
	public void visitar(Lista exp) {
		exp.getExpTopo().aceitar(this);
		if (exp.getProximo() != null) {
			res += ", ";
			exp.getProximo().aceitar(this);
		}
	}

	@Override
	public void visitar(ExpressaoAddLista exp) {
		res += "Adicionar(";
		exp.getExp().aceitar(this);
		res += ")";
	}

	@Override
	public void visitar(ExpressaoGetElemLista exp) {
		res += "RecuperarElemento(" + exp.getIndex();	
		res += ")";
	}

	@Override
	public void visitar(ExpressaoGetTamLista exp) {
		res += "Tamanho()";		
	}

	@Override
	public void visitar(ExpressaoRemoveLista exp) {
		res += "Remover(" + exp.getIndex();
		res += ")";
	}

}
