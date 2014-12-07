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


/*  Interface Sellable : Define o formato de um ente comercializável no comércio do jogo, e possui
	os métodos que são necessário para a implementação de lojas (Shop)  */
public interface Sellable
{
	/*  Método que retorna o nome do Produto  */
	public String getName();

	/*  Preço do Produto  */
	public double getPrice();

	/*  Descrição sucinta do produto  */
	public String getDescription();
}