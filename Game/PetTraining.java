package Game;

public class PetTraining extends Thread
{
	private int hardness;
	private int trainTime;
	private int result;

	public PetTraining (int hardness, int trainTime)
	{
		this.hardness = hardness;
		this.trainTime = trainTime;
	}

	@Override
	public void run ()
	{
		result = 0;

		//TREINA TREINA TREINA TREINA!
		for (int i = 0; i < trainTime*hardness; i++)
		{
			result += Utils.rnd(0,10);
		}

		// TENTA DESCANSAR UM POUQUINHO :3
		try
		{
			sleep (trainTime);
		}
		catch (InterruptedException e)
		{
			//O TREINADOR NÃO DEIXOU! MAIS trainTime/10 voltas!!!!!!
			for (int i = 0; i < (trainTime/10)*hardness; i++)
			{
				result += Utils.rnd(0,10);
			}
		}
	}

	public void setHardness () 
	{

	}

	public void setTrainTime ()
	{
		
	}

	public int getResult ()
	{
		return result;
	}
}