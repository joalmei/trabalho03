/*******************************************************************************************
*                         SCC 604 - Programacao Orientada a Objetos                        *
*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*
*                          Turma 2014/2 - Engenharia de Computação                         *
*                                  Professor: Moacir Ponti                                 *
*------------------------------------------------------------------------------------------*
*                                        Trabalho 1                                        *
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*
*                      Aluno: João Victor Almeida de Aguiar :: 8503986                     *
********************************************************************************************/

/*________________________________________________________________________________________*\
============================================================================================
||         Programa de teste utilizando as classes Item e GameCharacter    (JAVA)         ||
============================================================================================
\*----------------------------------------------------------------------------------------*/

// Nota importante !!:
//
// Pela necessidade de se trabalhar com alterações nos atributos de um Character gerados pelo uso de Items, foi necessário
// que, na classe Item, este tivesse conhecimento da classe Character.
//
// Nesse sentido, para que fosse possível este conhecimento "circular", é necessário que o arquivo da classe Item consiga
// ter acesso ao arquivo da classe Character, e como a classe Character possui um Inventário, essa precisa ter conhecimento
// da classe Item. Portanto, para que esses arquivos possam se comunicar, foi necessário que estes se apresentassem em um mesmo
// pacote, uma vez que o compilador não consegue gerenciar "dependências circulares" entre pacotes diferentes.
//
// Portanto, a abordagem de se tomar um pacote Items para os elementos relativos a Items e a Inventário foi substituida pela
// tomada de um pacote "Game".
//
// Este pacote possui todas as classes relativas ao jogo, as quais são utilizadas pela main, que implementa um teste do uso
// desse pacote.

import Game.*;


