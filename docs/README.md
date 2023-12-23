## LDTS_T14_G06 - Tactical Tanks

## Game Description

No jogo ao qual demos o nome de Tactical Tanks, os jogadores controlam um tanque pelo mapa (usando as teclas direcionais) e controlam para que direção querem disparar (usando as teclas wasd) com o objetivo de derrotar tanques inimigos, que serão npcs automatizados e ao mesmo tempo fugir dos disparos dos mesmos. 

Os jogadores terão ainda de contornar obstáculos ou usá-los estrategicamente como escudo. Os obstáculos são buracos no chão e caixas, sendo que as balas podem passar por cima dos buracos mas não por entre as caixas. Os tanques não podem passar por nenhum desses dois.

Se as balas ou do jogador ou do inimigo chocarem contra os limites do mapa, contra as caixas, ou contra os tanques, rebentam. Se a bala do jogador chocar com a bala no inimigo, as duas rebentarão.

No final de eliminar todos os inimigos, o jogador passa para o nível seguinte. O objetivo é progredir pelos diferentes níveis, cada um introduzindo novos mapas e mais difíceis tanques inimigos. A dificuldade de uns níveis será o número muito reduzido de balas, de outros o limite de tempo, de outros o número de tanques inimígos e de outros a combinação de todas estas dificuldades.

O jogador não poderá retornar a jogar a partir do último nível a que conseguiu chegar. Se um jogador perder num nível terá de retornar ao nível 1. No menu aparecer1á o recorde (nível máximo alcançado).

This project was developed by Afonso Campelo Poças (up202008323@fe.up.pt), Ana Catarina Patrício (up202107383@fe.up.pt) e Mariana de Sá Melo (up202207877@fe.up.pt) no âmbito da UC de LDTS 1º sem 2023-24.


### IMPLEMENTED FEATURES

- **Menu** - O menu apresenta os seguintes tópicos:
                                                    PLAY
                                                    RULES
                                                    RECORDS
                                                    EXIT

<br>
<br />

<p align="center" justify="center">
  <img src="screenshots/menu principal.png"/>
</p>
<p align="center">
  <b><i>Fig 1. Menu principal </i></b>
</p>  

<br>
<br />

<p align="center" justify="center">
  <img src="screenshots/rules.png"/>
</p>
<p align="center">
  <b><i>Fig 2. A opção "Rules" mostra as instruções de jogo </i></b>  
</p>  

<br>
<br />

<p align="center" justify="center">
  <img src="screenshots/records.png"/>
</p>
<p align="center">
  <b><i>Fig 3. High scores dos jogadores por ordem de melhor classificação </i></b>
</p>

<br>
<br />

- **Mover** - O tanque do utilizador (representado por um T) move-se no mapa através das teclas direcionais (↑↓←→)

- **Disparar** - Pode-se disparar em 4 direções diferentes usando as teclas wasd: para cima (w), para baixo (s), para a esquerda (a) e para a direita (d)

- **Caixas** - As caixas (representadas por um =) são usadas de acordo com a estratégia escolhida pelo jogador. Nem o tanque nem as balas passam por entre as caixas, mas ao final de serem atingidas 3 vezes, as caixas quebram. O jogador pode escolher usar a caixa como escudo ou quebrá-la e libertar caminho.

- **Buracos** - O jogador não pode passar pelos buracos (representados por um O). Se neles cair, é game over.

<br>
<br />

<p align="center" justify="center">
  <img src="gifs/cair buraco.gif"/>
</p>
<p align="center">
  <b><i>Gif 1. Tanque do jogador a cair num buraco </i></b>
</p>

<br>
<br />

