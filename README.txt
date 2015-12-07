Implementa��o do MiniHaskell
Alunos: Bruno Jorge Siqueira Rodrigues - 14/0017658
	Edgar Fabiano de Souza Filho - 14/0019201
	Lucas Rezende de Macedo - 14/0026363


Notas de c�digo
----------------------------------
Para visualizar o c�digo, deve-se importar o projeto no eclipse
 como um "Existing Project"

Import -> "Existing Project into Workspace" -> ../Path/to/MiniHaskell

A implementa��o � a mesma desenvolvida em sala do MiniHaskell com algumas
modifica��es e adapta��es nas express�es



Pontos positivos
----------------------------------
+ Expressao agora é uma classe abstrata com a implementacao do metodo aceitar;

+ Adicionado o tipo lista e expressoes de manipulacao de lista:
	- Recupera elemento;
	- Adiciona elemento;
	- Recupera tamanho da lista;
	- Remove elemento.

+ Criadas novas expressoes:
	- Multiplicacao;
	- Igualdade;
	- Maior ou igual;
	- Menor ou igual;
	- Fatorial.
	
+ Criadas as sobrecargas para visitar todas as expressoes concretas com o visitor;

+ Testada mais profundamente a expressao *aplicacao de funcao*;

+ Testadas as novas expressoes criadas;