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
	
}
