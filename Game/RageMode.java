package Game;

public class RageMode extends Thread
{
	public static final int MIN_RAGE = 1;
	public static final int MAX_RAGE = 100;
	public static final int STEP_TIME = 300;
	
	private int rage;
	private GameCharacter raged;

	public RageMode (int rage, GameCharacter raged)
	{
		setRage(rage);
		this.raged = raged;
	}

	public void setRage (int rage)
	{
		this.rage = Math.max(MIN_RAGE, rage);
		this.rage = Math.min(MAX_RAGE, rage);
	}

	public int getRage ()
	{
		return rage;
	}

	public void use ()
	{
		raged.setStrenght(raged.getStrenght() + rage^2);
		raged.setSpeed(raged.getSpeed() + rage);
		for (int i=0; i<STEP_TIME*rage; i++)
		{
			try
			{
				sleep(STEP_TIME);
			}
			catch(InterruptedException e)
			{
				// A interrupção não faz nada, além de deixar o personagem
				// sofrer com antecedência (como se fosse um efeito aleatório colateral da poção)
			}

			raged.addHP(-1*rage);
			raged.setConstitution(-1*rage/5);
		}

		raged.setSpeed(raged.getSpeed() - rage);
		raged.setStrenght(raged.getStrenght() - rage^2);
	}
}