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
||                 Arquivo de Implementação da Classe ManaPotion    (JAVA)                ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

public class ManaPotion extends Potion
{
	/*  Métodos da classe HealthPotion (todos são public)  */

	/***  Construtores e Destrutores  ***/
	
	/*  Construtor: recebe o nome, o preço e os pontos de restauração, que são termos imultáveis  */
	public ManaPotion(String name, double price, int restorepts)
	{
		super(name,price,restorepts);
	}


	/***  Métodos de uso do item  ***/

	/*  Método use (utiliza a poção)  */	
	public boolean use(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)	return false;
		
		user.addMP(this.getRestorePts());

		//Após utilizada, uma poção sempre é destruida!
		inv.removeItem(this.getName());

		return true;
	}
}