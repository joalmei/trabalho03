package Game;

interface Attacker {
	/*  Valor constante para sinalizar que um ataque foi MISS  */
	public static final int ATTACK_MISS = 0;

	/*  Valor constante para sinalizar que um ataque foi CRITICAL  */
	public static final int ATTACK_CRITICAL = 1;

	/*  Valor constante para sinalizar que um ataque ocorreu normalmente  */
	public static final int ATTACK_NORMAL = 2;


	public void attack(GameCharacter charac);
	public void train();
}