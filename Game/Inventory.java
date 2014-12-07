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

import java.util.*;
import java.io.*;
import java.lang.*;

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
	public void insertItem(Item item) throws FullInventoryException
	{
		//Não insere caso não exista mais espaço livre
		//Não insere caso exista um igual

		if (this.items.size() > spaces)
			throw new FullInventoryException("Inventário Cheio!!!");

		this.items.add(Pair.make_pair(item,false));
	}



	/***  Métodos Remoção  ***/

	/*  Remove do Inventário o Item de nome 'iname' APENAS SE ESTE NÃO ESTÁ EQUIPADO!!  */
	public Item removeItem(String iname)
	{
		// Busca a primeira ocorrência do item de nome 'iname'
		// deleta-o e termina a pesquisa

		Item it = null;

		for (int i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname) && !isEquipped(i))
			{
				it = items.get(i).first;
				this.items.remove(i);
				i = this.items.size();	//fim do for!
			}

		return it;
	}

	/*  Remove do Inventário o Item na posição 'pos' APENAS SE ESTE NÃO ESTÁ EQUIPADO!  */
	public Item removeItem(int pos)
	{
		if (pos < 0 || pos >= this.items.size() || isEquipped(pos))
			return null;
		else
		{
			Item it = items.get(pos).first;
			this.items.remove(pos);
			return it;
		}
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
	public boolean isEquipped (int pos) throws IllegalArgumentException
	{
		if (pos < 0 || ( pos >= this.items.size() ))
			return false;
		
		return this.items.get(pos).second;
	}

	public boolean isEquipped(String iname)
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
	public void equipItem(Item item, GameCharacter user) throws IllegalArgumentException
	{
		this.equipItem(item.getName(), user);
	}
	
	/*  Equipa o item cujo nome é 'iname', caso o Inventário o possua  */
	public void equipItem(String iname, GameCharacter user) throws IllegalArgumentException
	{
		int i = 0;

		for (i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname))
			{
				//caso esteja equipada, não faz sentido equipar novamente
				if (isEquipped(i))
					throw new IllegalArgumentException("Item já está equipado!");

				//caso seja um tipo de weapon, não se pode equipar mais do que MAX_WEAPONS!
				if (this.items.get(i).first.getAttackPts() != 0 && this.nweapons == MAX_WEAPONS)
					throw new IllegalArgumentException("Só duas arma por personagem!");
				
				//caso seja um tipo de armor, não se pode equipar mais do que 1!
				if (this.items.get(i).first.getDefensePts() != 0 && this.armored)
					throw new IllegalArgumentException("Só uma armadura por personagem!");

				this.items.get(i).second = this.items.get(i).first.equip(user, this);


				//caso não tenha sido possível equipar, retorna false
				if (this.items.get(i).second == false)
					throw new IllegalArgumentException("Não foi possível equipar o Item!");

				//caso seja um tipo de weapon, conta-se +1
				if (this.items.get(i).first.getAttackPts() != 0)
					this.nweapons++;
				
				//caso seja um tipo de armor, marca que esta está equipada!
				if (this.items.get(i).first.getDefensePts() != 0)
					this.armored = true;

				return;
			}

		throw new IllegalArgumentException("O item não está no inventário!");
	}


	/*  Equipa o item apontado por 'item', caso o Inventário o possua  */
	public void useItem(Item item, GameCharacter user) throws IllegalArgumentException
	{
		useItem(item.getName(), user);
	}
	
	/*  Equipa o item cujo nome é 'iname', caso o Inventário o possua  */
	public void useItem(String iname, GameCharacter user) throws IllegalArgumentException
	{
		int i = 0;

		// Busca o primeiro item de nome iname, e utiliza-o
		for (i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname))
			{
				if (isEquipped(i))
				{
					if (this.items.get(i).first.use(user,this) == false)
					{
						throw new IllegalArgumentException("Item não pode ser utilizado!");
					}
					else
						return;
				}
				else
				{
					throw new IllegalArgumentException("Item não está equipado!");
				}
			}
		throw new IllegalArgumentException("Item não está no Inventário do Personagem!");
	}


	/*  Desequipa o item apontado por 'item', caso o Inventário o possua  */
	public void unequipItem(Item item, GameCharacter user) throws IllegalArgumentException
	{
		this.unequipItem(item.getName(), user);
	}
	
	/*  Desequipa o item cujo nome é 'iname', caso o Inventário o possua  */
	public void unequipItem(String iname, GameCharacter user) throws IllegalArgumentException
	{
		int i = 0;

		for (i = 0; i < this.items.size(); ++i)
			if (this.items.get(i).first.getName().equals(iname) && isEquipped(i))
			{
				//caso não esteja equipado, não faz sentido desequipá-lo
				if (!isEquipped(i))
					throw new IllegalArgumentException("O item não está equipado!");

				//tenta desequipar
				this.items.get(i).second =  !(this.items.get(i).first.unequip(user, this));

				//se este permanece equipado, ocorreu algo errado!
				if (isEquipped(i))
					throw new IllegalArgumentException("Não foi possível desequipar o item!");

				//verifica se é uma weapon ou armor, e atualiza a quantidade de weapons/armors
				if (this.items.get(i).first.getAttackPts() != 0)
					this.nweapons--;
				if (this.items.get(i).first.getDefensePts() != 0)
					this.armored = false;

				return;
			}

		throw new IllegalArgumentException("O item não está no inventário!");
	}
}