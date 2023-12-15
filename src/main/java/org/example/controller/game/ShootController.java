package org.example.controller.game;


import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.Position;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.NPCs;
import org.example.model.game.elements.Shoot;
import org.example.model.game.map.Map;
import org.example.viewer.game.NPCViewer;

import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

import static java.time.zone.ZoneRulesProvider.refresh;

public class ShootController extends GameController {
    private static final int BULLET_SPEED = 100; // Adjust the speed as needed (milliseconds)

    public ShootController(Map map) {
        super(map);
    }

    public void shootUp() {
        shootInDirection(GUI.ACTION.UP);
    }

    public void shootDown() {
        shootInDirection(GUI.ACTION.DOWN);
    }

    public void shootLeft() {
        shootInDirection(GUI.ACTION.LEFT);
    }

    public void shootRight() {
        shootInDirection(GUI.ACTION.RIGHT);
    }

    private void shootInDirection(GUI.ACTION direction) {
        if (getModel().getPlayerTank().getBullets() > 0) {
            Shoot shoot = new Shoot(getModel().getPlayerTank().getPosition().getX(), getModel().getPlayerTank().getPosition().getY());
            getModel().setShoot(shoot);
            moveBullet(direction);
            getModel().getPlayerTank().decreaseBullets();
        }
    }

    private void moveBullet(GUI.ACTION direction) {
        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            Position bulletPosition = getModel().getPlayerTank().getPosition();
            boolean hitSomething = false;

            @Override
            public void run() {
                switch (direction) {
                    case UP -> bulletPosition = bulletPosition.getUp();
                    case DOWN -> bulletPosition = bulletPosition.getDown();
                    case LEFT -> bulletPosition = bulletPosition.getLeft();
                    case RIGHT -> bulletPosition = bulletPosition.getRight();
                }

                if (getModel().isEmpty(bulletPosition) && !hitSomething) {
                    getModel().getShoot().setPosition(bulletPosition);
                    if (getModel().isNPC(bulletPosition)) {
                        hitSomething = true;
                        for (NPCs npc : getModel().getNPCs()) {
                            if(npc.getPosition().equals(bulletPosition)) {
                                npc.decreaseLife();
                            }
                            if (npc.getLife() <= 0) {
                                // Remove the NPC from the game when its life reaches zero
                                getModel().removeNPC(npc);
                                getModel().setShoot(null);
                            }
                        }
                    }
                } else {
                    getModel().setShoot(null);
                    cancel(); // Stop the timer if the bullet hits something or reaches a non-empty spot
                }
            }
        }, 0, BULLET_SPEED);
    }

    @Override
    public void step(Game game, GUI.ACTION direction, long time) {
        switch (direction) {
            case SHOOTUP:
                if(getModel().getShoot() == null)
                    shootUp();
                break;
            case SHOOTRIGHT:
                if(getModel().getShoot() == null)
                    shootRight();
                break;
            case SHOOTDOWN:
                if(getModel().getShoot() == null)
                    shootDown();
                break;
            case SHOOTLEFT:
                if(getModel().getShoot() == null)
                    shootLeft();
                break;
        }
    }
}