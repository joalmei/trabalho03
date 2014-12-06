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

		do
		{
			System.out.show( "\nSelect Option: " );
			
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
				System.out.show( "INVALID OPTION!!\nTry one of these:\n" );
				showOptions();
			}

		}while (!option.equals("exit"));
	}

	public static void createChar (Game game)
	{
		
	}

	public static void createItem (Game game)
	{

	}

	public static void createTeam (Game game)
	{

	}

	public static void charJoinTeam (Game game)
	{

	}

	public static void showTeams (Game game)
	{

	}

	public static void showChars(Game game)
	{

	}

	public static void powerUp (Game game)
	{

	}

	public static void charEquipItem (Game game)
	{

	}

	public static void charUseItem (Game game)
	{

	}

	public static void showItems(Game game)
	{

	}
	
	public static void charWinsItem(Game game)
	{

	}
	
	public static void charAttack(Game game)
	{

	}
	
	public static void teamAttackTeam(Game game)
	{

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