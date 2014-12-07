package Game;

public class ItemShop extends Shop <Item>
{
	public double sell (String name, GameCharacter ch)
	{
		Item item = ch.removeItem(name);
		
		return (item == null) ? 0 : item.getPrice();
	}

	public void buy (String name, GameCharacter ch)
	{
		int prod = productId(name);
		double price = products.get(prod).getPrice();

		if (price > ch.getGold())
		{
			System.out.println("Dinheiro insuficiente!");
			return;
		}

		/*Verifica se o personagem pode receber o item*/
		try
		{
			ch.winItem(products.get(prod));
		}
		catch (FullInventoryException e)
		{
			System.err.println(e);
			return;
		}

		/*Personagem paga pelo item*/
		ch.spendGold(price);

		/*Item é removido da loja*/
		products.remove(prod);
	}

}