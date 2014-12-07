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
||                Arquivo de Implementação da Classe Auxiliar Utils    (JAVA)             ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

import java.util.Scanner;
import java.util.Random;

/*****  Classe que apresenta todas as funções auxiliares à implementação do sistema,
as quais não estão relacionadas diretamente à lógica do trabalho!  *****/

public class Utils
{

	/*  Retorna um número aleatório no intervalo [min,max)  */
	public static double rnd (double min, double max)
	{
		double range = max - min;
		Random rd = new Random();

		return rd.nextFloat()*range + min;
	}

	/*  Lê Strings, resolvendo o probela de qualquer   */
	public static String readString ()
	{
		String toRead;
	
		Scanner s = new Scanner (System.in);

		do
		{
			toRead = s.nextLine();
		}while(toRead.equals(""));

		return toRead;
	}

	public static int readInt ()
	{
		Scanner s = new Scanner (System.in);
		return s.nextInt();
	}

	public static double readDouble ()
	{
		Scanner s = new Scanner (System.in);
		return s.nextDouble();
	}

	
	/*  Funções que verificam os tipos apontados pelos ponteiros polimórficos 
	(de uso exclusivo da main! não fazem parte da implementação pedida do trabalho!) */

	public static boolean isWeapon(Item it)
	{
		return it instanceof Weapon;
	}

	public static boolean isArmor(Item it)
	{
		return it instanceof Armor;
	}

	public static boolean isPotion(Item it)
	{
		return it instanceof Potion;
	}

	public static boolean isHealthPotion(Item it)
	{
		return it instanceof HealthPotion;
	}

	public static boolean isManaPotion(Item it)
	{
		return it instanceof ManaPotion;
	}

	public static boolean isKnight(GameCharacter ch)
	{
		return ch instanceof Knight;
	}

	public static boolean isThief(GameCharacter ch)
	{
		return ch instanceof Thief;
	}

	public static boolean isWizard(GameCharacter ch)
	{
		return ch instanceof Wizard;
	}
}