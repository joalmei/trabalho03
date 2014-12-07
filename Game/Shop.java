package Game;

import java.util.ArrayList;

public abstract class Shop <T extends Sellable>
{
	
	protected ArrayList<T> products;

	public Shop ()
	{
		products = new ArrayList<T> ();
	}
	
	public void showShop ()
	{
		for (int i = 0; i < products.size(); ++i)
		{
			T prod = products.get(i);

			System.out.print("Nome: " + prod.getName() + " ~> ");
			System.out.print(prod.getName());
			System.out.println(" :: $" + prod.getPrice());
		}
	}

	public abstract void buy (String name, GameCharacter ch);

	public abstract double sell (String name, GameCharacter ch);

	protected int productId (String prod) throws IllegalArgumentException
	{
		int nprod = -1;

		for (int i = 0; i < products.size(); ++i)
		{
			if (products.get(i).getName().equals(prod))
			{
				nprod = i;
				i = products.size();
			}
		}

		if (nprod == -1)
			throw new IllegalArgumentException("Item não está no Jogo");

		return nprod;
	}
}