/*******************************************************************************************
*                         SCC 604 - Programacao Orientada a Objetos                        *
*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*
*                          Turma 2014/2 - Engenharia de Computação                         *
*                                  Professor: Moacir Ponti                                 *
*------------------------------------------------------------------------------------------*
*                                        Trabalho 3                                        *
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*
*                      Alunos: João Victor Almeida de Aguiar :: 8503986                    *
*                           Cassiano Zaghi de Oliveira :: 7987400                          *
********************************************************************************************/


package Game;

/*  Classe PetTraining : Implementa o treinamento de um pet em paralelo com as outras operações
	do programa!  */
public class PetTraining extends Thread
{
	public static final int TRAIN_LAP_TIME = 500;		//tempo de um ciclo de treinamento
	public static final int MIN_TRAIN_TIME = 100;		//tempo mínimo de treinamento [em número de ciclos]
	public static final int MIN_HARDNESS = 5;			//valor mínimo de dificuldade de um treinamento


	private int hardness;								//dificuldade de um treinamento
	private int trainTime;								//tempo de treinamento
	private int result;									//resultado parcial do treinamento [final, no caso do fim do trenamento]
	private int it;										//iteração

	private Pet pet;

	/*  Construtor do Treinamento, recebe a dificuldade, o tempo e o Pet a ser treinado  */
	public PetTraining (int hardness, int trainTime, Pet pet)
	{
		this.hardness = MIN_HARDNESS;
		this.trainTime = MIN_TRAIN_TIME;
		this.result = 0;
		this.pet = pet;
	}


	/*  Método run : Define a Thread quando é chamado o comando run()  */
	public void run ()
	{
		double run_result = 0;

		// Toma um valor arbitrário para o efeito do treino
		double train_effect = 1/(MIN_HARDNESS*MIN_TRAIN_TIME*5);

		//TREINA TREINA TREINA TREINA!
		for (it = 0; it < trainTime*hardness - 1; it++)
		{
			run_result += Utils.rnd(0,train_effect); //RENDIMENTO POR VOLTA É DE 0 A 10
			try
			{
				sleep (TRAIN_LAP_TIME);
			}
			catch (InterruptedException e) {;}	//caso ocorra uma exceção, deixa seu tratamento continuar

		}

		// TENTA DESCANSAR UM POUCO
		try
		{
			sleep (trainTime*TRAIN_LAP_TIME/5);
		}
		catch (InterruptedException e)
		{
			//O TREINADOR NÃO DEIXOU! MAIS trainTime/10 voltas!!!!!!
			for (int i = 0; i < (trainTime/10)*hardness; i++)
			{
				run_result += Utils.rnd(0,train_effect);
			}
		}

		it++;	//finaliza a última iteração

		result += (int) run_result;		//toma o resultado final 

		pet.addAttackPoints(this.getResult());		//adiciona ao pet as vantagens do treinamento

		it = 0;							//zera as iterações, para consultas futuras aos status do treinamento
	}

	//Toma o mínimo entre MIN_HARDNESS e hardness
	public void setHardness (int hardness) 
	{
		this.hardness = (hardness < MIN_HARDNESS) ? MIN_HARDNESS : hardness;
	}

	//Toma o máximo entre MAX_HARDNESS e hardness
	public void setTrainTime (int trainTime)
	{
		this.trainTime = (trainTime < MIN_TRAIN_TIME) ? MIN_TRAIN_TIME : trainTime;
	}

	/*  Retorna o resultado do útlimo treinamento, e reinicializa o treinamento  */
	public int getResult ()
	{
		int res = result;
		
		//Uma vez que o resultado de um treinamento for enviado pra fora do treinamento
		//o treinamento é resetado!
		result = 0;

		return res;
	}

	// retorna de 0 a 100 % do treinamento!
	public int getStatus ()
	{
		return (it * 100)/(trainTime*hardness);
	}
}