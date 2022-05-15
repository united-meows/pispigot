package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C00PacketKeepAlive extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.KEEP_ALIVE;
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
