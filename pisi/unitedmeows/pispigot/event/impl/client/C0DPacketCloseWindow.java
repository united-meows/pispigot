package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "close_window")
public class C0DPacketCloseWindow extends PisiEvent {
	private int windowID;

	public C0DPacketCloseWindow(PacketEvent event) {
		super(event);
		this.windowID = packet().getIntegers().read(0);
	}

	public int windowID() {
		return windowID;
	}

	public C0DPacketCloseWindow windowID(int windowID) {
		packet().getIntegers().write(0, windowID);
		this.windowID = windowID;
		return this;
	}
}
