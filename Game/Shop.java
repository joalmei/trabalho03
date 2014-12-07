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
		if (products.size() == 0)
		{
			System.out.print("\nThere isn't any products here ):\n");
			return;
		}

		for (int i = 0; i < products.size(); ++i)
		{
			T prod = products.get(i);

			System.out.print("Nome: " + prod.getName() + " ~> ");
			System.out.print(prod.getDescription());
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
			throw new IllegalArgumentException("Item isn't in this game!");

		return nprod;
	}

	private void showOpts ()
	{
		System.out.print("buy:				buy an item\n" + 
						"sell:				sell an item\n" +
						"show products:			show the products inside the shop\n" +
						"show opts:			show the shop options\n" +
						"char's inventory:		show char's inventory\n" +
						"char's pet:			show char's pet\n" +
						"exit:				exit shop\n");
	}

	public void enterShop (GameCharacter ch)
	{
		System.out.println("\nWelcome to " + getName() + " !");

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
				System.out.print("What will " + ch.getName() + " sell today? ");
				itname = Utils.readString();
				sell (itname, ch);
			}
			else if (opt.equals("show products"))
			{
				if (this.products.size() > 0)
				{	
					System.out.print("\nTake a look again! I'm sure you will love these!\n");
					showShop();
				}
				else
					System.out.print("\nThere isn't any products here ):\n");
			}
			else if (opt.equals("show opts"))
			{
				showOpts();
			}
			else if (opt.equals("char's inventory"))
			{
				ch.printInventory();

				String uneq;
				
				System.out.print("Do you want to unequip any of these? (yes/no) ");
	
				do
				{
					uneq = Utils.readString();
				}
				while (!uneq.equals("yes") && !uneq.equals("no"));

				if (uneq.equals("yes"))
				{
					System.out.print("Item's name to unnequip: ");

					String it = Utils.readString();

					ch.unequipItem(it); 
				}
			}
			else if (opt.equals("char's pet"))
			{
				if (ch.getPet() != null)
					System.out.println(ch.getPet().getName() + " -> " + ch.getPet().getAttackPoints() + " attk pts | $ " + ch.getPet().getPrice());
			}
			else if (!opt.equals("exit"))
			{
				System.out.println("Not Valid! Try 'show opts!'");
			}

		}while(!opt.equals("exit"));
	}
}