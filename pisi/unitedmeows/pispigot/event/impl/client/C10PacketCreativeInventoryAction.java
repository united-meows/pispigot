package pisi.unitedmeows.pispigot.event.impl.client;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;

@Type(main = "play" , client = true , finalType = "set_creative_slot")
public class C10PacketCreativeInventoryAction extends PisiEvent {
	private int slotID;
	private ItemStack stack;

	public C10PacketCreativeInventoryAction(PacketEvent event) {
		super(event);
		this.slotID = packet().getIntegers().read(0);
		this.stack = packet().getItemModifier().read(0);
	}

	public ItemStack stack() {
		return stack;
	}

	public int slotID() {
		return slotID;
	}

	public C10PacketCreativeInventoryAction stack(ItemStack stack) {
		packet().getItemModifier().write(0, stack);
		this.stack = stack;
		return this;
	}

	public C10PacketCreativeInventoryAction slotID(int slotID) {
		packet().getIntegers().write(0, slotID);
		this.slotID = slotID;
		return this;
	}
}
