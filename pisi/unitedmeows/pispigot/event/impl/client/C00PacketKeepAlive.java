package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "keep_alive")
public class C00PacketKeepAlive extends PisiEvent {
	private int key;

	public C00PacketKeepAlive(PacketEvent event) {
		super(event);
		this.key = packet().getIntegers().read(0);
	}

	public C00PacketKeepAlive key(int key) {
		packet().getIntegers().write(0, key);
		this.key = key;
		return this;
	}

	public int key() {
		return key;
	}
}
