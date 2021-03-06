package pisi.unitedmeows.pispigot.event.impl.client;

import static pisi.unitedmeows.pispigot.event.impl.client.C03PacketPlayer.C03Type.*;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "position_look")
public class C06PacketPlayerPosLook extends C03PacketPlayer {
	public C06PacketPlayerPosLook(PacketEvent event) {
		super(event);
		yaw = packet().getFloat().read(0);
		pitch = packet().getFloat().read(1);
		posX = event.getPacket().getDoubles().read(0);
		posY = event.getPacket().getDoubles().read(1);
		posZ = event.getPacket().getDoubles().read(2);
		type = LOOK_POS;
	}
}
