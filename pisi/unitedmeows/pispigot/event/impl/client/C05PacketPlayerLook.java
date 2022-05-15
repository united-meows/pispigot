package pisi.unitedmeows.pispigot.event.impl.client;

import static pisi.unitedmeows.pispigot.event.impl.client.C03PacketPlayer.C03Type.*;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

public class C05PacketPlayerLook extends C03PacketPlayer {
	public static final PacketType TYPE = PacketType.Play.Client.LOOK;

	public C05PacketPlayerLook(PacketEvent event) {
		super(event);
		yaw = packet().getFloat().read(0);
		pitch = packet().getFloat().read(1);
		type = LOOK;
	}
}
