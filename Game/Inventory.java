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
||                  Arquivo de Implementação da Classe Inventory    (JAVA)                ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

import java.util.ArrayList;

public class Inventory {

	/*  Constantes definidas para a classe  */
	private static int MAX_WEAPONS = 2;

	/*  Atributos da classe Inventory (todos são privados) */

	private int spaces;
	private double gold;
	private ArrayList<Pair<Item, Boolean>> items;

	private int nweapons;
	private boolean armored;


	/*  Métodos da classe Inventory  (todos são públicos) */

	/***  Construtores  ***/

	/*  Construtor padrão: Inicializa todos os Atributos  */
	public Inventory()
	{
		items = new ArrayList<Pair<Item, Boolean>> ();
		this.spaces = 0;
		this.gold = 0;

		this.nweapons = 0;
		this.armored = false;
	}
	


	/***  Setters  ***/

	/*  Define quantos espaços estarão disponíveis no inventário  */
	public void setSpaces(int spaces)
	{
		if (spaces < 0)
			return;

		this.spaces = spaces;

		//Caso o novo espaço disponível não é suficiente, o personagem
		//joga fora os itens adquiridos recentemente
		while (this.items.size() > spaces)
			this.items.remove(this.items.size()-1);	
	}



	/***  Getters  ***/

	/*  Retorna o valor do atributo 'gold'  */
	public double getTotalGold()
	{
		return this.gold;
	}
	
	/*  Retorna quanto espaço ainda pode ser utilizado  */
	public int getAvailableSpace()
	{
		return (this.spaces - this.items.size());
	}



	/***  Métodos de Busca  ***/

	/*  Retorna o item de nome 'iname' caso exista, e null caso contrário  */
	public Item searchItem(String iname)
	{
		Item search = null;

		// Busca pela primeira ocorrência do item de mesmo nome que 'iname'
		for (int i = 0; i < this.items.size() && search == null; ++i)
			if (this.items.get(i).first.getName().equals(iname))
				search = this.items.get(i).first;

		return search;
	}

	/*  Retorna o item na posição 'pos' caso exista, e null caso contrário  */
	public Item searchItem(int pos)
	{
		if (pos < 0 || (pos >= this.items.size()))
			return null;
		
		return this.items.get(pos).first;
	}



	/***  Métodos de Inserção  ***/

	/*  Insere no Inventário o Item apontado por 'item'  */
	public void insertItem(Item item)
	{
		//Não insere caso não exista mais espaço livre
		//Não insere caso exista um igual

		if (this.items.size() > spaces || item == null || searchItem(item.getName()) != null)
			return;

		this.items.add(Pair.make_pair(item,false));
	}



	/***  Métodos Remoção  ***/

	/*  Remove do Inventário o Item de nome 'iname'  */
	public void removeItem(String iname)
	{
		// Busca a primeira ocorrência do item de nome 'iname'
		// deleta-o e termina a pesquisa
		for (int i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname))
			{
				this.items.remove(i);
				i = this.items.size();	//fim do for!
			}
	}

	/*  Remove do Inventário o Item na posição 'pos'  */
	public void removeItem(int pos)
	{
		if (pos < 0 || pos >= this.items.size())
			return;
		else
			this.items.remove(pos);
	}


	
	/***  Demais Métodos  ***/

	/*  Implementa a retirada de dinheiro do inventário  */
	public void spendGold(double sgold)
	{
		if (this.gold < sgold)
			return;

		this.gold -= sgold;
	}

	/*  Implementa o ganho de dinheiro no inventário  */
	public void earnGold(double egold)
	{
		this.gold += egold;
	}

	/*  Verifica se o Item está equipado!  */
	boolean isEquipped (int pos)
	{
		if (pos < 0 || ( pos >= this.items.size() ))
			return false;
		
		return this.items.get(pos).second;
	}

	boolean isEquipped(String iname)
	{
		int i = 0;

		for (i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname))
			{
				return this.items.get(i).second;
			}

		return false;
	}


	/*  Equipa o item apontado por 'item', caso o Inventário o possua  */
	boolean equipItem(Item item, GameCharacter user)
	{
		if (item == null || user == null)
			return false;

		return this.equipItem(item.getName(), user);
	}
	
	/*  Equipa o item cujo nome é 'iname', caso o Inventário o possua  */
	boolean equipItem(String iname, GameCharacter user)
	{
		if (user == null)	return false;
		int i = 0;

		for (i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname))
			{
				//caso esteja equipada, não faz sentido equipar novamente
				if (isEquipped(i))
					return false;

				//caso seja um tipo de weapon, não se pode equipar mais do que MAX_WEAPONS!
				if (this.items.get(i).first.getAttackPts() != 0 && this.nweapons == MAX_WEAPONS)
					return false;
				
				//caso seja um tipo de armor, não se pode equipar mais do que 1!
				if (this.items.get(i).first.getDefensePts() != 0 && this.armored)
					return false;

				this.items.get(i).second = this.items.get(i).first.equip(user, this);


				//caso não tenha sido possível equipar, retorna false
				if (this.items.get(i).second == false)
					return false;

				//caso seja um tipo de weapon, conta-se +1
				if (this.items.get(i).first.getAttackPts() != 0)
					this.nweapons++;
				
				//caso seja um tipo de armor, marca que esta está equipada!
				if (this.items.get(i).first.getDefensePts() != 0)
					this.armored = true;

				return true;
			}

		return false;
	}


	/*  Equipa o item apontado por 'item', caso o Inventário o possua  */
	boolean useItem(Item item, GameCharacter user)
	{
		if (item == null || user == null)
			return false;

		return useItem(item.getName(), user);
	}
	
	/*  Equipa o item cujo nome é 'iname', caso o Inventário o possua  */
	boolean useItem(String iname, GameCharacter user)
	{
		if (user == null)	return false;

		int i = 0;

		// Busca o primeiro item de nome iname, e utiliza-o
		for (i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname) && isEquipped(i))
				return this.items.get(i).first.use(user,this);

		return false;
	}


	/*  Desequipa o item apontado por 'item', caso o Inventário o possua  */
	boolean unequipItem(Item item, GameCharacter user)
	{
		if (item == null || user == null)
			return false;

		return this.unequipItem(item.getName(), user);
	}
	
	/*  Desequipa o item cujo nome é 'iname', caso o Inventário o possua  */
	boolean unequipItem(String iname, GameCharacter user)
	{
		int i = 0;

		for (i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname) && isEquipped(i))
			{
				//caso não esteja equipado, não faz sentido desequipá-lo
				if (!isEquipped(i))
					return false;

				//tenta desequipar
				this.items.get(i).second =  !(this.items.get(i).first.unequip(user, this));

				//se este permanece equipado, ocorreu algo errado!
				if (isEquipped(i))
					return false;

				//verifica se é uma weapon ou armor, e atualiza a quantidade de weapons/armors
				if (this.items.get(i).first.getAttackPts() != 0)
					this.nweapons--;
				if (this.items.get(i).first.getDefensePts() != 0)
					this.armored = false;

				return true;
			}

		return false;
	}
}