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
||                    Arquivo de Implementação da Classe Team    (JAVA)                   ||
============================================================================================
\*----------------------------------------------------------------------------------------*/


package Game;

import java.util.ArrayList;

public class Team
{
	/*  Atributos da classe Team (todos são privados)  */

	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private ArrayList<GameCharacter> characters;


	/*  Métodos da classe Team (todos são public)  */


	/***  Construtores e Destrutores  ***/

	/*  Construtor: recebe o nome do time e a cor deste  */
	public Team(String name, Color color)
	{
		characters = new ArrayList<GameCharacter>();
		
		this.name = name;
		this.color = color;

		this.win = 0;
		this.lose = 0;
		this.draw = 0;
	}

	/***  Getters  ***/

	/*  Retorna name  */
	public String getName ()
	{
		return this.name;
	}
	
	/*  Retorna win, lose e draw em uma string  */
	public String getResults ()
	{
		return (this.win + " wins, " + this.lose + " loses, " + this.draw + " draws");
	}

	/*  Retorna os pontos do time (média dos HPs)  */
	public int getPoints ()
	{
		int media = 0;

		for (int i = 0; i < characters.size(); ++i)
		{
			media += characters.get(i).getHP();
		}

		if(media > 0)
			media /= characters.size();

		return media;
	}


	/*  Retorna o nome e a cor do time em uma string  */
	public String toString ()
	{
		String cl = "NOT_DEF";

		if (color == Color.blue)
			cl = "blue";
		else if (color == Color.red)
			cl = "red"; 
		else if (color == Color.green)
			cl = "green";
		else if (color == Color.yellow)
			cl = "yellow";
		else if (color == Color.white)
			cl = "white";
		else if (color == Color.black)
			cl = "black";

		return this.name + " " + cl;
	}


	/***  Métodos de Jogabilidade  ***/

	/*  Método que decide qual time venceu, e atribui os pontos relativos à classe atual
		retornando a diferença de pontos entre o time local e o time externo */	
	public int resolveBattle (Team t)
	{
		if (this.getPoints() > t.getPoints())
			++(this.win);
		else if (this.getPoints() == t.getPoints())
			++(this.draw);
		else
			++(this.lose);

		return this.getPoints() - t.getPoints();
	}


	/***  Métodos de gerenciamento dos personagens do time  ***/
	
	/*  Adiciona um personagem ao time  */
	public void addChar (GameCharacter nchar)
	{
		// Não insere um personagem que está no time duas vezes!
		if (nchar == null || searchChar(nchar.getName()) != null)
			return;

		characters.add(nchar);
	}
	
	/*  Retira um personagem do time, dada uma posição do vetor de personagens  */
	public boolean removeChar (int poschar)
	{
		if (poschar >= characters.size() || poschar < 0) 
			return false;

		characters.remove(poschar);
		return true;
	}

	/*  Retira um personagem do time, dado o personagem a ser retirado  */
	public boolean removeChar (GameCharacter remchar)
	{
		if (remchar == null)
			return false;

		//remove o primeiro jogador que encontrar, de mesmo nome
		for (int i = 0; i < characters.size(); ++i)
		{
			if (remchar.getName().equals(characters.get(i).getName()))
			{
				return removeChar(i);
				// i = characters.size();
			}
		}

		return false;
	}

	/*  Retira um personagem do time, dado o nome do personagem a ser retirado  */
	public boolean removeChar (String namechar)
	{
		//remove o primeiro jogador que encontrar, de mesmo nome
		for (int i = 0; i < characters.size(); ++i)
		{
			if (namechar.equals(characters.get(i).getName()))
			{
				return removeChar(i);
				// i = characters.size();
			}
		}

		return false;
	}

	/*  Busca um personagem no time, dado seu nome, e retorna-o  */
	public GameCharacter searchChar (String name)
	{
		for (int i = 0; i < characters.size(); ++i)
		{
			if (characters.get(i).getName().equals(name))
				return characters.get(i);
		}

		return null;
	}

	/**  Meus métodos (complementares ao escopo do trabalho)  **/
	
	/*  Busca um personagem no time, dado sua posição no vetor de personagens, e retorna-o  */
	public GameCharacter searchChar (int pos)
	{
		if (pos < 0 || pos >= characters.size())
			return null;
		else
			return characters.get(pos);
	}

	/*  Retorna quantos personagens existem no time  */
	public int nChars ()
	{
		return characters.size();
	}

	public void printTeam()
	{
		for (int i=0; i<characters.size(); i++)
		{
			System.out.println(characters.get(i).getName() + " --> " + characters.get(i).getHP() + " HP |_| "
								+ characters.get(i).getXP() + " XP |¨| " + characters.get(i).getMP() + " MP");
		}
	}
}