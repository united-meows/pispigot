package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C14PacketTabComplete extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.TAB_COMPLETE;

	public C14PacketTabComplete(PacketEvent event) {
		super(event);
	}

	public C14PacketTabComplete setMessage(String value) {
		packet().getStrings().write(0, value);
		return this;
	}

	public String message() {
		return packet().getStrings().read(0);
	}
}
