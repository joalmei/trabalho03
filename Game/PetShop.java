package Game;

public class PetShop extends Shop <Pet>
{
	public double sell(String name, GameCharacter ch)
	{	
		double price = ch.getPet().getPrice();

		Pet pet = ch.removePet();

		products.add(pet);

		return price;
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
			ch.winPet(products.get(prod));
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