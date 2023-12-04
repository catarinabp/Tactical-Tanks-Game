package org.example.controller.game;

import com.googlecode.lanterna.gui2.Direction;
import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.Position;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.Shoot;
import org.example.model.game.map.Map;

public class ShootController extends GameController{

    public ShootController(Map map) {
        super(map);
    }
    public void shootUp() {
        Position playerPosition = getModel().getPlayerTank().getPosition();

        // Assuming you have a Bullet class with a method to move upwards
        Shoot shoot = new Shoot(playerPosition.getX(), playerPosition.getY());

        // Set bullet direction to upwards
        shoot(getModel().getShoot().getPosition().getUp());

        // Your code to handle the bullet's movement (this is a hypothetical example)
        while (shouldMove()) {
            shootUp();
        }
    }

    public void shootDown() {
        Position playerPosition = getModel().getPlayerTank().getPosition();

        // Assuming you have a Bullet class with a method to move upwards
        Shoot shoot = new Shoot(playerPosition.getX(), playerPosition.getY());

        // Set bullet direction to upwards
        shoot(getModel().getShoot().getPosition().getDown());

        // Your code to handle the bullet's movement (this is a hypothetical example)
        while (shouldMove()) {
            shootDown();
        }
    }

    public void shootLeft() {
        Position playerPosition = getModel().getPlayerTank().getPosition();

        // Assuming you have a Bullet class with a method to move upwards
        Shoot shoot = new Shoot(playerPosition.getX(), playerPosition.getY());

        // Set bullet direction to upwards
        shoot(getModel().getShoot().getPosition().getLeft());

        // Your code to handle the bullet's movement (this is a hypothetical example)
        while (shouldMove()) {
            shootLeft();
        }
    }

    public void shootRight() {
        Position playerPosition = getModel().getPlayerTank().getPosition();

        // Assuming you have a Bullet class with a method to move upwards
        Shoot shoot = new Shoot(playerPosition.getX(), playerPosition.getY());

        // Set bullet direction to upwards
        shoot(getModel().getShoot().getPosition().getRight());

        // Your code to handle the bullet's movement (this is a hypothetical example)
        while (shouldMove()) {
            shootRight();
        }
    }


    public void shoot(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayerTank().setPosition(position);
            if (getModel().isNPC(position)) {
                getModel().getPlayerTank().decreaseLife();
            }
        }

    }

    public boolean shouldMove() {
        return true;
    }

    @Override
    public void step(Game game, GUI.ACTION direction, long time) {
        if (direction == GUI.ACTION.SHOOTUP) shootUp();
        if (direction == GUI.ACTION.SHOOTRIGHT) shootRight();
        if (direction == GUI.ACTION.SHOOTDOWN) shootDown();
        if (direction == GUI.ACTION.SHOOTLEFT) shootLeft();
    }
}
