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
||                Arquivo de Implementação da Classe HealthPotion    (JAVA)               ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

public class HealthPotion extends Potion
{
	/*  Métodos da classe HealthPotion (todos são public)  */

	/***  Construtores e Destrutores  ***/

	/*  Construtor: recebe o nome, o preço e os pontos de restauração, que são termos imultáveis  */
	public HealthPotion(String name,double price,int restorepts)
	{
		super(name,price,restorepts);
	}


	/***  Métodos de uso do item  ***/

	/*  Método use (utiliza a poção)  */	
	public boolean use(GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)	return false;
		
		user.addHP(this.getRestorePts());
	
		//Após ser utilizada, a poção é destruida!
		inv.removeItem(this.getName());

		return true;
	}

	public String getDescription ()
	{
		return "HealthPotion" + " ( " + getRestorePts() + " restore pts )";
	}
}