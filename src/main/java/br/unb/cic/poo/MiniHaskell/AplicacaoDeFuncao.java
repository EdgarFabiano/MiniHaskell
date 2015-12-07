package br.unb.cic.poo.MiniHaskell;

import java.util.List;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class AplicacaoDeFuncao extends Expressao{

	private String nome; 
	private List<Expressao> argumentos;
	
	public AplicacaoDeFuncao(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.argumentos = argumentos;
	}

	public Valor avaliar() {
		DecFuncao funcao = AmbienteExecucao.getInstance().consultaFuncao(nome);
		//primeiro passo: empilhar o ambiente de execucao
		//associando os argumentos aos parametros formais 
		//da declaracao de funcao. 
		
		AmbienteExecucao.getInstance().push();
		for(int i = 0; i < argumentos.size(); i++) {
			AmbienteExecucao.getInstance().declaraVariavel(funcao.getArgumentos().get(i), argumentos.get(i));
		}
		
		//segundo passo: avaliar o corpo da funcao e 
		//desempilhar. 
		
		Valor res = funcao.getCorpo().avaliar();
		AmbienteExecucao.getInstance().pop();
		return res;
	}

	public String getNome() {
		return nome;
	}

	public List<Expressao> getArgumentos() {
		return argumentos;
	}
	
	public boolean checarTipo() {
		for (Expressao expressao : argumentos) {
			if (expressao.checarTipo() == false) {
				return false;
			}
		}
		DecFuncao funcao = AmbienteExecucao.getInstance().consultaFuncao(nome);
		return funcao.getCorpo().checarTipo();
	}

	public Tipo tipo() {
		DecFuncao funcao = AmbienteExecucao.getInstance().consultaFuncao(nome);
		if (checarTipo()) {
			return funcao.getCorpo().tipo();
		}
		return Tipo.ERROR;
	}

}
