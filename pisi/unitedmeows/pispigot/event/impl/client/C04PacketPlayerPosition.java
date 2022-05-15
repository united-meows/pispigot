package pisi.unitedmeows.pispigot.event.impl.client;

import static pisi.unitedmeows.pispigot.event.impl.client.C03PacketPlayer.C03Type.*;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

public class C04PacketPlayerPosition extends C03PacketPlayer {
	public static final PacketType TYPE = PacketType.Play.Client.POSITION;

	public C04PacketPlayerPosition(PacketEvent event) {
		super(event);
		posX = event.getPacket().getDoubles().read(0);
		posY = event.getPacket().getDoubles().read(1);
		posZ = event.getPacket().getDoubles().read(2);
		type = POS;
	}
}
