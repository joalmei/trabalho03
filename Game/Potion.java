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
||                    Arquivo de Implementação da Classe Potion    (JAVA)                 ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

public abstract class Potion extends Item
{
	/*  Atributos da classe Potion (todos são protected)  */

	private int restorepts;

	/*  Métodos da classe Potion (todos são public)  */


	/***  Construtores e Destrutores  ***/

	/*  Construtor: recebe o nome, o preço e os pontos de restauração, que são termos imultáveis  */
	public Potion(String name, double price, int restorepts)
	{
		super(name,price);

		this.restorepts = restorepts;
	}

	/*  Construtor de Cópia  */
	public Potion(Potion pt)
	{
		super (pt);

		this.restorepts = pt.restorepts;
	}


	/***  Getters  ***/

	/*  Retorna restorepts  */
	public int getRestorePts()
	{
		return this.restorepts;
	}

	/*  Retornam os pontos de defesa e ataque de uma poção (isto é, 0)  */
	public int getDefensePts()
	{
		return 0;
	}
	public int getAttackPts()
	{
		return 0;
	}

	/***  Métodos de uso do item  ***/

	/*  Método use (utiliza a poção)  */
	public abstract boolean use(GameCharacter user, Inventory inv);

	/*  Métodos de equipar e desequipar uma poção (não refletem alteração alguma no character)  */
	public boolean equip(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null) return false;

		return true;
	}
	public boolean unequip(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null) return false;

		return true;
	}
}