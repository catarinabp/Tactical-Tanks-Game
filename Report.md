## LDTS_<T><G> - <TACTICAL TANKS>

No jogo ao qual demos o nome de Tactical Tanks, os jogadores controlam um tanque pelo mapa (usando as teclas direcionais) e controlam para que direção querem disparar (usando as teclas wasd) com o objetivo de derrotar tanques inimigos, que serão npcs automatizados e ao mesmo tempo fugir dos disparos dos mesmos. 

Os jogadores terão ainda de contornar obstáculos ou usá-los estrategicamente como escudo. Os obstáculos são buracos no chão e caixas, sendo que as balas podem passar por cima dos buracos mas não por entre as caixas. Os tanques não podem passar por nenhum desses dois.

Se as balas ou do jogador ou do inimigo chocarem contra os limites do mapa, contra as caixas, ou contra os tanques, rebentam. Se a bala do jogador chocar com a bala no inimigo, as duas rebentarão.

No final de eliminar todos os inimigos, o jogador passa para o nível seguinte. O objetivo é progredir pelos diferentes níveis, cada um introduzindo novos mapas e mais difíceis tanques inimigos. A dificuldade de uns níveis será o número muito reduzido de balas, de outros o limite de tempo, de outros o número de tanques inimígos e de outros a combinação de todas estas dificuldades.

O jogador não poderá retornar a jogar a partir do último nível a que conseguiu chegar. Se um jogador perder num nível terá de retornar ao nível 1. No menu aparecerá o recorde (nível máximo alcançado).

This project was developed by Ana Catarina Patrício (up202107383@fe.up.pt), ... (up@fe.up.pt) e ... (@fe.up.pt) no âmbito da UC de LDTS 1º sem 2023⁄24.
Grupo l14gr06

### IMPLEMENTED FEATURES

- **Mover** - O tanque do utilizador move-se no mapa através das teclas direcionais (↑↓←→)
screenshots
- **Disparar** - Pode-se disparar em 4 direções diferentes usando as teclas wasd: para cima (w), para baixo (s), para a esquerda (a) e para a direita (d)
screenshots
- **Inimigos** - Os inimigos serão npcs que disparam e se movem aleatoriamente continuamente
screenshots
- **Caixas** - As caixas servem de escudo estrategicamente. As balas não passam por entre as caixas.
screenshots
- **Buracos** - Os tanques não podem passar pelos buracos. As balas passam por cima dos buracos.
screenshots

### PLANNED FEATURES

- **Menu** - O menu apresentará os seguintes tópicos:
                                                    PLAY
                                                    INSTRUCTIONS
                                                    RECORDS
                                                    EXIT
![Alt text](/Pictures/menu.jpeg?raw=true)
![Alt text](/Pictures/instructions.jpeg?raw=true)

- **Níveis** - Quando o jogador matar todos os tanques inimigos, passa para o próximo nível
GUI mock-up
- **Número inicial de balas e packs para repor as balas** - Em níveis mais avançados o jogador deixará de ter um número ilimitado de balas e passará a ter de as repor caso não tenha matado ainda todos os inimigos. Aparecerá de forma random no mapa que dará mais x balas ao jogador se o utilizador passar por lá.
GUI mock-up
- **Tempo limite** - Em níveis mais avançados o jogador deixará de ter tempo ilimitado para rebentar os tanques inimigos e haverá um contador de tempo decrescente em formto de relógio digital fora do limite do mapa.
GUI mock-up
- **Número de disparos limite** - Em níveis mais avançados o jogador terá um número de balas muito reduzido e não poderá repor o número de balas a meio do jogo (com excessão de níveis em que o desafio é ter um número muito reduzido de balas).
GUI mock-up

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

#### TITLE

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

Julgamos que os 3 integrantes trabalharam de igual modo para concretizar este projeto, posto isto:

- Ana Catarina Patrício: (100/3)%
- ...: (100/3)%
- ...: (100/3)%

