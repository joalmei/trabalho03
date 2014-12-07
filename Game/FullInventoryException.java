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

import java.util.*;


/*  Exceção que é lançada quando o Inventory está cheio ou quando a capacidade máxima de Pets
	de um personagem é alcançada, uma vez que este caracteriza um Inventário de Pets  */
public class FullInventoryException extends Exception
{
      public FullInventoryException() {}

      public FullInventoryException(String message)
      {
         super(message);
      }
 }