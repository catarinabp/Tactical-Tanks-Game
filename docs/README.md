## LDTS_l14gr06 - Tactical Tanks

No jogo ao qual demos o nome de Tactical Tanks, os jogadores controlam um tanque pelo mapa (usando as teclas direcionais) e controlam para que direção querem disparar (usando as teclas wasd) com o objetivo de derrotar tanques inimigos, que serão npcs automatizados e ao mesmo tempo fugir dos disparos dos mesmos. 

Os jogadores terão ainda de contornar obstáculos ou usá-los estrategicamente como escudo. Os obstáculos são buracos no chão e caixas, sendo que as balas podem passar por cima dos buracos mas não por entre as caixas. Os tanques não podem passar por nenhum desses dois.

Se as balas ou do jogador ou do inimigo chocarem contra os limites do mapa, contra as caixas, ou contra os tanques, rebentam. Se a bala do jogador chocar com a bala no inimigo, as duas rebentarão.

No final de eliminar todos os inimigos, o jogador passa para o nível seguinte. O objetivo é progredir pelos diferentes níveis, cada um introduzindo novos mapas e mais difíceis tanques inimigos. A dificuldade de uns níveis será o número muito reduzido de balas, de outros o limite de tempo, de outros o número de tanques inimígos e de outros a combinação de todas estas dificuldades.

O jogador não poderá retornar a jogar a partir do último nível a que conseguiu chegar. Se um jogador perder num nível terá de retornar ao nível 1. No menu aparecer1á o recorde (nível máximo alcançado).

This project was developed by Afonso Campelo Poças (up202008323@fe.up.pt), Ana Catarina Patrício (up202107383@fe.up.pt) e Mariana de Sá Melo (up202207877@fe.up.pt) no âmbito da UC de LDTS 1º sem 2023⁄24.


### IMPLEMENTED FEATURES

- **Mover** - O tanque do utilizador move-se no mapa através das teclas direcionais (↑↓←→)

- **Inimigos** - Os inimigos serão npcs que disparam e se movem aleatoriamente continuamente

- **Caixas** - As caixas servem de escudo estrategicamente. As balas não passam por entre as caixas

- **Buracos** - Os tanques não podem passar pelos buracos. As balas passam por cima dos buracos


### PLANNED FEATURES

- **Disparar** - Pode-se disparar em 4 direções diferentes usando as teclas wasd: para cima (w), para baixo (s), para a esquerda (a) e para a direita (d)

- **Menu** - O menu apresentará os seguintes tópicos:
                                                    PLAY
                                                    INSTRUCTIONS
                                                    RECORDS
                                                    EXIT
![Alt text](/docs/menu.png?raw=true)
![Alt text](/docs/instructions.png?raw=true)

- **Níveis** - Quando o jogador matar todos os tanques inimigos, passa para o próximo nível

- **Número inicial de balas e packs para repor as balas** - Em níveis mais avançados o jogador deixará de ter um número ilimitado de balas e passará a ter de as repor caso não tenha matado ainda todos os inimigos. Aparecerá de forma random no mapa que dará mais x balas ao jogador se o utilizador passar por lá.

- **Tempo limite** - Em níveis mais avançados o jogador deixará de ter tempo ilimitado para rebentar os tanques inimigos e haverá um contador de tempo decrescente em formto de relógio digital fora do limite do mapa.

- **Número de disparos limite** - Em níveis mais avançados o jogador terá um número de balas muito reduzido e não poderá repor o número de balas a meio do jogo (com excessão de níveis em que o desafio é ter um número muito reduzido de balas).

![Alt text](/docs/game.png?raw=true)


**The Pattern**

Escolhemos usar o State Pattern para o GameState e MenuState. Essa abordagem utiliza subclasses para representar cada estado, sendo por isso mais fácil mudar de estado. Fica tudo encapsulado numa única classe e usa-se o Single Responsibility Principle e Open/Closed Principle.

A principal razão para esta escolha foi a necessidade de lidar com as mudanças de estado dos objetos. O State Pattern permite a desvinculação das transições de estado do algoritmo principal. Dá-nos ainda a liberdade de criar novos estados mais facilmente à medida que desenvolvemos o jogo se necessário.

Outro design pattern escolhido é o Factory Method pois permite criar subclasses, nomeadamente, os elementos do jogo.
![Alt text](/docs/uml.jpg?raw=true)

### SELF-EVALUATION

Julgamos que os 3 integrantes trabalharam de igual modo para concretizar este projeto, posto isto:

- Afonso Campelo Poças: (100/3)%
- Ana Catarina Patrício: (100/3)%
- Mariana de Sá Melo: (100/3)%
