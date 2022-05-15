package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C0APacketAnimation extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.ARM_ANIMATION;

	public C0APacketAnimation(PacketEvent event) {
		super(event);
	}
}
