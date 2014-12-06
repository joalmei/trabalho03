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
||                    Arquivo de Implementação da Classe Thief    (JAVA)                  ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

public class Thief extends GameCharacter
{
	/*  Atributos da classe Thief (todos são protected)  */

	protected int stealth;

	
	/*  Métodos da classe GameCharacter  */

	/***  Construtores e Destrutores  ***/

	/* Construtor que recebe o nome do personagem e stealth, e inicializa suas caracteristicas no mínimo aceitável
	i.e: 100 HP, XP = strength = speed = dexterity = constitution = 1*/
	public Thief(String alias, int stealth)
	{
		super(alias);

		this.stealth = stealth;
	}


	/*  Incrementa o stealth do Thief  */
	public void addStealth(int stealthup)
	{
		this.stealth += stealthup;
	}


	/***  Cálculo dos pontos (todos são protected)  ***/

	/*  Cálculo dos pontos de ataque  */
	protected int getAttackPoints()
	{
		return super.getAttackPoints() + this.stealth;
	}

	/*  Cálculo dos pontos de defesa  */
	protected int getDefensePoints()
	{
		return super.getDefensePoints();
	}

	public void train ()
	{
		this.myitems.spendGold(Utils.rnd(0,30));
		this.HP.addHP(Utils.rnd(0,60));
		this.XP.addXP(Utils.rnd(0,1));
}