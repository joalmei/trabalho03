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

public class Armor extends Item
{
	/*  Atributos da classe Armor (todos são protected)  */

	protected int defensepts;
	protected double weight;

	/*  Métodos da classe Armor (todos são public)  */

	/***  Construtores e Destrutores  ***/

	/*  Construtor: recebe o nome, o preço, os pontos de defesa da armadura e seu peso, que são termos imultáveis, definindo-o sem dono  */
	public Armor(String name, double price, int defensepts, double weight)
	{
		super(name,price);
		
		// se defensepts < 1, toma-se 1, se defensepts > 20, toma-se 20, caso contrário, toma-se defensepts
		this.defensepts = defensepts < 1 ? 1 : (defensepts > 20 ? 20 : defensepts);
		this.weight = weight;
	}

	/*  Construtor de Cópia  */
	public Armor(Armor am)
	{
		super (am);

		this.defensepts = am.defensepts;
		this.weight = am.weight;
	}


	/***  Getters  ***/

	/*  Retorna defensepts  */
	public int getDefensePts()
	{
		return this.defensepts;
	}

	/*  Retorna os pontos de Ataque de uma armadura, que no caso, é 0  */
	public int getAttackPts()
	{
		return 0;
	}

	/*  Retorna weight  */
	public double getWeigth()
	{
		return this.weight;
	}

	/***  Métodos de uso do Item  ***/

	/*  Método de uso imediato da armadura (ação instantânea)  */
	//não faz nada, uma vez que a armadura só faz sentido em uso contínuo
	public boolean use (GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)	return false;

		return true;
	}

	/*  Método que equipa a armadura do inventário no character, alterando
	o peso deste (início da ação de uso contínuo)  */
	public boolean equip(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)	return false;

		int s_ = (int) ((1.0*user.getSpeed())*Math.exp(-1.0 * Math.pow(this.weight,2)));

		user.setSpeed(s_);

		return true;
	}

	/*  Método que desequipa a armadura do inventário no character, retornando
		o peso deste ao seu peso original (fim da ação de uso contínuo)  */
	public boolean unequip(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)	return false;

		int s = (int) ((1.0*user.getSpeed())/Math.exp(-1.0 * Math.pow(this.weight,2)));
		
		user.setSpeed(s);

		return true;
	}

	public String getDescription ()
	{
		return "Armor ( " + getDefensePts() + " defense pts )";
	}
}