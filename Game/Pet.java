package Game;

public class Pet implements Attacker {

	/*Atributos*/
	private int attackPoints;
	private PetTraining pt;

	/*Construtor*/
	public Pet (int attackPoints)
	{
		this.attackPoints = attackPoints;
		pt = new PetTraining (attackPoints, attackPoints/10);
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

		int attack = (int) (this.getAttackPoints() - 0.8 * charac.getDefensePoints() + Utils.rnd(-50,50));

		if (attack < 0)
			attack = 1;

		charac.addHP(-1*attack);
	}

	public void train ()
	{
		pt.start();
	}
}