package Game;

public class ItemShop extends Shop <Item>
{
	public ItemShop (String name)
	{
		super (name);
	}

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

	public void buy (String name, GameCharacter ch)
	{
		int prod = 0;

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