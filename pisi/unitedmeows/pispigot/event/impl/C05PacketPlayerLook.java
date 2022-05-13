package pisi.unitedmeows.pispigot.event.impl;

import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Location;

public class C05PacketPlayerLook extends C03PacketPlayer {



    public C05PacketPlayerLook(PacketEvent event) {
        super(event);

        yaw = packet().getFloat().read(0);
        pitch = packet().getFloat().read(1);

        type = C03Type.LOOK;
    }

}
