package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "arm_animation")
public class C0APacketAnimation extends PisiEvent {
	public C0APacketAnimation(PacketEvent event) {
		super(event);
	}
}
