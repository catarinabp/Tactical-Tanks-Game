package org.example.controller.game;

package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.Position;
import org.example.model.game.elements.Element;
import org.example.model.game.map.Map;

public class ShootController extends GameController{

    private Map map;
    public ShootController(Map map) {
        super(map);
    }
    public void shootUp() {
        shoot(getModel().getPlayerTank().getPosition().getUp());
    }

    public void shootDown() {
        shoot(getModel().getPlayerTank().getPosition().getDown());
    }

    public void shootLeft() {
        shoot(getModel().getPlayerTank().getPosition().getLeft());
    }

    public void shootRight() {
        shoot(getModel().getPlayerTank().getPosition().getRight());
    }


    public void shoot(Element shooter, GUI.ACTION direction) {

    }

    @Override
    public void step(Game game, GUI.ACTION direction, long time) {
        if (direction == GUI.ACTION.SHOOTUP) shootUp();
        if (direction == GUI.ACTION.SHOOTRIGHT) shootRight();
        if (direction == GUI.ACTION.SHOOTDOWN) shootDown();
        if (direction == GUI.ACTION.SHOOTLEFT) shootLeft();
    }
}
