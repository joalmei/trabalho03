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
	do tipo item, que conhece a forma de transação com um GameCharacter em relação a items   */
public class ItemShop extends Shop <Item>
{
	/*  Construtor : Recebe o nome da loja, e chama o construtor da classe pai, que irá inicializar tudo que é necessário  */
	public ItemShop (String name)
	{
		super (name);
	}

	/*  Implementação do método sell, que realiza a transação de venda de item do personagem para a loja  */
	public double sell (String name, GameCharacter ch)
	{
		Item item = ch.removeItem(name);
		
		if (item == null)
		{
			System.err.println("Character doen't have this Item, or is equipped!");
			return 0;
		}

		ch.earnGold(item.getPrice());

		System.out.println(item.getName() + " is now part of our stok!");

		return item.getPrice();
	}

	/*  Implementação do método buy, que realiza a transação de venda de item da loja para o personagem  */
	public void buy (String name, GameCharacter ch)
	{
		int prod = 0;

		// caso o item não exita, o argumento é invalido!
		try
		{
			prod = productId(name);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
			return;
		}

		double price = products.get(prod).getPrice();

		if (price > ch.getGold())
		{
			System.out.println("Not Enought Money!");
			return;
		}

		/*Verifica se o personagem pode receber o item*/
		try
		{
			ch.winItem(products.get(prod));
		}
		catch (FullInventoryException e)
		{
			System.err.println(e.getMessage());
			return;
		}

		System.out.println(products.get(prod).getName() + " was successfully sold!");

		/*Personagem paga pelo item*/
		ch.spendGold(price);

		/*Item é removido da loja*/
		products.remove(prod);
	}

}