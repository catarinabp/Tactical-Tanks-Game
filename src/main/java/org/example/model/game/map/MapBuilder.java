package org.example.model.game.map;

import org.example.model.game.elements.NPCs;
import org.example.model.game.elements.PlayerTank;
import org.example.model.game.elements.Wall;

import java.util.List;

public abstract class MapBuilder {
    public Map createMap() {
        Map map = new Map(getWidth(), getHeight());

        map.setPlayerTank(createPlayerTank());
        map.setNPCs(createNPCs());
        map.setWalls(createWalls());

        return map;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<NPCs> createNPCs();

    protected abstract PlayerTank createPlayerTank();
}
