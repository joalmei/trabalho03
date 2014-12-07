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

/*  Classe Pet, é um companheiro para um GameCharacter que é tanto um item comprável em loja (Sellabe)
	como tem poder de ataque (Attacker). Este tem uma vantagem em frente ao GameCharacter, uma vez que
	este pode passar muito tempo em background treinando!  */
public class Pet implements Attacker, Sellable {
	private static final int MIN_ATTACK_POINTS = 1;

	/*Atributos*/
	private String name;		// nome do pet
	private int attackPoints;	// pontos de ataque do pet
	private PetTraining pt;		// thread de treinamento do pet

	/*Construtor*/
	public Pet (String name)
	{
		this.name = name;
		this.attackPoints = MIN_ATTACK_POINTS;
		pt = new PetTraining (attackPoints, attackPoints/10, this);
	}

	public void addAttackPoints (int attackPoints)
	{
		this.attackPoints = Math.max(MIN_ATTACK_POINTS, this.attackPoints + attackPoints);
	}	

	public double getPrice ()
	{
		return 5*getAttackPoints();
	}

	public int getAttackPoints () {

		return this.attackPoints;
	}

	public String getName() {
		return this.name;
	}

	/*  Implementa um ataque na forma 'this' ataca 'carac'  */
	public void attack(GameCharacter charac)
	{
		// Se o Pet está treinando, ele não pode atacar!
		if (pt.isAlive())
			return;

		int attack = (int) (0.01*this.getAttackPoints() - 0.8 * charac.getDefensePoints() + Utils.rnd(-50,50));

		if (attack < 0)
			attack = 1;

		charac.addHP(-1*attack);
	}

	public void train ()
	{
		int trainTime =  PetTraining.MIN_TRAIN_TIME * ((int) Utils.rnd(0,attackPoints));
		int hardness = PetTraining.MIN_HARDNESS*((int) Utils.rnd(0,attackPoints));

		pt.setTrainTime(trainTime);
		pt.setHardness(hardness);
		pt.start();

		//quando o treinamento em paralelo termina, o pet recebe os devidos benefícios =D

/*
		try
		{
			pt.join();
		}
		catch (InterruptedException e)
		{
			//Não faz nada, apenas deixa o pet pegar os resultados disponíveis até então!
		}

		addAttackPoints(pt.getResult());
*/
	}

	public int trainStatus ()
	{
		return pt.getStatus();
	}

	public String getDescription ()
	{
		return "Pet ( " + getAttackPoints() + " attack pts )";
	}
}