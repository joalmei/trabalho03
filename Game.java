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


import Game.*;

import java.util.*;

public class Game
{
	public static final int INVALID = -1;

	private ArrayList<GameCharacter> chars;
	//private ArrayList<Item> items;
	private ArrayList<Team> teams;
	//private ArrayList<Pet> pets;

	private PetShop petShop;
	private ItemShop itemShop;


	/*  Construtor Padrão: Cria as listas de personagens e times, e as lojas do jogo  */
	/*  Além disso, cria uma preliminar do jogo, já inserindo vários pesonagens e items nos inventários desses,
		conferindo que o jogo já inicializa com uma grande quantidade de possibilidades  */
	public Game()
	{
		chars = new ArrayList<GameCharacter> ();
		teams = new ArrayList<Team> ();
		petShop = new PetShop ("Miau, au au, etc e tal...");
		itemShop = new ItemShop ("Amazon Web Store");

		ArrayList<Item> items = new ArrayList<Item> ();
		ArrayList<Pet> pets = new ArrayList<Pet> ();

		/* Dados padrões, para teste preliminar do programa */

		/*  Criação dos Items de teste  */

		// Items do Mario
		items.add(new Weapon("Pimba!", 2.4, 5, 6));
		items.add(new Armor("SUPER Malha", 4.3, 5, 3));
		items.add(new ManaPotion("SUPER Dualidade", 6.4, 5));
		items.add(new HealthPotion("Cap", 5, 3));


		// Items do Altafim
		items.add(new Weapon("3000 VOLTS!", 0.5, 3, 2));
		items.add(new Armor("Superficie Gaussiana", 3, 3, 2));


		// Items do Max
		items.add(new Weapon("FLIP-FLOPS", 2.0, 3, 4));
		items.add(new HealthPotion("Cafe + Pao de Queijo", 3.0, 7));


		// Items da Jussara
		items.add(new Weapon("Att, Jussara!", 0.0, 4, 4));                //IT'S SUPER EFFECTIVE!
		items.add(new Armor(":) :3 *-* <3", 0.0, 6, 4));



		// Items do Daniel
		items.add(new Weapon("RAWR!", 2.4, 5, 7));
		items.add(new Weapon("Stewart", 4.3, 1, 3));
		items.add(new Armor("Chamonix", 20.5, 6, 4));
		items.add(new ManaPotion("A ZOEIRA!", 6, 2));


		// Items do Nolasco
		// A cada transacao acima de 6, o comprador ganha uma trufa :D
		items.add(new Weapon("MATEMATICA !!", 5.0, 8, 10));
		items.add(new Armor("EPSILON", 5.0, 10, 0));
		items.add(new HealthPotion("Calculo I", 1.0, 10));
		items.add(new ManaPotion("Analise", 4.0, 10));


		// Items da GRACA
		items.add(new Weapon("VC TA RINDO DO QUE? QUAL EH A GRACA?", 0.0, 5, 5));
		items.add(new Armor("Sedgewick", 10.0, 4, 0.5));


		// Items da Silvana
		items.add(new Weapon("JUPITERWEB!", 0.0, 5, 20));
		items.add(new HealthPotion("Formatura", 4.0, 5));

		
		// Items adicionais de fim de semestre:
		items.add(new HealthPotion("Homenagem", 0.5, 5));
		items.add(new Weapon("Prova na ultima semana", 0.1, 6, 4));


		/*  Criação dos Characters de teste, e redistribuição dos items para eles  */

		//Mario
		chars.add(new Knight("Mario Olesk", 3));
		chars.get(0).addXP(3);
		chars.get(0).setStrenght(4);
		chars.get(0).setSpeed(3);
		chars.get(0).setDexterity(3);
		chars.get(0).setConstitution(4);

		for (int i = 0; i < 4; ++i)
		{
			try
			{
				chars.get(0).winItem(items.get(i));
				chars.get(0).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}


		//Altafim
		chars.add(new Wizard("Altafim", 3));
		chars.get(1).addXP(3);
		chars.get(1).setStrenght(3);
		chars.get(1).setSpeed(2);
		chars.get(1).setDexterity(3);
		chars.get(1).setConstitution(1);

		for (int i = 4; i < 6; ++i)
		{
			try
			{
				chars.get(1).winItem(items.get(i));
				chars.get(1).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}


		//Max
		chars.add(new Thief("Max", 4));
		chars.get(2).addXP(2);
		chars.get(2).setStrenght(3);
		chars.get(2).setSpeed(6);
		chars.get(2).setDexterity(3);
		chars.get(2).setConstitution(3);

		for (int i = 6; i < 8; ++i)
		{
			try
			{
				chars.get(2).winItem(items.get(i));
				chars.get(2).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}


		//Jussara
		chars.add(new Wizard("Jussara", 5));
		chars.get(3).addXP(4);
		chars.get(3).setStrenght(1);
		chars.get(3).setSpeed(3);
		chars.get(3).setDexterity(4);
		chars.get(3).setConstitution(1);

		for (int i = 8; i < 10; ++i)
		{
			try
			{
				chars.get(3).winItem(items.get(i));
				chars.get(3).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}


		//Daniel
		chars.add(new Wizard("Daniel", 4));
		chars.get(4).addXP(3);
		chars.get(4).setStrenght(3);
		chars.get(4).setSpeed(4);
		chars.get(4).setDexterity(4);
		chars.get(4).setConstitution(2);

		for (int i = 10; i < 14; ++i)
		{
			try
			{
				chars.get(4).winItem(items.get(i));
				chars.get(4).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}


		//Nolasco
		chars.add(new Wizard("Nolasco", 5));
		chars.get(5).addXP(5);
		chars.get(5).setStrenght(4);
		chars.get(5).setSpeed(4);
		chars.get(5).setDexterity(5);
		chars.get(5).setConstitution(3);

		for (int i = 14; i < 18; ++i)
		{
			try
			{
				chars.get(5).winItem(items.get(i));
				chars.get(5).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}


		//Graça
		chars.add(new Thief("GracaP", 4));
		chars.get(6).addXP(2);
		chars.get(6).setStrenght(3);
		chars.get(6).setSpeed(6);
		chars.get(6).setDexterity(3);
		chars.get(6).setConstitution(1);

		for (int i = 18; i < 20; ++i)
		{
			try
			{
				chars.get(6).winItem(items.get(i));
				chars.get(6).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}


		//Silvana
		chars.add(new Knight("Silvana", 5));
		chars.get(7).addXP(3);
		chars.get(7).setStrenght(1);
		chars.get(7).setSpeed(2);
		chars.get(7).setDexterity(3);
		chars.get(7).setConstitution(1);

		for (int i = 20; i < 22; ++i)
		{
			try
			{
				chars.get(7).winItem(items.get(i));
				chars.get(7).equipItem(items.get(i));
			}
			catch (FullInventoryException e)
			{
				System.err.println(e.getMessage());
			}
		}

		//Remover os items já designados aos personagens do vetor de items
		int nremoves = items.size()-2;

		for (int i=0; i<nremoves; i++)
		{
			items.remove(0);
		}

		//Criação de dois times de teste e redistribuição dos personagens neles
		teams.add(new Team ("EESC", Color.green));
		teams.add(new Team ("ICMC", Color.blue));

		for (int i = 0; i < 4; ++i)
			teams.get(0).addChar (chars.get(i));

		for (int i = 4; i < 8; ++i)
		{
			teams.get(1).addChar (chars.get(i));
		}

		//Simula uma batalha básica entre os dois times
		teamBattle(0,1);

		//Cria novos items e pets para as lojas
		addItem(new Weapon("FISICA!!", 5.0, 8, 10));
		addItem(new Armor("DELTA", 5.0, 10, 0));
		addItem(new HealthPotion("Água", 1.0, 10));
		addItem(new ManaPotion("Suco de Laranja", 4.0, 10));
		addItem (new RagePotion("MilkShake", 10, 5));

		addPet(new Pet ("gatinho"));
		addPet(new Pet ("dragão"));
		addPet(new Pet ("leão"));
	}

	/*  Faz  um char ch sair do time tm */
	public void exitTeam (String ch, String tm) throws IllegalArgumentException
	{
		int tmId = teamId(tm);

		if (teams.get(tmId).removeChar(ch) != true)
			throw new IllegalArgumentException ("Personagem não faz parte do Time");
	}

	/*  Realiza uma batalha entre os times team1 e team2  */
	public void teamBattle (String team1, String team2) throws IllegalArgumentException
	{
		int tm1 = teamId(team1);
		int tm2 = teamId(team2);

		teamBattle (tm1, tm2);
	}

	/*  Realiza uma batalha entre os time team1 e team2  */
	private void teamBattle(int team1, int team2)
	{
		if (team1 == team2)
			System.out.println("REBELION ISN'T ALLOWED! THE TEAMS MUST BE DIFFERENT FOR BATTLE!\n");

		// Escolhe aleatóriamente qual o time que começa
		if (Utils.rnd(0,1) < 0.5)
		{
			int aux = team2;
			team2 = team1;
			team1 = aux;
		}
		
		// Escolhe aléatóriamente o jogador que começa
		int p1 = (int) Utils.rnd(0, teams.get(team1).nChars());

		// Inicia a batalha sequencialmente nos dois times
		for (int i = p1; i < teams.get(team1).nChars(); ++i)
		{
			GameCharacter c1 = teams.get(team1).searchChar(i);
			GameCharacter c2 = teams.get(team2).searchChar(i);
			
			if (c1 != null && c2 != null)
			{
				c1.attack(c2);
				if (c2.getHP() <= 0)
				{
					System.out.print( c2.getName() + " is DEAD )':\n" );
					removeChar(c2.getName());
				}
				else
				{
					c2.attack(c1);
					if (c1.getHP() <= 0)
					{
						System.out.print( c1.getName() + " is DEAD )':\n" );
						removeChar(c1.getName());
					}
				}
			}
		}

		// Depois de terminadas as batalhas, atualiza os dados dos times!
		int res = teams.get(team1).resolveBattle(teams.get(team2));
		teams.get(team2).resolveBattle(teams.get(team1));

		if (res > 0)
			System.out.println(teams.get(team1).getName() + " won!");
		else
			System.out.println(teams.get(team2).getName() + " won!");
	}


	/*  Implementa a luta entre dois GameCharacter ch1 e ch2  */
	public void charAttack (String ch1, String ch2) throws IllegalArgumentException
	{
		int c1,c2;
		c1 = charId(ch1);
		c2 = charId(ch2);

		charAttack(c1,c2);
	}

	/*  Implementa a luta entre dois GameCharacter ch1 e ch2  */
	private void charAttack (int ch1, int ch2) throws IllegalArgumentException
	{
		if (ch1 < 0 || ch2 < 0 || ch1 >= chars.size() || ch2 >= chars.size())
			throw new IllegalArgumentException ("Personagem não está no Jogo");

		if (ch1 == ch2)
			System.out.println("SUICIDE IS NOT AN OPTION! LIVE WITH YOUR PAINS!\n");

		chars.get(ch1).attack(chars.get(ch2));

		if (chars.get(ch2).getHP() <= 0)
		{
			System.out.print(chars.get(ch2).getName() + " is DEAD )':\n" );
			chars.remove (ch2);
		}
	}

	/*  Implementa a entrada do character ch no time tm  */
	public void joinTeam (String ch, String tm) throws IllegalArgumentException
	{
		int c = charId (ch);
		int t = teamId (tm);

		joinTeam (c,t);
	}

	/*  Implementa a entrada do character ch no time tm  */
	private void joinTeam (int ch, int tm) throws IllegalArgumentException
	{
		if (ch < 0 || ch >= chars.size())
			throw new IllegalArgumentException("Personagem não está no Jogo");
		if  (tm < 0 || tm >= teams.size())
			throw new IllegalArgumentException("Time não está no Jogo");

		for (int i = 0; i < teams.size() && teams.get(i).removeChar(chars.get(i).getName()); i++);

		teams.get(tm).addChar(chars.get(ch));
	}

	/*  Implementa a compra do item it pelo char ch  */
	public void buyItem (String ch, String it) throws IllegalArgumentException, FullInventoryException
	{
		int c = charId(ch);

		itemShop.buy(it, chars.get(c));
	}

	/*  Implementa a compra do Pet pet pelo char ch  */
	public void buyPet (String ch, String pet) throws IllegalArgumentException
	{
		int c = charId(ch);

		petShop.buy(pet, chars.get(c));
	}

	/*  Implementa o uso do item it pelo char ch (que possui este em seu inventário)  */
	public void useItem (String ch, String it) throws IllegalArgumentException
	{
		int c = charId (ch);

		chars.get(c).useItem(it);
	}

	/*  Implementa a equipagem do item it  pelo char ch (que possui este em seu inventário)  */
	public void equipItem (String ch, String it) throws IllegalArgumentException
	{
		int c = charId (ch);

		chars.get(c).equipItem(it);
	}

	/*  Adiciona o GameCharacter ch no jogo  */
	public void addChar (GameCharacter ch)
	{
		if (ch == null)
			return;

		chars.add(ch);
	}

	/*  Adiciona o time tm no jogo  */
	public void addTeam (Team tm)
	{
		if (tm == null)
			return;

		teams.add(tm);
	}

	/*  Adiciona o item it na loja de items  */
	public void addItem (Item it)
	{
		if (it == null)
			return;

		itemShop.sell(it);
	}

	/*  Adiciona o Pet pet na loja de pets  */
	public void addPet (Pet pet)
	{
		if (pet == null)
			return;

		petShop.sell(pet);
	}

	/*  Remove um personagem ch do jogo  */
	public void removeChar (String ch) throws IllegalArgumentException
	{
		int c = charId (ch);

		removeChar (c);
	}

	/*  Remove um personagem ch do jogo  */
	private void removeChar (int ch) throws IllegalArgumentException
	{
		if (ch < 0 || ch >= chars.size())
			throw new IllegalArgumentException("Personagem não está no Jogo!");

		for (int i = 0; i < teams.size() && teams.get(i).removeChar(chars.get(ch).getName()) != false; i++);

		chars.remove(ch);
	}

	/*  Remove um time tm do jogo  */
	public void removeTeam (String tm) throws IllegalArgumentException
	{
		int t = charId (tm);

		removeChar (t);
	}

	/*  Remove um time tm do jogo  */
	private void removeTeam (int tm) throws IllegalArgumentException
	{
		if (tm < 0 || tm >= teams.size())
			throw new IllegalArgumentException("Personagem não está no Jogo!");

		teams.remove(tm);
	}
	
	/*  Apresenta todos os personagens com suas respectivas classes, e seu dados  */
	public void showCharacters ()
	{
		System.out.print( "GameCharacter :\n" );
		for (int i = 0; i < chars.size(); ++i)
		{
			System.out.print( i + " :: " + chars.get(i).getName() + " ~> " + 
			chars.get(i).getHP() + " HP | " + chars.get(i).getXP() +
			" XP | " + chars.get(i).getMP() + " MP | (" );

			if (Utils.isKnight(chars.get(i)))
				System.out.print( "Knight" );
			else if (Utils.isThief(chars.get(i)))
				System.out.print( "Thief" );
			else if (Utils.isWizard(chars.get(i)))
				System.out.print( "Wizard" );

			System.out.print( ")\n" );
		}
	}

	/*  Apresenta todos os times com suas respectivas características  */
	public void showTeams ()
	{
		System.out.print( "Teams :\n" );
		for (int i = 0; i < teams.size(); ++i)
		{
			System.out.print( i + " :: " + teams.get(i).toString() + " has " + 
			teams.get(i).getPoints() + " points and " + teams.get(i).getResults() + "\n" );

			System.out.println("Players: ");

			teams.get(i).printTeam();

			System.out.println();
		}
	}

	/*  Apresenta o inventário do personagem ch do jogo  */
	public void showInventory(String ch) throws IllegalArgumentException
	{
		int c = charId(ch);

		chars.get(c).printInventory();
	}

	/*  Retorna o ID do time no vetor de times do jogo  */
	private int teamId (String tm) throws IllegalArgumentException
	{
		int t = -1;

		for (int i = 0; i < teams.size(); i++)
		{
			if (teams.get(i).getName().equals(tm))
			{
				t = i;
				i = teams.size();
			}
		}

		if (t == -1)
			throw new IllegalArgumentException("Time não está no Jogo");

		return t;
	}


	/*  Retorna o ID do personagem no vetor de personagens do jogo  */
	private int charId (String ch) throws IllegalArgumentException
	{

		int c = -1;

		for (int i = 0; i < chars.size(); i++)
		{
			if (chars.get(i).getName().equals(ch))
			{
				c = i;
				i = chars.size();
			}
		}

		if (c == -1)
			throw new IllegalArgumentException("Personagem não está no Jogo");

		return c;
	}

	/*  Realiza o treino de um personagem ch  */
	public void trainChar (String ch) throws IllegalArgumentException
	{
		int c = charId(ch);

		chars.get(c).train();
	}
	
	/*  Realiza o treino de um Pet de um personagem ch  */
	public void trainPet (String ch) throws IllegalArgumentException
	{
		int c = charId(ch);
		Pet pet = chars.get(c).getPet();

		if (pet == null)
			System.out.println("Personagem não tem um pet! :'(\n");
		else
			pet.train();
	}

	/*  Faz o personagem ch entrar no pet shop  */
	public void enterPetShop (String ch) throws IllegalArgumentException, FullInventoryException
	{
		int c = charId (ch);

		petShop.enterShop(chars.get(c));
	}

	/*  Faz o pesonagem ch entrar no item shop  */
	public void enterItemShop (String ch) throws IllegalArgumentException, FullInventoryException
	{
		int c = charId (ch);

		itemShop.enterShop(chars.get(c));
	}

	/*  Apresenta o status atual do personagem e de seu pet  */
	public void charStatus (String ch) throws IllegalArgumentException
	{
		int c = charId (ch);

		GameCharacter charac = chars.get(c);

		System.out.println(charac.getName() + " status:");

		System.out.println("XP:		" + charac.getXP());
		System.out.println("HP:		" + charac.getHP());
		System.out.println("MP:		" + charac.getMP());
		System.out.println("Strenght:	" + charac.getStrenght());
		System.out.println("Speed:		" + charac.getSpeed());
		System.out.println("Dexterity:	" + charac.getDexterity());
		System.out.println("Constitution:	" + charac.getConstitution());

		if (charac.getPet() != null)
		{
			System.out.println("The pet \'" + charac.getPet().getName() + "\' status:");
			System.out.println("Attack Points: 	" + charac.getPet().getAttackPoints());
			System.out.println("Training Status: 	" + charac.getPet().trainStatus() + "%");
		}
	}

}
