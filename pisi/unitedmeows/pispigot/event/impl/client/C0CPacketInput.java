package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "steer_vehicle")
public class C0CPacketInput extends PisiEvent {
	public C0CPacketInput(PacketEvent event) {
		super(event);
	}

	public C0CPacketInput setSideway(float value) {
		packet().getFloat().write(0, value);
		return this;
	}

	public C0CPacketInput setForward(float value) {
		packet().getFloat().write(1, value);
		return this;
	}

	public C0CPacketInput setJumping(boolean state) {
		packet().getBooleans().write(0, state);
		return this;
	}

	public C0CPacketInput setSneaking(boolean state) {
		packet().getBooleans().write(1, state);
		return this;
	}

	public boolean jump() {
		return packet().getBooleans().read(0);
	}

	public boolean sneak() {
		return packet().getBooleans().read(1);
	}

	public float sideway() {
		return packet().getFloat().read(0);
	}

	public float forward() {
		return packet().getFloat().read(1);
	}
}
