package Game;

public class RagePotion extends Potion
{
	public RagePotion (String name, double price, int restorepts)
	{
		super (name,price,restorepts);
	}

	public boolean use (GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)
			return false;
		
		RageMode rageMode = new RageMode(getRestorePts(), user);

		inv.removeItem(this.getName());

		try
		{
			rageMode.run();
			rageMode.join();
		}
		catch(InterruptedException e)
		{
			//Não faz nada, caso essa excessão ocorra, seria um evento aleatório
			//que seria como um "efeito colateral"!
		}

		return true;
	}

	public String getDescription ()
	{
		return "RagePotion" + " ( " + getRestorePts() + " RAGE pts )";
	}
}