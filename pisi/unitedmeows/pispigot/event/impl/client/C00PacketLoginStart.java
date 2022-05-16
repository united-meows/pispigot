package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "login" , client = true , finalType = "start")
public class C00PacketLoginStart extends PisiEvent {
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
