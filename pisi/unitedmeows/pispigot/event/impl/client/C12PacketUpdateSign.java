package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C12PacketUpdateSign extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.UPDATE_SIGN;
	private BlockPosition pos;
	private WrappedChatComponent[] lines;

	public C12PacketUpdateSign(PacketEvent event) {
		super(event);
		this.pos = packet().getBlockPositionModifier().read(0);
		this.lines = packet().getChatComponentArrays().read(0);
	}

	public C12PacketUpdateSign pos(BlockPosition position) {
		packet().getBlockPositionModifier().write(0, position);
		this.pos = position;
		return this;
	}

	public C12PacketUpdateSign lines(WrappedChatComponent... lines) {
		packet().getChatComponentArrays().write(0, lines);
		this.lines = lines;
		return this;
	}

	public BlockPosition pos() {
		return pos;
	}

	public WrappedChatComponent[] lines() {
		return lines.clone();
	}
}
