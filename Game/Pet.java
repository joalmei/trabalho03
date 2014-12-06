package Game;

public class Pet implements Attacker {
	private static final int MIN_ATTACK_POINTS = 1;

	/*Atributos*/
	private String name;
	private int attackPoints;
	private PetTraining pt;

	/*Construtor*/
	public Pet (String name)
	{
		this.name = name;
		this.attackPoints = MIN_ATTACK_POINTS;
		pt = new PetTraining (attackPoints, attackPoints/10);
	}

	public void addAttackPoints (int attackPoints)
	{
		this.attackPoints = Math.max(MIN_ATTACK_POINTS, this.attackPoints + attackPoints);
	}

	public int getAttackPoints () {

		return this.attackPoints;
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

		try
		{
			pt.join();
		}
		catch (InterruptedException e)
		{
			//Não faz nada, apenas deixa o pet pegar os resultados disponíveis até então!
		}

		addAttackPoints(pt.getResult());
	}
}