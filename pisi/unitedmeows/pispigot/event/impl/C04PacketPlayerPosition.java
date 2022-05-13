package pisi.unitedmeows.pispigot.event.impl;

import com.comphenix.protocol.events.PacketEvent;

public class C04PacketPlayerPosition extends C03PacketPlayer {



    public C04PacketPlayerPosition(PacketEvent event) {
        super(event);

        posX = event.getPacket().getDoubles().read(0);
        posY = event.getPacket().getDoubles().read(1);
        posZ = event.getPacket().getDoubles().read(2);
        type = C03Type.POS;
    }

}
