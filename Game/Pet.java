package Game;

public class Pet implements Attacker {

	/*** Constantes definidas! ***/

	/*  Valor constante para sinalizar que um ataque foi MISS  */
	private static final int ATTACK_MISS = 0;

	/*  Valor constante para sinalizar que um ataque foi CRITICAL  */
	private static final int ATTACK_CRITICAL = 1;

	/*  Valor constante para sinalizar que um ataque ocorreu normalmente  */
	private static final int ATTACK_NORMAL = 2;


	/*Atributos*/
	private int attackPoints;

	/*Construtor*/
	public Pet (int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public int getAttackPoints () {

		return this.attackPoints;
	}


	/*  Implementa um ataque na forma 'this' ataca 'carac'  */
	public void attack(GameCharacter charac)
	{
		
		int attack = (int) (this.getAttackPoints() - 0.8 * charac.getDefensePoints() + Utils.rnd(-50,50));

		if (attack < 0)
			attack = 1;

		charac.addHP(-1*attack);
	}
}