/*******************************************************************************************
*                         SCC 604 - Programacao Orientada a Objetos                        *
*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*
*                          Turma 2014/2 - Engenharia de Computação                         *
*                                  Professor: Moacir Ponti                                 *
*------------------------------------------------------------------------------------------*
*                                        Trabalho 2                                        *
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*
*                      Aluno: João Victor Almeida de Aguiar :: 8503986                     *
********************************************************************************************/

/*________________________________________________________________________________________*\
============================================================================================
||                    Arquivo de Implementação da Classe Wizard    (JAVA)                 ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

public class Wizard extends GameCharacter
{
	/*  Atributos da classe Wizard  */

	protected int wisdom;


	/*  Métodos da classe Wizard  */

	/***  Construtores e Destrutores  ***/

	/* Construtor que recebe o nome do personagem e wisdom, e inicializa suas caracteristicas no mínimo aceitável
	i.e: 100 HP, XP = strength = speed = dexterity = constitution = 1*/
	public Wizard(String alias, int wisdom)
	{
		super(alias);

		this.wisdom = wisdom;
	}
	

	/*  Incrementa o wisdom do Wizards  */
	public void addWisdom(int wisdomup)
	{
		this.wisdom = wisdomup;
	}

	
	/***  Cálculo dos pontos (todos são protected)  ***/

	/*  Cálculo dos pontos de ataque  */
	protected int getAttackPoints()
	{
		return super.getAttackPoints();
	}

	/*  Cálculo dos pontos de defesa  */
	protected int getDefensePoints()
	{
		return super.getDefensePoints() + (this.wisdom/2);
	}
}