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
			else if (option.equals("char to team"))
				charToTeam (game);
			else if (option.equals("print teams"))
				printTeams (game);
			else if (option.equals("print chars"))
				printChars(game);
			else if (option.equals("power up"))
				powerUp (game);
			else if (option.equals("print inventory"))
				printInventory(game);
			else if (option.equals("equip char"))
				char_equipItem (game);
			else if (option.equals("char use item"))
				charUseItem (game);
			else if (option.equals("print items"))
				printItems(game);
			else if (option.equals("char wins item"))
				charWinsItem(game);
			else if (option.equals("char attk"))
				charAttack(game);
			else if (option.equals("team battle"))
				teamAttackTeam(game);
			else if (option.equals("show opts"))
				showOptions();
			else if (!option.equals("exit"))
			{
				System.out.print( "INVALID OPTION!!\nTry one of these:\n" );
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

	public static void charToTeam (Game game)
	{

	}

	public static void printTeams (Game game)
	{

	}

	public static void printChars(Game game)
	{

	}

	public static void powerUp (Game game)
	{

	}

	public static void printInventory(Game game)
	{

	}

	public static void char_equipItem (Game game)
	{

	}

	public static void charUseItem (Game game)
	{

	}

	public static void printItems(Game game)
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

	}
	
}