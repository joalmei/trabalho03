/*******************************************************************************************
*                         SCC 604 - Programacao Orientada a Objetos                        *
*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*
*                          Turma 2014/2 - Engenharia de Computação                         *
*                                  Professor: Moacir Ponti                                 *
*------------------------------------------------------------------------------------------*
*                                        Trabalho 3                                        *
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*
*                      Alunos: João Victor Almeida de Aguiar :: 8503986                    *
*                           Cassiano Zaghi de Oliveira :: 7987400                          *
********************************************************************************************/


package Game;

/***  Implementação da class pair (existente em C++) em JAVA  ***/
public class Pair<F, S>
{
	//Assim como em C++, os atributos first e second são públicos
	public F first;
	public S second;

	//Construtor do Pair (recebe first e second)
	public Pair (F first, S second)
	{
		this.first = first;
		this.second = second;
	}

	//Método make_pair, que retorna um Pair com first e second, como no construtor
	public static <F, S> Pair<F, S> make_pair (F first, S second)
	{
		return new Pair<F, S> (first, second);
	}
}

