############################################################################################
#                         SCC 604 - Programacao Orientada a Objetos                        #
#::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::#
#                          Turma 2014/2 - Engenharia de Computação                         #
#                                  Professor: Moacir Ponti                                 #
#------------------------------------------------------------------------------------------#
#                                        Trabalho 3                                        #
#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#
#                     Alunos: João Victor Almeida de Aguiar :: 8503986                     #
#                           Cassiano Zaghi de Oliveira :: 7987400                          #
############################################################################################



CC = javac
GAME = Game
EXEC = Main

# Rotina principal da compilação (chama a pré-compilação de todos os arquivos)
all: items inventory shop character team utils main
	@echo 'PRONTO!'

# Rotinas de geração dos arquivos .class

items:
	@echo 'Pré-Compilando as classes de Items...'
	@$(CC)  $(GAME)/Item.java
	@$(CC)  $(GAME)/Armor.java
	@$(CC)  $(GAME)/Weapon.java
	@$(CC)  $(GAME)/Potion.java
	@$(CC)  $(GAME)/HealthPotion.java
	@$(CC)  $(GAME)/ManaPotion.java
	@$(CC)	$(GAME)/RageMode.java
	@$(CC)	$(GAME)/RagePotion.java
inventory:
	@echo 'Pré-Compilando Inventário, Jogo e Lojas...'
	@$(CC)  $(GAME)/Inventory.java
	@$(CC) ./Game.java
shop:
	@$(CC)	$(GAME)/Sellable.java
	@$(CC)	$(GAME)/Shop.java
	@$(CC)	$(GAME)/PetShop.java
	@$(CC)	$(GAME)/ItemShop.java
character:
	@echo 'Pré-Compilando as classes de Characters..'
	@$(CC)  $(GAME)/Attacker.java
	@$(CC)  $(GAME)/GameCharacter.java
	@$(CC)  $(GAME)/Pet.java
	@$(CC)  $(GAME)/PetTraining.java
	@$(CC)  $(GAME)/Knight.java
	@$(CC)  $(GAME)/Thief.java
	@$(CC)  $(GAME)/Wizard.java
team:
	@echo 'Pré-Compilando Team...'
	@$(CC)  $(GAME)/Team.java
utils:
	@echo 'Pré-Compilando arquivos auxiliares...'
	@$(CC)  $(GAME)/Pair.java
	@$(CC)  $(GAME)/Utils.java
main:
	@echo 'Pré-Compilando a Main...'
	@$(CC)  ./Main.java


# Executa o programa principal
run:
	@java $(EXEC)

# Apaga todos os arquivos compilados gerados
clean:
	@rm $(GAME)/*.class ./*.class
