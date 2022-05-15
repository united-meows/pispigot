package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C0FPacketConfirmTransaction extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.TRANSACTION;
	private int windowId;
	private short uid;
	private boolean accepted;

	public C0FPacketConfirmTransaction(PacketEvent event) {
		super(event);
		this.windowId = packet().getIntegers().read(0);
		this.accepted = packet().getBooleans().read(0);
		this.uid = packet().getShorts().read(0);
	}

	public C0FPacketConfirmTransaction windowID(int w_) {
		packet().getIntegers().write(0, w_);
		this.windowId = w_;
		return this;
	}

	public C0FPacketConfirmTransaction uid(short uid) {
		packet().getShorts().write(0, uid);
		this.uid = uid;
		return this;
	}

	public C0FPacketConfirmTransaction accepted(boolean accepted) {
		packet().getBooleans().write(0, accepted);
		this.accepted = accepted;
		return this;
	}

	public int windowID() {
		return windowId;
	}

	public int uid() {
		return uid;
	}

	public boolean accepted() {
		return accepted;
	}
}
