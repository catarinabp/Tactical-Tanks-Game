package org.example.model.game.map;

import org.example.model.game.elements.*;
import org.example.strategy.GreyPacketStrategy;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderMapBuilder extends MapBuilder {
    private static int level;
    private final List<String> lines;

    public LoaderMapBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderMapBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    public static int getLevel() {
        return level;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Hole> createHoles() {
        List<Hole> holes = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') holes.add(new Hole(x, y));
        }

        return holes;
    }

    @Override
    protected List<NPCs> createNPCs() {
        List<NPCs> npcs = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') npcs.add(new NPCs(x, y));
        }

        return npcs;
    }

    @Override

    protected List<Box> createBoxes() {
        List<Box> boxes = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') boxes.add(new Box(x, y));
        }

        return boxes;
    }

    @Override
    protected PlayerTank createPlayerTank() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'T') return new PlayerTank(x, y);
        }
        return null;
    }


    @Override
    protected Packet createPacket() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '*') return new Packet(x, y,new GreyPacketStrategy());
        }
        return null;
    }
}
