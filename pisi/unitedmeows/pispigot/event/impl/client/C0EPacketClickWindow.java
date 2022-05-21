package pisi.unitedmeows.pispigot.event.impl.client;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.events.PacketEvent;

import pisi.unitedmeows.pispigot.event.PisiEvent;
import pisi.unitedmeows.pispigot.util.Type;;

@Type(main = "play" , client = true , finalType = "window_click")
public class C0EPacketClickWindow extends PisiEvent {
	private int windowID , slot , button;
	private short actionNumber;
	private ItemStack clickedItem;
	private int clickType;

	public C0EPacketClickWindow(PacketEvent event) {
		super(event);
		this.windowID = packet().getIntegers().read(0);
		this.slot = packet().getIntegers().read(1);
		this.button = packet().getIntegers().read(2);
		this.actionNumber = packet().getShorts().read(0);
		this.clickedItem = packet().getItemModifier().read(0);
		this.clickType = packet().getIntegers().read(3);
	}

	public C0EPacketClickWindow windowID(int id) {
		packet().getIntegers().write(0, id);
		this.windowID = id;
		return this;
	}

	public C0EPacketClickWindow slot(int slot) {
		packet().getIntegers().write(1, slot);
		this.slot = slot;
		return this;
	}

	public C0EPacketClickWindow button(int button) {
		packet().getIntegers().write(2, button);
		this.button = button;
		return this;
	}

	public C0EPacketClickWindow actionNumber(short actionNumber) {
		packet().getShorts().write(0, actionNumber);
		this.actionNumber = actionNumber;
		return this;
	}

	public C0EPacketClickWindow clickedItem(ItemStack write) {
		packet().getItemModifier().write(0, write);
		this.clickedItem = write;
		return this;
	}

	public C0EPacketClickWindow clickType(int type) {
		packet().getIntegers().write(3, type);
		this.clickType = type;
		return this;
	}

	public int windowID() {
		return this.windowID;
	}

	public int slot() {
		return slot;
	}

	public int button() {
		return button;
	}

	public int clickType() {
		return clickType;
	}

	public short actionNumber() {
		return actionNumber;
	}

	public ItemStack clickedItem() {
		return clickedItem;
	}
}
