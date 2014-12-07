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

/*  Thread que implementa o "Modo Rage", que é ativado quando um GameCharacter toma uma rage potion,
	e se torna mais poderoso por um curto período de tempo  */
public class RageMode extends Thread
{
	/*  Constantes definidas  */
	public static final int MIN_RAGE = 1;
	public static final int MAX_RAGE = 100;
	public static final int STEP_TIME = 500;
	
	private int rage;				// Rage, que definie o poder de ataque
	private GameCharacter raged;	// GameCharacter que sofre os efeitos [que está no modo rage]

	/*  Construtor : recebe os atributos básicos, a quantidade de rage e quem está no modo rage  */
	public RageMode (int rage, GameCharacter raged)
	{
		setRage(rage);
		this.raged = raged;
	}

	/*  Define a quantidade de Rage  */
	public void setRage (int rage)
	{
		this.rage = Math.max(MIN_RAGE, rage);
		this.rage = Math.min(MAX_RAGE, rage);
	}

	/*  Define quem sofre dos efeitos do modo  */
	public void setRaged(GameCharacter raged)
	{
		this.raged = raged;
	}

	/*  Getter de Rage  */
	public int getRage ()
	{
		return rage;
	}

	/*  Método run: Define o comportamento da Thread quando esta está em execução  */
	public void run ()
	{
		//Aumenta bastante o Speed e a Strenght do personage
		raged.setStrenght(raged.getStrenght() + rage^2);
		raged.setSpeed(raged.getSpeed() + rage);
		for (int i=0; i<rage; i++)
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


			//E diminui HP e Constitution, como efeito colaeral
			raged.addHP(-1*rage);
			raged.setConstitution(-1*rage/5);
		}

		//ao fim do método, retorna aos valores normais de speed e strenght
		raged.setSpeed(raged.getSpeed() - rage);
		raged.setStrenght(raged.getStrenght() - rage^2);
	}
}