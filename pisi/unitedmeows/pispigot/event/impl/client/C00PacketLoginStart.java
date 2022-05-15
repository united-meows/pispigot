package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C00PacketLoginStart extends PisiEvent {
	public static final PacketType TYPE = PacketType.Login.Client.START;
	private String IGN;

	public C00PacketLoginStart(PacketEvent event) {
		super(event);
		IGN = event.getPacket().getStrings().read(0);
	}

	public C00PacketLoginStart setIGN(String _message) {
		IGN = _message;
		packetEvent.getPacket().getStrings().write(0, _message);
		return this;
	}

	public String IGN() {
		return IGN;
	}
}
