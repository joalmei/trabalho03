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
||                     Arquivo de Implementação da Classe Item    (JAVA)                  ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

public abstract class Item implements Sellable {

	/*   Atributos da classe Item (todos são privados)  */

	private String name;
	private double price;


	/*   Métodos da classe Item  (todos são públicos) */


	/***  Construtores  ***/

	/*  Construtor: recebe o nome, o preço, os pontos de ataque e de defesa do item, que são termos imultáveis, e define o Item sem dono  */
	public Item(String name, double price)
	{
		this.name = name;


		if (price < 0)
			this.price = 0;
		else
			this.price = price;
	}

	public Item(Item it)
	{
		this.name = it.name;
		this.price = it.price;
	}

	/***  Métodos Virtuais Puros que gerenciam as funcionalidades de um Item  ***/

	/*  Método que implementa a ação de Utilizar de um Item (ação instantânea)  */
	public abstract boolean use(GameCharacter user, Inventory inv);

	/*  Método que implementa equipar um Item (início de ação contínua)  */
	public abstract boolean equip(GameCharacter user, Inventory inv);

	/*  Método que implementa desequipar um Item (fim de ação contínua)  */
	public abstract boolean  unequip(GameCharacter user, Inventory inv);

	// Obs: A decisão de utilizar 3 métodos para gerenciar o uso de
	// um item vem do fato de os items serem utilizados instantâneamente
	// ou serem usados por um período de tempo. Logo faz sentido existir
	// a opção de equipar um item, e outra para usar o item. Além disso
	// alguns items perdem a sua ação ao serem desequipados (ex: Armor)
	// Com isso, esses 3 métodos abrangem completamente o significado
	// da utilização de um item em um jogo

	// Obs: A decisão de que esses métodos recebem como parâmetro o Character
	// (GameCharacter) e o Inventory como parâmetro, se referem à necessidade
	// desses métodos de alterar valores de XP, MP e Speed do Character, além
	// de delegar remoções e alterações em elementos do Inventory

	/***  Getters  ***/

	/*  Método que retorna os pontos de defesa de um Item  */
	public abstract int getDefensePts();
	
	/*  Método que retorna os pontos de ataque de um Item  */
	public abstract int getAttackPts();

	/*  Retorna o nome do Item  */
	public String getName()
	{
		return this.name;
	}

	/*  Retorna o preço do Item  */
	public double getPrice()
	{
		return this.price;
	}
}