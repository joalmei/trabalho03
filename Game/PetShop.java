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
/*  Tendo a classe abstrata de definição de uma loja genérica (Shop), podemos tomar uma loja
	do tipo Pet, que conhece a forma de transação a ser realizada com o GameCharacter para
	esse tipo de (Sellable)   */
public class PetShop extends Shop <Pet>
{
	/*  Costrutor : Recebe o nome da Shop  */
	public PetShop (String name)
	{
		super (name);
	}

	/*  Implementa a transação de venda de um Pet de um GameCharacter para a loja   */
	public double sell(String name, GameCharacter ch)
	{
		double price = ch.getPet().getPrice();

		Pet pet = ch.removePet();

		//Caso o Pet cujo nome é 'name', retorna o pet para o GameCharacter
		if (!pet.getName().equals(name))
		{
			try
			{
				ch.winPet(pet);
			}
			catch(FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}

			System.out.println(ch.getName() + " doesn't have " + pet.getName() + " as a pet!");
			return 0;
		}

		//Senão, recebe  o pet e retorna o dinheiro para o GameCharacter
		products.add(pet);

		ch.earnGold(pet.getPrice());

		System.out.println(pet.getName() + " is part of the shop now!");

		return price;
	}

	/*  Implementa a transação de venda de um Pet da Loja para um GameCharacter  */
	public void buy (String name, GameCharacter ch)
	{
		int prod = 0;

		// caso o produto não exista, o argumento é invalido!
		try
		{
			prod = productId(name);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
			return;
		}

		//verifica se o comprador tem dinheiro suficiente para comprar
		double price = products.get(prod).getPrice();

		if (price > ch.getGold())
		{
			System.out.println("Not Enought Money!");
			return;
		}

		/*Verifica se o personagem pode receber o item*/
		try
		{
			ch.winPet(products.get(prod));
		}
		catch (FullInventoryException e)
		{
			System.err.println(e.getMessage());
			return;
		}

		System.out.println(products.get(prod).getName() + " has a new owner now!");

		/*Personagem paga pelo item*/
		ch.spendGold(price);

		/*Item é removido da loja*/
		products.remove(prod);
	}
}