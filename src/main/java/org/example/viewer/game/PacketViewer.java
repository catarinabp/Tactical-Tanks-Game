package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Packet;

public class PacketViewer implements ElementViewer<Packet> {
    @Override
    public void draw(Packet packet, GUI gui) {
        gui.drawPacket(packet.getPosition());
    }
}
