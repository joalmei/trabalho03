/*******************************************************************************************
*                         SCC 604 - Programacao Orientada a Objetos                        *
*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*
*                          Turma 2014/2 - Engenharia de Computação                         *
*                                  Professor: Moacir Ponti                                 *
*------------------------------------------------------------------------------------------*
*                                        Trabalho 2                                        *
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*
*                      Aluno: João Victor Almeida de Aguiar :: 8503986                     *
********************************************************************************************/

/*________________________________________________________________________________________*\
============================================================================================
||                Arquivo de Implementação da Classe GameCharacter    (JAVA)              ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

// Obs: O nome da classe foi alterado de Character para GameCharacter para evitar ambiguidades
// em relação à classe Character do package java.lang, default da linguagem!
public class GameCharacter implements Attacker {

	/*** Constantes definidas! ***/

	/*  Valor constante para sinalizar que um ataque foi MISS  */
	private static final int ATTACK_MISS = 0;

	/*  Valor constante para sinalizar que um ataque foi CRITICAL  */
	private static final int ATTACK_CRITICAL = 1;

	/*  Valor constante para sinalizar que um ataque ocorreu normalmente  */
	private static final int ATTACK_NORMAL = 2;

	/*  Valor constante para o valor mínimo da soma entre as caracteristicas do personagem  */
	private static final int MIN_CHARACTERIZATION = 4;

	/*  Valor constante para o máximo da soma entre as caracteristicas do personagem  */
	private static final int MAX_CHARACTERIZATION = 100;

	/*  Valor constante mínimo de XP que um Personagem pode possuir  */
	private static final int MIN_XP = 1;

	/*  Valor constante máximo de XP que um Personagem pode possuir  */
	private static final int MAX_XP = 100;




	/*  Atributos da classe GameCharacter  */

	/*  Atributos privados  */
	private String alias;
	private Inventory myitems;
	private int HP;
	private int MP;
	private Pet pet;

	/*  Atributos protegidos  */
	protected int XP;
	protected int strenght;
	protected int speed;
	protected int dexterity;
	protected int constitution;



	/*  Métodos da classe GameCharacter  */
	
	/***  Construtores  ***/

	/* Construtor que recebe o nome do personagem e inicializa suas caracteristicas no mínimo aceitável */
	public GameCharacter (String alias)
	{
		this.alias = alias;

		myitems = new Inventory();
		myitems.setSpaces(10);
		
		this.HP = 100;
		this.XP = 1;
		this.strenght = 1;
		this.speed = 1;
		this.dexterity = 1;
		this.constitution = 1;
		this.pet = null;
	}


	
	/***  Setters  ***/

	public void setPet (Pet pet) {
		this.pet = pet;
	}
	
	/*  Atualiza o valor da força do GameCharacter  */
	public void setStrenght(int strenght)
	{
		int characterization = strenght + speed + dexterity + constitution;

		// O somatório das características devem estar no intervalo
		// [MIN_CHARACTERIZATION, MAX_CHARACTERIZATION] = [4,100]

		if (characterization > MAX_CHARACTERIZATION)
		{
			//toma-se o máximo valor válido de strenght
			this.strenght = MAX_CHARACTERIZATION - (characterization - strenght);
		}
		else if (characterization < MIN_CHARACTERIZATION)
		{
			// toma-se o valor mínimo válido de strenght
			this.strenght = MIN_CHARACTERIZATION - (characterization - strenght);
		}
		else
			this.strenght = strenght;
	}

	/*  Atualiza o valor da velocidade do GameCharacter  */
	public void setSpeed(int speed)
	{
		int characterization = strenght + speed + dexterity + constitution;

		// O somatório das características devem estar no intervalo
		// [MIN_CHARACTERIZATION, MAX_CHARACTERIZATION] = [4,100]
	
		if (characterization > MAX_CHARACTERIZATION)
		{
			//toma-se o máximo valor válido de speed
			this.speed = MAX_CHARACTERIZATION - (characterization - speed);
		}
		else if (characterization < MIN_CHARACTERIZATION)
		{
			//toma-se o mínimo valor válido de speed
			this.speed = MIN_CHARACTERIZATION - (characterization - speed);
		}
		else
			this.speed = speed;
	}

	/*  Atualiza o valor da destreza do GameCharacter  */
	public void setDexterity(int dexterity)
	{
		int characterization = strenght + speed + dexterity + constitution;

		// O somatório das características devem estar no intervalo
		// [MIN_CHARACTERIZATION, MAX_CHARACTERIZATION] = [4,100]
		
		if (characterization > MAX_CHARACTERIZATION)
		{
			//toma-se o máximo valor válido de dexterity
			this.dexterity = MAX_CHARACTERIZATION - (characterization - dexterity);
		}
		else if (characterization < MIN_CHARACTERIZATION)
		{
			//toma-se o mínimo valor válido de dexterity
			this.dexterity = MIN_CHARACTERIZATION - (characterization - dexterity);
		}
		else
			this.dexterity = dexterity;

	}

	/*  Atualiza o valor da constituição física do GameCharacter  */
	public void setConstitution(int constitution)
	{
		int characterization = strenght + speed + dexterity + constitution;

		// O somatório das características devem estar no intervalo
		// [MIN_CHARACTERIZATION, MAX_CHARACTERIZATION] = [4,100]
		
		if (characterization > MAX_CHARACTERIZATION)
		{
			//toma-se o máximo valor válido de constitution
			this.constitution = MAX_CHARACTERIZATION - (characterization - constitution);
		}
		else if (characterization < MIN_CHARACTERIZATION)
		{
			//toma-sse o mínimo valor válido de constitution
			this.constitution = MIN_CHARACTERIZATION - (characterization - constitution);
		}
		else
			this.constitution = constitution;
	}



	/***  Getters  ***/

	/**  Getters Públicos  **/

	/*  Retorna o nome do GameCharacter  */
	public String getName()
	{
		return this.alias;
	}

	/**  Getters Protegidos  **/

	/*  Retorna os pontos de defesa do GameCharacter  */
	protected int getDefensePoints()
	{
		int item_def_pts = 0;

		Item search = this.myitems.searchItem(0);	//primeiro elemento

		//soma todos os defense pts de todos os items (tipicamente, os items do tipo Armor)
		//pois os items que não possuem, retornam 0 (como Potion e Weapon)
		for (int i = 0; search != null; i++)
		{
			if (this.myitems.isEquipped(i))
				item_def_pts += search.getDefensePts();

			search = this.myitems.searchItem(i+1);	//toma o próximo elemento da lista
		}

		return (int) ((constitution*0.5 + dexterity*0.3 + speed*0.2)+item_def_pts)*(XP/6);
	}

	/*  Retorna os pontos de ataque do GameCharacter  */
	protected int getAttackPoints()
	{
		int item_att_pts = 0;

		Item search = this.myitems.searchItem(0);	//primeiro elemento da pesquisa

		//soma todos os attack pts de todos os items (tipicamente, os items do tipo Weapon)
		//pois os items que não possuem, retornam 0 (como Portion e Armor)
		for (int i = 0; search != null; i++)
		{
			if (this.myitems.isEquipped(i))
				item_att_pts += search.getAttackPts();

			search = this.myitems.searchItem(i+1);	//próximo elemento da pesquisa
		}

		return (int) ((strenght*0.5 + dexterity*0.3 + speed*0.2) + item_att_pts)*(XP/3);
	}


	/**  Getters Criados por Mim [públicos] (fora do pedido no trabalho)  **/

	/* Retorna o HP do GameCharacter */
	public int getHP()
	{
		return this.HP;
	}

	/* Retorna o XP do GameCharacter */
	public int getXP()
	{
		return this.XP;
	}

	/* Retorna o MP do GameCharacter */
	public int getMP()
	{
		return this.MP;
	}

	/* Retorna o MP do GameCharacter */

	/* Retorna a Força do GameCharacter */
	public int getStrenght()
	{
		return this.strenght;
	}

	/* Retorna a Velocidade do GameCharacter */
	public int getSpeed()
	{
		return this.speed;
	}

	/* Retorna a Destreza do GameCharacter */
	public int getDexterity()
	{
		return this.dexterity;
	}

	/* Retorna a Constituição Física do Personagem */
	public int getConstitution()
	{
		return this.constitution;
	}




	/***  Métodos de Jogabilidade  ***/

	/*  Adiciona ao this.XP atual do jogador uma quantidade XP, respeitando o limite superior de 100  */
	public void addXP(int XP)
	{
		this.XP += XP;

		// Caso o XP se torne maior que o máximo, toma-se o máximo
		if (this.XP > MAX_XP)
			this.XP = MAX_XP;

		// Caso o XP se torne menor que o mínimo, toma-se o mínimo
		if (this.XP < MIN_XP)
			this.XP = MIN_XP;
	}

	public void addHP(int HP)
	{
		this.HP += HP;

		//Não faz sentido existir HP negativo!
		if (this.HP < 0)
			this.HP = 0;
	}

	public void addMP(int MP)
	{
		this.MP += MP;

		// Não faz sentido existir MP negativo!
		if (this.MP < 0)
			this.MP = 0;
	}

	/*  Implementa um ataque na forma 'this' ataca 'carac'  */
	public void attack(GameCharacter charac)
	{
		//Seleciona o tipo de ataque (MISS,CRITICAL ou NORMAL)
		int attack_selec = attackSelection();

		//Caso seja MISS, o ataque não ocorre
		if (attack_selec == ATTACK_MISS)
			return;

		//Dano do ataque normal
		int attak = (int) (this.getAttackPoints() - charac.getDefensePoints() + Utils.rnd(-5,5));

		if (attak <= 0)
			attak = 1;

		//Caso o ataque seja CRITICAL, ele é duplicado
		if (attack_selec == ATTACK_CRITICAL)
			attak *= 2;

		charac.addHP(-1*attak);

		if (this.pet != null) {
			this.pet.attack(charac);
		}
	}


	/**  Métodos de Jogabilidade Criados por mim, para auxiliar na utilização do GameCharacter  **/

	/*  Implementa o ganho de um Item pelo pensonagem. 'this' adiciona a seu inventário   */
	
	// Os métodos de winItem a unequipItem, basicamente, eviam
	// o item (e, se necessário, a referência do character), para
	// as funções do inventário que tratam essas funcionalidades

	public void winItem (Item item) throws FullInventoryException
	{
		myitems.insertItem(item);
	}


	/*  Equipa o item apontado por 'item', caso o GameCharacter o possua  */
	public void equipItem(Item item) throws IllegalArgumentException
	{
		this.myitems.equipItem(item, this);
	}
	
	/*  Equipa o item cujo nome é 'iname', caso o GameCharacter o possua  */
	public void equipItem(String iname) throws IllegalArgumentException
	{
		this.myitems.equipItem(iname, this);
	}

	
	/*  Equipa o item apontado por 'item', caso o GameCharacter o possua  */
	public void useItem(Item item) throws IllegalArgumentException
	{
		this.myitems.useItem(item, this);
	}
	
	/*  Equipa o item cujo nome é 'iname', caso o GameCharacter o possua  */
	public void useItem(String iname) throws IllegalArgumentException
	{
		this.myitems.useItem(iname, this);
	}



	/*  Desequipa o item apontado por 'item', caso o GameCharacter o possua  */
	public void unequipItem(Item item) throws IllegalArgumentException
	{
		this.myitems.unequipItem(item, this);
	}
	
	/*  Desequipa o item cujo nome é 'iname', caso o GameCharacter o possua  */
	public void unequipItem(String iname) throws IllegalArgumentException
	{
		this.myitems.unequipItem(iname, this);
	}



	/**  Métodos auxiliares para a implementação dos Métodos de Jogabilidade, criados por mim [públicos]  **/
	
	/*  Imprime na saída padrão (terminal) o Inventário do personagem  */
	public void printInventory()
	{
		Item it = this.myitems.searchItem(0);	//primeiro elemento da pesquisa

		System.out.print( "There are " + this.myitems.getAvailableSpace() + " spaces avaliable!\n");

		for (int i = 0; it != null; i++)
		{
			System.out.print( it.getName() + " :: " + it.getPrice() + " $ :: ");

			System.out.print( "it has " + it.getDefensePts() + " defense pts and " + it.getAttackPts() + " attack pts ");

			System.out.print( " :: is" + (this.myitems.isEquipped(i) ? " " : "n't ") + "equipped\n");
		
			it = this.myitems.searchItem(i+1);	//proximo elemento da pesquisa
		}
	}

	/**  Métodos auxiliares para a implementação dos Métodos de Jogabilidade, criados por mim [privados]  **/
	
	/*  Implementa a escolha randômica do resultado do ataque (MISS, CRITICAL, NORMAL)  */
	private int attackSelection ()
	{
		double x = Utils.rnd(0,1);

		if (x < 0.1/XP)
			return ATTACK_MISS;

		// retira os valores < 0.1/XP, para calcular mais
		// facilmente a probabilidade
		x -= 0.1/XP;

		if (x < 0.02*(XP/2))
			return ATTACK_CRITICAL;

		return ATTACK_NORMAL;
	}
}