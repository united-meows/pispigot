package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C01PacketChat extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.CHAT;
	private String message;

	public C01PacketChat(PacketEvent event) {
		super(event);
		message = event.getPacket().getStrings().read(0);
	}

	public C01PacketChat setMessage(String _message) {
		message = _message;
		packetEvent.getPacket().getStrings().write(0, _message);
		return this;
	}

	public String message() {
		return message;
	}
}
