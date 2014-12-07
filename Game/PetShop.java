package Game;

public class PetShop extends Shop <Pet>
{
	public PetShop (String name)
	{
		super (name);
	}

	public double sell(String name, GameCharacter ch)
	{
		double price = ch.getPet().getPrice();

		Pet pet = ch.removePet();

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

		products.add(pet);

		return price;
	}

	public void buy (String name, GameCharacter ch)
	{
		int prod = productId(name);

		double price = products.get(prod).getPrice();

		if (price > ch.getGold())
		{
			System.out.println("Not enought money!");
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

		/*Personagem paga pelo item*/
		ch.spendGold(price);

		/*Item é removido da loja*/
		products.remove(prod);
	}
}