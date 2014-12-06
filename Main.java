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

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	private static Scanner s = new Scanner (System.in);

	public static void main(String[] args)
	{
		Game game = new Game();

		String option;

		do
		{
			System.out.print( "\nSelect Option: " );
			
			do
			{
				option = s.nextLine();
			}while (option.equals(""));	//for flush the buffer


			if (option.equals("new char"))
				createChar (game);
			else if (option.equals("new item"))
				createItem (game);
			else if (option.equals("new team"))
				createTeam (game);
			else if (option.equals("char join team"))
				charJoinTeam (game);
			else if (option.equals("equip char"))
				charEquipItem (game);
			else if (option.equals("char use item"))
				charUseItem (game);
			else if (option.equals("char wins item"))
				charWinsItem(game);
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
			else if (option.equals("show items"))
				showItems(game);
			else if (option.equals("show inventory"))
				showInventory(game);
			else if (!option.equals("exit"))
			{
				System.out.print( "INVALID OPTION!!\nTry one of these:\n" );
				showOptions();
			}

		}while (!option.equals("exit"));
	}

	public static void createChar (Game game)
	{	

		String name, type;
		int special;
		
		System.out.print( "Chars's name: " );
		
		do
		{
			name = s.nextLine();
		}while(name.equals(""));

		do
		{
			System.out.print( "Char's type: " );
			
			do
			{
				type = s.nextLine();
			}while(name.equals(""));

			type = type.toLowerCase();
			if (type.equals("knight"))
			{
				System.out.print( "Knight's power: " );
				special = s.nextInt();

				game.addChar(new Knight(name, special));
			}
			else if (type.equals("wizard"))
			{
				System.out.print( "Wizard's wisdom: " );
				special = s.nextInt();

				game.addChar(new Wizard(name, special));
			}
			else if (type.equals("thief"))
			{
				System.out.print( "Thief's stealth: " );
				special = s.nextInt();

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
		
		do
		{
			name = s.nextLine();
		}while (name.equals(""));

		System.out.print( "Item's price: " );
		price = s.nextDouble();


		System.out.print( "Item's type: " );
		
		do
		{
			type = s.nextLine();
		}while (type.equals(""));

		type = type.toLowerCase();

		if (type.equals("weapon"))
		{
			int attackpts;
			int range;

			System.out.print( "Weapon's Attack Points: " );
			attackpts = s.nextInt();

			System.out.print( "Weapon's Range: " );
			range = s.nextInt();

			game.addItem(new Weapon (name, price, attackpts, range));
		}
		else if (type.equals("armor"))
		{
			int defensepts;
			double weight;

			System.out.print( "Armor's Defense Points: " );
			defensepts = s.nextInt();

			System.out.print( "Armor's Weight: " );
			weight = s.nextInt();

			game.addItem(new Armor (name, price, defensepts, weight));
		}
		else if (type.equals("potion"))
		{
			String ptype;
			int restorepts;

			System.out.print( "Restore Points: " );
			restorepts = s.nextInt();

			System.out.print( "Potion Type: " );
			
			do
			{
				ptype = s.nextLine();
			}while (ptype.equals(""));


			ptype = ptype.toLowerCase();
			if (ptype.equals("mana"))
				game.addItem(new ManaPotion (name, price, restorepts));
			else if (ptype.equals("health"))
				game.addItem(new HealthPotion (name, price, restorepts));
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
		
		do
		{
			name = s.nextLine();
		}while (name.equals(""));

		do
		{
			System.out.print( "Team's color: " );
			
			do
			{
				color = s.nextLine();
			}while (color.equals(""));

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

	public static void charJoinTeam (Game game)
	{
		String teamID;
		String charID;

		System.out.print( "GameCharacter's name: " );
		charID = s.nextLine();

		System.out.print( "Team's nome: " );
		teamID = s.nextLine();

		game.joinTeam(charID, teamID);
	}

	public static void showTeams (Game game)
	{
		game.showTeams();
	}

	public static void showChars(Game game)
	{
		game.showCharacters();
	}

	public static void powerUp (Game game)
	{
		;
	}

	public static void charEquipItem (Game game)
	{
		String input, name;
		System.out.print( "Print character list? " );
		
		do
		{
			input = s.nextLine();
		}while (input.equals(""));

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showCharacters();

		System.out.print( "Char's name: " );
		
		do
		{
			name = s.nextLine();
		}while(name.equals(""));

		System.out.print( "Print character's inventory? " );
		
		do
		{
			input = s.nextLine();
		}while (input.equals(""));

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showInventory(name);


		String it;

		System.out.print( "Item's name: " );

		//Evitar o FLUSH!
		do
		{
			it = s.nextLine();
		}while (it.equals(""));

		game.equipItem(name, it);
	}

	public static void charUseItem (Game game)
	{
		String input, name;
		System.out.print( "Print character list? " );
		
		do
		{
			input = s.nextLine();
		}while (input.equals(""));

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showCharacters();

		System.out.print( "Char's name: " );
		
		do
		{
			name = s.nextLine();
		}while(name.equals(""));

		System.out.print( "Print character's inventory? " );
		
		do
		{
			input = s.nextLine();
		}while (input.equals(""));

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showInventory(name);


		String it;

		System.out.print( "Item's name: " );

		//Evitar o FLUSH!
		do
		{
			it = s.nextLine();
		}while (it.equals(""));

		game.useItem(name, it);

	}

	public static void showItems(Game game)
	{
		game.showItems();
	}
	
	public static void showInventory(Game game)
	{

	}

	public static void charWinsItem(Game game)
	{
		String input, name;
		System.out.print( "Print character list? " );
		
		do
		{
			input = s.nextLine();
		}while (input.equals(""));

		input = input.toLowerCase();
		if (input.equals("yes"))
			game.showCharacters();

		System.out.print( "Char's name: " );
		
		do
		{
			name = s.nextLine();
		}while(name.equals(""));

		String it;

		System.out.print( "Item's name: " );

		//Evitar o FLUSH!
		do
		{
			it = s.nextLine();
		}while (it.equals(""));

		game.winItem(name, it);
	}
	
	public static void charAttack(Game game)
	{	
		String name, enemy;

		System.out.print( "Char's name: " );
		
		do
		{
			name = s.nextLine();
		}while(name.equals(""));

		System.out.print( "Enemy's name: " );
		
		do
		{
			enemy = s.nextLine();
		}while(enemy.equals(""));

		game.charAttack(name, enemy);
	}
	
	public static void teamAttackTeam(Game game)
	{
		String t1,t2;
		
		System.out.print( "Team 1's name: " );
		do
		{
			t1 = s.nextLine();
		}while(t1.equals(""));


		System.out.print( "Team 2's name: " );
		do
		{
			t2 = s.nextLine();
		}while(t2.equals(""));

		game.teamBattle(t1, t2);
	}
	
	public static void showOptions()
	{
		System.out.print( "\nnew char 		: create char\n" +
		"new item 		: create item\n" +
		"new team 		: creat team\n" +
		"char to team 		: include a character in a team\n" +
		"power up 		: add char XP\n" + 
		"equip char 		: equip char with an item at his/her inventory\n" +
		"char use item 		: use char's item in his/her inventory\n" +
		"char wins item 		: char <- item\n" + 
		"char attk 		: char 1 attack char 2\n" +
		"team battle 		: make 2 teams BATTLE!\n" +
		"show opts 		: show options\n" + 
		"show teams 		: show all the teams in the game\n" +
		"show chars 		: show chars\n" + 
		"show items 		: show items\n" + 
		"show inventory 	: show inventory\n" +
		"exit 			: exit\n" );
	}

}