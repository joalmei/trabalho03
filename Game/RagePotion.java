package Game;

public class RagePotion extends Potion
{
	RageMode rageMode;

	public RagePotion (String name, double price, int restorepts)
	{
		super (name,price,restorepts);
		rageMode = new RageMode(getRestorePts(), null);
	}

	public boolean use (GameCharacter user, Inventory inv)
	{
		if (user == null || inv == null)
			return false;
		
		rageMode.setRaged(user);

		inv.removeItem(this.getName());

		rageMode.start();

		return true;
	}

	public String getDescription ()
	{
		return "RagePotion" + " ( " + getRestorePts() + " RAGE pts )";
	}
}