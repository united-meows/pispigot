package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "login" , client = true , finalType = "start")
public class C00PacketLoginStart extends PisiEvent {
	private WrappedGameProfile gameProfile;

	public C00PacketLoginStart(PacketEvent event) {
		super(event);
		gameProfile = event.getPacket().getGameProfiles().read(0);
	}

	public C00PacketLoginStart setIGN(WrappedGameProfile _message) {
		gameProfile = _message;
		packetEvent.getPacket().getGameProfiles().write(0, _message);
		return this;
	}

	public WrappedGameProfile gameProfile() {
		return gameProfile;
	}
}
