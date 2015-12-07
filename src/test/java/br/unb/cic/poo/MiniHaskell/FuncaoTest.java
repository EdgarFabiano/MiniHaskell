package br.unb.cic.poo.MiniHaskell;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class FuncaoTest extends TestCase {
	
	public void testFuncSimples () {
		List<String> argumentos = new ArrayList<>();
		argumentos.add("x");
		
		DecFuncao funcao = new DecFuncao("incremento", argumentos, new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(1)));
		AmbienteExecucao.getInstance().declaraFuncao(funcao);
		
		List<Expressao> args = new ArrayList<>();
		
		ValorInteiro v1 = new ValorInteiro(1); 
		args.add(v1);
		
		AplicacaoDeFuncao aplicacao = new AplicacaoDeFuncao("incremento", args);
		
		ValorInteiro res = (ValorInteiro) aplicacao.avaliar();
		assertEquals(new Integer(2), res.getValor());
		
	}
	
	public void testFuncMedia() {
		List<String> argumentos = new ArrayList<>();
		argumentos.add("x");
		argumentos.add("y");
		
		DecFuncao funcao = new DecFuncao("soma e multiplica", argumentos, new ExpressaoSoma(new ExpressaoSoma(new ExpRef(argumentos.get(0)), new ExpRef(argumentos.get(1))), new ExpressaoMultiplicacao(new ExpRef(argumentos.get(0)), new ExpRef(argumentos.get(1)))));
		AmbienteExecucao.getInstance().declaraFuncao(funcao);
		
		List<Expressao> args = new ArrayList<>();
		ValorInteiro v1 = new ValorInteiro(3); 
		args.add(v1);
		args.add(v1);
		
		AplicacaoDeFuncao aplicacao = new AplicacaoDeFuncao("soma e multiplica", args);
		
		ValorInteiro res = (ValorInteiro) aplicacao.avaliar();
		assertEquals(new Integer(15), res.getValor());
	}
	
	public void testFuncComplexa() {
		List<String> argumentos = new ArrayList<>();
		argumentos.add("x");
		argumentos.add("y");
		argumentos.add("z");
		argumentos.add("w");
		
		Expressao exp = new ExpressaoSoma(new ExpressaoMultiplicacao(new Fatorial(new ExpRef("x")), new ExpRef("y")), new ExpressaoMultiplicacao(new ExpRef("z"), new ExpRef("w")));
		
		DecFuncao funcao = new DecFuncao("complexa", argumentos, exp);
		AmbienteExecucao.getInstance().declaraFuncao(funcao);
		
		List<Expressao> args = new ArrayList<>();
		ValorInteiro v1 = new ValorInteiro(3);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(2);
		ValorInteiro v4 = new ValorInteiro(4);
		
		args.add(v1);
		args.add(v2);
		args.add(v3);
		args.add(v4);
		
		AplicacaoDeFuncao aplicacao = new AplicacaoDeFuncao("complexa", args);
		
		ValorInteiro res = (ValorInteiro) aplicacao.avaliar();
		assertEquals(new Integer(20), res.getValor());
	}
}
