package pisi.unitedmeows.pispigot.event.impl.client;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "held_item_slot")
public class C09PacketHeldItemChange extends PisiEvent {
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
