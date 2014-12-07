package Game;

import java.util.ArrayList;

public abstract class Shop <T extends Sellable>
{
	private String name;

	protected ArrayList<T> products;

	public Shop (String name)
	{
		setName(name);
		products = new ArrayList<T> ();
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public String getName ()
	{
		return this.name;
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

	public double sell (T product)
	{
		products.add(product);
		return product.getPrice();
	}

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

	private void showOpts ()
	{
		System.out.print("buy:				buy an item\n" + 
						"sell:				sell an item\n" +
						"show products:		show the products inside the shop\n" +
						"show opts:			show the shop options\n" +
						"char's inventory:	show char's inventory\n" +
						"char's pet:		show char's pet\n" +
						"exit:				exit shop\n");
	}

	public void enterShop (GameCharacter ch)
	{
		System.out.println("Welcome to " + getName() + " !");

		System.out.println("\nThis is our complete shelf: \n");

		showShop();

		showOpts();

		String opt, itname;
		
		do
		{
			System.out.print("What do you want to do? ");
			opt = Utils.readString();

			if (opt.equals("buy"))
			{
				System.out.print("What will " + ch.getName() + " buy today? ");
				itname = Utils.readString();
				buy (itname, ch);
			}
			else if (opt.equals("sell"))
			{
				System.out.print("What will " + ch.getName() + " buy today? ");
				itname = Utils.readString();
				buy (itname, ch);
			}
			else if (opt.equals("show products"))
			{
				System.out.print("\nTake a look again! I'm sure you will love these!\n");
				showShop();
			}
			else if (opt.equals("show opts"))
			{
				showOpts();
			}
			else if (!opt.equals("exit"))
			{
				System.out.println("Not Valid! Try 'show opts!'");
			}
			
		}while(!opt.equals("exit"));
	}
}