import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
	{
		Game game = new Game();

		String option;

		showOptions();

		do
		{
			System.out.print( "\nSelect Option: " );
			
			option = Utils.readString();


			if (option.equals("new char"))
				createChar (game);
			else if (option.equals("new item"))
				createItem (game);
			else if (option.equals("new team"))
				createTeam (game);
			else if (option.equals("new pet"))
				createPet (game);
			else if (option.equals("char join team"))
				charJoinTeam (game);
			else if (option.equals("equip char"))
				charEquipItem (game);
			else if (option.equals("train"))
				train (game);
			else if (option.equals("char's status"))
				status (game);
			else if (option.equals("char use item"))
				charUseItem (game);
			else if (option.equals("enter item shop"))
				enterItemShop(game);
			else if (option.equals("enter pet shop"))
				enterPetShop(game);
			else if (option.equals("char attk"))
				charAttack(game);
			else if (option.equals("team battle"))
				teamAttackTeam(game);
			else if (option.equals("show opts"))
				showOptions();
			else if (option.equals("show teams"))
				showTeams (game);
			else if (option.equals("show chars"))
				showChars(game);
			else if (option.equals("show inventory"))
				showInventory(game);
			else if (!option.equals("exit"))
			{
				System.out.print( "INVALID OPTION!!\nTry one of these:\n" );
				showOptions();
			}

		}while (!option.equals("exit"));

		System.out.println("Please, wait for the training and rage threads to finish the program!");
	}

	public static void createChar (Game game)
	{	

		String name, type;
		int special;
		
		System.out.print( "Chars's name: " );
		
		name = Utils.readString();

		do
		{
			System.out.print( "Char's type: " );
			
			type = Utils.readString();

			type = type.toLowerCase();
			if (type.equals("knight"))
			{
				System.out.print( "Knight's power: " );
				special = Utils.readInt();

				game.addChar(new Knight(name, special));
			}
			else if (type.equals("wizard"))
			{
				System.out.print( "Wizard's wisdom: " );
				special = Utils.readInt();

				game.addChar(new Wizard(name, special));
			}
			else if (type.equals("thief"))
			{
				System.out.print( "Thief's stealth: " );
				special = Utils.readInt();

				game.addChar(new Thief(name, special));
			}
			else
			{
				System.out.print( "NOT VALID! TRY: Knight, Thief or Wizard!\n" );
				type = "NO";
			}
		}while(type.equals("NO"));
	}

	public static void createItem (Game game)
	{
		String name, type;
		double price;
		System.out.print( "Item's name: " );
		
		name = Utils.readString();

		System.out.print( "Item's price: " );
		price = Utils.readDouble();


		System.out.print( "Item's type: " );
		
		type = Utils.readString();

		type = type.toLowerCase();

		if (type.equals("weapon"))
		{
			int attackpts;
			int range;

			System.out.print( "Weapon's Attack Points: " );
			attackpts = Utils.readInt();

			System.out.print( "Weapon's Range: " );
			range = Utils.readInt();

			game.addItem(new Weapon (name, price, attackpts, range));
		}
		else if (type.equals("armor"))
		{
			int defensepts;
			double weight;

			System.out.print( "Armor's Defense Points: " );
			defensepts = Utils.readInt();

			System.out.print( "Armor's Weight: " );
			weight = Utils.readInt();

			game.addItem(new Armor (name, price, defensepts, weight));
		}
		else if (type.equals("potion"))
		{
			String ptype;
			int restorepts;

			System.out.print( "Restore Points: " );
			restorepts = Utils.readInt();

			System.out.print( "Potion Type: " );
			
			ptype = Utils.readString();


			ptype = ptype.toLowerCase();
			if (ptype.equals("mana"))
				game.addItem(new ManaPotion (name, price, restorepts));
			else if (ptype.equals("health"))
				game.addItem(new HealthPotion (name, price, restorepts));
			else if (ptype.equals ("rage"))
				game.addItem(new RagePotion (name, price, restorepts));
			else
				System.out.print( "NOT VALID!\n" );
		}
		else
			System.out.print( "NOT VALID!\n" );
	}

	public static void createTeam (Game game)
	{
		String name;
		String color;
		Color cl = Color.black;

		System.out.print( "Team's name: " );
		
		name = Utils.readString();

		do
		{
			System.out.print( "Team's color: " );
			
			color = Utils.readString();

			color = color.toLowerCase();
			if (color.equals("blue"))
				cl = Color.blue;
			else if (color.equals("red"))
				cl = Color.red;
			else if (color.equals("green"))
				cl = Color.green;
			else if (color.equals("yellow"))
				cl = Color.yellow;
			else if (color.equals("white"))
				cl = Color.white;
			else if (color.equals("black"))
				cl = Color.black;
			else
			{
				System.out.print( "INVALID COLOR, TRY ONE OF THESE: blue, red, green, yellow, white, black\n" );
				color = "invalid";
			}
		}while (color.equals("invalid"));

		game.addTeam(new Team(name, cl));
	}

	public static void createPet (Game game)
	{
		String petname, option;

		System.out.println("Pet's name: ");

		petname = Utils.readString();

		Pet pet = new Pet (petname);

		game.addPet(pet);

		/*
		System.out.println("Do you think he needs a best character friend? (yes/no) :");

		do
		{
			option = Utils.readString();
		}while (!option.equals("yes") && !option.equals("no"));

		if (option.equals("yes"))
		{
			String charname = Utils.readString();
			game.winPet(charname,petname);
		}

		*/
	}

	public static void charJoinTeam (Game game)
	{
		String teamID;
		String charID;

		System.out.print( "GameCharacter's name: " );
		charID = Utils.readString();

		System.out.print( "Team's nome: " );
		teamID = Utils.readString();

		try {
			game.joinTeam(charID, teamID);
		}
		catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void showTeams (Game game)
	{
		game.showTeams();
	}

	public static void showChars(Game game)
	{
		game.showCharacters();
	}

	public static void charEquipItem (Game game)
	{
		String input, name;
		System.out.print( "Print character list? " );
		
		input = Utils.readString();

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showCharacters();

		System.out.print( "Char's name: " );
		
		name = Utils.readString();

		System.out.print( "Print character's inventory? " );
		
		input = Utils.readString();

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showInventory(name);


		String it;

		System.out.print( "Item's name: " );

		//Evitar o FLUSH!
		it = Utils.readString();

		try {
			game.equipItem(name, it);
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void charUseItem (Game game)
	{
		String input, name;
		System.out.print( "Print character list? " );
		
		input = Utils.readString();

		input = input.toLowerCase();

		if (input.equals("yes"))
			game.showCharacters();

		System.out.print( "Char's name: " );
		
		name = Utils.readString();

		System.out.print( "Print character's inventory? " );
		
		input = Utils.readString();

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showInventory(name);


		String it;

		System.out.print( "Item's name: " );

		//Evitar o FLUSH!
		it = Utils.readString();

		try {
			game.useItem(name, it);
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}

	/*public static void showItems(Game game)
	{
		game.showItems();
	}
	*/
	
	public static void showInventory(Game game)
	{	
		String name;

		System.out.print( "Char's name: " );
		
		name = Utils.readString();

		try {
			game.showInventory(name);
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}

/*
	public static void charWinsItem(Game game)
	{
		String input, name;
		System.out.print( "Print character list? " );
		
		input = Utils.readString();

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showCharacters();

		System.out.print( "Char's name: " );
		
		name = Utils.readString();

		String it;

		System.out.print( "Item's name: " );

		//Evitar o FLUSH!
		it = Utils.readString();


		try {
			game.winItem(name, it);
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		catch (FullInventoryException e) {
			System.err.println(e.getMessage());
		}

	}
*/

	public static void enterItemShop(Game game)
	{
		String name;

		System.out.print ("Which char will enter the shop? ");

		name = Utils.readString();

		try
		{
			game.enterItemShop(name);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (FullInventoryException e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void enterPetShop(Game game)
	{
		String name;

		System.out.print ("Which char will enter the shop? ");

		name = Utils.readString();

		try
		{
			game.enterPetShop(name);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (FullInventoryException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public static void charAttack(Game game)
	{	
		String name, enemy;

		System.out.print( "Char's name: " );
		
		name = Utils.readString();

		System.out.print( "Enemy's name: " );
		
		enemy = Utils.readString();

		try {
			game.charAttack(name, enemy);
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}
	
	public static void teamAttackTeam(Game game)
	{
		String t1,t2;
		
		System.out.print( "Team 1's name: " );
		t1 = Utils.readString();


		System.out.print( "Team 2's name: " );
		t2 = Utils.readString();

		try {
			game.teamBattle(t1, t2);
		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}

	public static void train (Game game) 
	{
		String name, type;

		System.out.print( "Char's name: " );
		
		name = Utils.readString();

		try {
			do
			{
				System.out.println("Who will train? (Char or Pet): ");
				
				type = Utils.readString();

				type = type.toLowerCase();
				if (type.equals("char"))
				{
					game.trainChar(name);
				}
				else if (type.equals("pet"))
				{
					game.trainPet(name);
				}
				else
				{
					System.out.print( "NOT VALID! TRY: Knight, Thief or Wizard!\n" );
					type = "NO";
				}
			}while(type.equals("NO"));

		}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void status (Game game)
	{
		String ch;

		System.out.print("Which char do you want to check? ");

		ch = Utils.readString();

		game.charStatus(ch);
	}

	public static void showOptions()
	{
		System.out.print( "\nnew char 		: create char\n" +
		"new item 		: create item\n" +
		"new team 		: creat team\n" +
		"new pet 		: creat pet\n" +
		"char to team 		: include a character in a team\n" +
		"power up 		: add char XP\n" + 
		"equip char 		: equip char with an item at his/her inventory\n" +
		"train 			: train a char or a pet's char\n" +
		"char use item 		: use char's item in his/her inventory\n" +
		"char attk 		: char 1 attack char 2\n" +
		"team battle 		: make 2 teams BATTLE!\n" +
		"enter item shop 	: enter in the items shop\n" +
		"enter pet shop 		: enter in the pet shop\n" +
		"show opts 		: show options\n" + 
		"show teams 		: show all the teams in the game\n" +
		"show chars 		: show chars\n" + 
		"show inventory 		: show inventory\n" +
		"exit 			: exit\n" );
	}

}