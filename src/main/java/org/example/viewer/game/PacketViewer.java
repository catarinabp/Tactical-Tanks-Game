package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Packet;
import org.example.strategy.GreyPacketStrategy;
import org.example.strategy.OrangePacketStrategy;

public class PacketViewer implements ElementViewer<Packet> {
    @Override
    public void draw(Packet packet, GUI gui) {
        if(packet.getStrategy() instanceof GreyPacketStrategy){
            gui.drawGreyPacket(packet.getPosition());
        }
        else if(packet.getStrategy() instanceof OrangePacketStrategy) {
            gui.drawOrangePacket(packet.getPosition());
        }
    }
}
