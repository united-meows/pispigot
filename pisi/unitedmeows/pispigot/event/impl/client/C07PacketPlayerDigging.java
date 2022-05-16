package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "block_dig")
public class C07PacketPlayerDigging extends PisiEvent {
	private BlockPosition position;
	private Direction facing;
	private PlayerDigType status;

	public C07PacketPlayerDigging(PacketEvent event) {
		super(event);
		position = packet().getBlockPositionModifier().read(0);
		facing = packet().getDirections().read(0);
		status = packet().getPlayerDigTypes().read(0);
	}

	public BlockPosition position() {
		return position;
	}

	public Direction facing() {
		return facing;
	}

	public PlayerDigType status() {
		return status;
	}

	public C07PacketPlayerDigging position(BlockPosition position) {
		packet().getBlockPositionModifier().write(0, position);
		this.position = position;
		return this;
	}

	public C07PacketPlayerDigging facing(Direction facing) {
		packet().getDirections().write(0, facing);
		this.facing = facing;
		return this;
	}

	public C07PacketPlayerDigging status(PlayerDigType type) {
		packet().getPlayerDigTypes().write(0, type);
		this.status = type;
		return this;
	}

	@Override
	public void onCanceled() {
		// TODO ersin
		super.onCanceled();
	}
}