- **Paredes** - Nem as balas, nem os npcs, nem o jogador são capazes de passar pelas paredes (representadas por um #). As paredes são inquebráveis.

- **Inimigos (npcs)** - Os inimigos (representados por um X) são npcs que se movem continuamente em direção ao jogador. Se tocarem no jogador, o jogador perde uma vida. Quando o jogador ficar sem vidas é game over.

<br>
<br />

<p align="center" justify="center">
  <img src="gifs/perder vida.gif"/>
</p>
<p align="center">
  <b><i>Gif 2. Tanque do jogador a perder por ficar sem vidas </i></b>
</p>

<br>
<br />

- **Contador de tempo** - No canto inferior esquerdo do mapa existe um contador de tempo crescente em formato de relógio digital.

- **Níveis** - Quando o jogador matar todos os tanques inimigos, passa para o próximo nível. Existem 2 níveis, sendo que o segundo é mais dificil que o anterior.

- **Número inicial de balas e packs para repor as balas** - O jogador começa com um um número de balas de acordo com o nível em que se encontra. Se as balas acabarem e o jogador ainda não tiver cumprido o objetivo de eliminar todos os npcs do mapa, terá de as repor passando pelos packs (representados por um *).Aparecerá de forma random no mapa.

<br>
<br />

<p align="center" justify="center">
  <img src="gifs/balas.gif"/>
</p>
<p align="center">
  <b><i>Gif 3. Tanque do jogador a carregar balas </i></b>
</p>

<br>
<br />

- **Packs de balas de quantidades diferentes** - Existem dois tipos de packs: os de cor cinza e os de cor amarela. Os cinza recarregam somente 1 bala enquanto que os amarelos recarregam 3 balas de uma vez. Estes aparecem alternadamente aleatoriamente pelo mapa. Ora cinza, ora amarelo.

- **Ecrã de Game Over** - Este é o ecrã que indica ao jogador que o jogo terminou (Game Over) e o encaminha para o menu principal.

<br>
<br />

<p align="center" justify="center">
  <img src="screenshots/game over.png"/>
</p>
<p align="center">
  <b><i>Fig 6. Mensagem de Game Over</i></b>
</p>

<br>
<br />

### PLANNED FEATURES

- **Tempo limite** - Tínhamos pensado em definir um tempo limite para finalizar um nível em níveis mais avançados. Por outras palavras, o jogador deixaria de ter tempo ilimitado para eliminar os tanques inimigos e haveria um contador de tempo fora do limite do mapa como o contador que implementamos, mas este seria decrescente. Quando chegasse a 00:00, seria Game Over.
Decidimos não avançar com esta ideia pois a principal dificuldade do jogo está em repor as balas e em fugir dos tanques inimigos. Para além disso, a tabela de recordes apresenta as tentativas que correspondem a um menor tempo de jogo para finalizar o nível, pelo que esta feature não faria por isso sentido.

- **Número de disparos limite** - Tínhamos idealizado definir um número de balas limite muito reduzido  para finalizar um nível em níveis mais avançados. O jogador não poderia repor o número de balas a meio do jogo, ou seja, deixariam de aparecer os packs de balas pelo mapa. Concluímos que não seria boa ideia porque o nível ficaria excessivamente dificil.

As features mais importantes para dinamizar o jogo foram implementadas com sucesso e por isso não achamos ter perdido em não ter implementado estas duas features.







## Design

### General Structure

<br>
<br />

<p align="center" justify="center">
  <img src="uml.png"/>
</p>
<p align="center">
  <b><i>Fig 6. Mensagem de Game Over</i></b>
</p>

<br>
<br />


#### Problem in Context:
Como o nosso jogo usa Graphical User Interface, contém varios gameStates e várias features, decidimos usar alguns dos patterns que viemos a estudar ao longo do semestre. Assim, desenvolveríamos o jogo da forma mais eficiente possível: uma estrutura simples e organizada.


#### The Pattern:
Escolhemos usar o **_State Pattern_**. Essa abordagem utiliza subclasses para representar cada estado, sendo por isso mais fácil mudar de estado. Fica tudo encapsulado numa única classe e usa-se o Single Responsibility Principle e Open/Closed Principle.

A principal razão para esta escolha foi a necessidade de lidar com as mudanças de estado dos objetos. O State Pattern permite a desvinculação das transições de estado do algoritmo principal. Dá-nos ainda a liberdade de criar novos estados mais facilmente à medida que desenvolvemos o jogo se necessário.

#### Implementation:
Regarding the implementation, we now have classes which main purpose is to store data (model), classes that control the logic of the game (controllers) and classes that are responsible for the visual effects on the screen (viewers), these types of classes associate with each other in the following manner:

<p align="center" justify="center">
  <img src="images/UML/MVC.png"/>
</p>
<p align="center">
  <b><i>Fig 1. Model, Controller and Viewer pattern design</i></b>
</p>

As for the different states, they are divided with the same methodology as the mvc style, and permite the game to alter its behavior in a simple and efficient way.

#### Consequences:
The use of these patterns in the current design allow the following benefits:
- The several states that represent the different menus become explicit in the code, instead of relying on a series of flags.
- A well organized code acknowledging the Single Responsibility Principle.
- Easy to add new features throughout the development stage.


### Observers and listeners
#### Problem in Context:  
Our game is controlled both by the mouse and the keyboard, many are the ways to receive input from these devices, for example: a thread that is running and every time it catches a signal it sends to the game itself (polling), the game being responsible for asking for input when needed, which is costly for our program since we may not send any signal to the program and unnecessary calls are made or the way we decided to implement which consists of using observers also known as listeners that are responsible for receiving the said input and redistributing it in a nicer and more usefull way to us. This takes some "weight" of the program as it will no longer need to be polling for input, as it will be properly warned when received.

#### The Pattern:
We have applied the **_Observer pattern_** which is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing. With this in mind the pattern allowed to solve the identified problems and apply a sustainable mechanism to receive any program input.

#### Implementation:
Implementation wise we store the observers in the main class (game class) and change its state according to the respective input processed by the available listener.
Though, it wasn't easy right from the start as our first attemp to implement this feature didn't act as expected. All listeners were always active, since when creating a Menu Button the listener would be activated by the newly created state, and it was far from being a structured and easy-to-read code.

<p align="center" justify="center">
  <img src="images/UML/ObsListener.png"/>
</p>
<p align="center">
  <b><i>Fig 2. Observers and Listeners screenshot</i></b>
</p>

#### Consequences:
Some consequences of using the stated pattern:
- Promotes the single responsibility principle.
- Clean code.
- Only the current game state is warned when an input is given.

### Battlefield builder
#### Problem in Context:
A battlefield consists in an aglomeration of elements such as walls, bombs, portals, a player, etc. 
Having different battlefields in the various levels, instead of having a builder to each level, a battlefield loader that reads from a file and inserts into its super class (battlefield builder) the needed elements, was the most appealing option. This implementation makes it possible to only create specific elements and also generate battlefields in different ways.

#### The Pattern:

Outro design pattern escolhido é o Factory Method pois permite criar subclasses, nomeadamente, os elementos do jogo.

The **_Factory Method_** and **_Builder_** are two creational design patterns, the first one provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. The second, allows you to construct complex objects step by step making a simpler code.

#### Implementation:
A factory is resposible for constructing the whole but the workers are the ones that actually execute the job. Analogously, our BattlefieldBuilder is a factory and its subclasses represent the workers.
As for the implmentation, the BattlefieldBuilder is an abstract class which knows how to construct a battlefield, however only its subclasses supply the necessary components of the battlefield. The BattlefieldLoader is one of referred subclasses that consists in a worker capable of reading different levels from different files. Another possible implementation would be a random loader that generates random components for the battlefield.
The builder pattern is implemented in all of the above classes by dividing the constructing in smaller steps.

<p align="center" justify="center">
  <img src="images/UML/BuilderLoader.png"/>
</p>
<p align="center">
  <b><i>Fig 3. Battlefield builder and loader</i></b>
</p>

These classes can be found in the following files:
- [BattlefieldBuilder](../src/main/java/com/g57/model/battlefield/BattlefieldBuilder.java)
- [BattlefieldLoader](../src/main/java/com/g57/model/battlefield/BattlefieldLoader.java)

#### Consequences:
Benefits of applying the above pattern:
- You avoid tight coupling between the creator and the concrete products.
- Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.
- You can construct objects step-by-step, defer construction steps or run steps recursively.


### Different types of commands
#### **Problem in Context:** 
In an initial and more simplified version of the current game, the diversity in between buttons was not significant. However, in the course of the development of the project, the number of buttons increased exponentially and the need to generalise the button element became more evident. That said and knowing that good software design is often based on the principle of separation of concerns, a major refactor had to be done. 

#### The Pattern:
We have applied the **_Command_** also know as Action pattern. This pattern turns a request into a stand-alone object that contains all information about the request.

#### Implementation:
Regarding the implemetation process, all the Button classes were deleted and transformed into a single **Button** with a command attribute. These **commands**  implement the same interface having an execution method that takes no parameters. This interface lets you use various commands with the same request sender, without coupling it to concrete classes of commands. As a bonus, now you can switch command objects linked to the sender, effectively changing the sender’s behavior at runtime.

<p align="center" justify="center">
  <img src="images/UML/ButtonCommand.png"/>
</p>
<p align="center">
  <b><i>Fig 4. Buttons and commands</i></b>
</p>

These classes can be found in the following files:
- [Button](../src/main/java/com/g57/model/element/button/Button.java)
- [Command](../src/main/java/com/g57/model/item/command/Command.java)

#### Consequences:
The Command Pattern allows the following consequences:
- You can decouple classes that invoke operations from classes that perform these operations (SRP).
- You can implement undo/redo.
- You can assemble a set of simple commands into a complex one.
- The code may become more complicated since you’re introducing a whole new layer between senders and receivers.


### GUI
#### Problem in Context:
Aiming for a structured and unstable (easy to change) code, we tried to make it as general as possible. The lanterna library contains various functions that aren't useful to our program, Interface Segregation Principle violation, and lacks some other functions that our interface needs. Also, if using the raw library, our game (high level module) would be directly depending on a low level module. This is a violation of the Dependency Inversion Principle (DIP). A need to implement an interface that solves these problems was born. 

#### The Pattern: 
We have applied the **_Facade_** pattern. A facade provides a simple interface to a complex subsystem which contains lots of moving parts, allowing us to only include the features that really matter.

#### Implementation:
<p align="center" justify="center">
  <img src="images/UML/GUI.png"/>
</p>
<p align="center">
  <b><i>Fig 5. Observers and Listeners screenshot</i></b>
</p>

These classes can be found in the following files:
- [Game](../src/main/java/com/g57/Game.java)
- [GUI](../src/main/java/com/g57/gui/GUI.java)
- [LanternaGUI](../src/main/java/com/g57/gui/LanternaGUI.java)

#### Consequences: 
The use of the Facade Pattern in the current design allows the following benefits:
- Isolate code from the complexity of a subsystem.
- Promotes testability and replaceability.
- Expand lanterna functionalities as well as respecting the Interface Segregation Principle.

## Known-code smells

We have fixed all the errors reported by error-prone. No other major code smells identified. 

## Testing

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="images/screenshots/codeCoverage"/>
</p>
<p align="center">
  <b><i>Fig 6. Code coverage screenshot</i></b>
</p>

### Link to mutation testing report
[Mutation tests](../build/reports/pitest/202105302045/index.html)











### SELF-EVALUATION

Julgamos que os 3 integrantes trabalharam de igual modo para concretizar este projeto. Distribuímos tarefas pelos 3 e mantivemos uma boa comunicação desde início até ao fim. Tivemos também a oportunidade de aplicar de forma prática os conhecimentos teóricos que viemos a estudar ao longo do semestre.
Posto isto, aqui estão as percentagens:

- Afonso Campelo Poças: (100/3)%
- Ana Catarina Patrício: (100/3)%
- Mariana de Sá Melo: (100/3)%
