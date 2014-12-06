package Game;

public class PetTraining extends Thread
{
	public static final int MIN_TRAIN_TIME = 100;
	public static final int MIN_HARDNESS = 5;


	private int hardness;
	private int trainTime;
	private int result;

	public PetTraining (int hardness, int trainTime)
	{
		this.hardness = MIN_HARDNESS;
		this.trainTime = MIN_TRAIN_TIME;
		this.result = 0;
	}

	@Override
	public void run ()
	{
		double run_result = 0;

		double train_effect = 1/(MIN_HARDNESS*MIN_TRAIN_TIME*5);

		//TREINA TREINA TREINA TREINA!
		for (int i = 0; i < trainTime*hardness; i++)
		{
			run_result += Utils.rnd(0,train_effect); //RENDIMENTO POR VOLTA É DE 0 A 10
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
				run_result += Utils.rnd(0,train_effect);
			}
		}

		
		result += (int) run_result;
	}

	public void setHardness (int hardness) 
	{
		this.hardness = (hardness < MIN_HARDNESS) ? MIN_HARDNESS : hardness;
	}

	public void setTrainTime (int trainTime)
	{
		this.trainTime = (trainTime < MIN_TRAIN_TIME) ? MIN_TRAIN_TIME : trainTime;
	}

	public int getResult ()
	{
		int res = result;
		
		//Uma vez que o resultado de um treinamento for enviado pra fora do treinamento
		//o treinamento é resetado!
		result = 0;

		return res;
	}
}