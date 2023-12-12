package org.example.model.game.map;

import org.example.model.game.elements.*;

import java.util.List;

public abstract class MapBuilder {
    public Map createMap() {
        Map map = new Map(getWidth(), getHeight());

        map.setPlayerTank(createPlayerTank());
        map.setNPCs(createNPCs());
        map.setPacket(createPacket());
        map.setWalls(createWalls());
        map.setHoles(createHoles());


        return map;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Hole> createHoles();

    protected abstract List<NPCs> createNPCs();

    protected abstract PlayerTank createPlayerTank();

    protected abstract Packet createPacket();

}
