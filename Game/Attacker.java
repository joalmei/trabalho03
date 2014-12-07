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

interface Attacker {
	/*  Valor constante para sinalizar que um ataque foi MISS  */
	public static final int ATTACK_MISS = 0;

	/*  Valor constante para sinalizar que um ataque foi CRITICAL  */
	public static final int ATTACK_CRITICAL = 1;

	/*  Valor constante para sinalizar que um ataque ocorreu normalmente  */
	public static final int ATTACK_NORMAL = 2;


	/*  Método que abstrai o conceito de atacar um personagem  */
	public void attack(GameCharacter charac);

	/*  Método que abstrai o conceito de treinar para melhor seu desempenho  */
	public void train();
}