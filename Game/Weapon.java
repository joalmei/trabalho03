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
||                    Arquivo de Implementação da Classe Weapon    (JAVA)                 ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

public class Weapon extends Item
{

	/*  Atributos da classe Weapon (todos são protected)  */
	protected int attackpts;
	protected double range;


	/*  Métodos da classe Weapon (todos são public)  */

	/***  Construtores e Destrutores  ***/

	/*  Construtor: recebe o nome, o preço, os pontos de ataque e seu alcance, que são termos imultáveis  */
	public Weapon(String name, double price, int attackpts, double range)
	{
		super (name,price);

		// se attackpts < 1, toma-se 1, se attackpts > 20, toma-se 20, caso contrário, toma-se attackpts
		this.attackpts = (attackpts < 1 ? 1 : (attackpts > 9 ? 9 : attackpts));
		this.range = range;
	}

	/*  Construtor de Cópia  */
	public Weapon(Weapon wp)
	{
		super (wp);

		this.attackpts = wp.attackpts;
		this.range = wp.range;
	}


	/***  Getters  ***/

	/*  Retorna attackpts  */
	public int getAttackPts()
	{
		return this.attackpts;
	}

	/*  Retorna os pontos de defesa de uma arma (ou seja, 0)  */
	public int getDefensePts()
	{
		return 0;
	}

	/*  Retorna range  */
	public double getRange()
	{
		return this.range;
	}


	/***  Métodos de uso da arma (como o item reflete apenas na
	contagem dos pontos de ataque, os 3 métodos não realizam
	nenhuma ação sobre o personagem e o inventário) ***/


	/*  Método que implementa o uso da arma  */
	public boolean use(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)	return false;
		
		return true;
	}

	/*  Método que implementa a ação de equipar a arma  */
	public boolean equip(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null) return false;
		return true;
	}

	/*  Método que implementa a ação de desequipar a arma  */
	public boolean unequip(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null) return false;
		return true;
	}

	public String getDescription ()
	{
		return "Weapon ( " + getAttackPts() + " attack pts )";
	}
}