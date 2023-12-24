package org.example.model.game.map;

import org.example.model.game.elements.*;
import org.example.strategy.GreyPacketStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMapBuilder extends MapBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfNPCs;

    public RandomMapBuilder(int width, int height, int numberOfNPCs) {
        this.rng = new Random();

        this.width = width;
        this.height = height;
        this.numberOfNPCs = numberOfNPCs;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }

    @Override
    protected List<Hole> createHoles() {


        return new ArrayList<>();
    }

    @Override
    protected List<Box> createBoxes() {

        return new ArrayList<>();
    }

    @Override
    protected List<NPCs> createNPCs() {
        List<NPCs> npcs = new ArrayList<>();

        while (npcs.size() < numberOfNPCs)
            npcs.add(new NPCs(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return npcs;
    }

    @Override
    protected PlayerTank createPlayerTank() {
        return new PlayerTank(width / 2, height / 2);
    }

    @Override
    protected Packet createPacket() {
        return new Packet(width / 5, height / 5,new GreyPacketStrategy());
    }


}
