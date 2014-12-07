/*******************************************************************************************
*                         SCC 604 - Programacao Orientada a Objetos                        *
*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*
*                          Turma 2014/2 - Engenharia de Computação                         *
*                                  Professor: Moacir Ponti                                 *
*------------------------------------------------------------------------------------------*
*                                        Trabalho 3                                        *
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*
*                      Alunos: João Victor Almeida de Aguiar :: 8503986                    *
*                           Cassiano Zaghi de Oliveira :: 7987400                          *
********************************************************************************************/


package Game;

/*  Classe RagePotion : Tipo especial de poção, que possui efeito diferenciado das outras,
	uma vez que o efeito desta passa com o tempo, e se torna danoso, no modelo Berseker  */
public class RagePotion extends Potion
{
	RageMode rageMode;	// Possui uma Thread que realiza esse efeito de Rage momentaneo

	/*  Construtor : Recebe o nome, o preco e os pontos que são equivalentes aos pontos de Rage em RageMode  */
	public RagePotion (String name, double price, int restorepts)
	{
		super (name,price,restorepts);
		rageMode = new RageMode(getRestorePts(), null);
	}

	/*  Implementação do uso de um item (classe Item)  */
	public boolean use (GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)
			return false;
		
		rageMode.setRaged(user);

		inv.removeItem(this.getName());

		rageMode.start();

		return true;
	}

	/*  Descrição do Sellable  */
	public String getDescription ()
	{
		return "RagePotion" + " ( " + getRestorePts() + " RAGE pts )";
	}
}