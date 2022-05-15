package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;

public class C09PacketHeldItemChange extends PisiEvent {
	public static final PacketType TYPE = PacketType.Play.Client.HELD_ITEM_SLOT;
	private int toSlot;

	public C09PacketHeldItemChange(PacketEvent event) {
		super(event);
		toSlot = event.getPacket().getIntegers().read(0);
	}

	@Override
	public void onCanceled() {
		player().getInventory().setHeldItemSlot(player().getInventory().getHeldItemSlot());
	}

	public int currentSlot() {
		return packetEvent.getPlayer().getInventory().getHeldItemSlot();
	}

	public int toSlot() {
		return toSlot;
	}
}
